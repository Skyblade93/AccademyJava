package it.corso.AccademiJava.ProductTest;

import it.corso.AccademiJava.DTO.ProductDto;
import it.corso.AccademiJava.Mapper.ProductMapper;
import it.corso.AccademiJava.Model.Product;
import it.corso.AccademiJava.Repository.ProductRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import it.corso.AccademiJava.Service.ProductService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProductService productService;

    // ---------------- TEST: findByName ----------------
    @Test
    void shouldFindByName() {
        Product product = new Product();
        product.setName("Laptop");

        ProductDto dto = new ProductDto();
        dto.setName("Laptop");

        when(productRepository.findByName("Laptop")).thenReturn(product);
        when(productMapper.toDTO(product)).thenReturn(dto);

        ProductDto result = productService.findByName("Laptop");

        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    // ---------------- TEST: findByPriceGreaterThan ----------------
    @Test
    void shouldFindByPriceGreaterThan() {
        Product product = new Product();
        product.setPrice(800.0);

        ProductDto dto = new ProductDto();
        dto.setPrice(800.0);

        when(productRepository.findByPriceGreaterThan(500.0)).thenReturn(List.of(product));
        when(productMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<ProductDto> result = productService.findByPriceGreaterThan(500.0);

        assertEquals(1, result.size());
        assertEquals(800.0, result.get(0).getPrice());
    }

    // ---------------- TEST: findByQuantityLessThan ----------------
    @Test
    void shouldFindByQuantityLessThan() {
        Product product = new Product();
        product.setQuantity(2);

        ProductDto dto = new ProductDto();
        dto.setQuantity(2);

        when(productRepository.findByQuantityLessThan(5)).thenReturn(List.of(product));
        when(productMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<ProductDto> result = productService.findByQuantityLessThan(5);

        assertEquals(1, result.size());
        assertEquals(2, result.get(0).getQuantity());
    }

    // ---------------- TEST: findByNameCustom ----------------
    @Test
    void shouldFindByNameCustom() {
        Product product = new Product();
        product.setName("Mouse");

        ProductDto dto = new ProductDto();
        dto.setName("Mouse");

        when(productRepository.findByNameCustom("Mouse")).thenReturn(product);
        when(productMapper.toDTO(product)).thenReturn(dto);

        ProductDto result = productService.findByNameCustom("Mouse");

        assertEquals("Mouse", result.getName());
    }

    // ---------------- TEST: findByPriceRange ----------------
    @Test
    void shouldFindByPriceRange() {
        Product product = new Product();
        product.setPrice(300.0);

        ProductDto dto = new ProductDto();
        dto.setPrice(300.0);

        when(productRepository.findByPriceRange(100.0, 500.0)).thenReturn(List.of(product));
        when(productMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<ProductDto> result = productService.findByPriceRange(100.0, 500.0);

        assertEquals(1, result.size());
        assertEquals(300.0, result.get(0).getPrice());
    }

    // ---------------- TEST: nativeFindByName ----------------
    @Test
    void shouldNativeFindByName() {
        Product product = new Product();
        product.setName("Keyboard");

        ProductDto dto = new ProductDto();
        dto.setName("Keyboard");

        when(productRepository.nativeFindByName("Keyboard")).thenReturn(product);
        when(productMapper.toDTO(product)).thenReturn(dto);

        ProductDto result = productService.nativeFindByName("Keyboard");

        assertEquals("Keyboard", result.getName());
    }

    // ---------------- TEST: nativeFindExpensive ----------------
    @Test
    void shouldNativeFindExpensive() {
        Product product = new Product();
        product.setPrice(1000.0);

        ProductDto dto = new ProductDto();
        dto.setPrice(1000.0);

        when(productRepository.nativeFindExpensive(900.0)).thenReturn(List.of(product));
        when(productMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<ProductDto> result = productService.nativeFindExpensive(900.0);

        assertEquals(1, result.size());
        assertEquals(1000.0, result.get(0).getPrice());
    }

    // ---------------- TEST: findOutOfStock ----------------
    @Test
    void shouldFindOutOfStock() {
        Product product = new Product();
        product.setQuantity(0);

        ProductDto dto = new ProductDto();
        dto.setQuantity(0);

        when(productRepository.findOutOfStock()).thenReturn(List.of(product));
        when(productMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<ProductDto> result = productService.findOutOfStock();

        assertEquals(1, result.size());
        assertEquals(0, result.get(0).getQuantity());
    }

    // ---------------- TEST: findByName FULL DTO ----------------
    @Test
    void shouldReturnFullProductDtoWhenFoundByName() throws Exception {
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

    // ---------------- TEST: insert WITH MAPPING LOGIC ----------------
    @Test
    void shouldInsertAndReturnMappedDto() throws Exception {
        ProductDto input = new ProductDto();
        input.setName("Mouse");
        input.setPrice(20.0);
        input.setQuantity(15);

        ProductDto output = new ProductDto();
        output.setName("Mouse");
        output.setPrice(20.0);
        output.setQuantity(15);

        when(service.insert(any())).thenReturn(output);

        mockMvc.perform(post("/Product/insert")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mouse"))
                .andExpect(jsonPath("$.price").value(20.0))
                .andExpect(jsonPath("$.quantity").value(15));
    }

    // ---------------- TEST: findByPriceGreaterThan MULTIPLE RESULTS ----------------
    @Test
    void shouldReturnMultipleProductsByPrice() throws Exception {
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

    // ---------------- TEST: findByQuantityLessThan MULTIPLE RESULTS ----------------
    @Test
    void shouldReturnMultipleProductsByQuantity() throws Exception {
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
                .andExpect(jsonPath("$[0].name").value("Keyboard"))
                .andExpect(jsonPath("$[1].name").value("Mouse"));
    }

    // ---------------- TEST: findByName SERVICE RETURNS NULL ----------------
    @Test
    void shouldReturnEmptyBodyWhenServiceReturnsNull() throws Exception {
        when(service.findByName("Unknown")).thenReturn(null);

        mockMvc.perform(get("/Product/findByName")
                        .param("name", "Unknown"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    // ---------------- TEST: insert VERIFY SERVICE + DTO FLOW ----------------
    @Test
    void shouldCallServiceInsertWithCorrectData() throws Exception {
        ProductDto dto = new ProductDto();
        dto.setName("Monitor");
        dto.setPrice(200.0);
        dto.setQuantity(4);

        when(service.insert(any())).thenReturn(dto);

        mockMvc.perform(post("/Product/insert")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());

        verify(service, times(1)).insert(any());
    }
}