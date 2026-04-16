package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.Mapper.ContactMapper;
import it.corso.AccademiJava.Model.Contact;
import it.corso.AccademiJava.DTO.ContactDto;
import it.corso.AccademiJava.Repository.ContactRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService extends AbstractService<Contact, ContactDto> {

    private final ContactRepository contactRepository;
    private final UserRepository userRepository;

    public ContactService(ContactRepository contactRepository,
                          ContactMapper contactMapper,
                          UserRepository userRepository) {

        super(contactRepository, contactMapper);
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
    }

    // 🔹 Cerca contatti per nome
    public List<Contact> cercaPerNome(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    // 🔹 Cerca contatto per email
    public Contact cercaPerEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    public ContactDto findByEmailDto(String email) {
        return converter.toDTO(contactRepository.findByEmail(email));
    }

    public List<ContactDto> findByNomeDto(String nome) {
        return converter.toDTOList(contactRepository.findByFirstName(nome));
    }
}
