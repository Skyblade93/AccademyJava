package it.corso.AccademiJava.DipendenteTest;


import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Mapper.DipendenteMapper;
import it.corso.AccademiJava.Model.Dipendente;
import it.corso.AccademiJava.Repository.DipendenteRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import it.corso.AccademiJava.Service.DipendenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DipendenteServiceTest {

    @Mock
    private DipendenteRepository dipendenteRepository;

    @Mock
    private DipendenteMapper dipendenteMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DipendenteService dipendenteService;

    private Dipendente dipendente;
    private DipendenteDto dipendenteDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        dipendente = new Dipendente();
        dipendente.setId(1);
        dipendente.setNomeDipendente("Topolino");
        dipendente.setCognomeDipendente("Mouse");
        dipendente.setEta(10);
        dipendente.setEmail("topolino@disney.com");
        dipendente.setNumeroTelefono(123);

        dipendenteDto = new DipendenteDto();
        dipendenteDto.setId(1);
        dipendenteDto.setNomeDipendente("Topolino");
        dipendenteDto.setCognomeDipendente("Mouse");
        dipendenteDto.setEta(10);
        dipendenteDto.setEmail("topolino@disney.com");
        dipendenteDto.setNumeroTelefono(123);
    }

    // 🔹 Test 1: Trova dipendente per nome, cognome e numero di telefono
    @Test
    void testFindByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono() {
        when(dipendenteRepository.findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono("Topolino", "Mouse", 123))
                .thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono("Topolino", "Mouse", 123);

        assertNotNull(result);
        assertEquals("Topolino", result.getNomeDipendente());
        assertEquals(123, result.getNumeroTelefono());
    }

    // 🔹Test 2: Trova dipendente per nome e cognome
    @Test
    void testFindByNomeAndCognome() {
        when(dipendenteRepository.findByNomeDipendenteAndCognomeDipendente("Topolino", "Mouse"))
                .thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByNomeAndCognome("Topolino", "Mouse");

        assertEquals("Mouse", result.getCognomeDipendente());
    }

    // 🔹Test 3: Trova dipendente per età
    @Test
    void testFindByEta() {
        when(dipendenteRepository.findByEta(10)).thenReturn(List.of(dipendente));
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        List<DipendenteDto> result = dipendenteService.findByEta(10);

        assertEquals(1, result.size());
        assertEquals("Topolino", result.get(0).getNomeDipendente());
    }

    // 🔹Test 4: Trova dipendenti con età maggiore di ...
    @Test
    void testFindByEtaGreaterThan() {
        when(dipendenteRepository.findByEtaGreaterThan(5)).thenReturn(List.of(dipendente));
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        List<DipendenteDto> result = dipendenteService.findByEtaGreaterThan(5);

        assertTrue(result.get(0).getEta() > 5);
    }

    // 🔹Test 5: Trova dipendente per email
    @Test
    void testFindByEmail() {
        when(dipendenteRepository.findByEmail("topolino@disney.com")).thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByEmail("topolino@disney.com");

        assertEquals("topolino@disney.com", result.getEmail());
    }

    // 🔹Test 6: Trova dipendente per email ed età
    @Test
    void testFindByEmailAndEta() {
        when(dipendenteRepository.findByEmailAndEta("topolino@disney.com", 10)).thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByEmailAndEta("topolino@disney.com", 10);

        assertEquals(10, result.getEta());
    }

    // 🔹Test 7: Trova dipendente per nome ed età
    @Test
    void testFindByNomeDipendenteAndEta() {
        when(dipendenteRepository.findByNomeDipendenteAndEta("Topolino", 10)).thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByNomeDipendenteAndEta("Topolino", 10);

        assertEquals("Topolino", result.getNomeDipendente());
        assertEquals(10, result.getEta());
    }

    // 🔹Test 8: Trova dipendente per cognome
    @Test
    void testFindByCognomeDipendente() {
        when(dipendenteRepository.findByCognomeDipendente("Mouse")).thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByCognomeDipendente("Mouse");

        assertEquals("Mouse", result.getCognomeDipendente());
    }

    // 🔹Test 9: Trova dipendente per email ed numero di telefono
    @Test
    void testFindByEmailAndNumeroTelefono() {
        when(dipendenteRepository.findByEmailAndNumeroTelefono("topolino@disney.com", 123)).thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByEmailAndNumeroTelefono("topolino@disney.com", 123);

        assertEquals(123, result.getNumeroTelefono());
    }

    // 🔹Test 10: Trova dipendente per nome
    @Test
    void testFindByNomeDipendente() {
        when(dipendenteRepository.findByNomeDipendente("Topolino")).thenReturn(dipendente);
        when(dipendenteMapper.toDTO(dipendente)).thenReturn(dipendenteDto);

        DipendenteDto result = dipendenteService.findByNomeDipendente("Topolino");

        assertEquals("Topolino", result.getNomeDipendente());
    }
}
