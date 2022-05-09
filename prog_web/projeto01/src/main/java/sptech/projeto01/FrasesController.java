package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
public class FrasesController {

    @GetMapping("/cumprimentar")
    public String cumprimentar() {
        return "olha eu na REST API!";
    }

    @GetMapping("/boa-noite")
    public String boaNoite(){
        Integer numero = ThreadLocalRandom.current().nextInt(0, 10);

        return "boa noite seu numero é : "+ numero;
    }

    @GetMapping("/{numero1}/{numero2}")
    public String somar(@PathVariable int numero1, @PathVariable int numero2){
        int soma = numero1 + numero2;
        return String.format("Resultado: %d", soma);
    }

    @GetMapping("/saudacao/{nome}")
    public String saudar(@PathVariable String nome){
        return String.format("Bem vindo %s", nome);
    }

    int numero = 0;


    @GetMapping("/contar")
    public String contar(){
        return String.format("Contando: %d", numero++);
    }

    // Singleton

}
