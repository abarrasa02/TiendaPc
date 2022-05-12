package com.example.TiendaPc.app.Dto;

import com.example.TiendaPc.Entity.Pedidos;
import com.example.TiendaPc.Entity.Productos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
