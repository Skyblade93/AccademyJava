package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.Mapper.CarrelloMapper;
import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Repository.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService extends AbstractService<Carrello, CarrelloDto> {

    @Autowired
    CarrelloRepository carrelloRepository;

    @Autowired
    CarrelloMapper carrelloMapper;

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
