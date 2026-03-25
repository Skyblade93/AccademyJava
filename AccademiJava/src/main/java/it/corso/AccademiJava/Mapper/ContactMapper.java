package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ContactDto;
import it.corso.AccademiJava.Model.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper extends AbstractConverter<Contact, ContactDto> {

    final private ModelMapper mapper = new ModelMapper();

    @Override
    public ContactDto toDTO(Contact entity) { return mapper.map(entity, ContactDto.class);}

    @Override
    public Contact toEntity(ContactDto dto) { return mapper.map(dto, Contact.class);}
}