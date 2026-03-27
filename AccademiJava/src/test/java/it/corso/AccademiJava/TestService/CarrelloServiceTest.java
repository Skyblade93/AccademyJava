package it.corso.AccademiJava.TestService;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.Mapper.CarrelloMapper;
import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Repository.CarrelloRepository;
import it.corso.AccademiJava.Service.CarrelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class) // Abilita l'automatismo di Mockito
public class CarrelloServiceTest {

    @Mock
    private CarrelloRepository carrelloRepository; // crea il "finto" repo

    @Mock
    private CarrelloMapper carrelloMapper; // crea il "finto" mapper

    @InjectMocks
    private CarrelloService carrelloService; // crea il service e ci inietta i mock sopra

    @Test
    void testFindById() {
        // GIVEN
        int id = 1;
        Carrello entity = new Carrello();
        CarrelloDto dto = new CarrelloDto();

        when(carrelloRepository.findById(id)).thenReturn(entity);
        when(carrelloMapper.toDTO(entity)).thenReturn(dto);

        // WHEN
        CarrelloDto result = carrelloService.findById(id);

        // THEN
        assertThat(result).isEqualTo(dto);
    }

    @Test
    void testCercaPerQuantita() {
        // 1. GIVEN
        int quantitaRicercata = 5;

        // creiamo una lista finta di Entity
        Carrello c1 = new Carrello();
        Carrello c2 = new Carrello();
        List<Carrello> entities = Arrays.asList(c1, c2);

        // creiamo una lista finta di DTO
        CarrelloDto d1 = new CarrelloDto();
        CarrelloDto d2 = new CarrelloDto();
        List<CarrelloDto> dtosEsperati = Arrays.asList(d1, d2);

        // definiamo i comportamenti dei mock
        when(carrelloRepository.cercaPerQuantita(quantitaRicercata)).thenReturn(entities);
        when(carrelloMapper.toDTOList(entities)).thenReturn(dtosEsperati);

        // 2. WHEN
        List<CarrelloDto> result = carrelloService.cercaPerQuantita(quantitaRicercata);

        // 3. THEN (verifiche specifiche per le liste)
        assertThat(result)
                .isNotNull()
                .hasSize(2) // verifica che ci siano 2 elementi
                .containsExactly(d1, d2) // verifica l'ordine e il contenuto
                .isEqualTo(dtosEsperati);

        // verifica che le chiamate siano avvenute correttamente
        verify(carrelloRepository).cercaPerQuantita(quantitaRicercata);
        verify(carrelloMapper).toDTOList(entities);
    }

    @Test
    void testCercaPerQuantita_Vuota() {
        int q = 100;
        when(carrelloRepository.cercaPerQuantita(q)).thenReturn(List.of()); // lista vuota
        when(carrelloMapper.toDTOList(anyList())).thenReturn(List.of());

        List<CarrelloDto> result = carrelloService.cercaPerQuantita(q);

        assertThat(result).isEmpty(); // verifica che restituisca una lista vuota e non null
    }

    @Test
    void testCercaPrezzoTotale() {
        double prezzo = 50.0;
        List<Carrello> entities = List.of(new Carrello());
        List<CarrelloDto> dtos = List.of(new CarrelloDto());

        when(carrelloRepository.cercaPrezzoTotale(prezzo)).thenReturn(entities);
        when(carrelloMapper.toDTOList(entities)).thenReturn(dtos);

        List<CarrelloDto> result = carrelloService.cercaPrezzoTotale(prezzo);

        assertThat(result).hasSize(1).isEqualTo(dtos);
    }

    @Test
    void testFindByIdAndPrezzoTotale() {
        int id = 1;
        double prezzo = 25.5;
        Carrello entity = new Carrello();
        CarrelloDto dto = new CarrelloDto();

        when(carrelloRepository.findByIdAndPrezzoTotale(id, prezzo)).thenReturn(entity);
        when(carrelloMapper.toDTO(entity)).thenReturn(dto);

        CarrelloDto result = carrelloService.findByIdAndPrezzoTotale(id, prezzo);

        assertThat(result).isEqualTo(dto);
    }

    @Test
    void testFindByIdAndQuantita() {
        int id = 1;
        int quantita = 3;
        Carrello entity = new Carrello();
        CarrelloDto dto = new CarrelloDto();

        when(carrelloRepository.findByIdAndQuantita(id, quantita)).thenReturn(entity);
        when(carrelloMapper.toDTO(entity)).thenReturn(dto);

        CarrelloDto result = carrelloService.findByIdAndQuantita(id, quantita);

        assertThat(result).isEqualTo(dto);
    }

    @Test
    void testFindByQuantitaAndPrezzoTotale() {
        int q = 10;
        double p = 100.0;
        List<Carrello> entities = List.of(new Carrello());
        List<CarrelloDto> dtos = List.of(new CarrelloDto());

        when(carrelloRepository.findByQuantitaAndPrezzoTotale(q, p)).thenReturn(entities);
        when(carrelloMapper.toDTOList(entities)).thenReturn(dtos);

        List<CarrelloDto> result = carrelloService.findByQuantitaAndPrezzoTotale(q, p);

        assertThat(result).isEqualTo(dtos);
    }

    @Test
    void testTrovaPrezzoMaggioreDi10() {
        // GIVEN
        double inputPrezzo = 5.0;

        // creiamo 2 DTO con prezzi diversi per testare la condizione > 10
        CarrelloDto dtoEconomico = new CarrelloDto();
        dtoEconomico.setPrezzoTotale(8.0); // Dovrebbe essere false

        CarrelloDto dtoCostoso = new CarrelloDto();
        dtoCostoso.setPrezzoTotale(15.0); // Dovrebbe essere true

        List<CarrelloDto> carrelliDto = List.of(dtoEconomico, dtoCostoso);
        List<Carrello> entities = List.of(new Carrello(), new Carrello());

        when(carrelloRepository.cercaPrezzoTotale(inputPrezzo)).thenReturn(entities);
        when(carrelloMapper.toDTOList(entities)).thenReturn(carrelliDto);

        // WHEN
        List<Boolean> result = carrelloService.trovaPrezzoMaggioreDi10(inputPrezzo);

        // THEN
        assertThat(result)
                .hasSize(2)
                .containsExactly(false, true); // 8.0 > 10 è false, 15.0 > 10 è true
    }
}