package com.example.TiendaPc.Controller;

import com.example.TiendaPc.Entity.UsuariosEntity;
import com.example.TiendaPc.Provider.UsuariosProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuariosProvider usuariosProvider;

    public UsuariosController(UsuariosProvider usuariosProvider) {
        this.usuariosProvider = usuariosProvider;
    }


    @GetMapping("/all")
    public ResponseEntity<List<UsuariosEntity>> getAllUsuarios(){
        List<UsuariosEntity> usuarios = usuariosProvider.findAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosEntity> getCategoriasById(@PathVariable("id") Long id){
        UsuariosEntity categoria = usuariosProvider.findUsuarioById(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UsuariosEntity> addUsuarios(@RequestBody UsuariosEntity usuariosEntity){
        UsuariosEntity newUsuariosEntity = usuariosProvider.addUsuarios(usuariosEntity);
        return new ResponseEntity<>(newUsuariosEntity, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UsuariosEntity> updateUsuarios(@RequestBody UsuariosEntity usuariosEntity){
        UsuariosEntity updateUsuariosEntity = usuariosProvider.updateUsuario(usuariosEntity);
        return new ResponseEntity<>(updateUsuariosEntity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UsuariosEntity> deleteCategorias(@PathVariable("id") Long id){
        
        usuariosProvider.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
