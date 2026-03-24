package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.NotificaDto;
import it.corso.AccademiJava.Model.Notifica;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class NotificaMapper extends AbstractConverter<Notifica, NotificaDto> {

    final private ModelMapper mapper = new ModelMapper();

    @Override
    public NotificaDto toDTO(Notifica entity) {
        return mapper.map(entity, NotificaDto.class);
    }

    @Override
    public Notifica toEntity(NotificaDto dto) {
        return mapper.map(dto, Notifica.class);
    }
}
