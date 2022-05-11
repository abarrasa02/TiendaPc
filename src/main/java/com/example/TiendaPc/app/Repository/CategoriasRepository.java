package com.example.TiendaPc.app.Repository;

import com.example.TiendaPc.app.Entity.Categorias;
import com.example.TiendaPc.app.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
