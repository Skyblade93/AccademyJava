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

import java.util.ArrayList;
import java.util.List;

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

        Carrello entity = carrelloRepository.findById(id);

        if (entity == null) {
            return null;
        }

        return carrelloMapper.toDTO(entity);
    }

    public List<CarrelloDto> cercaPerQuantita(int quantita) {
        return carrelloMapper.toDTOList(carrelloRepository.cercaPerQuantita(quantita));
    }

    public List<CarrelloDto> cercaPrezzoTotale(double prezzoTotale) {
        return carrelloMapper.toDTOList(carrelloRepository.cercaPrezzoTotale(prezzoTotale));
    }

    public CarrelloDto findByIdAndPrezzoTotale(int Id, double prezzoTotale) {
        CarrelloDto carrelloDto = carrelloMapper.toDTO(carrelloRepository.findByIdAndPrezzoTotale(Id, prezzoTotale));
        return carrelloDto;
    }

    public CarrelloDto findByIdAndQuantita(int Id, int quantita) {
        CarrelloDto carrelloDto = carrelloMapper.toDTO(carrelloRepository.findByIdAndQuantita(Id, quantita));
        return carrelloDto;
    }

    public List<CarrelloDto> findByQuantitaAndPrezzoTotale(int quantita, double prezzoTotale) {
         return carrelloMapper.toDTOList(carrelloRepository.findByQuantitaAndPrezzoTotale(quantita, prezzoTotale));
    }

    public List<Boolean> trovaPrezzoMaggioreDi10(double prezzoTotale) {
        //recupero della lista di carrelli
        List<CarrelloDto> carrelli = carrelloMapper.toDTOList(carrelloRepository.cercaPrezzoTotale(prezzoTotale));

        //genero una lista di boolean che da vero o falso in base alla condizione
        return carrelli.stream().map(dto -> dto.getPrezzoTotale() > 10).toList();
    }

}
