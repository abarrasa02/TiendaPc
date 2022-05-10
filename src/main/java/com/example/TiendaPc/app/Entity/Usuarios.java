package com.example.TiendaPc.app.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuarios implements Serializable {

    @Getter
    @Setter
    @Id
    @NotNull
    private int Id;
}
