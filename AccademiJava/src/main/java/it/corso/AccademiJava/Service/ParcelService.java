package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Mapper.ParcelMapper;
import it.corso.AccademiJava.Model.Parcel;
import it.corso.AccademiJava.Repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService extends AbstractService<Parcel, ParcelDto> {

    @Autowired
    ParcelMapper parcelMapper;
    @Autowired
    ParcelRepository parcelRepository;

    public ParcelDto findByWeight(Double weight) {
        return parcelMapper.toDTO(parcelRepository.findByWeight(weight));
    }
    public ParcelDto findByHeight(Integer height) {
        return parcelMapper.toDTO(parcelRepository.findByHeight(height));
    }
    public ParcelDto findByLength(Integer length) {return parcelMapper.toDTO(parcelRepository.findByLength(length));}
    public ParcelDto findByWidth(Integer width) {return parcelMapper.toDTO(parcelRepository.findByWidth(width));}
    public ParcelDto findByWeightGreaterThan(Double weight) {return parcelMapper.toDTO(parcelRepository.findByWeightGreaterThan(weight));}
    public ParcelDto findByHeightGreaterThan(Integer height) {return parcelMapper.toDTO(parcelRepository.findByHeightGreaterThan(height));}
    public ParcelDto findByLengthGreaterThan(Integer length) {return parcelMapper.toDTO(parcelRepository.findByLengthGreaterThan(length));}
    public ParcelDto findByWeightAndHeight(Double weight, Integer height) {return parcelMapper.toDTO(parcelRepository.findByWeightAndHeight(weight,height));}
    public ParcelDto findByWidthAndLength(Double width, Integer length) {return parcelMapper.toDTO(parcelRepository.findByWidthAndLength(width,length));}
    public ParcelDto findByWidhtGreaterThan(Integer width) {return parcelMapper.toDTO(parcelRepository.findByWidhtGreaterThan(width));}
    public ParcelDto findByReceiverName(String receiverName){return parcelMapper.toDTO(parcelRepository.findByReceiverName(receiverName));}
    public ParcelDto findByReceiverSurname(String receiverSurname){return parcelMapper.toDTO(parcelRepository.findByReceiverSurname(receiverSurname));}
    public ParcelDto findBySenderName(String senderName){return parcelMapper.toDTO(parcelRepository.findBySenderName(senderName));}
    public ParcelDto findBySenderSurname(String senderSurname){return parcelMapper.toDTO(parcelRepository.findBySenderSurname(senderSurname));}

    public ParcelService(ParcelRepository parcelRepository,
                         ParcelMapper parcelMapper) {

        super(parcelRepository, parcelMapper);
        this.parcelRepository = parcelRepository;
        this.parcelMapper = parcelMapper;
    }




}


