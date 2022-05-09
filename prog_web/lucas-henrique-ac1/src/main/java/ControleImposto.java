import java.util.ArrayList;
import java.util.List;

public class ControleImposto {

    private List<Tributavel> tributaveis;

    public ControleImposto() {
        this.tributaveis = new ArrayList<>();
    }

    public void addTributavel(Tributavel t){
        tributaveis.add(t);
    }

    public Double getTotalImposto(){
        Double total = 0.0;
        for(Tributavel t : tributaveis){
            total += t.getValorImposto();
        }
        return total;
    }

    public void exibeImpostos(){
        for(Tributavel t : tributaveis){
            if(t instanceof BrinquedoAlugado){
                System.out.println("-----------------------------------");
                System.out.println("Brinquedo Alugado: ");
                System.out.println(t);
            }
            if(t instanceof BrinquedoIngresso){
                System.out.println("-----------------------------------");
                System.out.println("Brinquedo Ingresso: ");
                System.out.println(t);
            }
            if(t instanceof Socio){
                System.out.println("-----------------------------------");
                System.out.println("Socio: ");
                System.out.println(t);
            }

        }
    }

}
