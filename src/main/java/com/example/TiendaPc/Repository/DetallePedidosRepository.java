package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.DetallePedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetallePedidosRepository extends JpaRepository<DetallePedidos, Long> {
    void deletePedidosById(Long id);

    Optional<DetallePedidos> findPedidoById(Long id);
}
