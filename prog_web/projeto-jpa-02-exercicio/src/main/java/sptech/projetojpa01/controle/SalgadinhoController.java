package sptech.projetojpa01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.repositorio.SalgadinhoRepository;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;

import java.util.List;

@RestController
@RequestMapping("/salgadinhos")
public class SalgadinhoController {

    @Autowired
    private SalgadinhoRepository repository;

    @PostMapping
    public ResponseEntity postSalgadinho(
            @RequestBody Salgadinho novoSalgadinho) {
        repository.save(novoSalgadinho);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getSalgadinhos() {

        new SalgadinhoSimplesResposta(1, "cheetos");

        List<Salgadinho> lista = repository.findAll();

        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/simples")
    public ResponseEntity getSimples() {
        List<SalgadinhoSimplesResposta> lista =
                repository.listaSimples();

        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/contagem")
    public ResponseEntity getContagem() {
// .count() faz um "select count(*)" p/ saber quantos registros tem na tabela
        long contagem = repository.count();
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/apimentados")
    public ResponseEntity getApimentados(){
        List<Salgadinho> lista = repository.findByApimentadoTrue();
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/contagem-nao-apimenetados")
    public ResponseEntity countNaoApimentados(){
        int contagem = repository.countByApimentado(false);
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/pouco-sal")
    public ResponseEntity getPoucoSal(){
        List<Salgadinho> lista = repository.findByNivelSalLessThan(4);
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/caros")
    public ResponseEntity getCaros(){
        List<Salgadinho> lista = repository.findByPrecoGreaterThanEqual(20.0);
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/relatorio-geral")
    public ResponseEntity getRelatorioGeral(){
        String relatorioGeral = "";
        List<Salgadinho> lista = repository.findAll();
        for(var salgadinho : lista) {
            relatorioGeral += salgadinho.getCodigo()+";"+salgadinho.getNome()+";"+salgadinho.getNivelSal()+";"+salgadinho.getApimentado()+"\r\n";
        }


        return ResponseEntity.status(200)
                .header("content-type", "aplication/csv")
                .header("content-disposition", "filename=\"salgadinhos.csv\"")
                .body(relatorioGeral);
    }

    @GetMapping("/filtro-preco/{preco1}/{preco2}")
    public ResponseEntity getFiltroPreco(@PathVariable Double preco1, @PathVariable Double preco2){
        List<Salgadinho> lista = repository.findByPrecoBetween(preco1, preco2);
        return ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/filtro-nome/{nome}")
    public ResponseEntity getFiltroNome(@PathVariable String nome){
        List<Salgadinho> lista = repository.findByNomeContains(nome);
        return ResponseEntity.status(200).body(lista);
    }
}
