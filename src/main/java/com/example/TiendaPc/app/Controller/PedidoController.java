package com.example.TiendaPc.app.Controller;

import com.example.TiendaPc.app.Entity.Categorias;
import com.example.TiendaPc.app.Entity.Pedido;
import com.example.TiendaPc.app.Entity.Productos;
import com.example.TiendaPc.app.Provider.PedidoServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class PedidoController {

    private PedidoServices pedidoServices;

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> getAllPedidos(){
        List<Pedido> pedidos = pedidoServices.findAllPedido();
        return new ResponseEntity<List<Pedido>>(pedidos, HttpStatus.OK);
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
    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Categorias> deleteCategorias(@PathVariable("id") Long id){
        pedidoServices.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
