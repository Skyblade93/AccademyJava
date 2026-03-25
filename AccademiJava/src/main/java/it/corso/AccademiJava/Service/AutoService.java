package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.Mapper.AutoMapper;
import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.TipoCarburante;
import it.corso.AccademiJava.Repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoService extends AbstractService<Auto, AutoDto>{

    @Autowired
    AutoMapper autoMapper;

    @Autowired
    AutoRepository autoRepository;

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
    public AutoDto findByCarburante(String carburante) { TipoCarburante c = TipoCarburante.valueOf(carburante.toUpperCase());
        return autoMapper.toDTO(autoRepository.findByCarburante(c).getFirst()
        );
    }

    public AutoDto findByMarcaAndCarburante(String marca, String carburante) {
        TipoCarburante c = TipoCarburante.valueOf(carburante.toUpperCase());
        return autoMapper.toDTO(autoRepository.findByMarcaAndCarburante(marca, c).getFirst()
        );
    }
}