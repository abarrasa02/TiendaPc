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
        List<Pedidos> compras = pedidosServices.findAllCompra();
        List<dtoPedidos> dtoPedidos = new ArrayList<>();

        for (int i = 0; i <compras.size(); i++) {
            dtoPedidos.add(new dtoPedidos());

            dtoPedidos.get(i).setId(compras.get(i).getId());
            dtoPedidos.get(i).setUsuarioId(compras.get(i).getUsuariosid().getId());
            dtoPedidos.get(i).setFecha(compras.get(i).getFecha());

        }
        return new ResponseEntity<>(dtoPedidos, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pedidos> addCompra(@RequestBody dtoPedidos compra){
        Pedidos compra1 = new Pedidos();
           compra1.setUsuariosid(usuariosServices.findUsuarioById(compra.getUsuarioId()));
           compra1.setFecha(compra.getFecha());
           compra1.setId(compra.getId());
        Pedidos newCompra = pedidosServices.addCompra(compra1);
        return new ResponseEntity<>(newCompra, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pedidos> updateCompra(@RequestBody dtoPedidos compra){
        Pedidos compra1 = new Pedidos();
        Pedidos updateCompra = new Pedidos();
        if (pedidosServices.findCompraById(compra.getId()) != null) {
            compra1.setId(compra.getId());
            compra1.setUsuariosid(usuariosServices.findUsuarioById(compra.getUsuarioId()));
            compra1.setFecha(compra.getFecha());
            updateCompra = pedidosServices.updateCompra(compra1);
        }
        return new ResponseEntity<>(updateCompra, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Pedidos> deleteCompra(@PathVariable("id") Long id){
        pedidosServices.deleteCompra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
