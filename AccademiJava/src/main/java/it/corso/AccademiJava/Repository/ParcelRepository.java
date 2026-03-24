package it.corso.AccademiJava.Repository;


import it.corso.AccademiJava.Model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Entrata DB
public interface ParcelRepository extends JpaRepository<Parcel,Integer>
{
}
