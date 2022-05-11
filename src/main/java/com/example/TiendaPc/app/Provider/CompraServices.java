package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Compra;
import com.example.TiendaPc.app.Repository.CompraRepository;

import java.util.List;

public class CompraServices {
    CompraRepository compraRepository;

    public Compra addCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public List<Compra> findAllCompra() {
        List<Compra> compra = compraRepository.findAll();
        return compra;
    }
    public Compra findCompraById(Long id){
        return compraRepository.findCompraById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteCompra(Long id){
        compraRepository.deleteComprasById(id);
    }
    public Compra updateCompra(Compra compra){
        if (compraRepository.findCompraById(compra.getId()).isPresent() == true){
            return compraRepository.save(compra);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
