package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paises")
public class OlimpiadasController {

    List<Pais> paises = new ArrayList<>();

    @GetMapping
    public Pais teste(){
        Pais pais = new Pais("Brasil", 12, 14,8);
        Pais pais2 = new Pais();
        return pais;
    }

    @GetMapping("/listar")
    public List<Pais> listarPaises(){
        paises.add(new Pais("Brasil", 12, 15, 7));
        paises.add(new Pais("EUA", 26, 35, 13));
        paises.add(new Pais("Japão", 32, 39, 20));
        paises.add(new Pais("Canada", 27, 19, 9));
            return this.paises;
    }

    @GetMapping("/cadastrar/{nome}/{ouro}/{prata}/{bronze}")
    public String cadastrarPais(@PathVariable String nome,
                                @PathVariable int ouro,
                                @PathVariable int prata,
                                @PathVariable int bronze
    ){
        paises.add(new Pais(nome, ouro, prata, bronze));
        return "Pais cadastrado com sucesso";
    }


    @GetMapping("buscar/{indice}")
    public Pais buscarPorIndice(@PathVariable Integer indice) {
        return paises.get(indice);
    }



}
