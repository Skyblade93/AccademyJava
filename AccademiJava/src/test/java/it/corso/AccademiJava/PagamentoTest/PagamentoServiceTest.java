package it.corso.AccademiJava.PagamentoTest;

import it.corso.AccademiJava.DTO.PagamentoDto;
import it.corso.AccademiJava.DTO.UserDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.PagamentoMapper;
import it.corso.AccademiJava.Model.MetodoPagamento;
import it.corso.AccademiJava.Model.Pagamento;
import it.corso.AccademiJava.Model.StatoPagamento;
import it.corso.AccademiJava.Model.User;
import it.corso.AccademiJava.Repository.PagamentoRepository;
import it.corso.AccademiJava.Service.PagamentoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Abilita Mockito nei test
@ExtendWith(MockitoExtension.class)
class PagamentoServiceTest {

    @Mock
    private PagamentoRepository pagamentoRepository;
    // Repository finto: evita accessi reali al database

    @Mock
    private PagamentoMapper pagamentoMapper;
    // Mapper finto: ci permette di simulare la conversione Entity -> DTO

    @Mock
    private Converter<Pagamento, PagamentoDto> converter;
    // Serve perché il service estende AbstractService e lo riceve nel costruttore

    @Mock
    private JpaRepository<Pagamento, Integer> jpaRepository;
    // Anche questo serve al costruttore della superclasse

    @InjectMocks
    private PagamentoService pagamentoService;
    // Crea il service e gli inietta automaticamente i mock sopra

    // Metodo di supporto per creare un oggetto Entity
    private Pagamento createPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(1);
        pagamento.setImporto(150.0);
        pagamento.setDataPagamento(LocalDateTime.of(2024, 6, 10, 15, 30));
        pagamento.setStato(StatoPagamento.COMPLETATO);
        pagamento.setMetodo(MetodoPagamento.CARTA);

        User user = new User();
        user.setId(5);
        user.setName("Mario");
        user.setDescription("Utente di test");

        pagamento.setUser(user);

        return pagamento;
    }

    // Metodo di supporto per creare il DTO corrispondente
    private PagamentoDto createDto() {
        PagamentoDto dto = new PagamentoDto();
        dto.setId(1);
        dto.setImporto(150.0);
        dto.setDataPagamento(LocalDateTime.of(2024, 6, 10, 15, 30));
        dto.setStato(StatoPagamento.COMPLETATO);
        dto.setMetodo(MetodoPagamento.CARTA);

        UserDto userDto = new UserDto();
        userDto.setId(5);
        userDto.setName("Mario");
        userDto.setDescription("Utente di test");

        dto.setUser(userDto);

        return dto;
    }

    @Test
    void testFindByDataPagamento() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();
        LocalDateTime data = LocalDateTime.of(2024, 6, 10, 15, 30);

        // Simuliamo ciò che restituirebbe il repository
        when(pagamentoRepository.findByDataPagamento(data)).thenReturn(List.of(pagamento));

        // Simuliamo la conversione lista Entity -> lista DTO
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        // Chiamiamo il metodo reale del service
        List<PagamentoDto> result = pagamentoService.findByDataPagamento(data);

        // Verifichiamo che i dati tornati siano quelli attesi
        assertEquals(1, result.size());
        assertEquals(150.0, result.getFirst().getImporto());
        assertEquals(StatoPagamento.COMPLETATO, result.getFirst().getStato());
    }

    @Test
    void testFindByStato() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        when(pagamentoRepository.findByStato(StatoPagamento.COMPLETATO))
                .thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByStato(StatoPagamento.COMPLETATO);

        assertEquals(1, result.size());
        assertEquals(StatoPagamento.COMPLETATO, result.getFirst().getStato());
    }

    @Test
    void testFindByMetodo() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        when(pagamentoRepository.findByMetodo(MetodoPagamento.CARTA))
                .thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByMetodo(MetodoPagamento.CARTA);

        assertEquals(1, result.size());
        assertEquals(MetodoPagamento.CARTA, result.getFirst().getMetodo());
    }

    @Test
    void testFindByUserId() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        when(pagamentoRepository.findByUserId(5)).thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByUserId(5);

        assertEquals(1, result.size());
        assertEquals(5, result.getFirst().getUser().getId());
        assertEquals("Mario", result.getFirst().getUser().getName());
    }

    @Test
    void testFindByImporto() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        when(pagamentoRepository.findByImporto(150.0)).thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByImporto(150.0);

        assertEquals(1, result.size());
        assertEquals(150.0, result.getFirst().getImporto());
    }

    @Test
    void testFindByImportoMaggioreDi() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        when(pagamentoRepository.findByImportoMaggioreDi(100.0)).thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByImportoMaggioreDi(100.0);

        assertEquals(1, result.size());
        assertEquals(150.0, result.getFirst().getImporto());
        assertEquals(MetodoPagamento.CARTA, result.getFirst().getMetodo());
    }
    @Test
    void testFindByStatoAndMetodo() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        // Simuliamo il repository (attenzione al nome del metodo: findByStatoAndMetodo)
        when(pagamentoRepository.findByStatoAndMetodo(StatoPagamento.COMPLETATO, MetodoPagamento.CARTA))
                .thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByStatoAndMetodo(StatoPagamento.COMPLETATO, MetodoPagamento.CARTA);

        assertEquals(1, result.size());
        assertEquals(StatoPagamento.COMPLETATO, result.getFirst().getStato());
        assertEquals(MetodoPagamento.CARTA, result.getFirst().getMetodo());
    }

    @Test
    void testFindPagamentiInPeriodo() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();
        LocalDateTime inizio = LocalDateTime.of(2024, 1, 1, 0, 0);
        LocalDateTime fine = LocalDateTime.of(2024, 12, 31, 23, 59);

        when(pagamentoRepository.findPagamentiInPeriodo(inizio, fine))
                .thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findPagamentiInPeriodo(inizio, fine);

        assertEquals(1, result.size());
        assertEquals(150.0, result.getFirst().getImporto());
    }

    @Test
    void testFindByUserIdAndStato() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        when(pagamentoRepository.findByUserIdAndStato(5, StatoPagamento.COMPLETATO))
                .thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByUserIdAndStato(5, StatoPagamento.COMPLETATO);

        assertEquals(1, result.size());
        assertEquals(5, result.getFirst().getUser().getId());
        assertEquals(StatoPagamento.COMPLETATO, result.getFirst().getStato());
    }

    @Test
    void testFindByImportoBetween() {
        Pagamento pagamento = createPagamento();
        PagamentoDto dto = createDto();

        when(pagamentoRepository.findByImportoBetween(100.0, 200.0))
                .thenReturn(List.of(pagamento));
        when(pagamentoMapper.toDTOList(List.of(pagamento))).thenReturn(List.of(dto));

        List<PagamentoDto> result = pagamentoService.findByImportoBetween(100.0, 200.0);

        assertEquals(1, result.size());
        assertEquals(150.0, result.getFirst().getImporto());
    }
}