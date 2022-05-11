package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Pedido;
import com.example.TiendaPc.app.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
