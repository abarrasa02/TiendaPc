package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.DetallePedidosEntity;
import com.example.TiendaPc.Repository.DetallePedidosRepository;
import com.example.TiendaPc.Repository.PedidosRepository;
import com.example.TiendaPc.Repository.ProductosRepository;
import com.example.TiendaPc.app.Dto.dtoDetallePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DetallePedidosProvider {


    @Autowired
    private PedidosProvider pedidosProvider;

    @Autowired
    private ProductosProvider productosProvider;

    private DetallePedidosRepository detallePedidosRepository;

    private PedidosRepository pedidosRepository;

    private ProductosRepository productosRepository;

    @Autowired
    public DetallePedidosProvider(DetallePedidosRepository detallePedidosRepository,
                                  PedidosRepository pedidosRepository,
                                  ProductosRepository productosRepository) {
        this.detallePedidosRepository = detallePedidosRepository;
        this.pedidosRepository = pedidosRepository;
        this.productosRepository = productosRepository;
    }

    public DetallePedidosEntity addPedido(dtoDetallePedidos pedidos) {
        DetallePedidosEntity detallePedidosEntity = new DetallePedidosEntity();
        detallePedidosEntity.setPedidoId(pedidosRepository.findCompraById(pedidos.getPedidoId()).orElseThrow(null));
        detallePedidosEntity.setProductosEntityId(productosRepository.findProductoById(pedidos.getProductosId()).orElseThrow(null));
        detallePedidosEntity.setId(pedidos.getId());
        detallePedidosEntity.setCantidad(pedidos.getCantidad());
        detallePedidosEntity.setPrecioUnidad(pedidos.getPrecioUnidad());
        return detallePedidosRepository.save(detallePedidosEntity);
    }

    public List<dtoDetallePedidos> findAllPedido() {
        List<DetallePedidosEntity> pedidos = detallePedidosRepository.findAll();
        List<dtoDetallePedidos> dtoDetallePedidos = new ArrayList<>();

        for (int i = 0; i <pedidos.size(); i++) {
            dtoDetallePedidos x=new dtoDetallePedidos();
            x.setId(pedidos.get(i).getId());
            x.setPedidoId(pedidos.get(i).getPedidoId().getId());
            x.setProductosId(pedidos.get(i).getProductosEntityId().getId());
            x.setCantidad(pedidos.get(i).getCantidad());
            x.setPrecioUnidad(pedidos.get(i).getPrecioUnidad());
            dtoDetallePedidos.add(x);
        }
        return  dtoDetallePedidos;
    }
    public DetallePedidosEntity findDetallePedidosById(Long id){
        DetallePedidosEntity detallePedidosEntity = detallePedidosRepository.findPedidoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
        return detallePedidosEntity;
    }
    public String deletePedido(Long id){
        try {
            detallePedidosRepository.deletePedidosById(id);
            return "Se ha borrado";
        }catch (Exception e){
            e.printStackTrace();
            return "Delete no funca";
        }
    }




    public DetallePedidosEntity updatePedido(dtoDetallePedidos pedido){
        DetallePedidosEntity detallePedidosEntity = new DetallePedidosEntity();
        if (detallePedidosRepository.findPedidoById(pedido.getId()) != null) {
            detallePedidosEntity.setPedidoId(pedidosProvider.findCompraById(pedido.getPedidoId()));
            detallePedidosEntity.setProductosEntityId(productosProvider.findProductoById(pedido.getProductosId()));
            detallePedidosEntity.setId(pedido.getId());
            detallePedidosEntity.setCantidad(pedido.getCantidad());
            detallePedidosEntity.setPrecioUnidad(pedido.getPrecioUnidad());
        }
          return detallePedidosRepository.save(detallePedidosEntity);

    }

}
