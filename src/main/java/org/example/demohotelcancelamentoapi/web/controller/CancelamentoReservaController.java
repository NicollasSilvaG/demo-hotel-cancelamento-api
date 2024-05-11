package org.example.demohotelcancelamentoapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.example.demohotelcancelamentoapi.service.CancelamentoReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/reservas/cancelamento")
public class CancelamentoReservaController {

    private final CancelamentoReservaService cancelamentoReservaService;

    @Operation(summary = "Cancela as reservas por ID", description = "Cancela as reservas por ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Cancela as reservas com base no id",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Void.class))))
            }
    )
    @PatchMapping("/{reservaId}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable int reservaId) {
        cancelamentoReservaService.cancelarReserva(reservaId);
        return ResponseEntity.noContent().build();
    }

}
