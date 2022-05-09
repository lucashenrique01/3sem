public class Produto {

    private Integer codProduto;
    private String nome;
    private Double preco;
    private String avaliacao;
    private Integer quantidadeVendida;

    public Produto(Integer codProduto, String nome, Double preco, String avaliacao) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.quantidadeVendida = 0;
    }

    public void comprar(Integer qtdComprada){
        this.quantidadeVendida += qtdComprada;
    }

    public Double calcularFaturamento(){
        return this.preco * this.quantidadeVendida;
    }

    @Override
    public String toString() {
        return String.format("%06d %-14s %7.2f %7s %14.3f", codProduto, nome, preco, avaliacao, calcularFaturamento());
    }
}
