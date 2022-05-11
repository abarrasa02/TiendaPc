package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    void deleteComprasById(Long id);
    Optional<Compra> findCompraById(Long id);

}
