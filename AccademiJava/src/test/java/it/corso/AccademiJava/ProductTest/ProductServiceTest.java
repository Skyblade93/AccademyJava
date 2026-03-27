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
}