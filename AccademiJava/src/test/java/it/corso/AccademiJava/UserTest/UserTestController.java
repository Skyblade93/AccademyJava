package it.corso.AccademiJava.UserTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.corso.AccademiJava.Controller.UserController;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFindUserByNome() throws Exception {
        UserDto dto = new UserDto();
        dto.setName("Mario");

        when(service.findByNome("Mario")).thenReturn(dto);

        mockMvc.perform(get("/User/FindByNome")
                        .param("nome", "Mario"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Mario"));
    }

    @Test
    void shouldInsertUser() throws Exception {
        UserDto dto = new UserDto();
        dto.setName("Luigi");

        mockMvc.perform(post("/User/insert")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Luigi"));

        verify(service).insert(any());
    }

    @Test
    void shouldFindByInitial() throws Exception {
        UserDto dto = new UserDto();
        dto.setName("Marco");

        when(service.trovaTramiteiniziale('M')).thenReturn(List.of(dto));

        mockMvc.perform(get("/User/trovaTramiteiniziale")
                        .param("find", "M"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Marco"));
    }
}