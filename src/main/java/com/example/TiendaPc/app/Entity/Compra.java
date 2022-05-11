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
    @JoinColumn(name = "pedidoId")
    private Pedido pedidoId;
<<<<<<< HEAD
    @ManyToOne
    private Productos productoId;

=======

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Productos productoId;
>>>>>>> 8ba7c4ec312f02dcb1faa2cbf8ad6ea09514ee8c

}
