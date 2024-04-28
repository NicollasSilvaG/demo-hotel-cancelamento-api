package org.example.demohotelcancelamentoapi.service;


import lombok.RequiredArgsConstructor;
import org.example.demohotelcancelamentoapi.entity.Reserva;
import org.example.demohotelcancelamentoapi.repository.CancelamentoReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CancelamentoReservaService {
    private final CancelamentoReservaRepository cancelamentoReservaRepository;
    

    @Transactional(readOnly = true)
    public List<Reserva> buscarPorLocalizacao(String local) {
       List<Reserva> reservas = List.of();
        return reservas;
    }

    @Transactional
    public void cancelarReserva(int reservaId) {
        Reserva reserva = cancelamentoReservaRepository.findById(reservaId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada com ID: " + reservaId));

        reserva.setStatus("cancelada");

    }
}
