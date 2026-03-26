package it.corso.AccademiJava.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="Pagamento",schema = "Accademi")

public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double importo;
    private LocalDateTime dataPagamento;
    @Enumerated(EnumType.STRING)
    private StatoPagamento stato;
    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodo;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

}
