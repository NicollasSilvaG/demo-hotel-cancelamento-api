package org.example.demohotelcancelamentoapi.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CancelamentoReservaResponseDto {
    private int id;
    private String nome;
    private String localizacao;

}
