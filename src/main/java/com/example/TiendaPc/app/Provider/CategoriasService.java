package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Categorias;
import com.example.TiendaPc.app.Repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {


    private CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public Categorias addCategorias(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    public List<Categorias> findAllCategorias() {
        List<Categorias> categorias = categoriasRepository.findAll();
        return categorias;
    }
    public Categorias findCategoriasById(Long id){
        return categoriasRepository.findCategoriasById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteCategorias(Long id){
        categoriasRepository.deleteCategoriasById(id);
    }
    public Categorias updateCategorias(Categorias categorias){
        if (categoriasRepository.findCategoriasById(categorias.getId()).isPresent() == true){
            return categoriasRepository.save(categorias);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
