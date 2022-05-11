package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.Categorias;
import com.example.TiendaPc.Entity.Pedido;
import com.example.TiendaPc.Provider.PedidoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoServices pedidoServices;

    public PedidoController(PedidoServices pedidoServices) {
        this.pedidoServices = pedidoServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> getAllPedidos(){
        List<Pedido> pedidos = pedidoServices.findAllPedido();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Pedido> addPedido(@RequestBody Pedido pedidos){
        Pedido newPedido = pedidoServices.addPedido(pedidos);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido){
        Pedido updatePedido = pedidoServices.updatePedido(pedido);
        return new ResponseEntity<>(updatePedido, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pedido> deletePedidos(@PathVariable("id") Long id){
        pedidoServices.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
