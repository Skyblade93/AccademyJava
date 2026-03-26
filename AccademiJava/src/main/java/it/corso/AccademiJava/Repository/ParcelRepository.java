package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository // Entrata DB
public interface ParcelRepository extends JpaRepository<Parcel,Integer>
{
    @Query("SELECT p FROM Parcel p WHERE p.weight = :weight")
    Parcel findByWeight(@Param("weight") Double weight);

    @Query("SELECT p FROM Parcel p WHERE p.height = :height")
    Parcel findByHeight(@Param("height") Integer height);





}
