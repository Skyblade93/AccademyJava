package it.corso.AccademiJava.Mapper;

import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Model.Parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelMapper {

    public List<ParcelDto> toDtoList(List<Parcel> parcels) {
        List<ParcelDto> parcelDtos = new ArrayList<>();
        parcels.forEach(parcel -> parcelDtos.add(toDto(parcel)));
        return parcelDtos;
    }

    public List<Parcel> toEntityList(List<ParcelDto> parcelDtos) {
        List<Parcel> parcels = new ArrayList<>();
        parcelDtos.forEach(dto -> parcels.add(toEntity(dto)));
        return parcels;
    }

    public ParcelDto toDto(Parcel parcel) {
        ParcelDto dto = new ParcelDto();

        dto.setId(parcel.getId());
        dto.setWeight(parcel.getWeight());
        dto.setHeight(parcel.getHeight());
        dto.setWidth(parcel.getWidth());
        dto.setLength(parcel.getLength());
        dto.setFragile(parcel.getFragile());

        return dto;
    }

    public Parcel toEntity(ParcelDto dto) {
        Parcel parcel = new Parcel();

        parcel.setId(dto.getId());
        parcel.setWeight(dto.getWeight());
        parcel.setHeight(dto.getHeight());
        parcel.setWidth(dto.getWidth());
        parcel.setLength(dto.getLength());
        parcel.setFragile(dto.getFragile());

        return parcel;
    }
}