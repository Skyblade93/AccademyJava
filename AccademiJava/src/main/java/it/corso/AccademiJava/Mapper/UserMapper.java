package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.User;
import org.modelmapper.ModelMapper;


public class UserMapper extends AbstractConverter<User, UserDto> {


   final private ModelMapper mapper = new ModelMapper();


    @Override
    public UserDto toDTO(User entity) { return mapper.map(entity, UserDto.class); }

    @Override
    public User toEntity(UserDto dto) { return mapper.map(dto, User.class);}
}