package com.example.TiendaPc.app.Dto;

import com.example.TiendaPc.Entity.ProductosID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class dtoPedidos {
    private Long id;
    private Long productoId;
    private Long usuarioId;
    private String fecha;
    private int cantidad;

}
