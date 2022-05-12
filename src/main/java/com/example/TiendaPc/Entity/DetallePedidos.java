package com.example.TiendaPc.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "DETALLEPEDIDOS")
public class DetallePedidos {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pedidoid")
    private Pedidos pedidoId;
    @ManyToOne
    @JoinColumn(name = "productoid")
    private Productos productosId;
    private int cantidad;
    @Column(name = "preciounidad")
    private double precioUnidad;

}
