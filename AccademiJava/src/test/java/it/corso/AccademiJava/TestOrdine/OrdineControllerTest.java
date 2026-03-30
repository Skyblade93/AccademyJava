package it.corso.AccademiJava.TestOrdine;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.corso.AccademiJava.Controller.OrdineController;
import it.corso.AccademiJava.Controller.UserController;
import it.corso.AccademiJava.DTO.OrdineDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Service.OrdineService;
import it.corso.AccademiJava.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrdineController.class)
class OrdineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrdineService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFindById() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setId(1);

        when(service.findById(1)).thenReturn(dto);

        mockMvc.perform(get("/Ordine/findById")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void shouldTrovaConCostoUguale() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(100);

        when(service.trovaConCostoUguale(100)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/trovaConCostoUguale")
                        .param("costo", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costo_totale").value(100));
    }

    @Test
    void shouldTrovaConNumeroProdottiMaggiore() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setNumero_prodotti(6);

        when(service.trovaConNumeroProdottiMaggiore(5)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/trovaConNumeroProdottiMaggiore")
                        .param("num_prodotti", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numero_prodotti").value(6));
    }

    @Test
    void shouldTrovaConIndirizzo() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setIndirizzo_spedizione("via manzoni");

        when(service.trovaConIndirizzo("via manzoni")).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/trovaConIndirizzo")
                        .param("indirizzo", "via manzoni"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].indirizzo_spedizione").value("via manzoni"));
    }

    @Test
    void shouldTrovaConCostoMaggiore() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(120);

        when(service.trovaConCostoMaggiore(110)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/trovaConCostoMaggiore")
                        .param("costo", "110"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costo_totale").value(120));
    }

    @Test
    void shouldTrovaConCostoMinore() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(120);

        when(service.trovaConCostoMaggiore(130)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/trovaConCostoMaggiore")
                        .param("costo", "130"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costo_totale").value(120));
    }

    @Test
    void shouldTrovaPerUtente() throws Exception {
        User user=new User();
        user.setId(1);
        OrdineDto dto = new OrdineDto();
        dto.setUtente(user);

        when(service.trovaPerUtente(1)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/trovaPerUtente")
                        .param("utente", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].utente.id").value(1));
    }

    @Test
    void shouldFiltro() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(30);
        dto.setNumero_prodotti(5);

        when(service.filtro(2,50)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/filtro")
                        .param("numero", "2")
                        .param("costo","50"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numero_prodotti").value(5))
                .andExpect(jsonPath("$[0].costo_totale").value(30));
    }

    @Test
    void shouldOrdinaPerCostoDecrescente() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(100);
        OrdineDto dto1 = new OrdineDto();
        dto1.setCosto_totale(50);
        OrdineDto dto2 = new OrdineDto();
        dto2.setCosto_totale(10);

        List<OrdineDto> dtos = List.of(dto, dto1, dto2);

        when(service.ordinaPerCostoDecrescente()).thenReturn(dtos);

        mockMvc.perform(get("/Ordine/ordinaPerCostoDecrescente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costo_totale").value(100))
                .andExpect(jsonPath("$[1].costo_totale").value(50))
                .andExpect(jsonPath("$[2].costo_totale").value(10));
    }

    @Test
    void shouldTrovaTraDueCosti() throws Exception {
        OrdineDto dto = new OrdineDto();
        dto.setCosto_totale(45);

        when(service.trovaTraDueCosti(40,50)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Ordine/trovaTraDueCosti")
                        .param("min", "40")
                        .param("max","50"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].costo_totale").value(45));
    }
}
