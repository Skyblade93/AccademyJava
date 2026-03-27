package it.corso.AccademiJava.UserTest;

import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Mapper.UserMapper;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.UserRepository;
import it.corso.AccademiJava.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private JpaRepository<User, Integer> jpaRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldFindByNome() {
        User user = new User();
        user.setName("Mario");

        UserDto dto = new UserDto();
        dto.setName("Mario");

        when(userRepository.findByName("Mario")).thenReturn(user);
        when(userMapper.toDTO(user)).thenReturn(dto);

        UserDto result = userService.findByNome("Mario");

        assertNotNull(result);
        assertEquals("Mario", result.getName());
    }

    @Test
    void shouldFindByDescription() {
        User user = new User();
        user.setDescription("Dev");

        UserDto dto = new UserDto();
        dto.setDescription("Dev");

        when(userRepository.findByDescription("Dev")).thenReturn(user);
        when(userMapper.toDTO(user)).thenReturn(dto);

        UserDto result = userService.findByDescription("Dev");

        assertEquals("Dev", result.getDescription());
    }

    @Test
    void shouldFindByInitial() {
        User user = new User();
        user.setName("Marco");

        UserDto dto = new UserDto();
        dto.setName("Marco");

        when(userRepository.trovaTramiteiniziale('M')).thenReturn(List.of(user));
        when(userMapper.toDTOList(any())).thenReturn(List.of(dto));

        List<UserDto> result = userService.trovaTramiteiniziale('M');

        assertEquals(1, result.size());
        assertEquals("Marco", result.get(0).getName());
    }
}