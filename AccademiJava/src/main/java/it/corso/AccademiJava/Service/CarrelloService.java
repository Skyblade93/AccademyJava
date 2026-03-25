package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Mapper.CarrelloMapper;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.UserMapper;
import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.CarrelloRepository;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService extends AbstractService<Carrello, CarrelloDto> {

    private final CarrelloRepository carrelloRepository;

    private final CarrelloMapper carrelloMapper;

    protected CarrelloService(JpaRepository<Carrello, Integer> repository, Converter<Carrello, CarrelloDto> converter, CarrelloMapper carrelloMapper, CarrelloRepository carrelloRepository) {
        super(repository, converter);
        this.carrelloMapper = carrelloMapper;
        this.carrelloRepository = carrelloRepository;
    }

    public CarrelloDto findById(int id) {
        CarrelloDto carrelloDto = carrelloMapper.toDTO(carrelloRepository.findById(id));
        return carrelloDto;
    }

    public CarrelloDto findByQuantita(int quantita) {
        CarrelloDto carrelloDto = carrelloMapper.toDTO(carrelloRepository.findByQuantita(quantita));
        return carrelloDto;
    }

    public CarrelloDto findById(double prezzoTotale) {
        CarrelloDto carrelloDto = carrelloMapper.toDTO(carrelloRepository.findByPrezzoTotale(prezzoTotale));
        return carrelloDto;
    }
}
