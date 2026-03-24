package it.corso.AccademiJava.Service;


import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Mapper.UserMapper;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.UserRepository;
import org.slf4j.spi.DefaultLoggingEventBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService extends AbstractService<User, UserDto> {

@Autowired
UserMapper userMapper;

@Autowired
UserRepository userRepository;


public UserDto FindByNome(String nome){
    return userMapper.toDTO(userRepository.findByNome(nome));
}


    public Integer CountLettere(String nome){
        return (FindByNome(nome).getName().length());
    }



}
