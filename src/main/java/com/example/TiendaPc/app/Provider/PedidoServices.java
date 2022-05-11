package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Pedido;
import com.example.TiendaPc.app.Repository.PedidoRepository;

import java.util.List;

public class PedidoServices {
    PedidoRepository pedidoRepository;

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
