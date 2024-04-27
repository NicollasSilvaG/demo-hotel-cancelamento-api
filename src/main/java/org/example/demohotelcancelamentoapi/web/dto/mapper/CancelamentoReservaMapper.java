package org.example.demohotelcancelamentoapi.web.dto.mapper;

import org.example.demohotelcancelamentoapi.entity.Reserva;
import org.example.demohotelcancelamentoapi.web.dto.CancelamentoReservaResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

public class CancelamentoReservaMapper {

    public static CancelamentoReservaResponseDto toDto(Reserva reserva) {
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<Reserva, CancelamentoReservaResponseDto> propertyMapper = mapperMain.createTypeMap(Reserva.class, CancelamentoReservaResponseDto.class);
        return mapperMain.map(reserva, CancelamentoReservaResponseDto.class);
    }

    public static List<CancelamentoReservaResponseDto> toListDto(List<Reserva> reservas) {
        return reservas.stream().map(reserva -> toDto(reserva)).collect(Collectors.toList());
    }

}
