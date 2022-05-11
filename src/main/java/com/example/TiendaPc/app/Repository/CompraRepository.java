package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Compra;
import com.example.TiendaPc.app.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
