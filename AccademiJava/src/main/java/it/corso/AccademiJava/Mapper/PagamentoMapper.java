package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.PagamentoDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Model.Pagamento;
import it.corso.AccademiJava.Model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper extends AbstractConverter<Pagamento, PagamentoDto> {
    final private ModelMapper mapper = new ModelMapper();
    @Override
    // public UserDto toDTO(User entity) { return mapper.map(entity, UserDto.class); }
    public PagamentoDto toDTO(Pagamento entity){return mapper.map(entity,PagamentoDto.class);}

    @Override
    public Pagamento toEntity(PagamentoDto dto) { return mapper.map(dto, Pagamento.class);}
}
