package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.OrdineDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.OrdineMapper;
import it.corso.AccademiJava.Mapper.UserMapper;
import it.corso.AccademiJava.Model.Ordine;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.OrdineRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdineService extends AbstractService<Ordine, OrdineDto> {

    private final  OrdineMapper ordineMapper;
    private final   OrdineRepository ordineRepository;

    public OrdineService(JpaRepository<Ordine, Integer> repository, Converter<Ordine, OrdineDto> converter, OrdineMapper ordineMapper, OrdineRepository ordineRepository) {
        super(repository, converter);
        this.ordineMapper = ordineMapper;
        this.ordineRepository = ordineRepository;
    }
/*
    public OrdineDto findById(int id){
            return ordineMapper.toDTO(ordineRepository.findById(id));
    }

    public List<OrdineDto> findByCosto_totale(float costo){
            return ordineMapper.toDTOList(ordineRepository.findByCosto_totale(costo));
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

    public List<OrdineDto> trovaPerUtente( Integer id){
        return ordineMapper.toDTOList(ordineRepository.trovaPerUtente(id));
    }

    public List<OrdineDto> filtro(Integer numero, float costo){
        return ordineMapper.toDTOList(ordineRepository.filtro(numero, costo));
    }

    public List<OrdineDto> ordinaPerCostoDecrescente(){
        return ordineMapper.toDTOList(ordineRepository.ordinaPerCostoDecrescente());
    }

    public List<OrdineDto> trovaTraDueCosti(float min, float max){
        return ordineMapper.toDTOList(ordineRepository.trovaTraDueCosti(min, max));
    }

}