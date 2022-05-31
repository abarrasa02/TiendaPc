package com.example.TiendaPc.Entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table ( name = "Productos")
public class ProductosEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private double precio;

    private int rebaja;

    @ManyToOne
    @JoinColumn(name = "categoriasid")
    private CategoriasEntity categoriasEntityId;


}
