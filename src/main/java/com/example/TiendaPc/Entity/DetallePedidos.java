package com.example.TiendaPc.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetallePedidos {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pedidos pedidoId;
    @ManyToOne
    @JoinColumn(name = "productosid")
    private Productos productosId;
    private int cantidad;
    private double precioUnidad;

}
