package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadesController {

    @GetMapping("/listar")
    public String listar(){
        return "todas as cidades";
    }

    @GetMapping("/adicionar")
    public String adicionar(){
        return "Cidade adicionada";
    }

    @GetMapping("/excluir")
    public String excluir(){
        return "Cidade excluida";
    }

    @GetMapping("/listar1")
    public String listar1(){
        return "todas as cidades";
    }

    @GetMapping("/top-5")
    public String top5(){
        return "Maceio, São Paulo, Salvador, Rio de Janeiro, Belo Horizonte";
    }
    @GetMapping
    public String home(){
        return "Bem vindo a API de cidades";
    }
}
