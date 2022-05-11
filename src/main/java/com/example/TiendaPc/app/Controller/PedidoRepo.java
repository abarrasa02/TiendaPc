package com.example.TiendaPc.app.Controller;

import com.example.TiendaPc.app.Entity.Pedido;
import com.example.TiendaPc.app.Entity.Productos;
import com.example.TiendaPc.app.Provider.PedidoServices;
import com.example.TiendaPc.app.Provider.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class PedidoRepo {

    @Autowired
    private PedidoServices pedidoServices;

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> getAllPedidos(){
        List<Pedido> pedidos = pedidoServices.findAllPedido();
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") Long id){
        Pedido pedidos = pedidoServices.findProductoById(id);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedidos){
        Pedido newPedido = pedidoServices.addPedido(pedidos);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido){
        Productos updatePedido = pedidoServices.updatePedido(pedido);
        return new ResponseEntity<>(updatePedido, HttpStatus.OK);
    }
}
