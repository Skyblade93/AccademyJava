package it.corso.AccademiJava;

import it.corso.AccademiJava.Controller.AutoController;
import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.Model.TipoCarburante;
import it.corso.AccademiJava.Service.AutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AutoController.class)
@ExtendWith(SpringExtension.class)
class AutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutoService autoService;

    private AutoDto createDto() {
        AutoDto dto = new AutoDto();
        dto.setId(1);
        dto.setMarca("Fiat");
        dto.setModello("Panda");
        dto.setTarga("AB123CD");
        dto.setCarburante("DIESEL");
        return dto;
    }

    @Test
    void testFindByTarga() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByTarga("AB123CD")).thenReturn(dto);

        mockMvc.perform(get("/Auto/findByTarga")
                        .param("targa", "AB123CD"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.targa").value("AB123CD"));
    }

    @Test
    void testFindByMarca() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByMarca("Fiat")).thenReturn(dto);

        mockMvc.perform(get("/Auto/findByMarca")
                        .param("marca", "Fiat"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Fiat"));
    }

    @Test
    void testFindByModello() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByModello("Panda")).thenReturn(dto);

        mockMvc.perform(get("/Auto/findByModello")
                        .param("modello", "Panda"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modello").value("Panda"));
    }

    @Test
    void testFindByMarcaAndModello() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByMarcaAndModello("Fiat", "Panda")).thenReturn(dto);

        mockMvc.perform(get("/Auto/findByMarcaAndModello")
                        .param("marca", "Fiat")
                        .param("modello", "Panda"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Fiat"))
                .andExpect(jsonPath("$.modello").value("Panda"));
    }

    @Test
    void testFindByModelloContaining() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByModelloContaining("Pan")).thenReturn(dto);

        mockMvc.perform(get("/Auto/findByModelloContaining")
                        .param("modello", "Pan"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.modello").value("Panda"));
    }

    @Test
    void testFindByMarcaStartingWith() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByMarcaStartingWith("Fi")).thenReturn(dto);

        mockMvc.perform(get("/Auto/findByMarcaStartingWith")
                        .param("marca", "Fi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Fiat"));
    }

    @Test
    void testFindByMarcaEndingWith() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByMarcaEndingWith("at")).thenReturn(dto);

        mockMvc.perform(get("/Auto/findByMarcaEndingWith")
                        .param("marca", "at"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.marca").value("Fiat"));
    }

    @Test
    void testFindByCarburante() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByCarburante("DIESEL")).thenReturn(List.of(dto));

        mockMvc.perform(get("/Auto/findByCarburante")
                        .param("carburante", "DIESEL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].carburante").value("DIESEL"));
    }

    @Test
    void testFindByMarcaAndCarburante() throws Exception {
        AutoDto dto = createDto();
        when(autoService.findByMarcaAndCarburante("Fiat", TipoCarburante.DIESEL))
                .thenReturn(List.of(dto));

        mockMvc.perform(get("/Auto/findByMarcaAndCarburante")
                        .param("marca", "Fiat")
                        .param("carburante", "DIESEL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].marca").value("Fiat"))
                .andExpect(jsonPath("$[0].carburante").value("DIESEL"));
    }


}
