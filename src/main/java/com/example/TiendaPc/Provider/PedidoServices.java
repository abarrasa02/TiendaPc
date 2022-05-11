package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.Pedido;
import com.example.TiendaPc.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServices {

    private PedidoRepository pedidoRepository;
    @Autowired
    public PedidoServices(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido addPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAllPedido() {
        List<Pedido> pedido = pedidoRepository.findAll();
        return pedido;
    }
    public void deletePedido(Long id){
        pedidoRepository.deletePedidosById(id);
    }
    public Pedido updatePedido(Pedido pedido){
        if (pedidoRepository.findPedidoById(pedido.getId()).isPresent()){
            return pedidoRepository.save(pedido);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
