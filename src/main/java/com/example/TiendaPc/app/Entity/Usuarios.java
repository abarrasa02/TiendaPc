package com.example.TiendaPc.app.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuarios implements Serializable {


    @Id
    @NotNull
    private Long id;

    private String nombre;

    private String apellido;

    private String apellido2;

    private String email;





}
