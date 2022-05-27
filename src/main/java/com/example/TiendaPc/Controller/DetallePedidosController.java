package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.DetallePedidosEntity;
import com.example.TiendaPc.Provider.DetallePedidosProvider;
import com.example.TiendaPc.app.Dto.dtoDetallePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detallePedidos")
public class DetallePedidosController {

    @Autowired
    private DetallePedidosProvider detallePedidosProvider;


    @GetMapping("/all")
    public ResponseEntity<List<dtoDetallePedidos>> getAllPedidos(){
        List<dtoDetallePedidos> dtoDetallePedidos = detallePedidosProvider.findAllPedido();
        return new ResponseEntity<>(dtoDetallePedidos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DetallePedidosEntity> addPedido(@RequestBody dtoDetallePedidos pedidos){
        DetallePedidosEntity newPedido = detallePedidosProvider.addPedido(pedidos);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DetallePedidosEntity> updatePedido(@RequestBody dtoDetallePedidos pedidos){
        DetallePedidosEntity detallePedidosEntity = new DetallePedidosEntity();
        DetallePedidosEntity updatePedido = detallePedidosProvider.updatePedido(pedidos);
        return new ResponseEntity<>(updatePedido, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DetallePedidosEntity> deletePedidos(@PathVariable("id") Long id){
        detallePedidosProvider.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
