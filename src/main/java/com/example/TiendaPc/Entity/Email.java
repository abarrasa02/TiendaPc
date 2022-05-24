package com.example.TiendaPc.Entity;
import lombok.*;
import java.io.File;


@AllArgsConstructor
@NoArgsConstructor

public class Email {

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