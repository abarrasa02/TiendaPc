package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Repository.CategoriasRepository;
import com.example.TiendaPc.Entity.CategoriasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoriasProvider {


    private CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasProvider(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public CategoriasEntity addCategorias(CategoriasEntity categoriasEntity) {
        return categoriasRepository.save(categoriasEntity);
    }

    public List<CategoriasEntity> findAllCategorias() {
        List<CategoriasEntity> categorias = categoriasRepository.findAll();
        return categorias;
    }

    public CategoriasEntity findCategoriaById(Long id){
        return categoriasRepository.findCategoriasById(id).orElseThrow(() -> new IllegalArgumentException("error"));
    }

    public String deleteCategorias(Long id){
        try {
            categoriasRepository.deleteCategoriasById(id);
            return "El producto se ha borrado";
        }catch (Exception e){
            e.printStackTrace();
            return "Delete no funca nano";
        }
    }

    public CategoriasEntity updateCategorias(CategoriasEntity categoriasEntity){
        if (categoriasRepository.findCategoriasById(categoriasEntity.getId()).isPresent()){
            return categoriasRepository.save(categoriasEntity);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
