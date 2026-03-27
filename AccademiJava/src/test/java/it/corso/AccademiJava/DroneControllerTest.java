package it.corso.AccademiJava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DroneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // 1. Test inserimento (Happy Path)
    @Test
    public void testInsertDrone() throws Exception {
        String droneJson = "{\"codiceSeriale\":\"DRN-99\",\"modello\":\"Predator\",\"livelloBatteria\":100}";
        this.mockMvc.perform(post("/Drone/insert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(droneJson))
                .andExpect(status().isOk());
    }

    // 2. Test ricerca per modello (Esistente)
    @Test
    public void testFindByModelloOk() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello")
                        .param("modello", "Predator"))
                .andExpect(status().isOk());
    }

    // 3. Test ricerca per modello (Stringa vuota)
    @Test
    public void testFindByModelloEmpty() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello")
                        .param("modello", ""))
                .andExpect(status().isOk()); // Spring risponde comunque 200, ma darà null
    }

    // 4. Test ricerca per iniziale
    @Test
    public void testTrovaTramiteIniziale() throws Exception {
        this.mockMvc.perform(get("/Drone/trovaTramiteIniziale")
                        .param("find", "P"))
                .andExpect(status().isOk());
    }

    // 5. Test recupero lista completa (ereditato da AbstractController)
    @Test
    public void testGetAll() throws Exception {
        this.mockMvc.perform(get("/Drone/getAll"))
                .andExpect(status().isOk());
    }

    // 6. Test recupero per ID (ereditato da AbstractController)
    @Test
    public void testGetById() throws Exception {
        this.mockMvc.perform(get("/Drone/getById")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }

    // 7. Test cancellazione (Verifichiamo se l'endpoint risponde)
    @Test
    public void testDelete() throws Exception {
        this.mockMvc.perform(get("/Drone/delete")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }

    // 8. Test Errore: Rotta inesistente (404)
    @Test
    public void testInvalidRoute() throws Exception {
        this.mockMvc.perform(get("/Drone/metodoCheNonEsiste"))
                .andExpect(status().isNotFound());
    }

    // 9. Test Errore: Metodo POST usato come GET
    @Test
    public void testWrongMethod() throws Exception {
        this.mockMvc.perform(get("/Drone/insert"))
                .andExpect(status().isMethodNotAllowed());
    }

    // 10. Test Parametro mancante (Dovrebbe dare errore 400 Bad Request)
    @Test
    public void testMissingParameter() throws Exception {
        this.mockMvc.perform(get("/Drone/findByModello"))
                .andExpect(status().isBadRequest());
    }
}