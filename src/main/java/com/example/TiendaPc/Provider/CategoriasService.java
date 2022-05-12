package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Repository.CategoriasRepository;
import com.example.TiendaPc.Entity.Categorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
