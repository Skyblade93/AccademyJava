package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.DipendenteMapper;
import it.corso.AccademiJava.Model.Dipendente;
import it.corso.AccademiJava.Repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DipendenteService extends AbstractService<Dipendente, DipendenteDto> {

    @Autowired
    private final  DipendenteMapper dipendenteMapper;

    @Autowired
    private final  DipendenteRepository dipendenteRepository;

    protected DipendenteService(JpaRepository<Dipendente, Integer> repository, Converter<Dipendente, DipendenteDto> converter, DipendenteMapper dipendenteMapper, DipendenteRepository dipendenteRepository) {
        super(repository, converter);
        this.dipendenteMapper = dipendenteMapper;
        this.dipendenteRepository = dipendenteRepository;
    }

    /*
        // 🔹 Metodo per trovare dipendente per nome, cognome e numero di telefono
        public DipendenteDto findByNomeAndCognomeAndNumber(String nome, String cognome, Integer numeroTelefono) {
            return dipendenteMapper.toDTO(
                    dipendenteRepository.findByNomeAndCognomeAndNumber(nome, cognome, numeroTelefono)
            );
        }
    */
    // 🔹 Metodo per trovare dipendente per nome e cognome
    public DipendenteDto findByNomeAndCognome(String nome, String cognome) {
        return dipendenteMapper.toDTO(
                dipendenteRepository.findByNomeDipendenteAndCognomeDipendente(nome, cognome)
        );
    }

    // 🔹 Metodo per trovare dipendenti per età
    public List<DipendenteDto> findByEta(Integer eta) {
        return dipendenteRepository.findByEta(eta)
                .stream()
                .map(dipendenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Metodo per trovare dipendenti con età maggiore di ...
    public List<DipendenteDto> findByEtaGreaterThan(Integer eta) {
        return dipendenteRepository.findByEtaGreaterThan(eta)
                .stream()
                .map(dipendenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    // 🔹 Metodo per trovare dipendente per email
    public DipendenteDto findByEmail(String email) {
        return dipendenteMapper.toDTO(dipendenteRepository.findByEmail(email));
    }

    // 🔹 Metodo per trovare dipendente per email ed età
    public DipendenteDto findByEmailAndEta(String email, Integer eta) {
        return dipendenteMapper.toDTO(
                dipendenteRepository.findByEmailAndEta(email, eta)
        );
    }

    // 🔹 Metodo 2 (JPQL) per trovare dipendente per nome ed età
    public DipendenteDto findByNomeAndEta(String nomeDipendente, Integer eta) {
        return dipendenteMapper.toDTO(
                dipendenteRepository.findByNomeAndEta(nomeDipendente, eta)
        );
    }

    // 🔹 Metodo 2 (JPQL) per trovare dipendente per cognome
    public DipendenteDto findByCognome(String cognome) {
        return dipendenteMapper.toDTO(dipendenteRepository.findByCognome(cognome));
    }

    // 🔹 Metodo 3 (Native) per trovare dipendente per email e numero di telefono
    public DipendenteDto findByEmailAndNumeroTelefono(String email, Integer numeroTelefono) {
        return dipendenteMapper.toDTO(
                dipendenteRepository.findByEmailAndNumber(email, numeroTelefono)
        );
    }

    // 🔹 Metodo 3 (native) per trovare dipendente per nome
    public DipendenteDto findByNome(String nomeDipendente) {
        return dipendenteMapper.toDTO(dipendenteRepository.findByNome(nomeDipendente));
    }

}