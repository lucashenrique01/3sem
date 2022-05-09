package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ControllerEstudande {

    private String nome;
    private Integer n1;
    private Integer n2;

    @GetMapping("/cadastrar-estudante/{nome}")
    public String cadastrarEstudante(@PathVariable String nome){
        this.nome = nome;
        return String.format("Estudante %s cadastrado(a) com sucesso", nome);
    }

    @GetMapping("/cadastrar-notas/{n1}/{n2}")
    public String cadastrarNota(@PathVariable Integer n1, @PathVariable Integer n2){
        Boolean condicacao1 = n1 <= 10 && n1 >=0;
        Boolean condicao2 = n2 <= 10 && n2 >=0;
        if(condicacao1 && condicao2){
            this.n1 = n1;
            this.n2 = n2;
            return "Notas cadastradas com sucesso";
        }
        return "Ambas as notas devem estar entre 0 e 10";
    }

    @GetMapping("/resultado")
    public String resultado(){
        if(!Objects.isNull(this.nome) && !Objects.isNull(this.n1)){
            int media = (this.n1 + this.n2) / 2;
            if(media >= 6 ){
                return String.format("Estudante %s aprovado com a média %d", this.nome, media);
            }
            return String.format("Com a média %d infelizmente não há aprovação", media);
        }
        return String.format("Cadastre o nome e as notas antes");
    }
}
