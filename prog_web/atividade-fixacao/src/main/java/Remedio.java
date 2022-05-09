public abstract class Remedio {

    private String nome;
    private String formula;
    private Integer dose;
    private Integer quantidade;
    private Double preco;

    public Remedio(String nome, String formula, Integer dose, Integer quantidade, Double preco) {
        this.nome = nome;
        this.formula = formula;
        this.dose = dose;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }



    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public abstract void vender();

    @Override
    public String toString() {
        return "Remedio{" +
                "nome='" + nome + '\'' +
                ", formula='" + formula + '\'' +
                ", dose=" + dose +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
