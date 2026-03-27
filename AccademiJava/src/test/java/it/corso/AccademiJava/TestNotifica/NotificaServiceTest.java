package it.corso.AccademiJava.TestNotifica;

import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Mapper.NotificaMapper;
import it.corso.AccademiJava.Model.Notifica;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import it.corso.AccademiJava.Repository.NotificaRepository;
import it.corso.AccademiJava.Service.NotificaService;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificaServiceTest {

	@Test
	void findByTitolo_restituisceDtoMappato() {
		Notifica entity = buildEntity("Titolo A", "Messaggio A");
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byTitolo = entity;
		NotificaService service = buildService(handler);

		NotificaDto result = service.FindByTitolo("Titolo A");

		assertEquals("Titolo A", result.getTitolo());
		assertEquals("Messaggio A", result.getMessaggio());
	}

	@Test
	void countMessaggioLength_restituisceLunghezzaQuandoEsisteNotifica() {
		Notifica entity = buildEntity("Titolo B", "123456");
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byTitolo = entity;
		NotificaService service = buildService(handler);

		Integer result = service.CountMessaggioLength("Titolo B");

		assertEquals(6, result);
	}

	@Test
	void countMessaggioLength_restituisceZeroQuandoNotificaAssente() {
		NotificaService service = buildService(new TestRepositoryHandler());

		Integer result = service.CountMessaggioLength("Mancante");

		assertEquals(0, result);
	}

	@Test
	void findByTipo_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("A", "m"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byTipo = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByTipo(TipoNotifica.ERRORE);

		assertEquals(1, result.size());
		assertEquals("A", result.getFirst().getTitolo());
	}

	@Test
	void findByPriorita_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("B", "n"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byPriorita = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByPriorita(PrioritaNotifica.ALTA);

		assertEquals(1, result.size());
		assertEquals("B", result.getFirst().getTitolo());
	}

	@Test
	void findByLetta_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("C", "o"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byLetta = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByLetta(Boolean.TRUE);

		assertEquals(1, result.size());
		assertEquals("C", result.getFirst().getTitolo());
	}

	@Test
	void findByTitoloAndTipo_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("Sistema", "update"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byTitoloAndTipo = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE);

		assertEquals(1, result.size());
		assertEquals("Sistema", result.getFirst().getTitolo());
	}

	@Test
	void findByDataCreazioneAfter_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("D", "p"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byDataCreazioneAfter = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByDataCreazioneAfter(LocalDateTime.of(2026, 3, 1, 10, 0));

		assertEquals(1, result.size());
		assertEquals("D", result.getFirst().getTitolo());
	}

	@Test
	void findByMessaggioContaining_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("E", "errore"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byMessaggioContaining = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByMessaggioContaining("err");

		assertEquals(1, result.size());
		assertEquals("E", result.getFirst().getTitolo());
	}

	@Test
	void findByLettaNative_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("F", "ok"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byLettaNative = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByLettaNative(Boolean.FALSE);

		assertEquals(1, result.size());
		assertEquals("F", result.getFirst().getTitolo());
	}

	@Test
	void findByDataCreazioneAfterNative_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("G", "native"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byDataCreazioneAfterNative = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByDataCreazioneAfterNative(LocalDateTime.of(2026, 3, 20, 9, 15));

		assertEquals(1, result.size());
		assertEquals("G", result.getFirst().getTitolo());
	}

	@Test
	void findByTitoloContaining_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("Titolo esteso", "txt"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byTitoloContaining = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByTitoloContaining("Titolo");

		assertEquals(1, result.size());
		assertEquals("Titolo esteso", result.getFirst().getTitolo());
	}

	@Test
	void findByTipoAndPriorita_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("Alert", "critico"));
		TestRepositoryHandler handler = new TestRepositoryHandler();
		handler.byTipoAndPriorita = entities;
		NotificaService service = buildService(handler);

		List<NotificaDto> result = service.FindByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA);

		assertEquals(1, result.size());
		assertEquals("Alert", result.getFirst().getTitolo());
	}

	private Notifica buildEntity(String titolo, String messaggio) {
		Notifica entity = new Notifica();
		entity.setTitolo(titolo);
		entity.setMessaggio(messaggio);
		entity.setTipo(TipoNotifica.INFORMAZIONE);
		entity.setPriorita(PrioritaNotifica.MEDIA);
		entity.setDataCreazione(LocalDateTime.of(2026, 3, 27, 10, 0));
		entity.setLetta(Boolean.FALSE);
		return entity;
	}

	private NotificaService buildService(TestRepositoryHandler handler) {
		NotificaRepository repository = (NotificaRepository) Proxy.newProxyInstance(
				NotificaRepository.class.getClassLoader(),
				new Class[]{NotificaRepository.class},
				handler
		);
		return new TestableNotificaService(null, new NotificaMapper(), repository);
	}

	private static class TestableNotificaService extends NotificaService {
		TestableNotificaService(JpaRepository<Notifica, Integer> repository,
								NotificaMapper mapper,
								NotificaRepository notificaRepository) {
			super(repository, mapper, notificaRepository);
		}
	}

	private static class TestRepositoryHandler implements InvocationHandler {
		private Notifica byTitolo;
		private List<Notifica> byTipo = List.of();
		private List<Notifica> byPriorita = List.of();
		private List<Notifica> byLetta = List.of();
		private List<Notifica> byTitoloAndTipo = List.of();
		private List<Notifica> byDataCreazioneAfter = List.of();
		private List<Notifica> byMessaggioContaining = List.of();
		private List<Notifica> byLettaNative = List.of();
		private List<Notifica> byDataCreazioneAfterNative = List.of();
		private List<Notifica> byTitoloContaining = List.of();
		private List<Notifica> byTipoAndPriorita = List.of();

		@Override
		public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) {
			return switch (method.getName()) {
				case "findByTitolo" -> byTitolo;
				case "findByTipo" -> byTipo;
				case "findByPriorita" -> byPriorita;
				case "findByLetta" -> byLetta;
				case "findByTitoloAndTipo" -> byTitoloAndTipo;
				case "findByDataCreazioneAfter" -> byDataCreazioneAfter;
				case "findByMessaggioContaining" -> byMessaggioContaining;
				case "findByLettaNative" -> byLettaNative;
				case "findByDataCreazioneAfterNative" -> byDataCreazioneAfterNative;
				case "findByTitoloContaining" -> byTitoloContaining;
				case "findByTipoAndPriorita" -> byTipoAndPriorita;
				case "toString" -> "TestRepositoryProxy";
				case "hashCode" -> System.identityHashCode(proxy);
				case "equals" -> proxy == args[0];
				default -> throw new UnsupportedOperationException("Metodo non gestito nel test: " + method.getName());
			};
		}
	}
}
