package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.Model.Elettricista;
import it.corso.AccademiJava.Repository.ElettricistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElettricistaService extends AbstractService {

    @Autowired
    private ElettricistaRepository elettricistaRepository;

    // 1 JPA AUT
    public Elettricista findByNome(String nome) {
        return elettricistaRepository.findByNome(nome);
    }

    // 2 JPA AUT
    public List<Elettricista> findDisponibili() {
        return elettricistaRepository.findByDisponibileTrue();
    }

    // 3 JPA AUT
    public List<Elettricista> findByCognome(String cognome) {
        return elettricistaRepository.findByCognome(cognome);
    }

    // 4 JPA AUT
    public List<Elettricista> findBySpecializzazione(String specializzazione) {
        return elettricistaRepository.findBySpecializzazione(specializzazione);
    }

    // 5 JPQL
    public Elettricista cercaPerNomeJPQL(String nome) {
        return elettricistaRepository.cercaPerNomeJPQL(nome);
    }

    // 6 JPQL
    public List<Elettricista> elettricistiDisponibiliJPQL() {
        return elettricistaRepository.elettricistiDisponibiliJPQL();
    }

    // 7 NAT
    public Elettricista findByNomeNative(String nome) {
        return elettricistaRepository.findByNomeNative(nome);
    }

    // 8 NAT
    public List<Elettricista> findDisponibiliNative() {
        return elettricistaRepository.findDisponibiliNative();
    }

    // 9JPA AUT
    public List<Elettricista> findByCognomeAndDisponibileTrue(String cognome) {
        return elettricistaRepository.findByCognomeAndDisponibileTrue(cognome);
    }

    // 10JPA AUT
    public List<Elettricista> findBySpecializzazioneAndDisponibileFalse(String specializzazione) {
        return elettricistaRepository.findBySpecializzazioneAndDisponibileFalse(specializzazione);
    }
}