package sptech.projetojpa01.controlle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.repositorio.SalgadinhoRepositorio;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salgadinhos")
public class SalgadinhoController {

    @Autowired
    private SalgadinhoRepositorio repositorio;

    @PostMapping
    public ResponseEntity postSalgadinho(@RequestBody Salgadinho novoSalgadinho){
        repositorio.save(novoSalgadinho);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getSalgadinho(){
        List<Salgadinho> salgadinhos = repositorio.findAll();
        if(salgadinhos.isEmpty()){
            return ResponseEntity.status(204).build();
        }else {
            return ResponseEntity.status(200).body(salgadinhos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getSalgadinhoById(@PathVariable int id){
        if(repositorio.existsById(id)){
            return ResponseEntity.status(200).body(repositorio.findById(id));
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSalgadinho(@PathVariable int id){
//        if(repositorio.existsById(id)){
//            repositorio.deleteById(id);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
        return ResponseEntity.of(repositorio.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSalgadinho(@PathVariable int id,
                                           @RequestBody Salgadinho novoSalgado){
        if(repositorio.existsById(id)){
            novoSalgado.setCodigo(id);
            repositorio.save(novoSalgado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
