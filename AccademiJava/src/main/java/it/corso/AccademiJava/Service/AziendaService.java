package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Mapper.AziendaMapper;
import it.corso.AccademiJava.Model.Azienda;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.AziendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AziendaService extends AbstractService<Azienda, AziendaDto> {

    @Autowired
    private final AziendaMapper aziendaMapper;

    @Autowired
    private final AziendaRepository aziendaRepository;

    protected AziendaService(AziendaMapper aziendaMapper, AziendaRepository aziendaRepository) {
        super(aziendaRepository, aziendaMapper);
        this.aziendaMapper = aziendaMapper;
        this.aziendaRepository = aziendaRepository;
    }

    //Ricerca un'azienda esatta per nome
    public AziendaDto findByNomeAzienda(String nomeAzienda){
        return aziendaMapper.toDTO(
                aziendaRepository.findByNomeAzienda(nomeAzienda)
        );
    }

    //Ricerca aziende il cui nome contiene una parola (ignore case)
    public List<AziendaDto> findByNomeAziendaContainingIgnoreCase (String parola){
        return aziendaMapper.toDTOList(
                aziendaRepository.findByNomeAziendaContainingIgnoreCase(parola)
        );
    }


    //Ricerca aziende il cui nome contiene una parola (ignore case)
    public List<AziendaDto> findByDescrizioneAziendaContainingIgnoreCase(String descrizioneAzienda){
        return aziendaMapper.toDTOList(
                aziendaRepository.findByDescrizioneAziendaContainingIgnoreCase(descrizioneAzienda)
        );
    }


    //Ricerca un'azienda tramite l'ID del titolare (User.id)
    public AziendaDto findByTitolare_Id(Integer titolare){
        return aziendaMapper.toDTO(
                aziendaRepository.findByTitolare_Id(titolare)
        );
    }

    //Ricerca aziende il cui nome contiene una parola (case-sensitive)
    public List<AziendaDto> findByNomeAziendaContaining(String parola){
        return aziendaMapper.toDTOList(aziendaRepository.findByNomeAziendaContaining(parola));
    }


    //Cerca un'azienda esatta per nome (simile a findByNomeAzienda)
    public AziendaDto cercaPerNome(String nomeAzienda){
        return aziendaMapper.toDTO(
                aziendaRepository.CercaPerNome(nomeAzienda)
        );
    }


    //Cerca un'azienda esatta per nome (simile a findByNomeAzienda)
    public List<AziendaDto> cercaPerDescrizione(String descrizioneAzienda){
        return aziendaMapper.toDTOList(
                aziendaRepository.CercaPerDescrizione(descrizioneAzienda)
        );
    }

    // Cerca aziende per descrizione (lista)
    public List<AziendaDto> trovaPerDescrizioneNative(String descrizione){
        return aziendaMapper.toDTOList(
                aziendaRepository.TrovaPerDescrizioneNative(descrizione)
        );
    }

    public Page<AziendaDto> getAziendePaginati(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Azienda> aziendePage = aziendaRepository.findAll(pageable);

        return aziendePage.map(aziendaMapper::toDTO);
    }

}
