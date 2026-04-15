package it.corso.AccademiJava.TestOrdine;

import it.corso.AccademiJava.DTO.OrdineDto;
import it.corso.AccademiJava.Mapper.OrdineMapper;
import it.corso.AccademiJava.Model.Ordine;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.OrdineRepository;
import it.corso.AccademiJava.Service.OrdineService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrdineServiceTest {
    @Mock
    private OrdineRepository ordineRepository;

    @Mock
    private OrdineMapper ordineMapper;

    @Mock
    private JpaRepository<User, Integer> jpaRepository;

    @InjectMocks
    private OrdineService ordineService;

    @Test
    void shouldFindById() {
        Ordine ordine = new Ordine();
        ordine.setId(1);

        OrdineDto dto = new OrdineDto();
        dto.setId(1);

        when(ordineRepository.findById(1)).thenReturn((ordine));
        when(ordineMapper.toDTO(ordine)).thenReturn(dto);

        OrdineDto result = ordineService.findById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void shouldTrovaConCostoUguale() {
        Ordine ordine = new Ordine();
        ordine.setCosto_totale(12);
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(12);

        Ordine ordine1 = new Ordine();
        ordine1.setCosto_totale(13);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCosto_totale(13);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.trovaConCostoUguale(12)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.trovaConCostoUguale(12);

        assertEquals(2, result.size());
        assertEquals(12, result.get(0).getCosto_totale());
        assertEquals(13, result.get(1).getCosto_totale());
    }

    @Test
    void shouldTrovaConNumeroProdottiMaggiore() {
        Ordine ordine = new Ordine();
        ordine.setNumero_prodotti(6);
        OrdineDto dto = new OrdineDto();
        dto.setNumero_prodotti(6);

        Ordine ordine1 = new Ordine();
        ordine1.setNumero_prodotti(7);
        OrdineDto dto1 = new OrdineDto();
        dto1.setNumero_prodotti(7);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.trovaConNumeroProdottiMaggiore(5)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.trovaConNumeroProdottiMaggiore(5);

        assertEquals(2, result.size());
        assertEquals(6, result.get(0).getNumero_prodotti());
        assertEquals(7, result.get(1).getNumero_prodotti());
    }

    @Test
    void shouldTrovaConIndirizzo() {
        Ordine ordine = new Ordine();
        ordine.setIndirizzo_spedizione("via manzoni");
        OrdineDto dto = new OrdineDto();
        dto.setIndirizzo_spedizione("via manzoni");

        Ordine ordine1 = new Ordine();
        ordine1.setIndirizzo_spedizione("via roma");
        OrdineDto dto1 = new OrdineDto();
        dto1.setIndirizzo_spedizione("via roma");

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.trovaConIndirizzo("via manzoni")).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.trovaConIndirizzo("via manzoni");

        assertEquals(2, result.size());
        assertEquals("via manzoni", result.get(0).getIndirizzo_spedizione());
        assertEquals("via roma", result.get(1).getIndirizzo_spedizione());
    }

    @Test
    void shouldTrovaConCostoMaggiore() {
        Ordine ordine = new Ordine();
        ordine.setCosto_totale(100);
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(100);

        Ordine ordine1 = new Ordine();
        ordine1.setCosto_totale(150);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCosto_totale(150);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.trovaConCostoMaggiore(99)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.trovaConCostoMaggiore(99);

        assertEquals(2, result.size());
        assertEquals(100, result.get(0).getCosto_totale());
        assertEquals(150, result.get(1).getCosto_totale());
    }

    @Test
    void shouldTrovaConCostoMinore() {
        Ordine ordine = new Ordine();
        ordine.setCosto_totale(100);
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(100);

        Ordine ordine1 = new Ordine();
        ordine1.setCosto_totale(150);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCosto_totale(150);

        List<Ordine> ordini = List.of(ordine, ordine1);
        List<OrdineDto> dtos = List.of(dto, dto1);

        when(ordineRepository.trovaConCostoMaggiore(151)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.trovaConCostoMaggiore(151);

        assertEquals(2, result.size());
        assertEquals(100, result.get(0).getCosto_totale());
        assertEquals(150, result.get(1).getCosto_totale());
    }

    @Test
    void shouldFiltro() {
        Ordine ordine = new Ordine();
        ordine.setCosto_totale(30);
        ordine.setNumero_prodotti(5);
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(30);
        dto.setNumero_prodotti(5);

        List<Ordine> ordini = List.of(ordine);
        List<OrdineDto> dtos = List.of(dto);

        when(ordineRepository.filtro(2,50)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.filtro(2,50);

        assertEquals(1, result.size());
        assertEquals(5, result.get(0).getNumero_prodotti());
        assertEquals(30, result.get(0).getCosto_totale());
    }

    @Test
    void shouldTrovaPerUtente() {
        User user=new User();
        user.setId(2);

        Ordine ordine = new Ordine();
        ordine.setUtente(user);
        OrdineDto dto = new OrdineDto();
        dto.setUtente(user);

        List<Ordine> ordini = List.of(ordine);
        List<OrdineDto> dtos = List.of(dto);

        when(ordineRepository.trovaPerUtente(1)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.trovaPerUtente(1);

        assertEquals(1, result.size());
        assertEquals(2, result.get(0).getUtente().getId());
    }

    @Test
    void shouldOrdinaPerCostoDecrescente() {
        Ordine ordine1 = new Ordine();
        ordine1.setCosto_totale(100);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCosto_totale(100);

        Ordine ordine2 = new Ordine();
        ordine2.setCosto_totale(50);
        OrdineDto dto2 = new OrdineDto();
        dto2.setCosto_totale(50);

        Ordine ordine3 = new Ordine();
        ordine3.setCosto_totale(10);
        OrdineDto dto3 = new OrdineDto();
        dto3.setCosto_totale(10);

        List<Ordine> ordini = List.of(ordine1, ordine2, ordine3);
        List<OrdineDto> dtos = List.of(dto1, dto2, dto3);

        when(ordineRepository.ordinaPerCostoDecrescente()).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.ordinaPerCostoDecrescente();

        assertEquals(3, result.size());
        assertEquals(100, result.get(0).getCosto_totale());
        assertEquals(50, result.get(1).getCosto_totale());
        assertEquals(10, result.get(2).getCosto_totale());
    }

    @Test
    void shouldTrovaTraDueCosti() {
        Ordine ordine = new Ordine();
        ordine.setCosto_totale(45);
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(45);

        List<Ordine> ordini = List.of(ordine);
        List<OrdineDto> dtos = List.of(dto);

        when(ordineRepository.trovaTraDueCosti(40,50)).thenReturn(ordini);
        when(ordineMapper.toDTOList(ordini)).thenReturn(dtos);

        List<OrdineDto> result = ordineService.trovaTraDueCosti(40,50);

        assertEquals(1, result.size());
        assertEquals(45, result.get(0).getCosto_totale());
    }
}
