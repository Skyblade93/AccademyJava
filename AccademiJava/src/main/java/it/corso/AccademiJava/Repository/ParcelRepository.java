package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.DTO.ParcelDto;
import it.corso.AccademiJava.Model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository // Entrata DB
public interface ParcelRepository extends JpaRepository<Parcel,Integer>
{
    @Query("SELECT p FROM Parcel p WHERE p.weight = :weight")
    Parcel findByWeight(@Param("weight") Double weight);

    @Query("SELECT p FROM Parcel p WHERE p.height = :height")
    Parcel findByHeight(@Param("height") Integer height);

    @Query("SELECT p FROM Parcel p WHERE p.width = :width")
    Parcel findByWidth(@Param("width") Integer width);

    @Query("SELECT p FROM Parcel p WHERE p.length = :length")
    Parcel findByLength(@Param("length") Integer length);

    @Query("SELECT p FROM Parcel p WHERE p.weight > :weight")
    Parcel findByWeightGreaterThan(@Param("weight") Double weight);

    @Query("SELECT p FROM Parcel p WHERE p.height > :height")
    Parcel findByHeightGreaterThan(@Param("height") Integer height);

    @Query("SELECT p FROM Parcel p WHERE p.width > :width")
    Parcel findByWidhtGreaterThan(@Param("width") Integer width);

    @Query("SELECT p FROM Parcel p WHERE p.length > :length")
    Parcel findByLengthGreaterThan(@Param("length") Integer length);

    @Query("SELECT p FROM Parcel p WHERE p.senderName = :senderName")
    Parcel findBySenderName(@Param("senderName")String senderName);

    @Query("SELECT p FROM Parcel p WHERE p.receiverName = :receiverName")
    Parcel findByReceiverName(@Param("receiverName")String senderSurname);

    @Query("SELECT p FROM Parcel p WHERE p.senderSurname = :senderSurname")
    Parcel findBySenderSurname(@Param("senderSurname")String senderSurname);

    List<Parcel> findByReceiverSurname(String receiverSurname);

    @Query(value = "SELECT * FROM Parcel WHERE p.weight = ?1 AND p.height = ?2", nativeQuery = true)
    Parcel findByWeightAndHeight(Double weight,Integer height);

    @Query(value = "SELECT * FROM Parcel WHERE p.width = ?1 AND p.length = ?2", nativeQuery = true)
    Parcel findByWidthAndLength(Double width,Integer length);


    String receiverSurname(String receiverSurname);
}
