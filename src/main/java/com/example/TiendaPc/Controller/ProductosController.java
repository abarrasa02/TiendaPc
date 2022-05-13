package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.Productos;
import com.example.TiendaPc.Provider.CategoriasService;
import com.example.TiendaPc.Provider.ProductosServices;
import com.example.TiendaPc.app.Dto.dtoProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosServices productosServices;

    @Autowired
    private CategoriasService categoriasService;


    @GetMapping("/all")
    public ResponseEntity<List<dtoProductos>> getAllProductos(){
        List<dtoProductos> dtoProductos = productosServices.findAllProductos();
        return new ResponseEntity<>(dtoProductos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Productos> addProductos(@RequestBody dtoProductos productos){
        Productos newProducto = productosServices.addProducto(productos);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Productos> updateProductos(@RequestBody dtoProductos productos){
        Productos updateProducto = productosServices.updateProducto(productos);
        return new ResponseEntity<>(updateProducto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Productos> deleteProductos(@PathVariable("id") Long id){
        productosServices.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
