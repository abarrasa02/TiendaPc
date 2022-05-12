package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Provider.CompraServices;
import com.example.TiendaPc.Entity.Compra;
import com.example.TiendaPc.app.Dto.dtoCompra;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compra")

public class CompraController {

    private CompraServices compraServices;

    public CompraController(CompraServices compraServices) {
        this.compraServices = compraServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<dtoCompra>> getAllCompras(){
        List<Compra> compras = compraServices.findAllCompra();
        List<dtoCompra> dtoCompras = new ArrayList<>();

        for (int i = 0; i <compras.size(); i++) {
            dtoCompras.add(new dtoCompra());
            dtoCompras.get(i).setCantidad(compras.get(i).getCantidad());
            dtoCompras.get(i).setId(compras.get(i).getId());
            dtoCompras.get(i).setUsuarioId(compras.get(i).getUsuariosid().getId());
            dtoCompras.get(i).setProductoId(compras.get(i).getProductoId().getId());
            dtoCompras.get(i).setFecha(compras.get(i).getFecha());

        }
        return new ResponseEntity<>(dtoCompras, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Compra> addCompra(@RequestBody dtoCompra compra){
        Compra compra1 = new Compra();
       for (int i = 0; i < compraServices.findAllCompra().size(); i++){
           Long id1 = compra.getProductoId();
           Long id2 = compra.getUsuarioId();
           if (compraServices.findAllCompra().get(i).getProductoId().getId().equals(id1)){
               compra1.setProductoId(compraServices.findAllCompra().get(i).getProductoId());
           }else if (compraServices.findAllCompra().get(i).getUsuariosid().getId().equals(id1)){
               compra1.setUsuariosid(compraServices.findAllCompra().get(i).getUsuariosid());
           }
           compra1.setCantidad(compra.getCantidad());
           compra1.setFecha(compra.getFecha());
           compra1.setId(compra.getId());
       }
        Compra newCompra = compraServices.addCompra(compra1);
        return new ResponseEntity<>(newCompra, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Compra> updateCompra(@RequestBody Compra Compra){
        Compra updateCompra = compraServices.updateCompra(Compra);
        return new ResponseEntity<>(updateCompra, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Compra> deleteCompra(@PathVariable("id") Long id){
        compraServices.deleteCompra(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
