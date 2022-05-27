package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.ProductosEntity;
import com.example.TiendaPc.Provider.CategoriasProvider;
import com.example.TiendaPc.Provider.ProductosProvider;
import com.example.TiendaPc.app.Dto.dtoProductos;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosProvider productosProvider;

    @Autowired
    private CategoriasProvider categoriasProvider;


    @GetMapping("/all")
    public ResponseEntity<List<dtoProductos>> getAllProductos(){
        List<dtoProductos> dtoProductos = productosProvider.findAllProductos();
        return new ResponseEntity<>(dtoProductos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductosEntity> addProductos(@RequestBody dtoProductos productos){
        ProductosEntity newProducto = productosProvider.addProducto(productos);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<ProductosEntity> updateProductos(@RequestBody dtoProductos productos){
        ProductosEntity updateProducto = productosProvider.updateProducto(productos);
        return new ResponseEntity<>(updateProducto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductosEntity> deleteProductos(@PathVariable("id") Long id){
        productosProvider.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private static final String FILENAME = "productos.xls";
    @GetMapping(value="/export", produces= MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> descargaExcel(HttpServletResponse response) throws Exception {
        List<dtoProductos> list = productosProvider.findAllProductos();

        ByteArrayInputStream in = productosProvider.exportAlldata(list);
        IOUtils.copy(in, response.getOutputStream());
        response.setContentType("application/x-download");
        response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(FILENAME, "UTF-8"));
        response.flushBuffer();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
