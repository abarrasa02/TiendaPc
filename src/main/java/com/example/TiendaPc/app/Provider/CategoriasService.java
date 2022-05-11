package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Categorias;
import com.example.TiendaPc.app.Repository.CategoriasRepository;

import java.util.List;

public class CategoriasService {

    CategoriasRepository categoriasRepository;

    public Categorias addProducto(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    public List<Categorias> findAllCategorias() {
        List<Categorias> categorias = categoriasRepository.findAll();
        return categorias;
    }
    public Categorias findProductoById(Long id){
        return categoriasRepository.findProductoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteProducto(Categorias categorias){
        categoriasRepository.delete(categorias);
    }
    public Categorias updateProducto(Categorias categorias){
        if (categoriasRepository.findProductoById(categorias.getId()).isPresent() == true){
            return categoriasRepository.save(categorias);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
