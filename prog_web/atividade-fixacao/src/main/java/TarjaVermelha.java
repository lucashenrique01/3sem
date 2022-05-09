import java.util.Scanner;

public class TarjaVermelha extends Remedio{

    private Boolean receita;
    private String receitaDescritivo;

    public TarjaVermelha(String nome, String formula, Integer dose, Integer quantidade, Double preco, Boolean receita, String receitaDescritivo) {
        super(nome, formula, dose, quantidade, preco);
        this.receita = receita;
        this.receitaDescritivo = receitaDescritivo;
    }

    public Boolean temReceita(){
        return this.receita;
    }

    @Override
    public void vender() {
        Scanner leitor = new Scanner(System.in);
       if (receita){
            this.receitaDescritivo = leitor.nextLine();
            setQuantidade(getQuantidade() - 1);
            System.out.println("Vendido");
        } else {
            setQuantidade(getQuantidade() - 1);
            System.out.println("Vendido");
        }
    }

    @Override
    public String toString() {
        return "TarjaVermelha{" +
                "receita=" + receita +
                ", receitaDescritivo='" + receitaDescritivo + '\'' +
                "} " + super.toString();
    }
}
