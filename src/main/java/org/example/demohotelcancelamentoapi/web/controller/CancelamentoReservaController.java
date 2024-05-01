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
@RequestMapping("api/v1/reservas/cancelamento")
public class CancelamentoReservaController {

    private final CancelamentoReservaService cancelamentoReservaService;

    @Operation(summary = "Cancela as reserva por ID", description = "Cancelar as reserva por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Cancela as reservas com base no id",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CancelamentoReservaResponseDto.class))))
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
