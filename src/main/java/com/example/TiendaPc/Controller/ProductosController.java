package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.Categorias;
import com.example.TiendaPc.Entity.Productos;
import com.example.TiendaPc.Provider.ProductosServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private ProductosServices productosServices;

    public ProductosController(ProductosServices productosServices) {
        this.productosServices = productosServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Productos>> getAllProductos(){
        List<Productos> productos = productosServices.findAllProductos();
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Productos> deleteProductos(@PathVariable("id") Long id){
        productosServices.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
