package it.corso.AccademiJava.Service;


import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.UserMapper;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService extends AbstractService<User, UserDto> {

private final UserMapper userMapper;

private final UserRepository userRepository;

    public UserService(JpaRepository<User, Integer> repository, Converter<User, UserDto> converter, UserMapper userMapper, UserRepository userRepository) {
        super(repository, converter);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }


    public UserDto findByNome(String nome){
    UserDto userDto = userMapper.toDTO(userRepository.findByName(nome));
    return userDto;
}


public UserDto findByDescription(String Description){
    return userMapper.toDTO(userRepository.findByDescription(Description));
}

public List<UserDto> trovaTramiteiniziale(Character i){
        return userMapper.toDTOList(userRepository.trovaTramiteiniziale(i));
}

}
