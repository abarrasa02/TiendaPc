package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Repository.CompraRepository;
import com.example.TiendaPc.Entity.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompraServices {


    private CompraRepository compraRepository;
    @Autowired
    public CompraServices(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Pedidos addCompra(Pedidos compra) {
        return compraRepository.save(compra);
    }

    public List<Pedidos> findAllCompra() {
        List<Pedidos> compra = compraRepository.findAll();
        return compra;
    }
    public Pedidos findCompraById(Long id){
        return compraRepository.findCompraById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteCompra(Long id){
        compraRepository.deleteComprasById(id);
    }
    public Pedidos updateCompra(Pedidos compra){
        if (compraRepository.findCompraById(compra.getId()).isPresent() == true){
            return compraRepository.save(compra);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
