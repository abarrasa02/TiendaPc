package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Pedido;
import com.example.TiendaPc.app.Repository.PedidoRepository;

import java.util.List;

public class PedidoServices {
    PedidoRepository pedidoRepository;

    public Pedido addProducto(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAllPedido() {
        List<Pedido> pedido = pedidoRepository.findAll();
        return pedido;
    }
    public Pedido findProductoById(Long id){
        return pedidoRepository.findProductoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteProducto(Pedido pedido){
        pedidoRepository.delete(pedido);
    }
    public Pedido updateProducto(Pedido pedido){
        if (pedidoRepository.findProductoById(pedido.getId()).isPresent() == true){
            return pedidoRepository.save(pedido);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
