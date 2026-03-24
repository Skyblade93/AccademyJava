package it.corso.AccademiJava.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Parcel
{
    @Id

    private Integer Id;
    private Double weight,height,width, length;
    private String receiver;
    private String sender;

}
