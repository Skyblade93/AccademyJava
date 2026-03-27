package it.corso.AccademiJava.TestDrone;

import it.corso.AccademiJava.Model.Drone;
import it.corso.AccademiJava.Repository.DroneRepository;
import it.corso.AccademiJava.Service.DroneService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DroneServiceTest {

    @Mock
    private DroneRepository droneRepository;

    @InjectMocks
    private DroneService droneService;

    @Test
    public void testSalvataggioDrone() {
        Drone drone = new Drone();
        drone.setCodiceSeriale("DRN-TEST-01");

        when(droneRepository.save(any(Drone.class))).thenReturn(drone);

    }
}