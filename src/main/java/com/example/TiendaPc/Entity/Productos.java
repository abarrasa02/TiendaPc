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

public class Productos {
    @Id
    @NotNull
    private Long id;

    private String nombre;

    private String descripcion;

    private int precio;

    private int rebaja;

    @ManyToOne
    @JoinColumn(name = "IDCATEGORIA")
    private Categorias categoriasid;

}
