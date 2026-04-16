package it.corso.AccademiJava.ContactTest;

import it.corso.AccademiJava.DTO.ContactDto;
import it.corso.AccademiJava.Mapper.ContactMapper;
import it.corso.AccademiJava.Model.Contact;
import it.corso.AccademiJava.Repository.ContactRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import it.corso.AccademiJava.Service.ContactService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ContactMapper contactMapper;

    @InjectMocks
    private ContactService contactService;

    // 🔹 FIND BY EMAIL
    @Test
    void testFindByEmail() {
        Contact contact = new Contact();
        contact.setEmail("test@email.com");

        ContactDto dto = new ContactDto();
        dto.setEmail("test@email.com");

        when(contactRepository.findByEmail("test@email.com")).thenReturn(contact);
        when(contactMapper.toDTO(contact)).thenReturn(dto);

        ContactDto result = contactService.findByEmailDto("test@email.com");

        assertNotNull(result);
        assertEquals("test@email.com", result.getEmail());
    }

    // 🔹 FIND BY NOME
    @Test
    void testFindByNome() {
        Contact contact = new Contact();
        contact.setFirstName("Mario");

        ContactDto dto = new ContactDto();
        dto.setFirstName("Mario");

        when(contactRepository.findByFirstName("Mario")).thenReturn(List.of(contact));
        when(contactMapper.toDTOList(List.of(contact))).thenReturn(List.of(dto));

        List<ContactDto> result = contactService.findByNomeDto("Mario");

        assertEquals(1, result.size());
        assertEquals("Mario", result.get(0).getFirstName());
    }
}
