package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ContactDto;
import it.corso.AccademiJava.Model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactMapper {
/*
    // LIST → DTO LIST
    public List<ContactDto> toDtoList(List<Contact> contacts) {
        List<ContactDto> dtos = new ArrayList<>();
        contacts.forEach(contact -> dtos.add(toDto(contact)));
        return dtos;
    }

    // DTO LIST → ENTITY LIST
    public List<Contact> toEntityList(List<ContactDto> dtos) {
        List<Contact> contacts = new ArrayList<>();
        dtos.forEach(dto -> contacts.add(toEntity(dto)));
        return contacts;
    }

    // ENTITY → DTO
    public ContactDto toDto(Contact contact) {
        ContactDto dto = new ContactDto();

        dto.setId(contact.getId());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setEmail(contact.getEmail());
        dto.setPhoneNumber(contact.getPhoneNumber());


        return dto;
    }

    // DTO → ENTITY
    public Contact toEntity(ContactDto dto) {
        Contact contact = new Contact();

        contact.setId(dto.getId());
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setEmail(dto.getEmail());
        contact.setPhoneNumber(dto.getPhoneNumber());


        return contact;
    }

 */
}