package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.Usuarios;
import com.example.TiendaPc.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UsuariosServices {


    private UsuariosRepository usuariosrepo;
    @Autowired
    public UsuariosServices(UsuariosRepository usuariosrepo) {
        this.usuariosrepo = usuariosrepo;
    }


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

    public void deleteUsuario(Long id){
        usuariosrepo.deleteUsuariosById(id);
    }
    public Usuarios updateUsuario(Usuarios usuarios){
        if (usuariosrepo.findUsuarioById(usuarios.getId()).isPresent()){
            return usuariosrepo.save(usuarios);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }
}
