package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Mapper.DipendenteMapper;
import it.corso.AccademiJava.Model.Dipendente;
import it.corso.AccademiJava.Repository.DipendenteRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DipendenteService extends AbstractService<Dipendente, DipendenteDto> {

    private final DipendenteMapper dipendenteMapper;
    //private final UserRepository userRepository;
    private final DipendenteRepository dipendenteRepository;

    protected DipendenteService(DipendenteMapper dipendenteMapper,
                                DipendenteRepository dipendenteRepository,
                                UserRepository userRepository, UserRepository userRepository1) {
        super(dipendenteRepository, dipendenteMapper);
        this.dipendenteMapper = dipendenteMapper;
        this.dipendenteRepository = dipendenteRepository;
        //this.userRepository = userRepository;
    }

    // 🔹 Metodo per trovare dipendente per nome, cognome e numero di telefono
    public DipendenteDto findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono(String nome, String cognome, Integer numeroTelefono) {
        return dipendenteMapper.toDTO(
                dipendenteRepository.findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono(nome, cognome, numeroTelefono)
        );
    }

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
    public DipendenteDto findByNomeDipendenteAndEta(String nomeDipendente, Integer eta) {
        return dipendenteMapper.toDTO(
                dipendenteRepository.findByNomeDipendenteAndEta(nomeDipendente, eta)
        );
    }

    // 🔹 Metodo 2 (JPQL) per trovare dipendente per cognome
    public DipendenteDto findByCognomeDipendente(String cognome) {
        return dipendenteMapper.toDTO(dipendenteRepository.findByCognomeDipendente(cognome));
    }

    // 🔹 Metodo 3 (Native) per trovare dipendente per email e numero di telefono
    public DipendenteDto findByEmailAndNumeroTelefono(String email, Integer numeroTelefono) {
        return dipendenteMapper.toDTO(
                dipendenteRepository.findByEmailAndNumber(email, numeroTelefono)
        );
    }

    // 🔹 Metodo 3 (native) per trovare dipendente per nome
    public DipendenteDto findByNomeDipendente(String nomeDipendente) {
        return dipendenteMapper.toDTO(dipendenteRepository.findByNomeDipendente(nomeDipendente));
    }

}