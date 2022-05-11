package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Productos;
import com.example.TiendaPc.app.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    void deleteUsuariosById(Long id);
    Optional<Usuarios> findUsuarioById(Long id);
}
