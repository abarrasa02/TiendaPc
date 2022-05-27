package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.DetallePedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidosEntity, Long> {
    void deletePedidosById(Long id);

    Optional<DetallePedidosEntity> findPedidoById(Long id);
}
