package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Mapper.AziendaMapper;
import it.corso.AccademiJava.Model.Azienda;
import it.corso.AccademiJava.Repository.AziendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AziendaService extends AbstractService<Azienda, AziendaDto> {

    @Autowired
    AziendaMapper aziendaMapper;

    @Autowired
    AziendaRepository aziendaRepository;
/*
    public AziendaDto findByNomeAzienda(String NomeAzienda){
        return aziendaMapper.toDTO(
                aziendaRepository.findByNomeAzienda(NomeAzienda)
        );
    }

    public AziendaDto findByDescrizioneAzienda(String descrizione){
        return aziendaMapper.toDTO(
                aziendaRepository.findByDescrizioneAzienda(descrizione)
        );
    }

    public AziendaDto findByTitolare(String titolare){
        return aziendaMapper.toDTO(
                aziendaRepository.findByTitolare(titolare)
        );
    }
*/
    public AziendaDto cercaPerNome(String nome){
        return aziendaMapper.toDTO(
                aziendaRepository.CercaPerNome(nome)
        );
    }

    // Richiama: TrovaPerDescrizioneNative
    public AziendaDto trovaPerDescrizioneNative(String descrizione){
        return aziendaMapper.toDTO(
                aziendaRepository.TrovaPerDescrizioneNative(descrizione)
        );
    }
}
