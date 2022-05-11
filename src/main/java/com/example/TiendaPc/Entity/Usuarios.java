package com.example.TiendaPc.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuarios implements Serializable {


    @Id
<<<<<<< HEAD:src/main/java/com/example/TiendaPc/app/Entity/Usuarios.java
    @NotNull
=======
    @Column(name = "id")
>>>>>>> c04392c73cedddd5689ff9bd2a7ffd1bd5a475b9:src/main/java/com/example/TiendaPc/Entity/Usuarios.java
    private Long id;

    private String nombre;

    private String apellido;

    private String apellido2;

    private String email;





}
