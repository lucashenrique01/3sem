import java.util.ArrayList;
import java.util.List;

public class ControleBonus {
    private List<Educadores> listaBonus;

    public ControleBonus() {
        listaBonus = new ArrayList<>();
    }

    public void verLista(){
        for(Educadores e : listaBonus){
            System.out.println(e);
        }
    }

    public void addEducador(Educadores e){
        listaBonus.add(e); //aqui está o poliformismo.
    }

    public Double totalBonus(){
        Double total = 0.0;
        for(Educadores e : listaBonus){
            total += e.getValorBonus();
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
