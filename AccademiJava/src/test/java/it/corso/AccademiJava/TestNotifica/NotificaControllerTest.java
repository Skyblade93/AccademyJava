package it.corso.AccademiJava.TestNotifica;

import it.corso.AccademiJava.Controller.NotificaController;
import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import it.corso.AccademiJava.Mapper.NotificaMapper;
import it.corso.AccademiJava.Repository.NotificaRepository;
import it.corso.AccademiJava.Service.NotificaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class NotificaControllerTest {

    private NotificaController controller;

    private FakeNotificaService service;

    @BeforeEach
    void setUp() throws Exception {
        controller = new NotificaController();
        service = new FakeNotificaService();
        Field serviceField = NotificaController.class.getDeclaredField("service");
        serviceField.setAccessible(true);
        serviceField.set(controller, service);
    }

    @Test
    void findByTitolo_delegaAlService() {
        NotificaDto expected = buildDto(1, "Titolo API", "Messaggio API");
        service.findByTitoloResult = expected;

        NotificaDto result = controller.FindByTitolo("Titolo API");

        assertSame(expected, result);
        assertEquals("Titolo API", service.lastTitolo);
    }

    @Test
    void countMessaggioLength_restituisceValoreDelService() {
        service.countResult = 12;

        Integer result = controller.CountMessaggioLength("Titolo API");

        assertEquals(12, result);
    }

    @Test
    void findByTipo_restituisceListaDalService() {
        service.findByTipoResult = List.of(buildDto(2, "Errore", "Dettaglio"));

        List<NotificaDto> result = controller.FindByTipo(TipoNotifica.ERRORE);

        assertEquals(1, result.size());
        assertEquals(TipoNotifica.ERRORE, service.lastTipo);
        assertEquals("Errore", result.getFirst().getTitolo());
    }

    @Test
    void findByPriorita_restituisceListaDalService() {
        service.findByPrioritaResult = List.of(buildDto(3, "Priorita", "Alta"));

        List<NotificaDto> result = controller.FindByPriorita(PrioritaNotifica.ALTA);

        assertSame(service.findByPrioritaResult, result);
        assertEquals(PrioritaNotifica.ALTA, service.lastPriorita);
    }

    @Test
    void findByLetta_restituisceListaDalService() {
        service.findByLettaResult = List.of(buildDto(4, "Letta", "Si"));

        List<NotificaDto> result = controller.FindByLetta(Boolean.TRUE);

        assertSame(service.findByLettaResult, result);
        assertEquals(Boolean.TRUE, service.lastLetta);
    }

    @Test
    void findByTitoloAndTipo_restituisceListaDalService() {
        service.findByTitoloAndTipoResult = List.of(buildDto(5, "Sistema", "Manutenzione"));

        List<NotificaDto> result = controller.FindByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE);

        assertSame(service.findByTitoloAndTipoResult, result);
        assertEquals("Sistema", service.lastTitolo);
        assertEquals(TipoNotifica.MANUTENZIONE, service.lastTipo);
    }

    @Test
    void findByDataCreazioneAfter_restituisceListaDalService() {
        LocalDateTime data = LocalDateTime.of(2026, 3, 27, 8, 30, 0);
        service.findByDataCreazioneAfterResult = List.of(buildDto(6, "Data", "Filtro"));

        List<NotificaDto> result = controller.FindByDataCreazioneAfter(data);

        assertSame(service.findByDataCreazioneAfterResult, result);
        assertEquals(data, service.lastData);
    }

    @Test
    void findByMessaggioContaining_restituisceListaDalService() {
        service.findByMessaggioContainingResult = List.of(buildDto(7, "Txt", "errore"));

        List<NotificaDto> result = controller.FindByMessaggioContaining("errore");

        assertSame(service.findByMessaggioContainingResult, result);
        assertEquals("errore", service.lastMessaggio);
    }

    @Test
    void findByLettaNative_restituisceListaDalService() {
        service.findByLettaNativeResult = List.of(buildDto(8, "Native", "False"));

        List<NotificaDto> result = controller.FindByLettaNative(Boolean.FALSE);

        assertSame(service.findByLettaNativeResult, result);
        assertEquals(Boolean.FALSE, service.lastLetta);
    }

    @Test
    void findByDataCreazioneAfterNative_restituisceListaDalService() {
        LocalDateTime data = LocalDateTime.of(2026, 3, 27, 9, 45, 0);
        service.findByDataCreazioneAfterNativeResult = List.of(buildDto(9, "NativeData", "Filtro"));

        List<NotificaDto> result = controller.FindByDataCreazioneAfterNative(data);

        assertSame(service.findByDataCreazioneAfterNativeResult, result);
        assertEquals(data, service.lastData);
    }

    @Test
    void findByTitoloContaining_restituisceListaDalService() {
        service.findByTitoloContainingResult = List.of(buildDto(10, "Titolo", "Filtro"));

        List<NotificaDto> result = controller.FindByTitoloContaining("Tit");

        assertSame(service.findByTitoloContainingResult, result);
        assertEquals("Tit", service.lastTitolo);
    }

    @Test
    void findByTipoAndPriorita_restituisceListaDalService() {
        service.findByTipoAndPrioritaResult = List.of(buildDto(11, "Combinata", "Critica"));

        List<NotificaDto> result = controller.FindByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA);

        assertSame(service.findByTipoAndPrioritaResult, result);
        assertEquals(TipoNotifica.AVVERTIMENTO, service.lastTipo);
        assertEquals(PrioritaNotifica.CRITICA, service.lastPriorita);
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

    private static class FakeNotificaService extends NotificaService {

        private String lastTitolo;
        private String lastMessaggio;
        private TipoNotifica lastTipo;
        private PrioritaNotifica lastPriorita;
        private Boolean lastLetta;
        private LocalDateTime lastData;
        private int countResult;
        private NotificaDto findByTitoloResult;
        private List<NotificaDto> findByTipoResult = List.of();
        private List<NotificaDto> findByPrioritaResult = List.of();
        private List<NotificaDto> findByLettaResult = List.of();
        private List<NotificaDto> findByTitoloAndTipoResult = List.of();
        private List<NotificaDto> findByDataCreazioneAfterResult = List.of();
        private List<NotificaDto> findByMessaggioContainingResult = List.of();
        private List<NotificaDto> findByLettaNativeResult = List.of();
        private List<NotificaDto> findByDataCreazioneAfterNativeResult = List.of();
        private List<NotificaDto> findByTitoloContainingResult = List.of();
        private List<NotificaDto> findByTipoAndPrioritaResult = List.of();

        FakeNotificaService() {
            super(null, new NotificaMapper(), EmptyRepository.newProxy());
        }

        @Override
        public NotificaDto FindByTitolo(String titolo) {
            this.lastTitolo = titolo;
            return findByTitoloResult;
        }

        @Override
        public Integer CountMessaggioLength(String titolo) {
            this.lastTitolo = titolo;
            return countResult;
        }

        @Override
        public List<NotificaDto> FindByTipo(TipoNotifica tipo) {
            this.lastTipo = tipo;
            return findByTipoResult;
        }

        @Override
        public List<NotificaDto> FindByPriorita(PrioritaNotifica priorita) {
            this.lastPriorita = priorita;
            return findByPrioritaResult;
        }

        @Override
        public List<NotificaDto> FindByLetta(Boolean letta) {
            this.lastLetta = letta;
            return findByLettaResult;
        }

        @Override
        public List<NotificaDto> FindByTitoloAndTipo(String titolo, TipoNotifica tipo) {
            this.lastTitolo = titolo;
            this.lastTipo = tipo;
            return findByTitoloAndTipoResult;
        }

        @Override
        public List<NotificaDto> FindByDataCreazioneAfter(LocalDateTime data) {
            this.lastData = data;
            return findByDataCreazioneAfterResult;
        }

        @Override
        public List<NotificaDto> FindByMessaggioContaining(String messaggio) {
            this.lastMessaggio = messaggio;
            return findByMessaggioContainingResult;
        }

        @Override
        public List<NotificaDto> FindByLettaNative(Boolean letta) {
            this.lastLetta = letta;
            return findByLettaNativeResult;
        }

        @Override
        public List<NotificaDto> FindByDataCreazioneAfterNative(LocalDateTime data) {
            this.lastData = data;
            return findByDataCreazioneAfterNativeResult;
        }

        @Override
        public List<NotificaDto> FindByTitoloContaining(String titolo) {
            this.lastTitolo = titolo;
            return findByTitoloContainingResult;
        }

        @Override
        public List<NotificaDto> FindByTipoAndPriorita(TipoNotifica tipo, PrioritaNotifica priorita) {
            this.lastTipo = tipo;
            this.lastPriorita = priorita;
            return findByTipoAndPrioritaResult;
        }
    }

    private static class EmptyRepository {
        static NotificaRepository newProxy() {
            return (NotificaRepository) Proxy.newProxyInstance(
                    NotificaRepository.class.getClassLoader(),
                    new Class[]{NotificaRepository.class},
                    (proxy, method, args) -> {
                        throw new UnsupportedOperationException("Metodo repository non usato nel test: " + method.getName());
                    }
            );
        }
    }
}
