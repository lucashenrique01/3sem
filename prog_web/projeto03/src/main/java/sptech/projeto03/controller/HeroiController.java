package sptech.projeto03.controller;

import org.springframework.web.bind.annotation.*;
import sptech.projeto03.model.Heroi;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> herois = new ArrayList<>();

    @GetMapping
    public List<Heroi> getHerois() {
        return herois;
    }

    @PostMapping
    public String postHeroi(@RequestBody Heroi novoHeroi){
        if(!herois.isEmpty()){
            for(Heroi h : herois){
                if(!novoHeroi.getNome().equalsIgnoreCase(h.getNome())){
                    this.herois.add(novoHeroi);
                    return "Herói cadadstrado com sucesso";
                }
            }
        }else {
            this.herois.add(novoHeroi);
            return "Herói cadadstrado com sucesso";
        }
        return "Erro ao cadastrar";
    }

    @GetMapping("/{indice}")
    public Heroi getHeroi(@PathVariable Integer indice) {
        if(existeIndice(indice)){
            return herois.get(indice);
        }
        return null;
    }

    @PutMapping("/{indice}")
    public String putHeroi(@RequestBody Heroi heroiAtualizado, @PathVariable int indice){
        if(existeIndice(indice)){
            this.herois.set(indice, heroiAtualizado);
            return "Herói atualizado com sucesso";
        }

        return "Herói não encontrado";
    }

    @DeleteMapping("/{indice}")
    public String deleteHeroi(@PathVariable int indice){
        if(existeIndice(indice)){
            this.herois.remove(indice);
            return "Herói removido com sucesso";
        }
        return "Herói não encontrado";

    }

    public Boolean existeIndice(int indice){
        if(indice <= this.herois.size() && this.herois.size() > 0){
            return true;
        }
        return false;
    }
}