package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.NotificaMapper;
import it.corso.AccademiJava.Model.Notifica;
import it.corso.AccademiJava.Model.PrioritaNotifica;
import it.corso.AccademiJava.Model.TipoNotifica;
import it.corso.AccademiJava.Repository.NotificaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificaService extends AbstractService<Notifica, NotificaDto> {

    @Autowired
    private final NotificaMapper notificaMapper;

    @Autowired
    private final NotificaRepository notificaRepository;

    protected NotificaService(JpaRepository<Notifica, Integer> repository, NotificaMapper notificaMapper, NotificaRepository notificaRepository) {
        super(repository, notificaMapper);
        this.notificaMapper = notificaMapper;
        this.notificaRepository = notificaRepository;
    }

    public NotificaDto FindByTitolo(String titolo) {
        return notificaMapper.toDTO(notificaRepository.findByTitolo(titolo));
    }

    public Integer CountMessaggioLength(String titolo) {
        NotificaDto notifica = FindByTitolo(titolo);
        if (notifica != null) {
            return notifica.getMessaggio().length();
        } else {
            return 0;
        }
    }

    public List<NotificaDto> FindByTipo(TipoNotifica tipo) {
        return notificaMapper.toDTOList(notificaRepository.findByTipo(tipo));
    }

    public List<NotificaDto> FindByPriorita(PrioritaNotifica priorita) {
        return notificaMapper.toDTOList(notificaRepository.findByPriorita(priorita));
    }

    public List<NotificaDto> FindByLetta(Boolean letta) {
        return notificaMapper.toDTOList(notificaRepository.findByLetta(letta));
    }

    public List<NotificaDto> FindByTitoloAndTipo(String titolo, TipoNotifica tipo) {
        return notificaMapper.toDTOList(notificaRepository.findByTitoloAndTipo(titolo, tipo));
    }

    public List<NotificaDto> FindByDataCreazioneAfter(LocalDateTime data) {
        return notificaMapper.toDTOList(notificaRepository.findByDataCreazioneAfter(data));
    }

    public List<NotificaDto> FindByMessaggioContaining(String messaggio) {
        return notificaMapper.toDTOList(notificaRepository.findByMessaggioContaining(messaggio));
    }

    public List<NotificaDto> FindByLettaNative(Boolean letta) {
        return notificaMapper.toDTOList(notificaRepository.findByLettaNative(letta));
    }

    public List<NotificaDto> FindByDataCreazioneAfterNative(LocalDateTime data) {
        return notificaMapper.toDTOList(notificaRepository.findByDataCreazioneAfterNative(data));
    }

    public List<NotificaDto> FindByTitoloContaining(String titolo) {
        return notificaMapper.toDTOList(notificaRepository.findByTitoloContainingIgnoreCase(titolo));
    }

    public List<NotificaDto> FindByTipoAndPriorita(TipoNotifica tipo, PrioritaNotifica priorita) {
        return notificaMapper.toDTOList(notificaRepository.findByTipoAndPriorita(tipo, priorita));
    }
}
