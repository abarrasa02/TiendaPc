package com.example.TiendaPc.app.Controller;

import com.example.TiendaPc.app.Entity.Productos;
import com.example.TiendaPc.app.Provider.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosRepo {
    @Autowired
    private ProductosServices productosServices;

    @GetMapping("/all")
    public ResponseEntity<List<Productos>> getAllProductos(){
        List<Productos> productos = productosServices.findAllProductos();
        return new ResponseEntity<List<Productos>>(productos, HttpStatus.OK);
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<Productos> getProductosById(@PathVariable("id") Long id){
        Productos productos = productosServices.findProductoById(id);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Productos> addProductos(@RequestBody Productos productos){
        Productos newProductos = productosServices.addProducto(productos);
        return new ResponseEntity<>(newProductos, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Productos> updateProductos(@RequestBody Productos productos){
        Productos updateProducto = productosServices.updateProducto(productos);
        return new ResponseEntity<>(updateProducto, HttpStatus.OK);
    }


}
