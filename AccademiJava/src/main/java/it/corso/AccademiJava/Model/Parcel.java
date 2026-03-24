package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Parcel", schema = "Accademi")
public class Parcel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double weight;
    private Integer height;
    private Integer width;
    private Integer length;
    private Boolean fragile;

    @OneToMany



}
