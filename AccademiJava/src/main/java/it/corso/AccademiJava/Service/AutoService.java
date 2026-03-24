package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.Mapper.AutoMapper;
import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AutoService extends AbstractService<Auto, AutoDto>{

    @Autowired
    AutoRepository autoRepository;

    @Autowired
    AutoMapper autoMapper;

    //  CREATE
    public Auto salvaAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    //  READ ALL
    public List<Auto> getAllAuto() {
        return autoRepository.findAll();
    }

    //  READ BY ID
    public Auto getAutoById(Integer id) {
        Optional<Auto> auto = autoRepository.findById(id);
        return auto.orElse(null);
    }

    //  JPQL
    public Auto getByTargaJPQL(String targa) {
        return autoRepository.trovaPerTargaJPQL(targa);
    }

    //  NATIVE
    public List<Auto> getByMarcaNative(String marca) {
        return autoRepository.trovaPerMarcaNative(marca);
    }

    //  DERIVATI

    public Auto getByTarga(String targa) {
        return autoRepository.findByTarga(targa);
    }

    public List<Auto> getByModello(String modello) {
        return autoRepository.findByModello(modello);
    }

    public List<Auto> getByMarca(String marca) {
        return autoRepository.findByMarca(marca);
    }

    public List<Auto> getByMarcaAndModello(String marca, String modello) {
        return autoRepository.findByMarcaAndModello(marca, modello);
    }

    public List<Auto> cercaModelloContiene(String modello) {
        return autoRepository.findByModelloContaining(modello);
    }

    public List<Auto> cercaMarcaIniziaPer(String marca) {
        return autoRepository.findByMarcaStartingWith(marca);
    }

    public List<Auto> cercaMarcaFiniscePer(String marca) {
        return autoRepository.findByMarcaEndingWith(marca);
    }

    //  UPDATE
    public Auto aggiornaAuto(Integer id, Auto nuovaAuto) {
        Optional<Auto> autoOpt = autoRepository.findById(id);

        if (autoOpt.isPresent()) {
            Auto auto = autoOpt.get();

            auto.setTarga(nuovaAuto.getTarga());
            auto.setMarca(nuovaAuto.getMarca());
            auto.setModello(nuovaAuto.getModello());

            return autoRepository.save(auto);
        }

        return null;
    }

    //  DELETE
    public void eliminaAuto(Integer id) {
        autoRepository.deleteById(id);
    }
}