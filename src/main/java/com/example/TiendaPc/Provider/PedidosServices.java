package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Repository.PedidosRepository;
import com.example.TiendaPc.Entity.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PedidosServices {


    private PedidosRepository pedidosRepository;
    @Autowired
    public PedidosServices(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public Pedidos addCompra(Pedidos compra) {
        return pedidosRepository.save(compra);
    }

    public List<Pedidos> findAllCompra() {
        List<Pedidos> compra = pedidosRepository.findAll();
        return compra;
    }
    public Pedidos findCompraById(Long id){
        return pedidosRepository.findCompraById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteCompra(Long id){
        pedidosRepository.deleteComprasById(id);
    }
    public Pedidos updateCompra(Pedidos compra){
        if (pedidosRepository.findCompraById(compra.getId()).isPresent() == true){
            return pedidosRepository.save(compra);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
