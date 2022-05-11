package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Pedido;
import com.example.TiendaPc.app.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findProductoById(Long id);
}
