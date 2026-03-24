package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper extends AbstractConverter<User, UserDto> {

    public List<UserDto> toDtoList(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> userDtos.add(toDTO(user)));
        return userDtos;
    }

    public List<User> toEntityList(List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        userDtos.forEach(userDto -> users.add(toEntity(userDto)));
        return users;
    }

    @Override
    public UserDto toDTO(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setDescription(user.getDescription());
        userDto.getContacts().addAll(user.getContacts());

        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setDescription(userDto.getDescription());
        user.getContacts().addAll(userDto.getContacts());

        return user;
    }
}