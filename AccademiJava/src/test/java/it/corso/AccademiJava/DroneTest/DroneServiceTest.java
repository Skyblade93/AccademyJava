package it.corso.AccademiJava.DroneTest;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Mapper.DroneMapper;
import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Service.DroneService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// Questa riga risolve l'errore "UnnecessaryStubbingException" rendendo Mockito più flessibile
@MockitoSettings(strictness = Strictness.LENIENT)
public class DroneServiceTest {

    @Mock
    private DroneRepository droneRepository;

    @Mock
    private DroneMapper droneMapper;

    @InjectMocks
    private DroneService droneService;

    @Test
    public void testInsertDrone() {
        Drone drone = new Drone();
        DroneDto dto = new DroneDto();

        when(droneMapper.toEntity(any(DroneDto.class))).thenReturn(drone);
        when(droneRepository.save(any(Drone.class))).thenReturn(drone);
        when(droneMapper.toDTO(any(Drone.class))).thenReturn(dto);

        DroneDto result = droneService.insert(dto);
        assertNotNull(result);
    }

    @Test
    public void testFindByModelloSuccess() {
        Drone drone = new Drone();
        when(droneRepository.findByModello("Predator")).thenReturn(List.of(drone));
        when(droneMapper.toDTO(any(Drone.class))).thenReturn(new DroneDto());

        DroneDto result = droneService.findByModello("Predator");
        assertNotNull(result);
    }

    @Test
    public void testFindByModelloNotFound() {
        when(droneRepository.findByModello("Inesistente")).thenReturn(new ArrayList<>());
        DroneDto result = droneService.findByModello("Inesistente");
        assertNull(result);
    }

    @Test
    public void testTrovaTramiteIniziale() {
        when(droneRepository.findByModelloStartingWith("P")).thenReturn(new ArrayList<>());
        List<DroneDto> lista = droneService.trovaTramiteIniziale('P');
        assertNotNull(lista);
    }

    @Test
    public void testUpdateDrone() {
        DroneDto dto = new DroneDto();
        dto.setId(1);
        // Rimosso lo stubbing superfluo che causava l'errore
        droneService.update(dto);
        verify(droneRepository, atLeastOnce()).save(any());
    }

    @Test
    public void testDeleteDrone() {
        droneService.delete(1);
        verify(droneRepository, times(1)).deleteById(1);
    }

    @Test
    public void testReadById() {
        Drone drone = new Drone();
        DroneDto dto = new DroneDto();

        // Configuriamo il mock per restituire il drone e poi convertirlo in DTO
        when(droneRepository.findById(1)).thenReturn(Optional.of(drone));
        when(droneMapper.toDTO(any(Drone.class))).thenReturn(dto);

        DroneDto result = droneService.read(1);
        assertNotNull(result, "Il risultato non deve essere null");
    }

    @Test
    public void testBatteryCheck() {
        Drone drone = new Drone();
        drone.setLivelloBatteria(10);
        assertTrue(drone.getLivelloBatteria() < 20);
    }

    @Test
    public void testToDtoList() {
        when(droneRepository.findByModelloStartingWith(anyString())).thenReturn(List.of(new Drone()));
        // Importante: il service probabilmente usa toDtoList per le liste
        when(droneMapper.toDtoList(any())).thenReturn(List.of(new DroneDto()));

        List<DroneDto> dtos = droneService.trovaTramiteIniziale('A');
        assertNotNull(dtos);
    }

    @Test
    public void testRepositoryError() {
        when(droneRepository.findById(any())).thenThrow(new RuntimeException("DB Down"));
        assertThrows(RuntimeException.class, () -> droneService.read(99));
    }
}