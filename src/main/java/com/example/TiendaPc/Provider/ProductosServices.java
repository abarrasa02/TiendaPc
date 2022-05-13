package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.Productos;
import com.example.TiendaPc.Repository.ProductosRepository;
import com.example.TiendaPc.app.Dto.dtoProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProductosServices {

    @Autowired
    private CategoriasService categoriasService;

    private ProductosRepository productosrepo;

    @Autowired
    public ProductosServices(ProductosRepository productosrepo) {
        this.productosrepo = productosrepo;
    }

    public Productos addProducto(dtoProductos productos) {
        Productos productos1 = new Productos();
        productos1.setCategoriasid(categoriasService.findCategoriaById(productos.getCategoriasid()));
        productos1.setPrecio(productos.getPrecio());
        productos1.setDescripcion(productos.getDescripcion());
        productos1.setId(productos.getId());
        productos1.setRebaja(productos.getRebaja());
        productos1.setNombre(productos.getNombre());
        return productosrepo.save(productos1);
    }

    public List<dtoProductos> findAllProductos() {
        List<Productos> productos = productosrepo.findAll();
        List<dtoProductos> dtoProductos = new ArrayList<>();

        for (int i = 0; i < productos.size(); i++) {
            dtoProductos x = new dtoProductos();
            dtoProductos.add(x);
            dtoProductos.get(i).setCategoriasid(productos.get(i).getCategoriasid().getId());
            dtoProductos.get(i).setId(productos.get(i).getId());
            dtoProductos.get(i).setDescripcion(productos.get(i).getDescripcion());
            dtoProductos.get(i).setNombre(productos.get(i).getNombre());
            dtoProductos.get(i).setPrecio(productos.get(i).getPrecio());
            dtoProductos.get(i).setRebaja(productos.get(i).getRebaja());
        }
        return dtoProductos;
    }
    public Productos findProductoById(Long id){
        return productosrepo.findProductoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteProducto(Long id){
        productosrepo.deleteProductosById(id);
    }
    public Productos updateProducto( dtoProductos productos){
        Productos productos1 = productosrepo.findProductoById(productos.getId()).orElseThrow(null);
        if (productos1 != null) {
            productos1.setCategoriasid(categoriasService.findCategoriaById(productos.getCategoriasid()));
            productos1.setPrecio(productos.getPrecio());
            productos1.setDescripcion(productos.getDescripcion());
            productos1.setId(productos.getId());
            productos1.setRebaja(productos.getRebaja());
            productos1.setNombre(productos.getNombre());
        }
        return productosrepo.save(productos1);
    }
}
