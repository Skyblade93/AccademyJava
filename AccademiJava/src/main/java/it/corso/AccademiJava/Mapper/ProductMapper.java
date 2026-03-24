package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ProductDto;
import it.corso.AccademiJava.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public List<ProductDto> toDtoList(List<Product> products){
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> productDtos.add(toDto(product)));
        return productDtos;
    }

    public List<Product> toEntityList(List<ProductDto> productDtos){
        List<Product> products = new ArrayList<>();
        productDtos.forEach(dto -> products.add(toEntity(dto)));
        return products;
    }

    public ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setCategory(product.getCategory());

        return dto;
    }

    public Product toEntity(ProductDto dto) {
        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setCategory(dto.getCategory());

        return product;
    }
}