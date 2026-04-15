package it.corso.AccademiJava.ParcelTest;


import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Mapper.ParcelMapper;
import it.corso.AccademiJava.Model.Parcel;
import it.corso.AccademiJava.Repository.ParcelRepository;
import it.corso.AccademiJava.Service.ParcelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParcelServiceTest
{
    @Mock
    private ParcelRepository parcelRepository;

    @Mock
    private ParcelMapper parcelMapper;

    @InjectMocks
    private ParcelService parcelService;
    @Test
    void findByWeight()
    {
        double weight = 10;
        Parcel entity = new Parcel();
        ParcelDto dto = new ParcelDto();

        when(parcelRepository.findByWeight(weight)).thenReturn(entity);
        when(parcelMapper.toDTO(entity)).thenReturn(dto);

        ParcelDto  result = parcelService.findByWeight(weight);

        assertThat(result).isEqualTo(dto);
    }
    @Test
    void findByHeight()
    {
        Integer height = 5;
        Parcel entity = new Parcel();
        ParcelDto dto = new ParcelDto();

        when(parcelRepository.findByHeight(height)).thenReturn(entity);
        when(parcelMapper.toDTO(entity)).thenReturn(dto);

        ParcelDto result = parcelService.findByHeight(height);

        assertThat(result).isEqualTo(dto);
    }
    @Test
    void findByLength()
    {
        Integer length = 3;
        Parcel entity = new Parcel();
        ParcelDto dto = new ParcelDto();

        when(parcelRepository.findByLength(length)).thenReturn(entity);
        when(parcelMapper.toDTO(entity)).thenReturn(dto);

        ParcelDto result = parcelService.findByLength(length);

        assertThat(result).isEqualTo(dto);
    }

    @Test
    void findByWidth()
    {
        Integer width = 4;
        Parcel entity = new Parcel();
        ParcelDto dto = new ParcelDto();

        when(parcelRepository.findByWidth(width)).thenReturn(entity);
        when(parcelMapper.toDTO(entity)).thenReturn(dto);

        ParcelDto result = parcelService.findByWidth(width);

        assertThat(result).isEqualTo(dto);
    }

    @Test
    void findByWeightAndHeight()
    {
       Double weight = 4.0;
       Integer height = 6;

       Parcel entity = new Parcel();
       ParcelDto dto = new ParcelDto();

       when(parcelRepository.findByWeightAndHeight(weight,height)).thenReturn(entity);
       when(parcelMapper.toDTO(entity)).thenReturn(dto);

       ParcelDto result = parcelService.findByWeightAndHeight(weight,height);

       assertThat(result).isEqualTo(dto);
    }

    @Test
    void findByWidthAndLength()
    {
        Double width = 7.0;
        Integer length = 8;

        Parcel entity = new Parcel();
        ParcelDto dto = new ParcelDto();


        when(parcelRepository.findByWidthAndLength(width,length)).thenReturn(entity);
        when(parcelMapper.toDTO(entity)).thenReturn(dto);

        ParcelDto result = parcelService.findByWidthAndLength(width,length);

        assertThat(result).isEqualTo(dto);
    }


}
