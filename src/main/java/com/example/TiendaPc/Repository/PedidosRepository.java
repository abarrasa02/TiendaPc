package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.PedidosEntity;
import com.example.TiendaPc.Entity.ProductosID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosEntity, Long> {
    void deleteComprasById(Long id);

    Optional<PedidosEntity> findCompraById(Long id);

}
