package com.example.TiendaPc.Provider;

import com.example.TiendaPc.Entity.UsuariosEntity;
import com.example.TiendaPc.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UsuariosProvider {


    private UsuariosRepository usuariosrepo;

    @Autowired
    public UsuariosProvider(UsuariosRepository usuariosrepo) {
        this.usuariosrepo = usuariosrepo;
    }


    public UsuariosEntity addUsuarios(UsuariosEntity usuariosEntity){
        return usuariosrepo.save(usuariosEntity);
    }

    public List<UsuariosEntity> findAllUsuarios(){
        List<UsuariosEntity> usuarios = usuariosrepo.findAll();
        return usuarios;
    }

    public UsuariosEntity findUsuarioById(Long id){
        UsuariosEntity usuariosEntity = usuariosrepo.findUsuarioById(id).orElseThrow(() -> new IllegalArgumentException("No funca"));
        return usuariosEntity;
    }

    public void deleteUsuario(Long id){
            usuariosrepo.deleteUsuariosById(id);

    }
    public UsuariosEntity updateUsuario(UsuariosEntity usuariosEntity){
        if (usuariosrepo.findUsuarioById(usuariosEntity.getId()).isPresent()){
            return usuariosrepo.save(usuariosEntity);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }
}
