package it.corso.AccademiJava.NotificaTest;

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

		@Override
		public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) {
			return switch (method.getName()) {
				case "findByTitolo" -> byTitolo;
				case "findByTipo" -> byTipo;
				case "toString" -> "TestRepositoryProxy";
				case "hashCode" -> System.identityHashCode(proxy);
				case "equals" -> proxy == args[0];
				default -> throw new UnsupportedOperationException("Metodo non gestito nel test: " + method.getName());
			};
		}
	}
}
