package it.corso.AccademiJava.TestNotifica;

import it.corso.AccademiJava.Controller.NotificaController;
import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import it.corso.AccademiJava.Service.NotificaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificaControllerTest {

    @InjectMocks
    private NotificaController controller;

    @Mock
    private NotificaService service;

    @Test
    void findByTitolo_delegaAlService() {
        NotificaDto expected = buildDto(1, "Titolo API", "Messaggio API");
        when(service.FindByTitolo("Titolo API")).thenReturn(expected);

        NotificaDto result = controller.FindByTitolo("Titolo API");

        assertSame(expected, result);
        verify(service).FindByTitolo("Titolo API");
    }

    @Test
    void countMessaggioLength_restituisceValoreDelService() {
        when(service.CountMessaggioLength("Titolo API")).thenReturn(12);

        Integer result = controller.CountMessaggioLength("Titolo API");

        assertEquals(12, result);
        verify(service).CountMessaggioLength("Titolo API");
    }

    @Test
    void findByTipo_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(2, "Errore", "Dettaglio"));
        when(service.FindByTipo(TipoNotifica.ERRORE)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByTipo(TipoNotifica.ERRORE);

        assertEquals(1, result.size());
        assertEquals("Errore", result.getFirst().getTitolo());
        verify(service).FindByTipo(TipoNotifica.ERRORE);
    }

    @Test
    void findByPriorita_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(3, "Priorita", "Alta"));
        when(service.FindByPriorita(PrioritaNotifica.ALTA)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByPriorita(PrioritaNotifica.ALTA);

        assertSame(expected, result);
        verify(service).FindByPriorita(PrioritaNotifica.ALTA);
    }

    @Test
    void findByLetta_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(4, "Letta", "Si"));
        when(service.FindByLetta(Boolean.TRUE)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByLetta(Boolean.TRUE);

        assertSame(expected, result);
        verify(service).FindByLetta(Boolean.TRUE);
    }

    @Test
    void findByTitoloAndTipo_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(5, "Sistema", "Manutenzione"));
        when(service.FindByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE);

        assertSame(expected, result);
        verify(service).FindByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE);
    }

    @Test
    void findByDataCreazioneAfter_restituisceListaDalService() {
        LocalDateTime data = LocalDateTime.of(2026, 3, 27, 8, 30, 0);
        List<NotificaDto> expected = List.of(buildDto(6, "Data", "Filtro"));
        when(service.FindByDataCreazioneAfter(data)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByDataCreazioneAfter(data);

        assertSame(expected, result);
        verify(service).FindByDataCreazioneAfter(data);
    }

    @Test
    void findByMessaggioContaining_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(7, "Txt", "errore"));
        when(service.FindByMessaggioContaining("errore")).thenReturn(expected);

        List<NotificaDto> result = controller.FindByMessaggioContaining("errore");

        assertSame(expected, result);
        verify(service).FindByMessaggioContaining("errore");
    }

    @Test
    void findByLettaNative_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(8, "Native", "False"));
        when(service.FindByLettaNative(Boolean.FALSE)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByLettaNative(Boolean.FALSE);

        assertSame(expected, result);
        verify(service).FindByLettaNative(Boolean.FALSE);
    }

    @Test
    void findByDataCreazioneAfterNative_restituisceListaDalService() {
        LocalDateTime data = LocalDateTime.of(2026, 3, 27, 9, 45, 0);
        List<NotificaDto> expected = List.of(buildDto(9, "NativeData", "Filtro"));
        when(service.FindByDataCreazioneAfterNative(data)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByDataCreazioneAfterNative(data);

        assertSame(expected, result);
        verify(service).FindByDataCreazioneAfterNative(data);
    }

    @Test
    void findByTitoloContaining_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(10, "Titolo", "Filtro"));
        when(service.FindByTitoloContaining("Tit")).thenReturn(expected);

        List<NotificaDto> result = controller.FindByTitoloContaining("Tit");

        assertSame(expected, result);
        verify(service).FindByTitoloContaining("Tit");
    }

    @Test
    void findByTipoAndPriorita_restituisceListaDalService() {
        List<NotificaDto> expected = List.of(buildDto(11, "Combinata", "Critica"));
        when(service.FindByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA)).thenReturn(expected);

        List<NotificaDto> result = controller.FindByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA);

        assertSame(expected, result);
        verify(service).FindByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA);
    }

    private NotificaDto buildDto(Integer id, String titolo, String messaggio) {
        NotificaDto dto = new NotificaDto();
        dto.setId(id);
        dto.setTitolo(titolo);
        dto.setMessaggio(messaggio);
        dto.setTipo(TipoNotifica.INFORMAZIONE);
        dto.setPriorita(PrioritaNotifica.MEDIA);
        dto.setDataCreazione(LocalDateTime.of(2026, 3, 27, 10, 0));
        dto.setLetta(Boolean.FALSE);
        return dto;
    }

}
