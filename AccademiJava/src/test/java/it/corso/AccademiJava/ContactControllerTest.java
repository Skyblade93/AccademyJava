package it.corso.AccademiJava;

import it.corso.AccademiJava.Controller.ContactController;
import it.corso.AccademiJava.DTO.ContactDto;
import it.corso.AccademiJava.Service.ContactService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContactController.class)
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    // 🔹 GET ALL
    @Test
    void testGetAll() throws Exception {

        ContactDto dto = new ContactDto();
        dto.setFirstName("Mario");

        when(contactService.getAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/Contact/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Mario"));
    }

    // 🔹 FIND BY EMAIL
    @Test
    void testFindByEmail() throws Exception {

        ContactDto dto = new ContactDto();
        dto.setEmail("test@email.com");

        when(contactService.findByEmailDto("test@email.com")).thenReturn(dto);

        mockMvc.perform(get("/Contact/findByEmail")
                        .param("email", "test@email.com"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@email.com"));
    }

    // 🔹 FIND BY NOME
    @Test
    void testFindByNome() throws Exception {

        ContactDto dto = new ContactDto();
        dto.setFirstName("Mario");

        when(contactService.findByNomeDto("Mario")).thenReturn(List.of(dto));

        mockMvc.perform(get("/Contact/findByNome")
                        .param("nome", "Mario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Mario"));
    }

    // 🔹 DELETE
    @Test
    void testDelete() throws Exception {

        mockMvc.perform(delete("/Contact/delete")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }
}
