package com.example.TiendaPc.app.Controller;

import com.example.TiendaPc.app.Entity.Categorias;
import com.example.TiendaPc.app.Entity.Usuarios;
import com.example.TiendaPc.app.Provider.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosServices usuariosServices;


    @GetMapping("/all")
    public ResponseEntity<List<Usuarios>> getAllUsuarios(){
        List<Usuarios> usuarios = usuariosServices.findAllUsuarios();
        return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<Usuarios> getUsuariosById(@PathVariable("id") Long id){
        Usuarios usuarios = usuariosServices.findUsuarioById(id);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Usuarios> addUsuarios(@RequestBody Usuarios usuarios){
        Usuarios newUsuarios = usuariosServices.addUsuarios(usuarios);
        return new ResponseEntity<>(newUsuarios, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Usuarios> updateUsuarios(@RequestBody Usuarios usuarios){
        Usuarios updateUsuarios = usuariosServices.updateUsuario(usuarios);
        return new ResponseEntity<>(updateUsuarios, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Categorias> deleteCategorias(@PathVariable("id") Long id){
        usuariosServices.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
