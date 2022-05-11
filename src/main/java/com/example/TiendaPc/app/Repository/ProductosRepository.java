package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
    Optional<Productos> findProductoById(Long id);
}
