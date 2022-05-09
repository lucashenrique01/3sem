public abstract class Produto implements Tributavel{

    private int codigo;
    private String descricao;
    private Double preco;

    public Produto(int codigo, String descricao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

}
