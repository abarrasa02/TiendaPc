package com.example.TiendaPc.app.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Categorias  implements Serializable {
    @Id
    @NotNull
    private Long id;

    private String descripcion;



}
