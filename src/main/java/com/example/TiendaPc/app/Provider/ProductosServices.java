package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Productos;
import com.example.TiendaPc.app.Entity.Usuarios;
import com.example.TiendaPc.app.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductosServices {
    @Autowired
    private ProductosRepository productosrepo;

    public Productos addProducto(Productos productos) {
        return productosrepo.save(productos);
    }

    public List<Productos> findAllProductos() {
        List<Productos> productos = productosrepo.findAll();
        return productos;
    }
    public Productos findProductoById(Long id){
        return productosrepo.findProductoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteProducto(Productos productos){
        productosrepo.delete(productos);
    }
    public Productos updateProducto(Productos productos){
        if (productosrepo.findProductoById(productos.getId()).isPresent() == true){
            return productosrepo.save(productos);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }
}
