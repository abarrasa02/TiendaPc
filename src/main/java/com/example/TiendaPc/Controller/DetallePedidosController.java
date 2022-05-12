package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.DetallePedidos;
import com.example.TiendaPc.Provider.DetallePedidosServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class DetallePedidosController {

    private DetallePedidosServices detallePedidosServices;

    public DetallePedidosController(DetallePedidosServices detallePedidosServices) {
        this.detallePedidosServices = detallePedidosServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetallePedidos>> getAllPedidos(){
        List<DetallePedidos> pedidos = detallePedidosServices.findAllPedido();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DetallePedidos> addPedido(@RequestBody DetallePedidos pedidos){
        DetallePedidos newPedido = detallePedidosServices.addPedido(pedidos);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<DetallePedidos> updatePedido(@RequestBody DetallePedidos pedido){
        DetallePedidos updatePedido = detallePedidosServices.updatePedido(pedido);
        return new ResponseEntity<>(updatePedido, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DetallePedidos> deletePedidos(@PathVariable("id") Long id){
        detallePedidosServices.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
