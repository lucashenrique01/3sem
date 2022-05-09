import java.util.Scanner;

public class TarjaPreta extends Remedio{

    private String receitaEspecial;
    private Integer crm;

    public TarjaPreta(String nome, String formula, Integer dose, Integer quantidade, Double preco, String receitaEspecial, Integer crm) {
        super(nome, formula, dose, quantidade, preco);
        this.receitaEspecial = receitaEspecial;
        this.crm = crm;
    }

    @Override
    public void vender() {
        Scanner leitor = new Scanner(System.in);
        this.receitaEspecial = leitor.nextLine();
        crm = leitor.nextInt();
        setQuantidade(getQuantidade() - 1);
        System.out.println("Vendido");
    }

    @Override
    public String toString() {
        return "TarjaPreta{" +
                "receitaEspecial='" + receitaEspecial + '\'' +
                ", crm=" + crm +
                "} " + super.toString();
    }
}
