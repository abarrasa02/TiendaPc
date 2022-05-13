package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.DetallePedidos;
import com.example.TiendaPc.Entity.Pedidos;
import com.example.TiendaPc.Repository.DetallePedidosRepository;
import com.example.TiendaPc.Repository.PedidosRepository;
import com.example.TiendaPc.Repository.ProductosRepository;
import com.example.TiendaPc.app.Dto.dtoDetallePedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DetallePedidosServices {


    @Autowired
    private PedidosServices pedidosServices;

    @Autowired
    private ProductosServices productosServices;

    private DetallePedidosRepository detallePedidosRepository;

    private PedidosRepository pedidosRepository;

    private ProductosRepository productosRepository;

    @Autowired
    public DetallePedidosServices(DetallePedidosRepository detallePedidosRepository,
                                  PedidosRepository pedidosRepository,
                                  ProductosRepository productosRepository) {
        this.detallePedidosRepository = detallePedidosRepository;
        this.pedidosRepository = pedidosRepository;
        this.productosRepository = productosRepository;
    }

    public DetallePedidos addPedido( dtoDetallePedidos pedidos) {
        DetallePedidos detallePedidos = new DetallePedidos();
        detallePedidos.setPedidoId(pedidosRepository.findCompraById(pedidos.getPedidoId()).orElseThrow(null));
        detallePedidos.setProductosId(productosRepository.findProductoById(pedidos.getProductosId()).orElseThrow(null));
        detallePedidos.setId(pedidos.getId());
        detallePedidos.setCantidad(pedidos.getCantidad());
        detallePedidos.setPrecioUnidad(pedidos.getPrecioUnidad());
        return detallePedidosRepository.save(detallePedidos);
    }

    public List<dtoDetallePedidos> findAllPedido() {
        List<DetallePedidos> pedidos = detallePedidosRepository.findAll();
        List<dtoDetallePedidos> dtoDetallePedidos = new ArrayList<>();
        for (int i = 0; i <pedidos.size(); i++) {
            dtoDetallePedidos.add(new dtoDetallePedidos());
            dtoDetallePedidos.get(i).setId(pedidos.get(i).getId());
            dtoDetallePedidos.get(i).setPedidoId(pedidos.get(i).getPedidoId().getId());
            dtoDetallePedidos.get(i).setProductosId(pedidos.get(i).getProductosId().getId());
            dtoDetallePedidos.get(i).setCantidad(pedidos.get(i).getCantidad());
            dtoDetallePedidos.get(i).setPrecioUnidad(pedidos.get(i).getPrecioUnidad());

        }
        return  dtoDetallePedidos;
    }
    public DetallePedidos findDetallePedidosById(Long id){
        DetallePedidos detallePedidos = detallePedidosRepository.findPedidoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
        return detallePedidos;
    }
    public void deletePedido(Long id){
        detallePedidosRepository.deletePedidosById(id);
    }




    public DetallePedidos updatePedido(dtoDetallePedidos pedido){
        DetallePedidos detallePedidos = new DetallePedidos();
        if (detallePedidosRepository.findPedidoById(pedido.getId()) != null) {
            detallePedidos.setPedidoId(pedidosServices.findCompraById(pedido.getPedidoId()));
            detallePedidos.setProductosId(productosServices.findProductoById(pedido.getProductosId()));
            detallePedidos.setId(pedido.getId());
            detallePedidos.setCantidad(pedido.getCantidad());
            detallePedidos.setPrecioUnidad(pedido.getPrecioUnidad());
        }
          return detallePedidosRepository.save(detallePedidos);

    }

}
