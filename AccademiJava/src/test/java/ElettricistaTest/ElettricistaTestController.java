package ElettricistaTest;

import it.corso.AccademiJava.Controller.ElettricistaController;
import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Service.ElettricistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//test controll
//coreggere gli errori prima di fare push
public class ElettricistaTestController {

    @Mock
    private ElettricistaService elettricistaService; // mockdelservice

    @InjectMocks
    private ElettricistaController elettricistaController; // controllerdatestare

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // inizializmock
    }

    //test1 find by nome
    @Test
    void testFindByNome() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setNome("Ciro");
        dto.setCognome("Esposito");

        // 🔧 FIX: il service ritorna LISTA, non singolo oggetto
        when(elettricistaService.findByNome("Ciro")).thenReturn(Arrays.asList(dto));

        // 🔧 FIX: il controller ritorna ResponseEntity<List<>>
        ResponseEntity<List<ElettricistaDto>> response = elettricistaController.findByNome("Ciro");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value()); // 🔧 FIX deprecato
        assertEquals("Ciro", response.getBody().get(0).getNome()); // 🔧 FIX lista
    }

    //EST2 find disp.
    @Test
    void testFindDisponibili() {
        ElettricistaDto dto1 = new ElettricistaDto();
        dto1.setNome("Ciro");
        ElettricistaDto dto2 = new ElettricistaDto();
        dto2.setNome("Mario");

        when(elettricistaService.findDisponibili()).
                thenReturn(Arrays.asList(dto1, dto2));

        List<ElettricistaDto> result = elettricistaController.
                findDisponibili();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    // TEST3 find by cognome
    @Test
    void testFindByCognome() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setCognome("Esposito");

        when(elettricistaService.findByCognome("Esposito")).
                thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaController.findByCognome("Esposito");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Esposito", result.get(0).getCognome());
    }

    //TES4 find by specializ.
    @Test
    void testFindBySpecializzazione() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setSpecializzazione("Industriale");

        when(elettricistaService.findBySpecializzazione("Industriale")).
                thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaController.
                findBySpecializzazione("Industriale");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Industriale", result.get(0)
                .getSpecializzazione());
    }

    //TEST 5 jpql cerca per nome
    @Test
    void testCercaPerNomeJPQL() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setNome("Ciro");

        when(elettricistaService.cercaPerNomeJPQL("Ciro")).thenReturn(dto);

        ResponseEntity<ElettricistaDto> response = elettricistaController.
                cercaPerNomeJPQL("Ciro");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value()); // 🔧 FIX
        assertEquals("Ciro", response.getBody().getNome());
    }

    //TEST6 jpql disp.
    @Test
    void testElettricistiDisponibiliJPQL() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setNome("Ciro");

        when(elettricistaService.elettricistiDisponibiliJPQL()).
                thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaController.
                elettricistiDisponibiliJPQL();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    //test7 native find by nome
    @Test
    void testFindByNomeNative() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setNome("Ciro");

        when(elettricistaService.findByNomeNative("Ciro")).
                thenReturn(dto);

        ResponseEntity<ElettricistaDto> response = elettricistaController.
                findByNomeNative("Ciro");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value()); // 🔧 FIX
        assertEquals("Ciro", response.getBody().getNome());
    }

    //TEST8 nat. disp.
    @Test
    void testFindDisponibiliNative() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setNome("Ciro");

        when(elettricistaService.findDisponibiliNative()).
                thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaController.
                findDisponibiliNative();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    //test 9 cognome + disp.
    @Test
    void testFindByCognomeAndDisponibileTrue() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setCognome("Esposito");

        when(elettricistaService.findByCognomeAndDisponibileTrue("Esposito")).
                thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaController.
                findByCognomeAndDisponibileTrue("Esposito");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Esposito", result.get(0).getCognome());
    }

    //test10  specializz + non disp.
    @Test
    void testFindBySpecializzazioneAndDisponibileFalse() {
        ElettricistaDto dto = new ElettricistaDto();
        dto.setSpecializzazione("Industriale");

        when(elettricistaService.
                findBySpecializzazioneAndDisponibileFalse("Industriale"))
                .thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaController.
                findBySpecializzazioneAndDisponibileFalse("Industriale");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Industriale", result.get(0).getSpecializzazione());
    }
}