package com.example.TiendaPc.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class dtoPedidos {
    private Long id;
    private Long usuarioId;
    private String fecha;

}
