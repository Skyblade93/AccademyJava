package ElettricistaTest;

import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Mapper.ElettricistaMapper;
import it.corso.AccademiJava.Model.Elettricista;
import it.corso.AccademiJava.Repository.ElettricistaRepository;
import it.corso.AccademiJava.Service.ElettricistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//test del service
// coreggere definitivament gli stessi errori
public class ElettricistaTestService {

    @Mock
    private ElettricistaRepository elettricistaRepository; // mockrepository

    @Mock
    private ElettricistaMapper elettricistaMapper; // mockmapper

    @InjectMocks
    private ElettricistaService elettricistaService; // service testconimock

    private Elettricista entity; // oggetto prova
    private ElettricistaDto dto; // dt prova

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // inizializz i mock

        // creo entity es.
        entity = new Elettricista();
        entity.setNome("Ciro");
        entity.setCognome("Esposito");
        entity.setSpecializzazione("Industriale");
        entity.setDisponibile(true);

        // creo dto esatt
        dto = new ElettricistaDto();
        dto.setNome("Ciro");
        dto.setCognome("Esposito");
        dto.setSpecializzazione("Industriale");
        dto.setDisponibile(true);
    }

    //test 1find by nome
    @Test
    void testFindByNome() {
        when(elettricistaRepository.findByNome("Ciro")).thenReturn(entity);
        when(elettricistaMapper.toDTO(entity)).thenReturn(dto);

        ElettricistaDto result = elettricistaService.findByNome("Ciro");

        // controllo che funzioni
        assertNotNull(result);
        assertEquals("Ciro", result.getNome());
    }

    //TEST 2 find disponibili
    @Test
    void testFindDisponibili() {
        when(elettricistaRepository.findByDisponibileTrue()).thenReturn(Arrays.asList(entity));
        when(elettricistaMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.findDisponibili();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    //test3 find by cognome
    @Test
    void testFindByCognome() {
        when(elettricistaRepository.findByCognome("Esposito")).thenReturn(Arrays.asList(entity));
        when(elettricistaMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.findByCognome("Esposito");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Esposito", result.get(0).getCognome());
    }

    // TEST4 find by specializz.
    @Test
    void testFindBySpecializzazione() {
        when(elettricistaRepository.findBySpecializzazione("Industriale")).thenReturn(Arrays.asList(entity));
        when(elettricistaMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.findBySpecializzazione("Industriale");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Industriale", result.get(0).getSpecializzazione());
    }

    // TEST5 jpql cerca per nome
    @Test
    void testCercaPerNomeJPQL() {
        when(elettricistaRepository.cercaPerNomeJPQL("Ciro")).thenReturn(entity);
        when(elettricistaMapper.toDTO(entity)).thenReturn(dto);

        ElettricistaDto result = elettricistaService.cercaPerNomeJPQL("Ciro");

        assertNotNull(result);
        assertEquals("Ciro", result.getNome());
    }

    // TEST6 jpql disp.
    @Test
    void testElettricistiDisponibiliJPQL() {
        when(elettricistaRepository.elettricistiDisponibiliJPQL()).thenReturn(Arrays.asList(entity));
        when(elettricistaMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.elettricistiDisponibiliJPQL();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    // test7 native find by nome
    @Test
    void testFindByNomeNative() {
        when(elettricistaRepository.findByNomeNative("Ciro")).thenReturn(entity);
        when(elettricistaMapper.toDTO(entity)).thenReturn(dto);

        ElettricistaDto result = elettricistaService.findByNomeNative("Ciro");

        assertNotNull(result);
        assertEquals("Ciro", result.getNome());
    }

    @Test
    void testFindByNomeNativeNull() {
        // se non trova nulla
        when(elettricistaRepository.findByNomeNative("Ciro")).thenReturn(null);

        ElettricistaDto result = elettricistaService.findByNomeNative("Ciro");

        assertNull(result); // deveesserenull
    }

    // TEST8 native disp.
    @Test
    void testFindDisponibiliNative() {
        when(elettricistaRepository.findDisponibiliNative()).thenReturn(Arrays.asList(entity));
        when(elettricistaMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.findDisponibiliNative();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testFindDisponibiliNativeVuoto() {
        when(elettricistaRepository.findDisponibiliNative()).thenReturn(Collections.emptyList());

        List<ElettricistaDto> result = elettricistaService.findDisponibiliNative();

        assertNotNull(result);
        assertTrue(result.isEmpty()); // lista vuota
    }

    //TEST 9 cognome + disp.
    @Test
    void testFindByCognomeAndDisponibileTrue() {
        when(elettricistaRepository.findByCognomeAndDisponibileTrue("Esposito")).thenReturn(Arrays.asList(entity));
        when(elettricistaMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.findByCognomeAndDisponibileTrue("Esposito");

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    // TEST10 specializz. + non disp.
    @Test
    void testFindBySpecializzazioneAndDisponibileFalse() {
        Elettricista nonDisp = new Elettricista();
        nonDisp.setSpecializzazione("Industriale");
        nonDisp.setDisponibile(false);

        ElettricistaDto dtoNonDisp = new ElettricistaDto();
        dtoNonDisp.setSpecializzazione("Industriale");
        dtoNonDisp.setDisponibile(false);

        when(elettricistaRepository.findBySpecializzazioneAndDisponibileFalse("Industriale"))
                .thenReturn(Arrays.asList(nonDisp));
        when(elettricistaMapper.toDTOList(anyList())).thenReturn(Arrays.asList(dtoNonDisp));

        List<ElettricistaDto> result = elettricistaService.findBySpecializzazioneAndDisponibileFalse("Industriale");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertFalse(result.get(0).getDisponibile());
    }
}