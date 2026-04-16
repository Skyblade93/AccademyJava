package it.corso.AccademiJava.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ParcelDto
{

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

    private Integer ordineId;
    private Integer pagamentoId;
    private List<Integer> notificheIds;
}
