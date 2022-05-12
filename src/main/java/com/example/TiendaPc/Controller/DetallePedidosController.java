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
    public ResponseEntity<List<DetallePedidos>> getAllPedidos(){
        List<DetallePedidos> pedidos = detallePedidosServices.findAllPedido();
        List<dtoDetallePedidos> dtoDetallePedidos = new ArrayList<>();
        for (int i = 0; i <pedidos.size(); i++) {
            dtoDetallePedidos.add(new dtoDetallePedidos());
            dtoDetallePedidos.get(i).setId(pedidos.get(i).getId());
            dtoDetallePedidos.get(i).setPedidoId(pedidos.get(i).getPedidoId().getId());
            dtoDetallePedidos.get(i).setProductosId(pedidos.get(i).getProductosId().getId());
            dtoDetallePedidos.get(i).setCantidad(pedidos.get(i).getCantidad());
            dtoDetallePedidos.get(i).setPrecioUnidad(pedidos.get(i).getPrecioUnidad());

        }
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DetallePedidos> addPedido(@RequestBody dtoDetallePedidos pedidos){
        DetallePedidos detallePedidos = new DetallePedidos();
        detallePedidos.setPedidoId(pedidosServices.findCompraById(pedidos.getPedidoId()));
        detallePedidos.setProductosId(productosServices.findProductoById(pedidos.getProductosId()));
        detallePedidos.setId(pedidos.getId());
        detallePedidos.setCantidad(pedidos.getCantidad());
        detallePedidos.setPrecioUnidad(pedidos.getPrecioUnidad());
        DetallePedidos newPedido = detallePedidosServices.addPedido(detallePedidos);
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
