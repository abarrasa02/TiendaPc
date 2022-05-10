package com.example.TiendaPc.app.Entity;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private int categoriasid;

}
