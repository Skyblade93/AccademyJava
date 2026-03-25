package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.OrdineDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Mapper.OrdineMapper;
import it.corso.AccademiJava.Mapper.UserMapper;
import it.corso.AccademiJava.Model.Ordine;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.OrdineRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdineService extends AbstractService<Ordine, OrdineDto> {

    @Autowired
    OrdineMapper ordineMapper;

    @Autowired
    OrdineRepository ordineRepository;
/*
    public OrdineDto FindById(Integer id){
        return ordineMapper.toDTO(ordineRepository.FindById(id));
    }

    public List<OrdineDto> FindByCosto_totale(float costo){
        return ordineMapper.toDTOList(ordineRepository.FindByCosto_totale(costo));
    }
*/
    public List<OrdineDto> trovaConNumeroProdottiMaggiore(Integer numero_prodotti){
        return ordineMapper.toDTOList(ordineRepository.trovaConNumeroProdottiMaggiore(numero_prodotti));
    }

    public List<OrdineDto> trovaConIndirizzo(String indirizzo){
        return ordineMapper.toDTOList(ordineRepository.trovaConIndirizzo(indirizzo));
    }

    public List<OrdineDto> trovaConCostoMaggiore(float costo){
        return ordineMapper.toDTOList(ordineRepository.trovaConCostoMaggiore(costo));
    }

    public List<OrdineDto> trovaConCostoMinore(float costo){
        return ordineMapper.toDTOList(ordineRepository.trovaConCostoMinore(costo));
    }

    public List<OrdineDto> trovaPerUtente( User utente){
        return ordineMapper.toDTOList(ordineRepository.trovaPerUtente(utente));
    }

    public List<OrdineDto> filtro(Integer numero, float costo){
        return ordineMapper.toDTOList(ordineRepository.filtro(numero, costo));
    }

    public List<OrdineDto> ordinaPerCostoDecrescente(String indirizzo){
        return ordineMapper.toDTOList(ordineRepository.ordinaPerCostoDecrescente());
    }

    public List<OrdineDto> trovaTraDueCosti(float min, float max){
        return ordineMapper.toDTOList(ordineRepository.trovaTraDueCosti(min, max));
    }

}