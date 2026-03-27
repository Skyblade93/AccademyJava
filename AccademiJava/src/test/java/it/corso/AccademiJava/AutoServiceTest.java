package it.corso.AccademiJava;


import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.Mapper.AutoMapper;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.TipoCarburante;
import it.corso.AccademiJava.Repository.AutoRepository;
import it.corso.AccademiJava.Service.AutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AutoServiceTest {

    @Mock
    private AutoRepository autoRepository;

    @Mock
    private AutoMapper autoMapper;

    @Mock
    private Converter<Auto, AutoDto> converter;

    @Mock
    private JpaRepository<Auto, Integer> jpaRepository;

    @InjectMocks
    private AutoService autoService;

    private Auto createAuto() {
        Auto auto = new Auto();
        auto.setMarca("Fiat");
        auto.setModello("Panda");
        auto.setTarga("AB123CD");
        auto.setCarburante(TipoCarburante.DIESEL);
        return auto;
    }

    private AutoDto createDto() {
        AutoDto dto = new AutoDto();
        dto.setMarca("Fiat");
        dto.setModello("Panda");
        dto.setTarga("AB123CD");
        dto.setCarburante("DIESEL");
        return dto;
    }

    @Test
    void testFindByTarga() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByTarga("AB123CD")).thenReturn(auto);
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        AutoDto result = autoService.findByTarga("AB123CD");

        assertEquals("Fiat", result.getMarca());
        assertEquals("Panda", result.getModello());
    }

    @Test
    void testFindByMarca() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByMarca("Fiat")).thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        AutoDto result = autoService.findByMarca("Fiat");

        assertEquals("Fiat", result.getMarca());
    }

    @Test
    void testFindByModello() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByModello("Panda")).thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        AutoDto result = autoService.findByModello("Panda");

        assertEquals("Panda", result.getModello());
    }

    @Test
    void testFindByMarcaAndModello() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByMarcaAndModello("Fiat", "Panda")).thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        AutoDto result = autoService.findByMarcaAndModello("Fiat", "Panda");

        assertEquals("Fiat", result.getMarca());
        assertEquals("Panda", result.getModello());
    }

    @Test
    void testFindByModelloContaining() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByModelloContaining("Pan")).thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        AutoDto result = autoService.findByModelloContaining("Pan");

        assertEquals("Panda", result.getModello());
    }

    @Test
    void testFindByMarcaStartingWith() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByMarcaStartingWith("Fi")).thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        AutoDto result = autoService.findByMarcaStartingWith("Fi");

        assertEquals("Fiat", result.getMarca());
    }

    @Test
    void testFindByMarcaEndingWith() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByMarcaEndingWith("at")).thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        AutoDto result = autoService.findByMarcaEndingWith("at");

        assertEquals("Fiat", result.getMarca());
    }

    @Test
    void testFindByCarburante() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByCarburante(TipoCarburante.DIESEL)).thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        List<AutoDto> result = autoService.findByCarburante("DIESEL");

        assertEquals(1, result.size());
        assertEquals("DIESEL", result.getFirst().getCarburante());
    }

    @Test
    void testFindByMarcaAndCarburante() {
        Auto auto = createAuto();
        AutoDto dto = createDto();

        when(autoRepository.findByMarcaAndCarburante("Fiat", TipoCarburante.DIESEL))
                .thenReturn(List.of(auto));
        when(autoMapper.toDTO(auto)).thenReturn(dto);

        List<AutoDto> result = autoService.findByMarcaAndCarburante("Fiat", TipoCarburante.DIESEL);

        assertEquals(1, result.size());
        assertEquals("Fiat", result.getFirst().getMarca());
        assertEquals("DIESEL", result.getFirst().getCarburante());
    }

}
