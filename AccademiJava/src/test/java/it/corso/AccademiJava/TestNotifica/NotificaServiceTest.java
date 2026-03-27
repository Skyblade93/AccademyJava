package it.corso.AccademiJava.TestNotifica;

import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Mapper.NotificaMapper;
import it.corso.AccademiJava.Model.Notifica;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import it.corso.AccademiJava.Repository.NotificaRepository;
import it.corso.AccademiJava.Service.NotificaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificaServiceTest {

	@Mock
	private JpaRepository<Notifica, Integer> repository;

	@Mock
	private NotificaRepository notificaRepository;

	@Spy
	private NotificaMapper mapper = new NotificaMapper();

	@InjectMocks
	private TestableNotificaService service;

	@Test
	void findByTitolo_restituisceDtoMappato() {
		Notifica entity = buildEntity("Titolo A", "Messaggio A");
		when(notificaRepository.findByTitolo("Titolo A")).thenReturn(entity);

		NotificaDto result = service.FindByTitolo("Titolo A");

		assertEquals("Titolo A", result.getTitolo());
		assertEquals("Messaggio A", result.getMessaggio());
		verify(notificaRepository).findByTitolo("Titolo A");
	}

	@Test
	void countMessaggioLength_restituisceLunghezzaQuandoEsisteNotifica() {
		Notifica entity = buildEntity("Titolo B", "123456");
		when(notificaRepository.findByTitolo("Titolo B")).thenReturn(entity);

		Integer result = service.CountMessaggioLength("Titolo B");

		assertEquals(6, result);
		verify(notificaRepository).findByTitolo("Titolo B");
	}

	@Test
	void countMessaggioLength_restituisceZeroQuandoNotificaAssente() {
		when(notificaRepository.findByTitolo("Mancante")).thenReturn(null);

		Integer result = service.CountMessaggioLength("Mancante");

		assertEquals(0, result);
		verify(notificaRepository).findByTitolo("Mancante");
	}

	@Test
	void findByTipo_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("A", "m"));
		when(notificaRepository.findByTipo(TipoNotifica.ERRORE)).thenReturn(entities);

		List<NotificaDto> result = service.FindByTipo(TipoNotifica.ERRORE);

		assertEquals(1, result.size());
		assertEquals("A", result.getFirst().getTitolo());
		verify(notificaRepository).findByTipo(TipoNotifica.ERRORE);
	}

	@Test
	void findByPriorita_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("B", "n"));
		when(notificaRepository.findByPriorita(PrioritaNotifica.ALTA)).thenReturn(entities);

		List<NotificaDto> result = service.FindByPriorita(PrioritaNotifica.ALTA);

		assertEquals(1, result.size());
		assertEquals("B", result.getFirst().getTitolo());
		verify(notificaRepository).findByPriorita(PrioritaNotifica.ALTA);
	}

	@Test
	void findByLetta_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("C", "o"));
		when(notificaRepository.findByLetta(Boolean.TRUE)).thenReturn(entities);

		List<NotificaDto> result = service.FindByLetta(Boolean.TRUE);

		assertEquals(1, result.size());
		assertEquals("C", result.getFirst().getTitolo());
		verify(notificaRepository).findByLetta(Boolean.TRUE);
	}

	@Test
	void findByTitoloAndTipo_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("Sistema", "update"));
		when(notificaRepository.findByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE)).thenReturn(entities);

		List<NotificaDto> result = service.FindByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE);

		assertEquals(1, result.size());
		assertEquals("Sistema", result.getFirst().getTitolo());
		verify(notificaRepository).findByTitoloAndTipo("Sistema", TipoNotifica.MANUTENZIONE);
	}

	@Test
	void findByDataCreazioneAfter_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("D", "p"));
		LocalDateTime data = LocalDateTime.of(2026, 3, 1, 10, 0);
		when(notificaRepository.findByDataCreazioneAfter(data)).thenReturn(entities);

		List<NotificaDto> result = service.FindByDataCreazioneAfter(data);

		assertEquals(1, result.size());
		assertEquals("D", result.getFirst().getTitolo());
		verify(notificaRepository).findByDataCreazioneAfter(data);
	}

	@Test
	void findByMessaggioContaining_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("E", "errore"));
		when(notificaRepository.findByMessaggioContaining("err")).thenReturn(entities);

		List<NotificaDto> result = service.FindByMessaggioContaining("err");

		assertEquals(1, result.size());
		assertEquals("E", result.getFirst().getTitolo());
		verify(notificaRepository).findByMessaggioContaining("err");
	}

	@Test
	void findByLettaNative_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("F", "ok"));
		when(notificaRepository.findByLettaNative(Boolean.FALSE)).thenReturn(entities);

		List<NotificaDto> result = service.FindByLettaNative(Boolean.FALSE);

		assertEquals(1, result.size());
		assertEquals("F", result.getFirst().getTitolo());
		verify(notificaRepository).findByLettaNative(Boolean.FALSE);
	}

	@Test
	void findByDataCreazioneAfterNative_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("G", "native"));
		LocalDateTime data = LocalDateTime.of(2026, 3, 20, 9, 15);
		when(notificaRepository.findByDataCreazioneAfterNative(data)).thenReturn(entities);

		List<NotificaDto> result = service.FindByDataCreazioneAfterNative(data);

		assertEquals(1, result.size());
		assertEquals("G", result.getFirst().getTitolo());
		verify(notificaRepository).findByDataCreazioneAfterNative(data);
	}

	@Test
	void findByTitoloContaining_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("Titolo esteso", "txt"));
		when(notificaRepository.findByTitoloContaining("Titolo")).thenReturn(entities);

		List<NotificaDto> result = service.FindByTitoloContaining("Titolo");

		assertEquals(1, result.size());
		assertEquals("Titolo esteso", result.getFirst().getTitolo());
		verify(notificaRepository).findByTitoloContaining("Titolo");
	}

	@Test
	void findByTipoAndPriorita_restituisceListaDto() {
		List<Notifica> entities = List.of(buildEntity("Alert", "critico"));
		when(notificaRepository.findByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA)).thenReturn(entities);

		List<NotificaDto> result = service.FindByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA);

		assertEquals(1, result.size());
		assertEquals("Alert", result.getFirst().getTitolo());
		verify(notificaRepository).findByTipoAndPriorita(TipoNotifica.AVVERTIMENTO, PrioritaNotifica.CRITICA);
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

	private static class TestableNotificaService extends NotificaService {
		TestableNotificaService(JpaRepository<Notifica, Integer> repository,
								NotificaMapper mapper,
								NotificaRepository notificaRepository) {
			super(repository, mapper, notificaRepository);
		}
	}
}
