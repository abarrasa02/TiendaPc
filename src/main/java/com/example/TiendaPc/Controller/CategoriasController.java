package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Provider.CategoriasProvider;
import com.example.TiendaPc.Entity.CategoriasEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriasController {

    private CategoriasProvider categoriasServices;

    public CategoriasController(CategoriasProvider categoriasServices) {
        this.categoriasServices = categoriasServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<CategoriasEntity>> getAllCategoriass(){
        List<CategoriasEntity> categoriasses = categoriasServices.findAllCategorias();


        return new ResponseEntity<>(categoriasses, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CategoriasEntity> getCategoriasById(@PathVariable("id") Long id){
        CategoriasEntity categoria = categoriasServices.findCategoriaById(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoriasEntity> addCategorias(@RequestBody CategoriasEntity categoriasEntity){
        CategoriasEntity newCategoriasEntity = categoriasServices.addCategorias(categoriasEntity);
        return new ResponseEntity<>(newCategoriasEntity, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoriasEntity> updateCategorias(@RequestBody CategoriasEntity categoriasEntity){
        CategoriasEntity updateCategoriasEntity = categoriasServices.updateCategorias(categoriasEntity);
        return new ResponseEntity<>(updateCategoriasEntity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoriasEntity> deleteCategorias(@PathVariable("id") Long id){
        categoriasServices.deleteCategorias(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
