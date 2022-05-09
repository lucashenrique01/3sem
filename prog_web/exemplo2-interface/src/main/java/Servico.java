public class Servico implements Vendavel{

    private String descricao;
    private Integer codigo;
    private Integer qtdeHoras;
    private Double valorHora;

    public Servico(String descricao, Integer codigo, Integer qtdeHoras, Double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.qtdeHoras = qtdeHoras;
        this.valorHora = valorHora;
    }

    @Override
    public Double getValorVenda() {
        return this.qtdeHoras * this.valorHora;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", qtdeHoras=" + qtdeHoras +
                ", valorHora=" + valorHora +
                '}';
    }
}
