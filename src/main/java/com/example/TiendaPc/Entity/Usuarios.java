package com.example.TiendaPc.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuarios implements Serializable {


    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String apellido2;

    private String email;

    private String ciudad;

    private String Pais;

    private String lineadireccion1;





}
