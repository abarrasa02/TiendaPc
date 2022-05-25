package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.Productos;
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
        productos1.setCategoriasId(categoriasService.findCategoriaById(productos.getCategoriasId()));
        productos1.setPrecio(productos.getPrecio());
        productos1.setDescripcion(productos.getDescripcion());
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
            dtoProductos.get(i).setCategoriasId(productos.get(i).getCategoriasId().getId());
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
            productos1.setCategoriasId(categoriasService.findCategoriaById(productos.getCategoriasId()));
            productos1.setPrecio(productos.getPrecio());
            productos1.setDescripcion(productos.getDescripcion());
            productos1.setId(productos.getId());
            productos1.setRebaja(productos.getRebaja());
            productos1.setNombre(productos.getNombre());
        }
        return productosrepo.save(productos1);
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
