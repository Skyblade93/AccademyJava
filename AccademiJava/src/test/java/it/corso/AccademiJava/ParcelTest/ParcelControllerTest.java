package it.corso.AccademiJava.ParcelTest;

import it.corso.AccademiJava.Controller.ParcelController;
import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Service.ParcelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParcelControllerTest
{
    @Mock
    private ParcelService parcelService;

    @InjectMocks
    private ParcelController parcelController;

    @Test
    void testFindById()
    {
        int id = 1;
        ParcelDto dtoMock = new ParcelDto();
        dtoMock.setId(id);

        when(parcelService.findById(id)).thenReturn(dtoMock);
        when(parcelService)
    }
}
