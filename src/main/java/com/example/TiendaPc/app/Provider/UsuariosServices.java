package com.example.TiendaPc.app.Provider;

import com.example.TiendaPc.app.Entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UsuariosServices {

    private UsuariosRepo usuariosrepo;

    @Autowired

    public UsuariosServices(UsuariosRepo usuariosRepo){
        this.usuariosRepo = usuariosRepo;
    }


    public Usuarios addUsuarios(Usuarios categoria){
        return categoriaRepo.save(categoria);
    }
}
