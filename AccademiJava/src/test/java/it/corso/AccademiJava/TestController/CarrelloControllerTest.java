package it.corso.AccademiJava.TestController;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import it.corso.AccademiJava.Controller.CarrelloController;
import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.Service.CarrelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class) // abilita l'automatismo di Mockito
public class CarrelloControllerTest {

    @Mock
    private CarrelloService service; // crea il "finto" repo

    @InjectMocks
    private CarrelloController carrelloController; // crea il service e ci inietta i mock sopra

    @Test
    void testFindById() {
        // 1. GIVEN
        int id = 1;
        CarrelloDto dtoMock = new CarrelloDto();
        dtoMock.setId(id);

        // istruiamo il mock: "Quando il controller chiama il service, restituisci questo DTO"
        when(service.findById(id)).thenReturn(dtoMock);

        // 2. WHEN
        // chiamata diretta al metodo del controller
        CarrelloDto result = carrelloController.findById(id);

        // 3. THEN
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(dtoMock); // verifica che l'oggetto sia lo stesso

        // verifica che il controller abbia usato il service
        verify(service, times(1)).findById(id);
    }

    @Test
    void testFindByQuantita() {
        // 1. GIVEN
        int quantitaParam = 5;
        CarrelloDto dto1 = new CarrelloDto();
        CarrelloDto dto2 = new CarrelloDto();
        List<CarrelloDto> mockLista = List.of(dto1, dto2);

        // quando il controller chiama il service, restituisci la lista finta
        when(service.cercaPerQuantita(quantitaParam)).thenReturn(mockLista);

        // 2. WHEN
        List<CarrelloDto> result = carrelloController.findByQuantita(quantitaParam);

        // 3. THEN
        assertThat(result)
                .isNotNull()
                .hasSize(2)
                .containsExactly(dto1, dto2);

        // verifica che il controller abbia passato il parametro corretto al service
        verify(service).cercaPerQuantita(quantitaParam);
    }

    @Test
    void testFindByQuantita_ListaVuota() {
        // GIVEN: Il service non trova nulla e restituisce una lista vuota
        int quantitaParam = 100;
        when(service.cercaPerQuantita(quantitaParam)).thenReturn(List.of());

        // WHEN
        List<CarrelloDto> result = carrelloController.findByQuantita(quantitaParam);

        // THEN
        assertThat(result).isEmpty();
        verify(service).cercaPerQuantita(100);
    }
}