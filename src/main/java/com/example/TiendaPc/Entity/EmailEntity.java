package com.example.TiendaPc.Entity;
import lombok.*;

import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor


public class EmailEntity {

    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String asunto;
    @Getter
    @Setter
    private String mensaje;

}