package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.Mapper.AutoMapper;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.TipoCarburante;
import it.corso.AccademiJava.Repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService extends AbstractService<Auto, AutoDto>{

    @Autowired
    private final    AutoMapper autoMapper;

    @Autowired
    private final   AutoRepository autoRepository;

    protected AutoService(JpaRepository<Auto, Integer> repository, Converter<Auto, AutoDto> converter, AutoMapper autoMapper, AutoRepository autoRepository) {
        super(repository, converter);
        this.autoMapper = autoMapper;
        this.autoRepository = autoRepository;
    }

    //  JPQL
    public AutoDto findByTarga(String targa) {return autoMapper.toDTO(autoRepository.findByTarga(targa)
        );
    }

    //  NATIVE
    public List<AutoDto> findByMarca(String marca) {
        return autoRepository.findByMarca(marca)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }


    //  DERIVATI

    public List<AutoDto> findByModello(String modello) {
        return autoRepository.findByModello(modello)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }


    public List<AutoDto> findByMarcaAndModello(String marca, String modello) {
        return autoRepository.findByMarcaAndModello(marca, modello)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }
    public List<AutoDto> findByModelloContaining(String modello) {
        return autoRepository.findByModelloContaining(modello)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }

    public List<AutoDto> findByMarcaStartingWith(String marca) {
        return autoRepository.findByMarcaStartingWith(marca)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }

    public List<AutoDto> findByMarcaEndingWith(String marca) {
        return autoRepository.findByMarcaEndingWith(marca)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }


    public List<AutoDto> findByCarburante(String carburante) {
        TipoCarburante c = TipoCarburante.valueOf(carburante.toUpperCase());

        return autoRepository.findByCarburante(c)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }

    public List<AutoDto> findByMarcaAndCarburante(String marca, TipoCarburante carburante) {
        return autoRepository.findByMarcaAndCarburante(marca, carburante)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }


}