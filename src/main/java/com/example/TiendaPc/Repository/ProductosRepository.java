package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, Long> {
    void deleteProductosById(Long id);
    Optional<ProductosEntity> findProductoById(Long id);
}
