package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Mapper.AziendaMapper;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Model.Azienda;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.AziendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AziendaService extends AbstractService<Azienda, AziendaDto> {

    @Autowired
    private final   AziendaMapper aziendaMapper;

    @Autowired
    private final   AziendaRepository aziendaRepository;

    protected AziendaService(JpaRepository<Azienda, Integer> repository, Converter<Azienda, AziendaDto> converter, AziendaMapper aziendaMapper, AziendaRepository aziendaRepository) {
        super(repository, converter);
        this.aziendaMapper = aziendaMapper;
        this.aziendaRepository = aziendaRepository;
    }
    /*

    public AziendaDto findByNomeAzienda(String nomeAzienda){
        return aziendaMapper.toDTO(
                aziendaRepository.findByNomeAzienda(nomeAzienda)
        );
    }

    public AziendaDto findByDescrizioneAzienda(String descrizioneAzienda){
        return aziendaMapper.toDTO(
                aziendaRepository.findByDescrizioneAzienda(descrizioneAzienda)
        );
    }

    public AziendaDto findByTitolare(User titolare){
        return aziendaMapper.toDTO(
                aziendaRepository.findByTitolare(titolare)
        );
    }

    public AziendaDto cercaPerNome(String nomeAzienda){
        return aziendaMapper.toDTO(
                aziendaRepository.CercaPerNome(nomeAzienda)
        );
    }

    // Richiama: TrovaPerDescrizioneNative
    public AziendaDto trovaPerDescrizioneNative(String descrizione){
        return aziendaMapper.toDTO(
                aziendaRepository.TrovaPerDescrizioneNative(descrizione)
        );
    }

     */
}
