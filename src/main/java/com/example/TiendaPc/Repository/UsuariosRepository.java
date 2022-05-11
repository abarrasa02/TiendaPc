package com.example.TiendaPc.Repository;

<<<<<<< HEAD:src/main/java/com/example/TiendaPc/app/Repository/UsuariosRepository.java

import com.example.TiendaPc.app.Entity.Usuarios;
=======
import com.example.TiendaPc.Entity.Usuarios;
>>>>>>> c04392c73cedddd5689ff9bd2a7ffd1bd5a475b9:src/main/java/com/example/TiendaPc/Repository/UsuariosRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    void deleteUsuariosById(Long id);

    Optional<Usuarios> findUsuarioById(Long id);
}
