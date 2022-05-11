package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Compra;
import com.example.TiendaPc.app.Repository.CompraRepository;

import java.util.List;

public class CompraServices {
    CompraRepository compraRepository;

    public Compra addProducto(Compra compra) {
        return compraRepository.save(compra);
    }

    public List<Compra> findAllCompra() {
        List<Compra> compra = compraRepository.findAll();
        return compra;
    }
    public Compra findProductoById(Long id){
        return compraRepository.findProductoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteProducto(Compra compra){
        compraRepository.delete(compra);
    }
    public Compra updateProducto(Compra compra){
        if (compraRepository.findProductoById(compra.getId()).isPresent() == true){
            return compraRepository.save(compra);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
