package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.DipendenteDto;
import it.corso.AccademiJava.Model.Dipendente;
import org.modelmapper.ModelMapper;

public class DipendenteMapper extends AbstractConverter<Dipendente, DipendenteDto> {

    // Istanza di ModelMapper utilizzata per mappare automaticamente campi con lo stesso nome
    final private ModelMapper mapper = new ModelMapper();

    // Converte un'entità Dipendente in DTO DipendenteDto
    // ModelMapper copia automaticamente tutti i campi che hanno lo stesso nome e tipo
    @Override
    public DipendenteDto toDTO(Dipendente entity) { return mapper.map(entity, DipendenteDto.class); }

    // Converte un DTO DipendenteDto in entità Dipendente
    // Anche qui ModelMapper gestisce automaticamente il mapping dei campi
    @Override
    public Dipendente toEntity(DipendenteDto dto) { return mapper.map(dto, Dipendente.class); }

}