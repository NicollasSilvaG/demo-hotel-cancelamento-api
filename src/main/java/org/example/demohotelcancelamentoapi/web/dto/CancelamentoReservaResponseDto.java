package org.example.demohotelcancelamentoapi.web.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CancelamentoReservaResponseDto {
    private String id;
    private String check_in;
    private String check_out;
    private String quarto_id;
    private String hotel_id;
    private String status;

}
