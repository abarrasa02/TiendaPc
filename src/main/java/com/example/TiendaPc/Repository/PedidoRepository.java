package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    void deletePedidosById(Long id);

    Optional<Pedido> findPedidoById(Long id);
}
