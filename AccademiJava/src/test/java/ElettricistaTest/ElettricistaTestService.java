package ElettricistaTest;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ElettricistaTestService {

    @Mock
    private ElettricistaRepository repository;

    @Mock
    private ElettricistaMapper mapper;

    @InjectMocks
    private ElettricistaService service;

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

    // 1 FIND BY NOME
    @Test
    void testFindByNome() {

        when(repository.findByNome("Ciro"))
                .thenReturn(Arrays.asList(entity));

        when(mapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        List<ElettricistaDto> result = service.findByNome("Ciro");

        assertEquals(1, result.size());
    }

    // 2 DISPONIBILI
    @Test
    void testFindDisponibili() {

        when(repository.findByDisponibileTrue())
                .thenReturn(Arrays.asList(entity));

        when(mapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        assertEquals(1, service.findDisponibili().size());
    }

    // 3 COGNOME
    @Test
    void testFindByCognome() {

        when(repository.findByCognome("Esposito"))
                .thenReturn(Arrays.asList(entity));

        when(mapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        assertEquals(1, service.findByCognome("Esposito").size());
    }

    // 4 SPECIALIZZAZIONE
    @Test
    void testFindBySpecializzazione() {

        when(repository.findBySpecializzazione("Industriale"))
                .thenReturn(Arrays.asList(entity));

        when(mapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        assertEquals(1, service.findBySpecializzazione("Industriale").size());
    }

    // 5 JPQL
    @Test
    void testCercaPerNomeJPQL() {

        when(repository.cercaPerNomeJPQL("Ciro"))
                .thenReturn(entity);

        when(mapper.toDTO(entity))
                .thenReturn(dto);

        assertEquals("Ciro", service.cercaPerNomeJPQL("Ciro").getNome());
    }

    // 6 JPQL DISP
    @Test
    void testElettricistiDisponibiliJPQL() {

        when(repository.elettricistiDisponibiliJPQL())
                .thenReturn(Arrays.asList(entity));

        when(mapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        assertEquals(1, service.elettricistiDisponibiliJPQL().size());
    }

    // 7 NATIVE
    @Test
    void testFindByNomeNative() {

        when(repository.findByNomeNative("Ciro"))
                .thenReturn(entity);

        when(mapper.toDTO(entity))
                .thenReturn(dto);

        assertEquals("Ciro", service.findByNomeNative("Ciro").getNome());
    }

    // 8 NULL CASE
    @Test
    void testFindByNomeNativeNull() {

        when(repository.findByNomeNative("Ciro"))
                .thenReturn(null);

        assertNull(service.findByNomeNative("Ciro"));
    }

    // 9 NATIVE LIST
    @Test
    void testFindDisponibiliNative() {

        when(repository.findDisponibiliNative())
                .thenReturn(Arrays.asList(entity));

        when(mapper.toDTOList(anyList()))
                .thenReturn(Arrays.asList(dto));

        assertEquals(1, service.findDisponibiliNative().size());
    }

    // 10 EMPTY LIST
    @Test
    void testFindDisponibiliNativeVuoto() {

        when(repository.findDisponibiliNative())
                .thenReturn(Collections.emptyList());

        assertTrue(service.findDisponibiliNative().isEmpty());
    }
}