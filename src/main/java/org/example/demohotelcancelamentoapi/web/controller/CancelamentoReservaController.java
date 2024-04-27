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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/reservas")
public class CancelamentoReservaController {

    private final CancelamentoReservaService hotelService;

    @Operation(summary = "Listar hotéis por localização", description = "Listar hotéis por localização",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista os hotéis com base em um termo que contenha parcialmente o nome da localização",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CancelamentoReservaResponseDto.class))))
            }
    )
    @GetMapping("/localizacao/{local}")
    public ResponseEntity<List<CancelamentoReservaResponseDto>> getByLocation(@PathVariable String local) {
        List<Reserva> reservas = hotelService.buscarPorLocalizacao(local);
        return ResponseEntity.ok(CancelamentoReservaMapper.toListDto(reservas));
    }

    @GetMapping
    public String getTest() {
        return "Hotel Cancelamento Reserva API";
    }
}
