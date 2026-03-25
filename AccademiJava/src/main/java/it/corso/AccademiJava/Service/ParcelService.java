package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.AutoDto;
import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Mapper.ParcelMapper;
import it.corso.AccademiJava.Model.Parcel;
import it.corso.AccademiJava.Repository.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelService extends AbstractService<Parcel, ParcelDto>{

    @Autowired
    ParcelMapper parcelMapper;
    @Autowired
    ParcelRepository parcelRepository;

        public ParcelDto findByWeight(Double weight) {return parcelMapper.toDTO(parcelRepository.findByWeight(weight));


    }

}
