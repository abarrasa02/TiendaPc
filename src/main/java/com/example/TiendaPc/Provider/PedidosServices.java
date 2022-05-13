package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.DetallePedidos;
import com.example.TiendaPc.Repository.PedidosRepository;
import com.example.TiendaPc.Entity.Pedidos;
import com.example.TiendaPc.Repository.UsuariosRepository;
import com.example.TiendaPc.app.Dto.dtoPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidosServices {

    private UsuariosRepository usuariosRepository;

    private PedidosRepository pedidosRepository;

    @Autowired
    private UsuariosServices usuariosServices;

    @Autowired
    public PedidosServices(PedidosRepository pedidosRepository,UsuariosRepository usuariosRepository) {
        this.pedidosRepository = pedidosRepository;
        this.usuariosRepository = usuariosRepository;
    }

    public Pedidos addCompra(dtoPedidos compra) {
        Pedidos pedidos = new Pedidos();
        pedidos.setUsuariosid(usuariosRepository.findUsuarioById(compra.getUsuarioId()).orElseThrow(null));
        pedidos.setFecha(compra.getFecha());
        return pedidosRepository.save(pedidos);
    }

    public List<dtoPedidos> findAllCompra() {
        List<Pedidos> compras = pedidosRepository.findAll();
        List<dtoPedidos> dtoPedidos = new ArrayList<>();

        for (int i = 0; i <compras.size(); i++) {
            dtoPedidos.add(new dtoPedidos());

            dtoPedidos.get(i).setId(compras.get(i).getId());
            dtoPedidos.get(i).setUsuarioId(compras.get(i).getUsuariosid().getId());
            dtoPedidos.get(i).setFecha(compras.get(i).getFecha());

        }
        return  dtoPedidos;
    }
    public Pedidos findCompraById(Long id){
        return pedidosRepository.findCompraById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteCompra(Long id){
        pedidosRepository.deleteComprasById(id);
    }
    public Pedidos updateCompra(dtoPedidos compra){
        Pedidos compra1 = findCompraById(compra.getId());
        if (compra1!= null) {
            compra1.setUsuariosid(usuariosServices.findUsuarioById(compra.getUsuarioId()));
            compra1.setFecha(compra.getFecha());
        }
        return pedidosRepository.save(compra1);
    }

}
