package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.Categorias;
import com.example.TiendaPc.Entity.Usuarios;
import com.example.TiendaPc.Provider.UsuariosServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuariosServices usuariosServices;

    public UsuariosController(UsuariosServices usuariosServices) {
        this.usuariosServices = usuariosServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Usuarios>> getAllUsuarios(){
        List<Usuarios> usuarios = usuariosServices.findAllUsuarios();
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuarios> deleteCategorias(@PathVariable("id") Long id){
        usuariosServices.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
