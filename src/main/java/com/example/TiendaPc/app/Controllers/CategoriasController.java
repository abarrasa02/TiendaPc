package com.example.TiendaPc.app.Controllers;

import com.example.TiendaPc.app.Entity.Categorias;
import com.example.TiendaPc.app.Provider.CategoriasService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoriasController {

    private final CategoriasService categoriasServices;


    @GetMapping("/all")
    public ResponseEntity<List<Categorias>> getAllCategoriass(){
        List<Categorias> categoriass = categoriasServices.findAllCategorias();
        return new ResponseEntity<>(categoriass, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Categorias> addCategorias(@RequestBody Categorias categorias){
        Categorias newCategorias = categoriasServices.addCategorias(categorias);
        return new ResponseEntity<>(newCategorias, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Categorias> updateCategorias(@RequestBody Categorias categorias){
        Categorias updateCategorias = categoriasServices.updateCategorias(categorias);
        return new ResponseEntity<>(updateCategorias, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Categorias> deleteCategorias(@PathVariable("id") Long id){
        categoriasServices.deleteCategorias(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
