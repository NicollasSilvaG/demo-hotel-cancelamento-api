package org.example.demohotelcancelamentoapi.service;


import lombok.RequiredArgsConstructor;
import org.example.demohotelcancelamentoapi.entity.Reserva;
import org.example.demohotelcancelamentoapi.repository.CancelamentoReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;

@RequiredArgsConstructor
@Service
public class CancelamentoReservaService {
    private final CancelamentoReservaRepository cancelamentoReservaRepository;


    @Transactional
    public void cancelarReserva(int reservaId) {
        Reserva reserva = cancelamentoReservaRepository.findById(reservaId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada com ID: " + reservaId));

        if(LocalDate.now().isBefore(reserva.getCheck_in().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) && reserva.getStatus().equals("ativa")) {
            reserva.setStatus("cancelada");
        }
    }
}
