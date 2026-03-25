package it.corso.AccademiJava.Repository;


import it.corso.AccademiJava.Model.Auto;
import it.corso.AccademiJava.Model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Entrata DB
public interface ParcelRepository extends JpaRepository<Parcel,Integer>
{
    @Query("SELECT p FROM Parcel p WHERE p.weight = :weight")
    Parcel findByWeight(@Param("weight") Double weight);





}
