package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Mapper.ElettricistaMapper;
import it.corso.AccademiJava.Model.Elettricista;
import it.corso.AccademiJava.Repository.ElettricistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElettricistaService extends AbstractService<Elettricista, ElettricistaDto> {


    private final  ElettricistaRepository elettricistaRepository;


    private final ElettricistaMapper elettricistaMapper;

    public ElettricistaService(ElettricistaRepository elettricistaRepository,
                               ElettricistaMapper elettricistaMapper) {

        super(elettricistaRepository, elettricistaMapper);
        this.elettricistaRepository = elettricistaRepository;
        this.elettricistaMapper = elettricistaMapper;
    }

    // 1 JPA AUT
    public ElettricistaDto findByNome(String nome) {
        return elettricistaMapper.toDTO(elettricistaRepository.findByNome(nome));
    }

    // 2 JPA AUT
    public List<ElettricistaDto> findDisponibili() {
        return elettricistaMapper.toDTOList(elettricistaRepository.findByDisponibileTrue());
    }

    // 3 JPA AUT
    public List<ElettricistaDto> findByCognome(String cognome) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findByCognome(cognome));
    }

    // 4 JPA AUT
    public List<ElettricistaDto> findBySpecializzazione(String specializzazione) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findBySpecializzazione(specializzazione));
    }

    // 5 JPQL
    public ElettricistaDto cercaPerNomeJPQL(String nome) {
        return elettricistaMapper.toDTO(elettricistaRepository.cercaPerNomeJPQL(nome));
    }

    // 6 JPQL
    public List<ElettricistaDto> elettricistiDisponibiliJPQL() {
        return elettricistaMapper.toDTOList(elettricistaRepository.elettricistiDisponibiliJPQL());
    }

    // 7 NAT
    public ElettricistaDto findByNomeNative(String nome) {
        return elettricistaMapper.toDTO(elettricistaRepository.findByNomeNative(nome));
    }

    // 8 NAT
    public List<ElettricistaDto> findDisponibiliNative() {
        return elettricistaMapper.toDTOList(elettricistaRepository.findDisponibiliNative());
    }

    // 9JPA AUT
    public List<ElettricistaDto> findByCognomeAndDisponibileTrue(String cognome) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findByCognomeAndDisponibileTrue(cognome));
    }

    // 10JPA AUT
    public List<ElettricistaDto> findBySpecializzazioneAndDisponibileFalse(String specializzazione) {
        return elettricistaMapper.toDTOList(elettricistaRepository.findBySpecializzazioneAndDisponibileFalse(specializzazione));
    }}