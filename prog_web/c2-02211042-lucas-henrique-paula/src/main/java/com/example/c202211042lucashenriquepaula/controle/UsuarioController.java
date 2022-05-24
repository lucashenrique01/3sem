package com.example.c202211042lucashenriquepaula.controle;

import com.example.c202211042lucashenriquepaula.entidade.Usuario;
import com.example.c202211042lucashenriquepaula.repositorio.UsuarioRepository;
import com.example.c202211042lucashenriquepaula.requisicao.UsuarioAutenticadoRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity addUsuario(@RequestBody @Valid Usuario novoUsuario){
        repository.save(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/autenticacao")
    public ResponseEntity autenticaUsuario(@RequestBody @Valid UsuarioAutenticadoRequisicao usuarioAutenciado){
        String loginInformado = usuarioAutenciado.getLogin();
        String senhaInformada = usuarioAutenciado.getSenha();
        Usuario usuarioAutenticado = repository.findByLoginAndSenha(loginInformado, senhaInformada);
        if(Objects.isNull(usuarioAutenticado)){
            return ResponseEntity.status(404).build();
        }
        usuarioAutenticado.setAutenticado(true);
        repository.save(usuarioAutenticado);
        return ResponseEntity.status(200).body(usuarioAutenticado);
    }

    @GetMapping
    public ResponseEntity getUsuario(){
        List<Usuario> listaUsuarios = repository.findAll();
        if(listaUsuarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaUsuarios);
    }

    @DeleteMapping("/autenticacao/{login}")
    public ResponseEntity logoffUsuario(@PathVariable String login){
        Usuario usuarioLogoff = repository.findByLoginAndAutenticadoTrue(login);
        if(!Objects.isNull(usuarioLogoff)){
            usuarioLogoff.setAutenticado(false);
            repository.save(usuarioLogoff);
            return ResponseEntity.status(200).build();
        }else if(repository.existsByLogin(login)){
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.status(404).build();
    }

    //Retorna uma lista de todos os usuários autenticados.
    @GetMapping("/autenticados")
    public ResponseEntity usuariosAutenticados(){
        List<Usuario> listaUsuariosAutenticados = repository.findAllByAutenticadoTrue();
        if(listaUsuariosAutenticados.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaUsuariosAutenticados);
    }




}
