package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.DetallePedidos;
import com.example.TiendaPc.Repository.DetallePedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DetallePedidosServices {

    private DetallePedidosRepository detallePedidosRepository;
    @Autowired
    public DetallePedidosServices(DetallePedidosRepository detallePedidosRepository) {
        this.detallePedidosRepository = detallePedidosRepository;
    }

    public DetallePedidos addPedido(DetallePedidos pedido) {
        return detallePedidosRepository.save(pedido);
    }

    public List<DetallePedidos> findAllPedido() {
        List<DetallePedidos> pedido = detallePedidosRepository.findAll();
        return pedido;
    }
    public void deletePedido(Long id){
        detallePedidosRepository.deletePedidosById(id);
    }
    public DetallePedidos updatePedido(DetallePedidos pedido){
        if (detallePedidosRepository.findPedidoById(pedido.getId()).isPresent()){
            return detallePedidosRepository.save(pedido);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

}
