package com.example.TiendaPc.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidosEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuariosid")
    @NotNull
    private UsuariosEntity usuariosid;

    @NotNull
    private String fecha;

}
