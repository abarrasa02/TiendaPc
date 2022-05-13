package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    void deleteComprasById(Long id);

    Optional<Pedidos> findCompraById(Long id);

}
