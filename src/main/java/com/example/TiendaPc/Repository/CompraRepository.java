package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    void deleteComprasById(Long id);
    Optional<Compra> findCompraById(Long id);

}
