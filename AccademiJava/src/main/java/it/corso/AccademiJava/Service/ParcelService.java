package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Mapper.ParcelMapper;
import it.corso.AccademiJava.Mapper.ProductMapper;
import it.corso.AccademiJava.Model.Parcel;
import it.corso.AccademiJava.Repository.ParcelRepository;
import it.corso.AccademiJava.Repository.ProductRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService extends AbstractService<Parcel, ParcelDto> {

    @Autowired
    ParcelMapper parcelMapper;
    @Autowired
    ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository,
                         ParcelMapper parcelMapper) {

        super(parcelRepository, parcelMapper);
        this.parcelRepository = parcelRepository;
        this.parcelMapper = parcelMapper;
    }


    public ParcelDto findByWeight(Double weight) {
        return parcelMapper.toDTO(parcelRepository.findByWeight(weight));
    }

}


