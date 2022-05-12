package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Provider.CategoriasService;
import com.example.TiendaPc.Entity.Categorias;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriasController {

    private CategoriasService categoriasServices;

    public CategoriasController(CategoriasService categoriasServices) {
        this.categoriasServices = categoriasServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Categorias>> getAllCategoriass(){
        List<Categorias> categoriass = categoriasServices.findAllCategorias();


        return new ResponseEntity<>(categoriass, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Categorias> getCategoriasById(@PathVariable("id") Long id){
        Categorias categoria = categoriasServices.findCategoriaById(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Categorias> deleteCategorias(@PathVariable("id") Long id){
        categoriasServices.deleteCategorias(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
