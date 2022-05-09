public class Perfume extends Produto{

    private String fragancia;

    public Perfume(int codigo, String descricao, Double preco, String fragancia) {
        super(codigo, descricao, preco);
        this.fragancia = fragancia;
    }

    @Override
    public Double getValorTributo() {
        return super.getPreco() * 0.27;
    }

    @Override
    public String toString() {
        return String.format("%s \n Vitamina: %s", super.toString(), this.fragancia);
    }
}
