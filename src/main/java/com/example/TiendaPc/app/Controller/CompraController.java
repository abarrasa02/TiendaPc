package com.example.TiendaPc.app.Controller;

import com.example.TiendaPc.app.Entity.Compra;
import com.example.TiendaPc.app.Provider.CompraServices;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")

public class CompraController {

    @Autowired
    private CompraServices compraServices;



    @GetMapping("/all")
    public ResponseEntity<List<Compra>> getAllCompras(){
        List<Compra> Compras = compraServices.findAllCompra();
        return new ResponseEntity<>(Compras, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Compra> addCompra(@RequestBody Compra Compra){
        Compra newCompra = compraServices.addCompra(Compra);
        return new ResponseEntity<>(newCompra, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Compra> updateCompra(@RequestBody Compra Compra){
        Compra updateCompra = compraServices.updateCompra(Compra);
        return new ResponseEntity<>(updateCompra, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Compra> deleteCompra(@PathVariable("id") Long id){
        compraServices.deleteCompra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
