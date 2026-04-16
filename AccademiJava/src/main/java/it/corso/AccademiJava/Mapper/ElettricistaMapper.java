package it.corso.AccademiJava.Mapper;
import java.util.List;
import java.util.stream.Collectors;
import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Model.Elettricista;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

// Mapper basic
@Component
public class ElettricistaMapper extends AbstractConverter<Elettricista, ElettricistaDto> {


    // ModelMapper fa conv.auto con Entity e DTO
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ElettricistaDto toDTO(Elettricista entity) {
        // Converte entity Elettricista in DTO auto
        if (entity == null) return null;
        return mapper.map(entity, ElettricistaDto.class);
    }

    @Override
    public Elettricista toEntity(ElettricistaDto dto) {
        // Converte DTO ElettricistaDto in entity
        if (dto == null) return null;
        return mapper.map(dto, Elettricista.class);
    }
    public List<ElettricistaDto> toDTOList(List<Elettricista> lista) {
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}