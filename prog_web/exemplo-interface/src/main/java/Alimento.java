public class Alimento extends Produto{

    private int quantVitamina;

    public Alimento(int codigo, String descricao, Double preco, int quantVitamina) {
        super(codigo, descricao, preco);
        this.quantVitamina = quantVitamina;
    }

    @Override
    public Double getValorTributo() {
        return super.getPreco() * 0.15;
    }

    @Override
    public String toString() {
        return String.format("%s \n Vitamina: %d", super.toString(), this.quantVitamina);
    }
}
