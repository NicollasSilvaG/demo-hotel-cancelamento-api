package org.example.demohotelcancelamentoapi.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.Date;

@Table(name = "Reserva")
@Entity(name = "Reserva")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date check_in;
    private Date check_out;
    private int quarto_id;
    private int hotel_id;
    private String status;
}

