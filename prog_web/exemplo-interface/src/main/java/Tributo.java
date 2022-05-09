import java.util.ArrayList;
import java.util.List;

public class Tributo {

    List<Tributavel> tributos;

    public Tributo() {
        this.tributos = new ArrayList<>();
    }

    public void exibeTodos(){
        for(Tributavel t : tributos){
            System.out.println(t);
        }
    }

    public void adicionaTributavel(Tributavel t){
        tributos.add(t);
    }

    public Double calculaTotalTributo(){
        Double total = 0.0;
        for(Tributavel t : tributos){
            total += t.getValorTributo();
        }
        return total;
    }
}
