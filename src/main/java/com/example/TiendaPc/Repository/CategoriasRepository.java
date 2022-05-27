package com.example.TiendaPc.Repository;

import com.example.TiendaPc.Entity.CategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<CategoriasEntity, Long> {

    void deleteCategoriasById(Long id);
    Optional<CategoriasEntity> findCategoriasById(Long id);
}
