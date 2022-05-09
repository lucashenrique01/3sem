import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Vendavel> listaVendas;

    public Carrinho() {
        this.listaVendas = new ArrayList<>();
    }

    public void adicionarVenda(Vendavel v){
        listaVendas.add(v);
    }

    public Double calculaTotalVenda(){
        Double total = 0.0;
        for(Vendavel v : listaVendas){
            total += v.getValorVenda();
        }
        return total;
    }

    public void exibeIntesCarrinho(){
        for(Vendavel v : listaVendas){
            System.out.println(v);
        }
    }
}
