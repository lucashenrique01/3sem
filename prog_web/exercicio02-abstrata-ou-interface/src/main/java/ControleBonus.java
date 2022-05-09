import java.util.ArrayList;
import java.util.List;

public class ControleBonus {
    private List<IBonus> listaBonus;

    public ControleBonus() {
        listaBonus = new ArrayList<>();
    }

    public void verLista(){
        for(IBonus b : listaBonus){
            System.out.println(b);
        }
    }

    public void addFuncBonus(IBonus b){
        listaBonus.add(b); //aqui está o poliformismo.
    }

    public Double totalBonus(){
        Double total = 0.0;
        for(IBonus b : listaBonus){
            total += b.getValorBonus();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ControleBonus{" +
                "listaBonus=" + listaBonus +
                '}';
    }
}
