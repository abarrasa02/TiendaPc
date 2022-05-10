package com.example.TiendaPc.app.Entity;

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
    private Pedido pedidoId;
    @ManyToMany
    private Productos productoId;
    

}
