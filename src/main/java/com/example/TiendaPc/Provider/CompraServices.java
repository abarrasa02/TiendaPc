package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Repository.CompraRepository;
import com.example.TiendaPc.Entity.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServices {


    private CompraRepository compraRepository;
    @Autowired
    public CompraServices(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

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
