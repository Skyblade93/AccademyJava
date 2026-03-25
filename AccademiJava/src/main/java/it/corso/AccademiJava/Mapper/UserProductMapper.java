package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.UserProductDto;
import it.corso.AccademiJava.Model.UserProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserProductMapper extends AbstractConverter<UserProduct, UserProductDto> {

    private final ModelMapper mapper = new ModelMapper();

    // Entity -> DTO
    @Override
    public UserProductDto toDTO(UserProduct entity) {
        return mapper.map(entity, UserProductDto.class);
    }

    // DTO -> Entity
    @Override
    public UserProduct toEntity(UserProductDto dto) {
        return mapper.map(dto, UserProduct.class);
    }
}