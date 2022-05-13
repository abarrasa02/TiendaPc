package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.DetallePedidos;
import com.example.TiendaPc.Entity.Pedidos;
import com.example.TiendaPc.Provider.DetallePedidosServices;
import com.example.TiendaPc.Provider.PedidosServices;
import com.example.TiendaPc.Provider.ProductosServices;
import com.example.TiendaPc.app.Dto.dtoDetallePedidos;
import com.example.TiendaPc.app.Dto.dtoPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detallePedidos")
public class DetallePedidosController {

    @Autowired
    private DetallePedidosServices detallePedidosServices;

    @Autowired
    private PedidosServices pedidosServices;

    @Autowired
    private ProductosServices productosServices;


    @GetMapping("/all")
    public ResponseEntity<List<dtoDetallePedidos>> getAllPedidos(){
        List<dtoDetallePedidos> dtoDetallePedidos = detallePedidosServices.findAllPedido();
        return new ResponseEntity<>(dtoDetallePedidos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DetallePedidos> addPedido(@RequestBody dtoDetallePedidos pedidos){
        DetallePedidos newPedido = detallePedidosServices.addPedido(pedidos);
        return new ResponseEntity<>(newPedido, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DetallePedidos> updatePedido(@RequestBody dtoDetallePedidos pedidos){
        DetallePedidos detallePedidos = new DetallePedidos();
        DetallePedidos updatePedido = detallePedidosServices.updatePedido(pedidos);
        return new ResponseEntity<>(updatePedido, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DetallePedidos> deletePedidos(@PathVariable("id") Long id){
        detallePedidosServices.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
