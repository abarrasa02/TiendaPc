package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Compra;
import com.example.TiendaPc.app.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    Optional<Compra> findProductoById(Long id);
}
