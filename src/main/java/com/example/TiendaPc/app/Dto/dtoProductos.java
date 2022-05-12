package com.example.TiendaPc.app.Dto;

import com.example.TiendaPc.Entity.Categorias;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class dtoProductos {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int rebaja;
    private Long categoriasid;


}
