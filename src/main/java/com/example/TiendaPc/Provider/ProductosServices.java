package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.Productos;
import com.example.TiendaPc.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductosServices {

    private ProductosRepository productosrepo;
    @Autowired
    public ProductosServices(ProductosRepository productosrepo) {
        this.productosrepo = productosrepo;
    }

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
    public void deleteProducto(Long id){
        productosrepo.deleteProductosById(id);
    }
    public Productos updateProducto(Productos productos){
        if (productosrepo.findProductoById(productos.getId()).isPresent() == true){
            return productosrepo.save(productos);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }
}
