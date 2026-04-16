package it.corso.AccademiJava.ElettricistaTest;

import it.corso.AccademiJava.DTO.ElettricistaDto;
import it.corso.AccademiJava.Mapper.ElettricistaMapper;
import it.corso.AccademiJava.Model.Elettricista;
import it.corso.AccademiJava.Repository.ElettricistaRepository;
import it.corso.AccademiJava.Service.ElettricistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//fixato tutto x reset testservice
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//fixato tutto e test rifatti x reset
public class ElettricistaTestService {

    @Mock
    private ElettricistaRepository elettricistaRepository;

    @Mock
    private ElettricistaMapper elettricistaMapper;

    @InjectMocks
    private ElettricistaService elettricistaService;

    private Elettricista entity;
    private ElettricistaDto dto;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        entity = new Elettricista();
        entity.setNome("Ciro");
        entity.setCognome("Esposito");
        entity.setSpecializzazione("Industriale");
        entity.setDisponibile(true);

        dto = new ElettricistaDto();
        dto.setNome("Ciro");
        dto.setCognome("Esposito");
        dto.setSpecializzazione("Industriale");
        dto.setDisponibile(true);
    }

    @Test
    void testFindByNome() {  //1
        when(elettricistaRepository.
                findByNome("Ciro"))
                .thenReturn(Arrays.asList(entity));

        when(elettricistaMapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.
                findByNome("Ciro");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Ciro", result.get(0).getNome());
    }

    @Test
    void testFindDisponibili() { //2

        when(elettricistaRepository.
                findByDisponibileTrue())
                .thenReturn(Arrays.asList(entity));

        when(elettricistaMapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.
                findDisponibili();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testFindByCognome() {  //3

        when(elettricistaRepository.findByCognome("Esposito"))
                .thenReturn(Arrays.asList(entity));

        when(elettricistaMapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = elettricistaService.
                findByCognome("Esposito");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Esposito", result.get(0).getCognome());
    }

    @Test
    void testFindBySpecializzazione() {  //3

        when(elettricistaRepository.
                findBySpecializzazione("Industriale"))
                .thenReturn(Arrays.asList(entity));

        when(elettricistaMapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result =
                elettricistaService.
                        findBySpecializzazione("Industriale");

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testCercaPerNomeJPQL() {  //4

        when(elettricistaRepository.cercaPerNomeJPQL("Ciro"))
                .thenReturn(entity);

        when(elettricistaMapper.toDTO(entity))
                .thenReturn(dto);

        ElettricistaDto result =
                elettricistaService.
                        cercaPerNomeJPQL("Ciro");

        assertNotNull(result);
        assertEquals("Ciro", result.getNome());
    }

    @Test
    void testFindDisponibiliNativeVuoto() {  //5

        when(elettricistaRepository.
                findDisponibiliNative())
                .thenReturn(Collections.emptyList());

        List<ElettricistaDto> result =
                elettricistaService.
                        findDisponibiliNative();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}