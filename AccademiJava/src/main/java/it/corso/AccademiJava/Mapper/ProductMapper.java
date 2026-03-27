package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ProductDto;
import it.corso.AccademiJava.Model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper extends AbstractConverter<Product, ProductDto> {

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ProductDto toDTO(Product entity) {
        return mapper.map(entity, ProductDto.class);
    }

    @Override
    public Product toEntity(ProductDto dto) {
        return mapper.map(dto, Product.class);
    }
}