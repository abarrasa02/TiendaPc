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
        List<Productos> productos = productosServices.findAllProductos();
        List<dtoProductos> dtoProductos = new ArrayList<>();

        for (int i = 0; i < productos.size(); i++) {
            dtoProductos x = new dtoProductos();
            dtoProductos.add(x);
            dtoProductos.get(i).setCategoriasid(productos.get(i).getCategoriasid().getId());
            dtoProductos.get(i).setId(productos.get(i).getId());
            dtoProductos.get(i).setDescripcion(productos.get(i).getDescripcion());
            dtoProductos.get(i).setNombre(productos.get(i).getNombre());
            dtoProductos.get(i).setPrecio(productos.get(i).getPrecio());
             dtoProductos.get(i).setRebaja(productos.get(i).getRebaja());
        }

        return new ResponseEntity<>(dtoProductos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Productos> addProductos(@RequestBody dtoProductos productos){
        Productos productos1 = new Productos();

            Long id1 = productos.getCategoriasid();

            productos1.setCategoriasid(categoriasService.findCategoriaById(productos.getCategoriasid()));
            productos1.setPrecio(productos.getPrecio());
            productos1.setDescripcion(productos.getDescripcion());
            productos1.setId(productos.getId());
            productos1.setRebaja(productos.getRebaja());
            productos1.setNombre(productos.getNombre());

        Productos newProducto = productosServices.addProducto(productos1);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
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
