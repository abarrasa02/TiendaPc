package com.example.TiendaPc.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class dtoDetallePedidos {
    private Long id;
    private Long pedidoId;
    private Long productosId;
    private int cantidad;
    private double precioUnidad;
}
