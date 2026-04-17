package it.corso.AccademiJava.AziendaTest;

import it.corso.AccademiJava.Controller.AziendaController;
import it.corso.AccademiJava.DTO.AziendaDto;
import it.corso.AccademiJava.Service.AziendaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AziendaControllerTest {

    @Mock
    private AziendaService service;

    @InjectMocks
    private AziendaController controller;

    @Test
    public void findByNomeAzienda(){
        AziendaDto aziendaDto = new AziendaDto();
        aziendaDto.setNomeAzienda("Amazon");

        when(service.findByNomeAzienda("Amazon")).thenReturn(aziendaDto);

        AziendaDto result = controller.findByNomeAzienda("Amazon");

        assertNotNull(result);
        assertEquals("Amazon", result.getNomeAzienda());

        verify(service).findByNomeAzienda("Amazon");
    }

    @Test
    void findByNomeAziendaContainingIgnoreCase(){
        AziendaDto aziendaDto1 = new AziendaDto();
        aziendaDto1.setNomeAzienda("Amazon Spa");
        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setNomeAzienda("Google Spa");

        List<AziendaDto> list = List.of(aziendaDto1,aziendaDto2);
        when(service.findByNomeAziendaContainingIgnoreCase("spa")).thenReturn(list);

        List<AziendaDto> result = controller.findByNomeAziendaContainingIgnoreCase("spa");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Amazon Spa", result.get(0).getNomeAzienda());
        assertEquals("Google Spa", result.get(1).getNomeAzienda());
        verify(service).findByNomeAziendaContainingIgnoreCase("spa");
    }

    @Test
    void findByDescrizioneAziendaContainingIgnoreCase() {
        AziendaDto aziendaDto1 = new AziendaDto();
        aziendaDto1.setDescrizioneAzienda("Descrizione 1");
        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setDescrizioneAzienda("Descrizione 2");

        List<AziendaDto> list = List.of(aziendaDto1,aziendaDto2);

        when(service.findByDescrizioneAziendaContainingIgnoreCase("descrizione")).thenReturn(list);

        List<AziendaDto> result =  controller.findByDescrizioneAziendaContainingIgnoreCase("descrizione");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Descrizione 1", result.get(0).getDescrizioneAzienda());
        assertEquals("Descrizione 2", result.get(1).getDescrizioneAzienda());
        verify(service).findByDescrizioneAziendaContainingIgnoreCase("descrizione");
    }

    @Test
    void findByTitolare_Id(){
        AziendaDto aziendaDto= new AziendaDto();
        aziendaDto.setNomeAzienda("Tech");

        when(service.findByTitolare_Id(1)).thenReturn(aziendaDto);

        AziendaDto result = controller.findByTitolare_Id(1);

        assertNotNull(result);
        assertEquals(aziendaDto, result);
        verify(service).findByTitolare_Id(1);
    }

    @Test
    void findByNomeAziendaContaining(){
        AziendaDto aziendaDto1 = new AziendaDto();
        aziendaDto1.setNomeAzienda("Tech srl");
        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setNomeAzienda("Google srl");

        List<AziendaDto> list = List.of(aziendaDto1,aziendaDto2);
        when(service.findByNomeAziendaContaining("srl")).thenReturn(list);

        List<AziendaDto> result = service.findByNomeAziendaContaining("srl");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Tech srl", result.get(0).getNomeAzienda());
        assertEquals("Google srl", result.get(1).getNomeAzienda());
        verify(service).findByNomeAziendaContaining("srl");
    }

    @Test
    void CercaPerNome(){
        AziendaDto aziendaDto =  new AziendaDto();
        aziendaDto.setNomeAzienda("Amazon Spa");

        when(service.cercaPerNome("Amazon Spa")).thenReturn(aziendaDto);
        AziendaDto result = service.cercaPerNome("Amazon Spa");

        assertNotNull(result);
        assertEquals(aziendaDto, result);
        verify(service).cercaPerNome("Amazon Spa");
    }

    @Test
    void CercaPerDescrizione(){
        AziendaDto aziendaDto1 =  new AziendaDto();
        aziendaDto1.setDescrizioneAzienda("descrizione 1");
        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setDescrizioneAzienda("descrizione 2");

        List<AziendaDto> list = List.of(aziendaDto1,aziendaDto2);
        when(service.cercaPerDescrizione("descrizione")).thenReturn(list);

        List<AziendaDto> result = service.cercaPerDescrizione("descrizione");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("descrizione 1", result.get(0).getDescrizioneAzienda());
        assertEquals("descrizione 2", result.get(1).getDescrizioneAzienda());
        verify(service).cercaPerDescrizione("descrizione");
    }

    @Test
    void trovaPerDescrizioneNative(){
        AziendaDto aziendaDto1 =  new AziendaDto();
        aziendaDto1.setDescrizioneAzienda("descrizione 1");
        AziendaDto aziendaDto2 = new AziendaDto();
        aziendaDto2.setDescrizioneAzienda("descrizione 2");

        List<AziendaDto> list = List.of(aziendaDto1,aziendaDto2);
        when(service.trovaPerDescrizioneNative("descrizione")).thenReturn(list);

        List<AziendaDto> result = service.trovaPerDescrizioneNative("descrizione");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("descrizione 1", result.get(0).getDescrizioneAzienda());
        assertEquals("descrizione 2", result.get(1).getDescrizioneAzienda());
        verify(service).trovaPerDescrizioneNative("descrizione");
    }

    @Test
    void getAziendePaginati() {

        AziendaDto dto = new AziendaDto();
        dto.setId(1);
        dto.setNomeAzienda("Tech");

        Page<AziendaDto> page = new PageImpl<>(List.of(dto));

        when(service.getAziendePaginati(0, 10)).thenReturn(page);

        Page<AziendaDto> result = controller.getPage(0, 10);

        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals(1, result.getContent().get(0).getId());

        verify(service).getAziendePaginati(0, 10);
    }
}
