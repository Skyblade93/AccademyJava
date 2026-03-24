package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ProductDTO;
import it.corso.AccademiJava.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public List<ProductDTO> toDtoList(List<Product> products){
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> productDTOs.add(toDto(product)));
        return productDTOs;
    }

    public List<Product> toEntityList(List<ProductDTO> productDTOs){
        List<Product> products = new ArrayList<>();
        productDTOs.forEach(dto -> products.add(toEntity(dto)));
        return products;
    }

    public ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setCategory(product.getCategory());

        return dto;
    }

    public Product toEntity(ProductDTO dto) {
        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setCategory(dto.getCategory());

        return product;
    }
}