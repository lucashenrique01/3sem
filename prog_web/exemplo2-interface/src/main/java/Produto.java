public abstract class Produto implements Vendavel{

    private Integer codigo;
    private String nome;
    private Double precoCusto;

    public Produto(Integer codigo, String nome, Double precoCusto) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoCusto = precoCusto;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", precoCusto=" + precoCusto +
                '}';
    }
}
