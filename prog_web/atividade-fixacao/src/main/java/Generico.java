public class Generico extends Remedio{

    public Generico(String nome, String formula, Integer dose, Integer quantidade, Double preco) {
        super(nome, formula, dose, quantidade, preco);
    }

    @Override
    public void vender() {
        setQuantidade(getQuantidade() - 1);
        System.out.println("Vendido");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
