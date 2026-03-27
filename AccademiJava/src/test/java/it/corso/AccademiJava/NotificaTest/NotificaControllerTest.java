package it.corso.AccademiJava.NotificaTest;

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
        private TipoNotifica lastTipo;
        private int countResult;
        private NotificaDto findByTitoloResult;
        private List<NotificaDto> findByTipoResult = List.of();

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
