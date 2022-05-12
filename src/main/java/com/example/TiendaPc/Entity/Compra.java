package com.example.TiendaPc.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Compra {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "usuariosid")
    private Usuarios usuariosid;

    @ManyToOne
    @JoinColumn(name = "productoid")
    private Productos productoId;

    private String fecha;

}
