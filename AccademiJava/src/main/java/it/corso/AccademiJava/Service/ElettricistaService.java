package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Mapper.ElettricistaMapper;
import it.corso.AccademiJava.Model.Elettricista;
import it.corso.AccademiJava.Repository.ElettricistaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElettricistaService extends AbstractService<Elettricista, ElettricistaDto> {

    private final ElettricistaRepository elettricistaRepository;
    private final ElettricistaMapper elettricistaMapper;

    public ElettricistaService(ElettricistaRepository elettricistaRepository,
                               ElettricistaMapper elettricistaMapper) {
        super(elettricistaRepository, elettricistaMapper);
        this.elettricistaRepository = elettricistaRepository;
        this.elettricistaMapper = elettricistaMapper;
    }


    // 1 JPA AUTO X NOME
    public ElettricistaDto findByNome(String nome) {
        return elettricistaMapper.toDTO(elettricistaRepository.findByNome(nome));
    }
    // 2 JAP AUTO X ELETTR. DISP.
    public List<ElettricistaDto> findDisponibili() {
        return elettricistaMapper.toDTOList(elettricistaRepository.findByDisponibileTrue());
    }
    // 3 JPA AUTO X COGNOME
    public List<ElettricistaDto> findByCognome(String cognome) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findByCognome(cognome));
    }
    // 4 JPA AUTO X SPECIALIZZ.
    public List<ElettricistaDto> findBySpecializzazione(String specializzazione) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findBySpecializzazione(specializzazione));
    }
    // 5 JPQL CERCA X NOME
    public ElettricistaDto cercaPerNomeJPQL(String nome) {
        return elettricistaMapper.toDTO(elettricistaRepository.cercaPerNomeJPQL(nome));
    }
    // 6 JPQL LIST.DISP.
    public List<ElettricistaDto> elettricistiDisponibiliJPQL() {
        return elettricistaMapper.toDTOList(elettricistaRepository.elettricistiDisponibiliJPQL());
    }

    // 7 NATIVA X NOME
    public ElettricistaDto findByNomeNative(String nome) {
        Elettricista e = elettricistaRepository.findByNomeNative(nome);
        if (e == null) return null;          // <-- controllo aggiunto
        return elettricistaMapper.toDTO(e);
    }

    // 8 NATIVA DISP.
    public List<ElettricistaDto> findDisponibiliNative() {
        List<Elettricista> list = elettricistaRepository.findDisponibiliNative();
        if (list == null || list.isEmpty()) return new ArrayList<>(); // <-- controllo aggiunto
        return elettricistaMapper.toDTOList(list);
    }
    // 9 COGNOME + NO DISP.
    public List<ElettricistaDto> findByCognomeAndDisponibileTrue(String cognome) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findByCognomeAndDisponibileTrue(cognome));
    }
    // 10 SPECIALIZZ. + NO DISP.
    public List<ElettricistaDto> findBySpecializzazioneAndDisponibileFalse(String specializzazione) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findBySpecializzazioneAndDisponibileFalse(specializzazione));
    }



    public
}