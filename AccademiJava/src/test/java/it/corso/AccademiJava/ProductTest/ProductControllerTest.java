package it.corso.AccademiJava.ProductTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.corso.AccademiJava.Controller.ProductController;
import it.corso.AccademiJava.DTO.ProductDto;
import it.corso.AccademiJava.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @Autowired
    private ObjectMapper objectMapper;

    // ---------------- TEST: findByName ----------------
    @Test
    void shouldFindProductByName() throws Exception {
        ProductDto dto = new ProductDto();
        dto.setName("Laptop");

        when(service.findByName("Laptop")).thenReturn(dto);

        mockMvc.perform(get("/Product/findByName")
                        .param("name", "Laptop"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    // ---------------- TEST: insert ----------------
    @Test
    void shouldInsertProduct() throws Exception {
        ProductDto dto = new ProductDto();
        dto.setName("Mouse");
        dto.setPrice(25.0);
        dto.setQuantity(10);

        when(service.insert(any())).thenReturn(dto);

        mockMvc.perform(post("/Product/insert")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mouse"))
                .andExpect(jsonPath("$.price").value(25.0))
                .andExpect(jsonPath("$.quantity").value(10));

        verify(service).insert(any());
    }

    // ---------------- TEST: findByPriceGreaterThan ----------------
    @Test
    void shouldFindProductsByPriceGreaterThan() throws Exception {
        ProductDto dto = new ProductDto();
        dto.setName("Smartphone");
        dto.setPrice(800.0);

        when(service.findByPriceGreaterThan(500.0)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Product/findByPriceGreaterThan")
                        .param("price", "500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Smartphone"))
                .andExpect(jsonPath("$[0].price").value(800.0));
    }

    // ---------------- TEST: findByQuantityLessThan ----------------
    @Test
    void shouldFindProductsByQuantityLessThan() throws Exception {
        ProductDto dto = new ProductDto();
        dto.setName("Keyboard");
        dto.setQuantity(2);

        when(service.findByQuantityLessThan(5)).thenReturn(List.of(dto));

        mockMvc.perform(get("/Product/findByQuantityLessThan")
                        .param("quantity", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Keyboard"))
                .andExpect(jsonPath("$[0].quantity").value(2));
    }
}