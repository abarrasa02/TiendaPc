package com.example.TiendaPc.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class dtoCompra {
    private Long id;
    private int cantidad;
    private Long usuarioId;
    private Long productoId;
    private String fecha;

}
