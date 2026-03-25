package it.corso.AccademiJava.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProductDto {

    private Integer id;

    private Integer userId;
    private Integer productId;

    private Integer quantity;
}