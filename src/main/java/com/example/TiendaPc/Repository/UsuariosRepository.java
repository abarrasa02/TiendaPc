package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    void deleteUsuariosById(Long id);

    Optional<Usuarios> findUsuarioById(Long id);
}
