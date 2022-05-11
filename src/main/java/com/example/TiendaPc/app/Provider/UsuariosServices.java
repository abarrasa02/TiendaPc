package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Usuarios;
import com.example.TiendaPc.app.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UsuariosServices {

    @Autowired
    private UsuariosRepository usuariosrepo;


    public Usuarios addUsuarios(Usuarios usuarios){
        return usuariosrepo.save(usuarios);
    }

    public List<Usuarios> findAllUsuarios(){
        List<Usuarios> usuarios = usuariosrepo.findAll();
        return usuarios;
    }
    public Usuarios findUsuarioById(Long id){
        return usuariosrepo.findUsuarioById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
    }

    public void deleteUsuario(Usuarios usuarios){
        usuariosrepo.delete(usuarios);
    }
    public Usuarios updateUsuario(Usuarios usuarios){
        if (usuariosrepo.findUsuarioById(usuarios.getId()).isPresent() == true){
            return usuariosrepo.save(usuarios);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }
}
