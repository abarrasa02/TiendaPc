package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.Productos;
import com.example.TiendaPc.Provider.CategoriasService;
import com.example.TiendaPc.Provider.ProductosServices;
import com.example.TiendaPc.app.Dto.dtoProductos;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static javax.script.ScriptEngine.FILENAME;

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
    private static final String FILENAME = "productos.xls";
    @GetMapping(value="/export", produces= MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> descargaExcel(HttpServletResponse response) throws Exception {
        List<dtoProductos> list = productosServices.findAllProductos();

        ByteArrayInputStream in = productosServices.exportAlldata(list);
        IOUtils.copy(in, response.getOutputStream());
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(FILENAME, "UTF-8"));
        response.flushBuffer();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
