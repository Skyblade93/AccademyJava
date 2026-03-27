package it.corso.AccademiJava;

import it.corso.AccademiJava.Controller.DroneController;
import it.corso.AccademiJava.Service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// IMPORT STATICI AGGRESSIVI PER RISOLVERE IL ROSSO
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DroneController.class)
public class DroneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DroneService droneService;

    // 1. Test Inserimento Drone (POST)
    @Test
    public void testInsertDrone() throws Exception {
        String droneJson = "{\"codiceSeriale\":\"DRN-99\",\"modello\":\"Predator\",\"livelloBatteria\":100}";
        this.mockMvc.perform(post("/Drone/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(droneJson))
                .andExpect(status().isOk());
    }

    // 2. Test Ricerca per Modello (GET con parametro)
    @Test
    public void testFindByModelloOk() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello")
                        .param("modello", "Predator"))
                .andExpect(status().isOk());
    }

    // 3. Test Ricerca per Iniziale (GET con parametro 'find')
    @Test
    public void testTrovaTramiteInizialeOk() throws Exception {
        this.mockMvc.perform(get("/Drone/trovaTramiteIniziale")
                        .param("find", "P"))
                .andExpect(status().isOk());
    }

    // 4. Test Errore: Parametro 'modello' mancante (400 Bad Request)
    @Test
    public void testMissingParameterModello() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello"))
                .andExpect(status().isBadRequest());
    }

    // 5. Test Errore: Parametro 'find' mancante (400 Bad Request)
    @Test
    public void testTrovaInizialeMissingParam() throws Exception {
        this.mockMvc.perform(get("/Drone/trovaTramiteIniziale"))
                .andExpect(status().isBadRequest());
    }

    // 6. Test Errore: Tipo dato errato (String invece di Character)
    @Test
    public void testTrovaInizialeWrongType() throws Exception {
        this.mockMvc.perform(get("/Drone/trovaTramiteIniziale")
                        .param("find", "StringaTroppoLunga"))
                .andExpect(status().isBadRequest());
    }

    // 7. Test Errore: JSON malformato nella insert
    @Test
    public void testInsertDroneInvalidJson() throws Exception {
        String badJson = "{\"codiceSeriale\":\"DRN-99\"";
        this.mockMvc.perform(post("/Drone/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(badJson))
                .andExpect(status().isBadRequest());
    }

    // 8. Test Ricerca con stringa vuota (L'endpoint risponde 200)
    @Test
    public void testFindByModelloEmpty() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello")
                        .param("modello", ""))
                .andExpect(status().isOk());
    }

    // 9. Test Errore: Body della POST completamente vuoto
    @Test
    public void testInsertEmptyBody() throws Exception {
        this.mockMvc.perform(post("/Drone/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isBadRequest());
    }

    // 10. Test di sicurezza: URL inesistente (404 Not Found)
    @Test
    public void testRouteInesistente() throws Exception {
        this.mockMvc.perform(get("/Drone/metodoCheNonEsiste"))
                .andExpect(status().isNotFound());
    }
}