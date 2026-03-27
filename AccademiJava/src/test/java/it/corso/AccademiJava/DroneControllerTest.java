package it.corso.AccademiJava;

import it.corso.AccademiJava.Controller.DroneController;
import it.corso.AccademiJava.Service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DroneController.class)
public class DroneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DroneService droneService;

    // 1. Inserimento corretto
    @Test
    public void testInsertDrone() throws Exception {
        String droneJson = "{\"codiceSeriale\":\"DRN-99\",\"modello\":\"Predator\",\"livelloBatteria\":100}";
        this.mockMvc.perform(post("/Drone/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(droneJson))
                .andExpect(status().isOk());
    }

    // 2. Ricerca per modello corretta
    @Test
    public void testFindByModelloOk() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello")
                        .param("modello", "Predator"))
                .andExpect(status().isOk());
    }

    // 3. Ricerca per iniziale corretta
    @Test
    public void testTrovaTramiteInizialeOk() throws Exception {
        this.mockMvc.perform(get("/Drone/trovaTramiteIniziale")
                        .param("find", "P"))
                .andExpect(status().isOk());
    }

    // 4. Errore: manca il parametro 'modello' (Aspettiamo 400)
    @Test
    public void testMissingParameterModello() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello"))
                .andExpect(status().isBadRequest());
    }

    // 5. Errore: manca il parametro 'find' (Aspettiamo 400)
    @Test
    public void testTrovaInizialeMissingParam() throws Exception {
        this.mockMvc.perform(get("/Drone/trovaTramiteIniziale"))
                .andExpect(status().isBadRequest());
    }

    // 6. Errore: tipo dato errato per Character (Aspettiamo 400)
    @Test
    public void testTrovaInizialeWrongType() throws Exception {
        this.mockMvc.perform(get("/Drone/trovaTramiteIniziale")
                        .param("find", "TroppoLunga"))
                .andExpect(status().isBadRequest());
    }

    // 7. Errore: JSON dell'insert rotto (Aspettiamo 400)
    @Test
    public void testInsertDroneInvalidJson() throws Exception {
        String badJson = "{\"codiceSeriale\":\"DRN-99\"";
        this.mockMvc.perform(post("/Drone/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(badJson))
                .andExpect(status().isBadRequest());
    }

    // 8. Ricerca per modello con stringa vuota (L'URL esiste, quindi deve dare 200 o 400 a seconda del service)
    @Test
    public void testFindByModelloEmpty() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello")
                        .param("modello", ""))
                .andExpect(status().isOk());
    }

    // 9. Test metodo POST con Body vuoto (Aspettiamo 400)
    @Test
    public void testInsertEmptyBody() throws Exception {
        this.mockMvc.perform(post("/Drone/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isBadRequest());
    }

    // 10. Test su un URL che non esiste per confermare il 404 (Test di sicurezza)
    @Test
    public void testRouteInesistente() throws Exception {
        this.mockMvc.perform(get("/Drone/metodoCheNonEsiste"))
                .andExpect(status().isNotFound());
    }
}