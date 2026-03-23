package it.corso.AccademiJava.Service;


import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.UserRepository;
import org.slf4j.spi.DefaultLoggingEventBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService  {

    DefaultLoggingEventBuilder Debug;

    @Autowired
    UserRepository userRepository;

    public void leggiDb()
    {

        Debug.log(userRepository.findAll().toString());

    }



}
