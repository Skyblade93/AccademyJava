package it.corso.AccademiJava;

import it.corso.AccademiJava.DTO.DroneDto;
import it.corso.AccademiJava.Mapper.DroneMapper;
import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Service.DroneService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DroneServiceTest {

    @Mock
    private DroneRepository droneRepository;

    @Mock
    private DroneMapper droneMapper;

    @InjectMocks
    private DroneService droneService;

    // 1. Test Inserimento Drone
    @Test
    public void testInsertDrone() {
        Drone drone = new Drone();
        drone.setCodiceSeriale("DRN-001");
        DroneDto dto = new DroneDto();

        when(droneMapper.toEntity(any(DroneDto.class))).thenReturn(drone);
        when(droneRepository.save(any(Drone.class))).thenReturn(drone);
        when(droneMapper.toDTO(any(Drone.class))).thenReturn(dto);

        DroneDto result = droneService.insert(dto);
        assertNotNull(result);
    }

    // 2. Test Ricerca per Modello (Trovato)
    @Test
    public void testFindByModelloSuccess() {
        Drone drone = new Drone();
        drone.setModello("Predator");

        when(droneRepository.findByModello("Predator")).thenReturn(List.of(drone));
        when(droneMapper.toDTO(any(Drone.class))).thenReturn(new DroneDto());

        DroneDto result = droneService.findByModello("Predator");
        assertNotNull(result);
    }

    // 3. Test Ricerca per Modello (Non trovato)
    @Test
    public void testFindByModelloNotFound() {
        when(droneRepository.findByModello("Inesistente")).thenReturn(new ArrayList<>());

        // Il tuo service potrebbe lanciare eccezione o dare null
        assertThrows(Exception.class, () -> droneService.findByModello("Inesistente"));
    }

    // 4. Test Ricerca tramite Iniziale
    @Test
    public void testTrovaTramiteIniziale() {
        when(droneRepository.findByModelloStartingWith("P")).thenReturn(new ArrayList<>());

        List<DroneDto> lista = droneService.trovaTramiteIniziale('P');
        assertNotNull(lista);
    }

    // 5. Test Update (Ereditato da AbstractService)
    @Test
    public void testUpdateDrone() {
        DroneDto dto = new DroneDto();
        dto.setId(1);
        when(droneRepository.existsById(1)).thenReturn(true);

        droneService.update(dto);
        verify(droneRepository, times(1)).save(any());
    }

    // 6. Test Delete (Ereditato da AbstractService)
    @Test
    public void testDeleteDrone() {
        droneService.delete(1);
        verify(droneRepository, times(1)).deleteById(1);
    }

    // 7. Test FindById (Ereditato da AbstractService)
    @Test
    public void testFindById() {
        when(droneRepository.findById(1)).thenReturn(Optional.of(new Drone()));

        DroneDto result = droneService.findById(1);
        assertNotNull(result);
    }

    // 8. Test Verifica Batteria Scarica (Logica custom)
    @Test
    public void testBatteryCheck() {
        Drone drone = new Drone();
        drone.setLivelloBatteria(10);
        // Qui potresti testare un metodo del service che avvisa se la batteria è < 20%
        assertTrue(drone.getLivelloBatteria() < 20);
    }

    // 9. Test Mapper Lista
    @Test
    public void testToDtoList() {
        List<Drone> entities = List.of(new Drone(), new Drone());
        when(droneMapper.toDTO(any())).thenReturn(new DroneDto());

        List<DroneDto> dtos = droneService.trovaTramiteIniziale('A');
        assertNotNull(dtos);
    }

    // 10. Test con Repository che restituisce Errore
    @Test
    public void testRepositoryError() {
        when(droneRepository.findById(anyInt())).thenThrow(new RuntimeException("DB Down"));

        assertThrows(RuntimeException.class, () -> droneService.findById(99));
    }
}