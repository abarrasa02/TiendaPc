package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.ProductosEntity;
import com.example.TiendaPc.Repository.ProductosRepository;
import com.example.TiendaPc.app.Dto.dtoProductos;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProductosProvider {

    @Autowired
    private CategoriasProvider categoriasProvider;

    private ProductosRepository productosrepo;

    @Autowired
    public ProductosProvider(ProductosRepository productosrepo) {
        this.productosrepo = productosrepo;
    }

    public ProductosEntity addProducto(dtoProductos productos) {
        ProductosEntity productosEntity1 = new ProductosEntity();
        productosEntity1.setCategoriasEntityId(categoriasProvider.findCategoriaById(productos.getCategoriasId()));
        productosEntity1.setPrecio(productos.getPrecio());
        productosEntity1.setDescripcion(productos.getDescripcion());
        productosEntity1.setRebaja(productos.getRebaja());
        productosEntity1.setNombre(productos.getNombre());


        return productosrepo.save(productosEntity1);
    }

    public List<dtoProductos> findAllProductos() {
        List<ProductosEntity> productos = productosrepo.findAll();
        List<dtoProductos> dtoProductos = new ArrayList<>();

        for(ProductosEntity prod: productos) {
            dtoProductos x = new dtoProductos();

            x.setPrecio(prod.getPrecio());
        }

        for (int i = 0; i < productos.size(); i++) {
            dtoProductos x = new dtoProductos();


            x.setCategoriasId(productos.get(i).getCategoriasEntityId().getId());
            x.setId(productos.get(i).getId());
            x.setDescripcion(productos.get(i).getDescripcion());
            x.setNombre(productos.get(i).getNombre());
            x.setPrecio(productos.get(i).getPrecio());
            x.setRebaja(productos.get(i).getRebaja());
            dtoProductos.add(x);
        }
        return dtoProductos;
    }
    public ProductosEntity findProductoById(Long id){
        return productosrepo.findProductoById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }
    public void deleteProducto(Long id){
      productosrepo.deleteProductosById(id);
    }
    public ProductosEntity updateProducto(dtoProductos productos){
        ProductosEntity productosEntity1 = productosrepo.findProductoById(productos.getId()).orElseThrow(null);
        if (productosEntity1 != null) {
            productosEntity1.setCategoriasEntityId(categoriasProvider.findCategoriaById(productos.getCategoriasId()));
            productosEntity1.setPrecio(productos.getPrecio());
            productosEntity1.setDescripcion(productos.getDescripcion());
            productosEntity1.setId(productos.getId());
            productosEntity1.setRebaja(productos.getRebaja());
            productosEntity1.setNombre(productos.getNombre());
        }
        return productosrepo.save(productosEntity1);
    }
    public ByteArrayInputStream exportAlldata(List<dtoProductos>productos) throws Exception {
        String[] columns ={"Nombre","Descripcion","Precio","Rebaja"};
        Workbook workbook=new HSSFWorkbook();

        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        Sheet sheet=workbook.createSheet("Productos");
        Row row=sheet.createRow(0);
        CellStyle headercellstyle = workbook.createCellStyle();
        headercellstyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        headercellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        for (int i=0;i<columns.length;i++){
            Cell cell =row.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int initRow=1;
        for (dtoProductos    productos1: productos){
            row=sheet.createRow(initRow);
            row.createCell(0).setCellValue(productos1.getNombre());
            row.createCell(1).setCellValue(productos1.getDescripcion());
            row.createCell(2).setCellValue(productos1.getPrecio());
            row.createCell(3).setCellValue(productos1.getRebaja());
            initRow++;
        }

        workbook.write(stream);


        return new ByteArrayInputStream(stream.toByteArray());
    }
}
