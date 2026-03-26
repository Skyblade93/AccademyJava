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
    public AutoDto findByMarca(String marca) {return autoMapper.toDTO(autoRepository.findByMarca(marca).getFirst()
        );
    }

    //  DERIVATI

    public AutoDto findByModello(String modello) {return autoMapper.toDTO(autoRepository.findByModello(modello).getFirst()
        );
    }

    public AutoDto findByMarcaAndModello(String marca, String modello) {return autoMapper.toDTO(autoRepository.findByMarcaAndModello(marca, modello).getFirst()
        );
    }

    public AutoDto findByModelloContaining(String modello) {return autoMapper.toDTO(autoRepository.findByModelloContaining(modello).getFirst()
        );
    }

    public AutoDto findByMarcaStartingWith(String marca) {return autoMapper.toDTO(autoRepository.findByMarcaStartingWith(marca).getFirst()
        );
    }

    public AutoDto findByMarcaEndingWith(String marca) {return autoMapper.toDTO(autoRepository.findByMarcaEndingWith(marca).getFirst()
        );
    }


    public List<AutoDto> findByCarburante(String carburante) {
        TipoCarburante c = TipoCarburante.valueOf(carburante.toUpperCase());

        return autoRepository.findByCarburante(c)
                .stream()
                .map(autoMapper::toDTO)
                .toList();
    }
/*
    public AutoDto findByMarcaAndCarburante(String marca, String carburante) {
        TipoCarburante c = TipoCarburante.valueOf(carburante.toUpperCase());
        return autoMapper.toDTO(autoRepository.findByMarcaAndCarburante(marca, c).getFirst()
        );
    }

     */
}