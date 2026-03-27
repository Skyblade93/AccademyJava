package it.corso.AccademiJava.DipendenteTest;

import it.corso.AccademiJava.Controller.DipendenteController;
import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Service.DipendenteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DipendenteController.class)
public class DipendenteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DipendenteService dipendenteService;

    // 🔹 Test 1: Trova dipendente per nome, cognome e numero di telefono
    @Test
    void testFindByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono() throws Exception {

        // 1️⃣ Creo un DipendenteDto realistico
        DipendenteDto dto = new DipendenteDto();
        dto.setId(1);
        dto.setNomeDipendente("Topolino");
        dto.setCognomeDipendente("Mouse");
        dto.setNumeroTelefono(123);

        // 2️⃣ Dico al mock di restituire questo DTO quando il service viene chiamato
        when(dipendenteService
                .findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono("Topolino", "Mouse", 123))
                .thenReturn(dto);

        // 3️⃣ Faccio la chiamata GET al controller
        mockMvc.perform(get("/Dipendente/findByNomeDipendenteAndCognomeDipendenteAndNumeroTelefono")
                        .param("nomeDipendente", "Topolino")
                        .param("cognomeDipendente", "Mouse")
                        .param("numeroTelefono", "123"))
                .andExpect(status().isOk()) // verifica il codice 200
                // 🔹 verifico che i dati restituiti siano corretti
                .andExpect(jsonPath("$.nomeDipendente").value("Topolino"))
                .andExpect(jsonPath("$.cognomeDipendente").value("Mouse"))
                .andExpect(jsonPath("$.numeroTelefono").value(123));
    }

    // 🔹Test 2: Trova dipendente per nome e cognome
    @Test
    void testFindByNomeDipendenteAndCognomeDipendente() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(1);
        dto.setNomeDipendente("Topolino");
        dto.setCognomeDipendente("Mouse");

        when(dipendenteService.findByNomeAndCognome("Topolino", "Mouse"))
                .thenReturn(dto);

        mockMvc.perform(get("/Dipendente/findByNomeDipendenteAndCognomeDipendente")
                        .param("nomeDipendente", "Topolino")
                        .param("cognomeDipendente", "Mouse"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeDipendente").value("Topolino"))
                .andExpect(jsonPath("$.cognomeDipendente").value("Mouse"));
    }

    // 🔹Test 3: Trova dipendente per età
    @Test
    void testFindByEta() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(2);
        dto.setNomeDipendente("Paperino");
        dto.setCognomeDipendente("Duck");
        dto.setEta(10);
        dto.setEmail("paperino@disney.com");
        dto.setNumeroTelefono(456);

        when(dipendenteService.findByEta(10)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Dipendente/findByEta")
                        .param("eta", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomeDipendente").value("Paperino"))
                .andExpect(jsonPath("$[0].cognomeDipendente").value("Duck"))
                .andExpect(jsonPath("$[0].eta").value(10))
                .andExpect(jsonPath("$[0].email").value("paperino@disney.com"))
                .andExpect(jsonPath("$[0].numeroTelefono").value(456));
    }

    // 🔹Test 4: Trova dipendenti con età maggiore di ...
    @Test
    void testFindByEtaGreaterThan() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(3);
        dto.setNomeDipendente("Minni");
        dto.setCognomeDipendente("Mouse");
        dto.setEta(15);
        dto.setEmail("minni@disney.com");
        dto.setNumeroTelefono(789);

        when(dipendenteService.findByEtaGreaterThan(10)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Dipendente/findByEtaGreaterThan")
                        .param("eta", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomeDipendente").value("Minni"))
                .andExpect(jsonPath("$[0].cognomeDipendente").value("Mouse"))
                .andExpect(jsonPath("$[0].eta").value(15))
                .andExpect(jsonPath("$[0].email").value("minni@disney.com"))
                .andExpect(jsonPath("$[0].numeroTelefono").value(789));
    }

    // 🔹Test 5: Trova dipendente per email
    @Test
    void testFindByEmail() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(4);
        dto.setNomeDipendente("Topolino");
        dto.setCognomeDipendente("Mouse");
        dto.setEta(10);
        dto.setEmail("topolino@disney.com");
        dto.setNumeroTelefono(123);

        when(dipendenteService.findByEmail("topolino@disney.com")).thenReturn(dto);

        mockMvc.perform(get("/Dipendente/findByEmail")
                        .param("email", "topolino@disney.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("topolino@disney.com"))
                .andExpect(jsonPath("$.nomeDipendente").value("Topolino"))
                .andExpect(jsonPath("$.cognomeDipendente").value("Mouse"));
    }

    // 🔹Test 6: Trova dipendente per email ed età
    @Test
    void testFindByEmailAndEta() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(5);
        dto.setNomeDipendente("Paperino");
        dto.setCognomeDipendente("Duck");
        dto.setEta(10);
        dto.setEmail("paperino@disney.com");
        dto.setNumeroTelefono(456);

        when(dipendenteService.findByEmailAndEta("paperino@disney.com", 10)).thenReturn(dto);

        mockMvc.perform(get("/Dipendente/findByEmailAndEta")
                        .param("email", "paperino@disney.com")
                        .param("eta", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("paperino@disney.com"))
                .andExpect(jsonPath("$.eta").value(10));
    }

    // 🔹Test 7: Trova dipendente per nome ed età
    @Test
    void testFindByNomeDipendenteAndEta() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(6);
        dto.setNomeDipendente("Topolino");
        dto.setCognomeDipendente("Mouse");
        dto.setEta(10);
        dto.setEmail("topolino@disney.com");
        dto.setNumeroTelefono(123);

        when(dipendenteService.findByNomeDipendenteAndEta("Topolino", 10)).thenReturn(dto);

        mockMvc.perform(get("/Dipendente/findByNomeDipendenteAndEta")
                        .param("nomeDipendente", "Topolino")
                        .param("eta", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeDipendente").value("Topolino"))
                .andExpect(jsonPath("$.eta").value(10));
    }

    // 🔹Test 8: Trova dipendente per cognome
    @Test
    void testFindByCognomeDipendente() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(7);
        dto.setNomeDipendente("Topolino");
        dto.setCognomeDipendente("Mouse");
        dto.setEta(10);
        dto.setEmail("topolino@disney.com");
        dto.setNumeroTelefono(123);

        when(dipendenteService.findByCognomeDipendente("Mouse")).thenReturn(dto);

        mockMvc.perform(get("/Dipendente/findByCognomeDipendente")
                        .param("cognomeDipendente", "Mouse"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cognomeDipendente").value("Mouse"));
    }

    // 🔹Test 9: Trova dipendente per email ed numero di telefono
    @Test
    void testFindByEmailAndNumeroTelefono() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(8);
        dto.setNomeDipendente("Paperina");
        dto.setCognomeDipendente("Duck");
        dto.setEta(12);
        dto.setEmail("paperina@disney.com");
        dto.setNumeroTelefono(789);

        when(dipendenteService.findByEmailAndNumeroTelefono("paperina@disney.com", 789)).thenReturn(dto);

        mockMvc.perform(get("/Dipendente/findByEmailAndNumeroTelefono")
                        .param("email", "paperina@disney.com")
                        .param("numeroTelefono", "789"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("paperina@disney.com"))
                .andExpect(jsonPath("$.numeroTelefono").value(789));
    }

    // 🔹Test 10: Trova dipendente per nome
    @Test
    void testFindByNomeDipendente() throws Exception {

        DipendenteDto dto = new DipendenteDto();
        dto.setId(9);
        dto.setNomeDipendente("Topolino");
        dto.setCognomeDipendente("Mouse");
        dto.setEta(10);
        dto.setEmail("topolino@disney.com");
        dto.setNumeroTelefono(123);

        when(dipendenteService.findByNomeDipendente("Topolino")).thenReturn(dto);

        mockMvc.perform(get("/Dipendente/findByNomeDipendente")
                        .param("nomeDipendente", "Topolino"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomeDipendente").value("Topolino"));
    }

}