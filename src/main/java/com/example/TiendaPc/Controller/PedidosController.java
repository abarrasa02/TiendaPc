package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.ProductosID;
import com.example.TiendaPc.Provider.PedidosProvider;
import com.example.TiendaPc.Entity.PedidosEntity;
import com.example.TiendaPc.Provider.ProductosProvider;
import com.example.TiendaPc.Provider.UsuariosProvider;
import com.example.TiendaPc.app.Dto.dtoPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")

public class PedidosController {

    @Autowired
    private PedidosProvider pedidosProvider;

    @Autowired
    private ProductosProvider productosProvider;

    @Autowired
    private UsuariosProvider usuariosProvider;


    @GetMapping("/all")
    public ResponseEntity<List<dtoPedidos>> getAllCompras(){
        List<dtoPedidos> dtoPedidos = pedidosProvider.findAllCompra();
        return new ResponseEntity<>(dtoPedidos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PedidosEntity> addCompra(@RequestBody dtoPedidos compra){
        PedidosEntity newCompra = pedidosProvider.addCompra(compra);
        return new ResponseEntity<>(newCompra, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PedidosEntity> updateCompra(@RequestBody dtoPedidos compra){
          PedidosEntity updateCompra = pedidosProvider.updateCompra(compra);
        return new ResponseEntity<>(updateCompra, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PedidosEntity> deleteCompra(@PathVariable("id") Long id){
        pedidosProvider.deleteCompra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
