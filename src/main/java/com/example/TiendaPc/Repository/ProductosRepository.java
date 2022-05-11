package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
    void deleteProductosById(Long id);
    Optional<Productos> findProductoById(Long id);
}
