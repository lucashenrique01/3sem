package com.example.c202211042lucashenriquepaula.repositorio;

import com.example.c202211042lucashenriquepaula.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Usuario findByLoginAndSenha(String login, String senha);
    Usuario findByLoginAndAutenticadoTrue(String login);
    Boolean existsByLogin(String login);
    List<Usuario> findAllByAutenticadoTrue();
}
