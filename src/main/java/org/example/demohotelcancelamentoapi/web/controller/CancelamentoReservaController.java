package org.example.demohotelcancelamentoapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.example.demohotelcancelamentoapi.entity.Reserva;
import org.example.demohotelcancelamentoapi.service.CancelamentoReservaService;
import org.example.demohotelcancelamentoapi.web.dto.CancelamentoReservaResponseDto;
import org.example.demohotelcancelamentoapi.web.dto.mapper.CancelamentoReservaMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/reservas")
public class CancelamentoReservaController {

    private final CancelamentoReservaService cancelamentoReservaService;

    @Operation(summary = "Cancelar reserva por ID", description = "Cancela uma reserva com base no seu ID",
            responses = {

                    @ApiResponse(responseCode = "204", description = "Reserva Cancelada",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CancelamentoReservaResponseDto.class)))),

                    @ApiResponse(responseCode = "404", description = "Reserva não encontrada com o ID fornecido"),
            }
    )
    @PatchMapping("/{reservaId}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable int reservaId) {
        cancelamentoReservaService.cancelarReserva(reservaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public String getTest() {
        return "Hotel Cancelamento Reserva API";
    }

}
