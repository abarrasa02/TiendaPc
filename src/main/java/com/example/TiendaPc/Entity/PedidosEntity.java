package com.example.TiendaPc.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table ( name = "Pedidos")
@IdClass(ProductosID.class)
public class PedidosEntity implements Serializable {

    @Id
    @NotNull
    private Long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "productosid")
    private ProductosEntity productos;

    @ManyToOne
    @JoinColumn(name = "usuariosid")
    @NotNull
    private UsuariosEntity usuariosid;

    @NotNull
    private int cantidad;

    @NotNull
    private String fecha;

}
