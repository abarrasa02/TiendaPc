package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    void deleteCategoriasById(Long id);
    Optional<Categorias> findCategoriasById(Long id);
}
