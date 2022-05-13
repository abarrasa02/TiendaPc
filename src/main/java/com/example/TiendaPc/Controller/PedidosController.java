package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Provider.PedidosServices;
import com.example.TiendaPc.Entity.Pedidos;
import com.example.TiendaPc.Provider.ProductosServices;
import com.example.TiendaPc.Provider.UsuariosServices;
import com.example.TiendaPc.app.Dto.dtoPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedidos")

public class PedidosController {

    @Autowired
    private PedidosServices pedidosServices;

    @Autowired
    private ProductosServices productosServices;

    @Autowired
    private UsuariosServices usuariosServices;


    @GetMapping("/all")
    public ResponseEntity<List<dtoPedidos>> getAllCompras(){
        List<dtoPedidos> dtoPedidos = pedidosServices.findAllCompra();
        return new ResponseEntity<>(dtoPedidos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pedidos> addCompra(@RequestBody dtoPedidos compra){
        Pedidos newCompra = pedidosServices.addCompra(compra);
        return new ResponseEntity<>(newCompra, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pedidos> updateCompra(@RequestBody dtoPedidos compra){
          Pedidos updateCompra = pedidosServices.updateCompra(compra);
        return new ResponseEntity<>(updateCompra, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pedidos> deleteCompra(@PathVariable("id") Long id){
        pedidosServices.deleteCompra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
