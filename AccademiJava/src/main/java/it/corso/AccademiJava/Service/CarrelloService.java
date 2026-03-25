package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.Mapper.CarrelloMapper;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Repository.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService extends AbstractService<Carrello, CarrelloDto> {

    @Autowired
    private final   CarrelloRepository carrelloRepository;

    @Autowired
    private final   CarrelloMapper carrelloMapper;

    protected CarrelloService(JpaRepository<Carrello, Integer> repository, Converter<Carrello, CarrelloDto> converter, CarrelloRepository carrelloRepository, CarrelloMapper carrelloMapper) {
        super(repository, converter);
        this.carrelloRepository = carrelloRepository;
        this.carrelloMapper = carrelloMapper;
    }

    public CarrelloDto FindById(int id) {
        return carrelloMapper.toDTO(carrelloRepository.findById(id));
    }

    public CarrelloDto FindByPrezzoTotale(double prezzoTotale) {
        return carrelloMapper.toDTO(carrelloRepository.findByPrezzoTotale(prezzoTotale));
    }

    public CarrelloDto FindByQuantita(int quantita) {
        return carrelloMapper.toDTO(carrelloRepository.findByQuantita(quantita));

    }
}
