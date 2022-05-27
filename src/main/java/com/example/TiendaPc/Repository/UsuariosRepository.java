package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long> {
    void deleteUsuariosById(Long id);

    Optional<UsuariosEntity> findUsuarioById(Long id);
}
