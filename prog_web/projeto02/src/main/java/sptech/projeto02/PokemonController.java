package sptech.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    List<Pokemon> pokemons = new ArrayList<>();

    @GetMapping("/cadastrar/{nome}/{tipo}/{forca}/{capturado}")
    public String cadastrar(@PathVariable String nome,
                            @PathVariable String tipo,
                            @PathVariable Double forca,
                            @PathVariable Boolean capturado){
        this.pokemons.add(new Pokemon(nome, tipo, forca, capturado));

        return String.format("Pokemon %s cadastrado com sucesso", nome);
    }

    @GetMapping("/remover/{indice}")
    public String remorer(@PathVariable int indice){

        if (indice <= this.pokemons.size() && this.pokemons.size() > 0){
            this.pokemons.remove(indice);
            return String.format("Pokemon %s removido com sucesso", this.pokemons.get(indice).getNome());
        }
        return  "Indice inexistente";
    }

    @GetMapping("/buscar/{indice}")
    public Pokemon pokemonPorIndice(@PathVariable int indice){
        if (indice <= this.pokemons.size() && this.pokemons.size() > 0){
            return this.pokemons.get(indice);
        }
        return null;
    }

     @GetMapping("/atualizar/{indice}/{nome}/{tipo}/{forca}/{capturado}")
     public String atualizarPokemon(@PathVariable int indice,
                                   @PathVariable String nome,
                                   @PathVariable String tipo,
                                   @PathVariable Double forca,
                                   @PathVariable Boolean capturado
     ){
        Pokemon pokemonAtual = this.pokemons.get(indice);
        pokemonAtual.setNome(nome);
        pokemonAtual.setTipo(tipo);
        pokemonAtual.setForca(forca);
        pokemonAtual.setCapturado(capturado);
        //this.pokemons.set(indice, new Pokemon(nome, tipo, forca, capturado)); solução do professor
        return String.format("Pokemon $s atualizado com sucesso", nome);
     }

    @GetMapping("/listar")
    public List<Pokemon> listarPokemons(){
        return this.pokemons;
     }

     @GetMapping("/{tipo}/contagem")
    public Integer contagemPokemon(@PathVariable String tipo){
        Integer contagem = 0;
        for(Pokemon p : pokemons){
            if(p.getTipo().equals(tipo)){
                ++contagem;
            }
        }

//       long contagem = this.pokemons.stream().filter(pokemon -> pokemon.getTipo().equals(tipo)).count();
         
         return contagem;
     }

    @GetMapping("/capturados")
    public List<Pokemon> capturados(){
//        List<Pokemon> capturados = new ArrayList<>();
//        for(Pokemon p : pokemons){
//            if(p.getCapturado()){
//                capturados.add(p);
//            }
//        }
//        return capturados;

//        return this.pokemons.stream().filter(pokemon -> pokemon.getCapturado()).collect(Collectors.toList()); // Exemplo mais moderno pelo professor.
        return this.pokemons.stream().filter(Pokemon::getCapturado).collect(Collectors.toList()); // Exemplo mais moderno pelo professor.
    }

    @GetMapping("/fortes")
    public List<Pokemon> pokemonsFortes(){
        List<Pokemon> fortes = new ArrayList<>();
        for(Pokemon p : pokemons){
            if(p.getForca() > 3000){
                fortes.add(p);
            }
        }


        return fortes;
    }

    @GetMapping("/fracos")
    public List<Pokemon> pokemonsFracos(){
        List<Pokemon> fracos = new ArrayList<>();
        for(Pokemon p : pokemons){
            if(p.getForca() <= 3000){
                fracos.add(p);
            }
        }
        return fracos;
    }

}
