package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Repository.PedidosRepository;
import com.example.TiendaPc.Entity.PedidosEntity;
import com.example.TiendaPc.Repository.UsuariosRepository;
import com.example.TiendaPc.app.Dto.dtoPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PedidosProvider {

    private UsuariosRepository usuariosRepository;

    private PedidosRepository pedidosRepository;

    @Autowired
    private UsuariosProvider usuariosProvider;

    @Autowired
    public PedidosProvider(PedidosRepository pedidosRepository, UsuariosRepository usuariosRepository) {
        this.pedidosRepository = pedidosRepository;
        this.usuariosRepository = usuariosRepository;
    }

    public PedidosEntity addCompra(dtoPedidos compra) {
        PedidosEntity pedidosEntity = new PedidosEntity();
        pedidosEntity.setUsuariosid(usuariosRepository.findUsuarioById(compra.getUsuarioId()).orElseThrow(null));
        pedidosEntity.setFecha(compra.getFecha());
        return pedidosRepository.save(pedidosEntity);
    }

    public List<dtoPedidos> findAllCompra() {
        List<PedidosEntity> compras = pedidosRepository.findAll();
        List<dtoPedidos> dtoPedidos = new ArrayList<>();

        for (int i = 0; i <compras.size(); i++) {
            dtoPedidos x = new dtoPedidos();


           x.setId(compras.get(i).getId());
            x.setUsuarioId(compras.get(i).getUsuariosid().getId());
            x.setFecha(compras.get(i).getFecha());
            dtoPedidos.add(x);
        }
        return  dtoPedidos;
    }
    public PedidosEntity findCompraById(Long id){
        return pedidosRepository.findCompraById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public String deleteCompra(Long id){
        try {
            pedidosRepository.deleteComprasById(id);
            return "Se borro";
        }catch (Exception e){
            e.printStackTrace();
            return "Delete no funca";
        }
        }
    public PedidosEntity updateCompra(dtoPedidos compra){
        PedidosEntity compra1 = findCompraById(compra.getId());
        if (compra1!= null) {
            compra1.setUsuariosid(usuariosProvider.findUsuarioById(compra.getUsuarioId()));
            compra1.setFecha(compra.getFecha());
        }
        return pedidosRepository.save(compra1);
    }

}
