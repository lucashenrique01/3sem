public class Professor implements IBonus {
    private String nome;
    private Integer qtdeAulas;
    private Double valorHora;

    public Professor(String nome, Integer qtdeAulas, Double valorHora) {
        this.nome = nome;
        this.qtdeAulas = qtdeAulas;
        this.valorHora = valorHora;
    }

    @Override
    public Double getValorBonus() {
        return this.qtdeAulas * this.valorHora * 4.5 * 0.15;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", qtdeAulas=" + qtdeAulas +
                ", valorHora=" + valorHora +
                '}';
    }
}
