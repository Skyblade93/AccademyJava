package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Parcel", schema = "Accademi")
public class Parcel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String senderName;
    private String senderSurname;
    private String receiverName;
    private String receiverSurname;
    private Double weight;
    private Integer height;
    private Integer width;
    private Integer length;
    private Boolean fragile;


    //Per ogni ordine c'è una spedizione.
    @OneToOne
    @JoinColumn(name = "ordine_id")
    private Ordine ordine;
    // Ogni spedizione ha un pagamento.
    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private Pagamento pagamento;

    //Ogni spedizione ha più notifiche.
    @OneToMany(mappedBy = "parcel")
    private List<Notifica> notifiche;










}
