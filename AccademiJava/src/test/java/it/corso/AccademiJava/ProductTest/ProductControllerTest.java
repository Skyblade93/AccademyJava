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

    // ---------------- TEST: findByName FULL DTO ----------------
    @Test
    void shouldFindProductByNameWithAllFields() throws Exception {
        ProductDto dto = new ProductDto();
        dto.setName("Laptop");
        dto.setPrice(1200.0);
        dto.setQuantity(5);

        when(service.findByName("Laptop")).thenReturn(dto);

        mockMvc.perform(get("/Product/findByName")
                        .param("name", "Laptop"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andExpect(jsonPath("$.price").value(1200.0))
                .andExpect(jsonPath("$.quantity").value(5));
    }

    // ---------------- TEST: insert DIFFERENT PRODUCT ----------------
    @Test
    void shouldInsertAnotherProduct() throws Exception {
        ProductDto dto = new ProductDto();
        dto.setName("Monitor");
        dto.setPrice(150.0);
        dto.setQuantity(5);

        when(service.insert(any())).thenReturn(dto);

        mockMvc.perform(post("/Product/insert")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Monitor"))
                .andExpect(jsonPath("$.price").value(150.0))
                .andExpect(jsonPath("$.quantity").value(5));

        verify(service).insert(any());
    }

    // ---------------- TEST: findByPriceGreaterThan MULTIPLE ----------------
    @Test
    void shouldFindMultipleProductsByPriceGreaterThan() throws Exception {
        ProductDto dto1 = new ProductDto();
        dto1.setName("Laptop");
        dto1.setPrice(1200.0);

        ProductDto dto2 = new ProductDto();
        dto2.setName("Smartphone");
        dto2.setPrice(800.0);

        when(service.findByPriceGreaterThan(500.0)).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/Product/findByPriceGreaterThan")
                        .param("price", "500"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Laptop"))
                .andExpect(jsonPath("$[1].name").value("Smartphone"));
    }

    // ---------------- TEST: findByQuantityLessThan MULTIPLE ----------------
    @Test
    void shouldFindMultipleProductsByQuantityLessThan() throws Exception {
        ProductDto dto1 = new ProductDto();
        dto1.setName("Keyboard");
        dto1.setQuantity(2);

        ProductDto dto2 = new ProductDto();
        dto2.setName("Mouse");
        dto2.setQuantity(3);

        when(service.findByQuantityLessThan(5)).thenReturn(List.of(dto1, dto2));

        mockMvc.perform(get("/Product/findByQuantityLessThan")
                        .param("quantity", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].name").value("Mouse"));
    }

    // ---------------- TEST: findByPriceGreaterThan EMPTY ----------------
    @Test
    void shouldReturnEmptyListWhenNoProductsMatchPrice() throws Exception {
        when(service.findByPriceGreaterThan(2000.0)).thenReturn(List.of());

        mockMvc.perform(get("/Product/findByPriceGreaterThan")
                        .param("price", "2000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    // ---------------- TEST: findByQuantityLessThan EMPTY ----------------
    @Test
    void shouldReturnEmptyListWhenNoProductsMatchQuantity() throws Exception {
        when(service.findByQuantityLessThan(1)).thenReturn(List.of());

        mockMvc.perform(get("/Product/findByQuantityLessThan")
                        .param("quantity", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }
}