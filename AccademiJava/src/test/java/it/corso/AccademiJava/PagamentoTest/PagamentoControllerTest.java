package it.corso.AccademiJava.PagamentoTest;

import it.corso.AccademiJava.Controller.PagamentoController;
import it.corso.AccademiJava.DTO.PagamentoDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.MetodoPagamento;
import it.corso.AccademiJava.Model.StatoPagamento;
import it.corso.AccademiJava.Service.PagamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Carica solo il layer web del controller PagamentoController
@WebMvcTest(PagamentoController.class)
@ExtendWith(SpringExtension.class)
class PagamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    // MockMvc serve per simulare chiamate HTTP senza avviare davvero il server

    @MockBean
    private PagamentoService pagamentoService;
    // MockBean crea un finto service da iniettare nel controller
    // così il test controlla solo il comportamento del controller

    // Metodo di supporto per creare un PagamentoDto valido da riutilizzare nei test
    private PagamentoDto createDto() {
        PagamentoDto dto = new PagamentoDto();
        dto.setId(1);
        dto.setImporto(150.0);
        dto.setDataPagamento(LocalDateTime.of(2024, 6, 10, 15, 30));
        dto.setStato(StatoPagamento.COMPLETATO);
        dto.setMetodo(MetodoPagamento.CARTA);

        UserDto userDto = new UserDto();
        userDto.setId(5);
        userDto.setName("Mario");
        userDto.setDescription("Utente di test");

        dto.setUser(userDto);

        return dto;
    }

    @Test
    void testFindByDataPagamento() throws Exception {
        PagamentoDto dto = createDto();

        // Dato che il controller riceve una stringa e la converte in LocalDateTime,
        // nel mock dobbiamo usare lo stesso valore finale convertito
        LocalDateTime data = LocalDateTime.of(2024, 6, 10, 15, 30);

        // Simuliamo il comportamento del service:
        // quando riceve quella data, restituisce una lista con un pagamento
        when(pagamentoService.findByDataPagamento(data)).thenReturn(List.of(dto));

        // Simuliamo una GET all'endpoint del controller
        mockMvc.perform(get("/pagamento/findByDataPagamento")
                        .param("dataPagamento", "2024-06-10T15:30:00"))
                .andExpect(status().isOk()) // ci aspettiamo HTTP 200
                .andExpect(jsonPath("$[0].importo").value(150.0))
                .andExpect(jsonPath("$[0].stato").value("COMPLETATO"))
                .andExpect(jsonPath("$[0].metodo").value("CARTA"));
    }

    @Test
    void testFindByStato() throws Exception {
        PagamentoDto dto = createDto();

        // Simuliamo il service quando viene richiesto lo stato COMPLETATO
        when(pagamentoService.findByStato(StatoPagamento.COMPLETATO))
                .thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByStato")
                        .param("stato", "COMPLETATO"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].stato").value("COMPLETATO"));
    }

    @Test
    void testFindByMetodo() throws Exception {
        PagamentoDto dto = createDto();

        // Simuliamo il service quando viene richiesto il metodo CARTA
        when(pagamentoService.findByMetodo(MetodoPagamento.CARTA))
                .thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByMetodo")
                        .param("metodo", "CARTA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].metodo").value("CARTA"));
    }

    @Test
    void testFindByUserId() throws Exception {
        PagamentoDto dto = createDto();

        // Simuliamo la ricerca dei pagamenti dell'utente con id 5
        when(pagamentoService.findByUserId(5)).thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByUserId")
                        .param("userId", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user.id").value(5))
                .andExpect(jsonPath("$[0].user.name").value("Mario"));
    }

    @Test
    void testFindByImporto() throws Exception {
        PagamentoDto dto = createDto();

        // Simuliamo la ricerca per importo esatto
        when(pagamentoService.findByImporto(150.0)).thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByImporto")
                        .param("importo", "150.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].importo").value(150.0));
    }

    @Test
    void testFindByImportoMaggioreDi() throws Exception {
        PagamentoDto dto = createDto();

        // Simuliamo la ricerca dei pagamenti con importo maggiore di 100
        when(pagamentoService.findByImportoMaggioreDi(100.0)).thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByImportoMaggioreDi")
                        .param("importo", "100.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].importo").value(150.0));
    }
    @Test
    void testFindByStatoAndMetodo() throws Exception {
        PagamentoDto dto = createDto();
        when(pagamentoService.findByStatoAndMetodo(StatoPagamento.COMPLETATO, MetodoPagamento.CARTA))
                .thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByStatoAndMetodo")
                        .param("stato", "COMPLETATO")
                        .param("metodo", "CARTA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].stato").value("COMPLETATO"))
                .andExpect(jsonPath("$[0].metodo").value("CARTA"));
    }

    @Test
    void testFindPagamentiInPeriodo() throws Exception {
        PagamentoDto dto = createDto();
        LocalDateTime inizio = LocalDateTime.of(2024, 1, 1, 0, 0);
        LocalDateTime fine = LocalDateTime.of(2024, 12, 31, 23, 59);

        when(pagamentoService.findPagamentiInPeriodo(inizio, fine)).thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findPagamentiInPeriodo")
                        .param("inizio", "2024-01-01T00:00:00")
                        .param("fine", "2024-12-31T23:59:59"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dataPagamento").exists());
    }

    @Test
    void testFindByUserIdAndStato() throws Exception {
        PagamentoDto dto = createDto();
        when(pagamentoService.findByUserIdAndStato(5, StatoPagamento.COMPLETATO))
                .thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByUserIdAndStato")
                        .param("userId", "5")
                        .param("stato", "COMPLETATO"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].user.id").value(5))
                .andExpect(jsonPath("$[0].stato").value("COMPLETATO"));
    }

    @Test
    void testFindByImportoBetween() throws Exception {
        PagamentoDto dto = createDto();
        when(pagamentoService.findByImportoBetween(100.0, 200.0)).thenReturn(List.of(dto));

        mockMvc.perform(get("/pagamento/findByImportoBetween")
                        .param("min", "100.0")
                        .param("max", "200.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].importo").value(150.0));
    }
}