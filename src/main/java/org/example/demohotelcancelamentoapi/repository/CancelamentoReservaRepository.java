package org.example.demohotelcancelamentoapi.repository;

import org.example.demohotelcancelamentoapi.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelamentoReservaRepository extends JpaRepository<Reserva, Integer> {

}
