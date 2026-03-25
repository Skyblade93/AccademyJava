package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.CarrelloDto;
import it.corso.AccademiJava.Mapper.CarrelloMapper;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Model.Carrello;
import it.corso.AccademiJava.Repository.CarrelloRepository;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrelloService extends AbstractService<Carrello, CarrelloDto> {

    private final CarrelloRepository carrelloRepository;

    private final UserRepository userRepository;

    public CarrelloService(CarrelloRepository carrelloRepository, UserRepository userRepository, CarrelloMapper carrelloMapper) {

        super(carrelloRepository, carrelloMapper);
        this.carrelloRepository = carrelloRepository;
        this.userRepository = userRepository;
    }

    public Carrello findById(int id) {
        return carrelloRepository.findById(id);
    }

    public Carrello findByQuantita(int quantita) {
        return carrelloRepository.findByQuantita(quantita);
    }

    public Carrello findById(double prezzoTotale) {
        return carrelloRepository.findByPrezzoTotale(prezzoTotale);
    }
}
