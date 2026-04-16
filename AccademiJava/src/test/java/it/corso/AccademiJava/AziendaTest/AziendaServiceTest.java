package it.corso.AccademiJava.AziendaTest;


import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Mapper.AziendaMapper;
import it.corso.AccademiJava.Model.Azienda;
import it.corso.AccademiJava.Repository.AziendaRepository;
import it.corso.AccademiJava.Service.AziendaService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AziendaServiceTest {

    @Mock
    private AziendaRepository aziendaRepository;

    @Mock
    private AziendaMapper aziendaMapper;

    @InjectMocks
    private AziendaService aziendaService;

    @Mock
    private JpaRepository<Azienda, Integer> jpaRepository;

    @Test
    void findByName(){
        Azienda azienda = new Azienda();
        azienda.setNomeAzienda("Amazon");

        AziendaDto  aziendaDto = new AziendaDto();
        aziendaDto.setNomeAzienda("Amazon");

        when(aziendaRepository.findByNomeAzienda("Amazon")).thenReturn(azienda);
        when(aziendaMapper.toDTO(azienda)).thenReturn(aziendaDto);

        AziendaDto result = aziendaService.findByNomeAzienda("Amazon");

        assertNotNull(result);
        assertEquals("Amazon", result.getNomeAzienda());

    }

    @Test
    void findByNomeAziendaContainingIgnoreCase(){
        Azienda azienda = new Azienda();
        azienda.setNomeAzienda("Tech Solutions");

        AziendaDto aziendaDto = new AziendaDto();
        aziendaDto.setNomeAzienda("Tech Solutions");

        when(aziendaRepository
                    .findByNomeAziendaContainingIgnoreCase("tech"))
                    .thenReturn(List.of(azienda));

        when(aziendaMapper
                    .toDTOList(List.of(azienda)))
                    .thenReturn(List.of(aziendaDto));


        List<AziendaDto> result =
                    aziendaService
                            .findByNomeAziendaContainingIgnoreCase("tech");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Tech Solutions",
                    result.getFirst().getNomeAzienda());
    }

    @Test
    void findByDescrizioneAziendaContainingIgnoreCase(){
        Azienda azienda = new Azienda();
        azienda.setDescrizioneAzienda("Descrizione");

        AziendaDto aziendaDto = new AziendaDto();
        aziendaDto.setDescrizioneAzienda("Descrizione");

        when(aziendaRepository.findByDescrizioneAziendaContainingIgnoreCase("descrizione")).thenReturn(List.of(azienda));
        when(aziendaMapper.toDTOList(List.of(azienda))).thenReturn(List.of(aziendaDto));

        List<AziendaDto> result = aziendaService.findByDescrizioneAziendaContainingIgnoreCase("descrizione");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Descrizione", result.getFirst().getDescrizioneAzienda());
    }



    @Test
    void findByTitolare_Id() {
        Azienda  azienda = new Azienda();
        azienda.setNomeAzienda("Tech");

        AziendaDto  aziendaDto = new AziendaDto();
        aziendaDto.setNomeAzienda("Tech");

        when(aziendaRepository.findByTitolare_Id(1)).thenReturn(azienda);
        when(aziendaMapper.toDTO(azienda)).thenReturn(aziendaDto);

        AziendaDto result = aziendaService.findByTitolare_Id(1);

        assertNotNull(result);
        assertEquals("Tech", result.getNomeAzienda());
    }

    @Test
    void findByNomeAziendaContaining() {
        Azienda azienda1 = new Azienda();
        azienda1.setNomeAzienda("Tech SRL");

        Azienda azienda2 = new Azienda();
        azienda2.setNomeAzienda("Food SRL");

        AziendaDto aziendaDto1 = new AziendaDto();
        aziendaDto1.setNomeAzienda("Tech SRL");

        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setNomeAzienda("Food SRL");

        List<Azienda> aziende = List.of(azienda1, azienda2);
        List<AziendaDto> dtos = List.of(aziendaDto1, aziendaDto2);

        when(aziendaRepository
                .findByNomeAziendaContaining("srl"))
                .thenReturn(aziende);

        when(aziendaMapper
                .toDTOList(aziende))
                .thenReturn(dtos);

        List<AziendaDto> result =
                aziendaService
                        .findByNomeAziendaContaining("srl");


        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals("Tech SRL",
                result.get(0).getNomeAzienda());

        assertEquals("Food SRL",
                result.get(1).getNomeAzienda());
    }

    @Test
    void cercaPerNome(){
        Azienda azienda = new Azienda();
        azienda.setNomeAzienda("Tech SRL");

        AziendaDto aziendaDto = new AziendaDto();
        aziendaDto.setNomeAzienda("Tech SRL");

        when(aziendaRepository.CercaPerNome("Tech SRL")).thenReturn(azienda);
        when(aziendaMapper.toDTO(azienda)).thenReturn(aziendaDto);

        assertNotNull(aziendaService.cercaPerNome("Tech SRL"));
        assertEquals("Tech SRL", aziendaDto.getNomeAzienda());
    }

    @Test
    void CercaPerDescrizione(){
        Azienda azienda1 = new Azienda();
        azienda1.setDescrizioneAzienda("descrizione 1");
        Azienda azienda2 = new Azienda();
        azienda2.setDescrizioneAzienda("descrizione 2");

        AziendaDto aziendaDto1 = new AziendaDto();
        aziendaDto1.setDescrizioneAzienda("descrizione 1");
        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setDescrizioneAzienda("descrizione 2");

        List<Azienda> aziende = List.of(azienda1, azienda2);
        List<AziendaDto> aziendeDtos = List.of(aziendaDto1, aziendaDto2);

        when(aziendaRepository.CercaPerDescrizione("descrizione")).thenReturn(aziende);
        when(aziendaMapper.toDTOList(aziende)).thenReturn(aziendeDtos);

        List<AziendaDto> result = aziendaService.cercaPerDescrizione("descrizione");

        assertNotNull(result);
        assertEquals("descrizione 1", result.get(0).getDescrizioneAzienda());
        assertEquals("descrizione 2", result.get(1).getDescrizioneAzienda());
    }

    @Test
    void trovaPerDescrizioneNative(){
        Azienda azienda1 = new Azienda();
        azienda1.setDescrizioneAzienda("descrizione 1");
        Azienda azienda2 = new Azienda();
        azienda2.setDescrizioneAzienda("descrizione 2");

        AziendaDto aziendaDto1 = new AziendaDto();
        aziendaDto1.setDescrizioneAzienda("descrizione 1");
        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setDescrizioneAzienda("descrizione 2");

        List<Azienda> aziende = List.of(azienda1, azienda2);
        List<AziendaDto> aziendeDtos = List.of(aziendaDto1, aziendaDto2);

        when(aziendaRepository.TrovaPerDescrizioneNative("descrizione")).thenReturn(aziende);
        when(aziendaMapper.toDTOList(aziende)).thenReturn(aziendeDtos);

        List<AziendaDto> result = aziendaService.trovaPerDescrizioneNative("descrizione");

        assertNotNull(result);
        assertEquals("descrizione 1", result.get(0).getDescrizioneAzienda());
        assertEquals("descrizione 2", result.get(1).getDescrizioneAzienda());
    }

    @Test
    void getAziendePaginati() {

        Azienda azienda = new Azienda();
        azienda.setNomeAzienda("Tech");

        List<Azienda> lista = List.of(azienda);

        Page<Azienda> page = new PageImpl<>(
                lista,
                PageRequest.of(0, 10),
                lista.size()
        );

        AziendaDto dto = new AziendaDto();
        dto.setNomeAzienda("Tech");

        when(aziendaRepository.findAll(PageRequest.of(0, 10)))
                .thenReturn(page);

        when(aziendaMapper.toDTO(azienda))
                .thenReturn(dto);

        Page<AziendaDto> result =
                aziendaService.getAziendePaginati(0, 10);

        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals("Tech", result.getContent().get(0).getNomeAzienda());
    }
}

