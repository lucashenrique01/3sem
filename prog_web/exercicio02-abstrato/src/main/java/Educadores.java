public abstract class Educadores { //Classe abstrata, pois possui relacionamentos que permite herença e atributos reutilizaveis.
    private String nome;
    private Integer qtdeAulas;
    private Double valorHoraAula;

    public Educadores(String nome, Integer qtdeAulas, Double valorHoraAula) {
        this.nome = nome;
        this.qtdeAulas = qtdeAulas;
        this.valorHoraAula = valorHoraAula;
    }

    public Integer getQtdeAulas() {
        return qtdeAulas;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    public abstract Double getValorBonus();

    @Override
    public String toString() {
        return "Educadores{" +
                "nome='" + nome + '\'' +
                ", qtdeAulas=" + qtdeAulas +
                ", valorHoraAula=" + valorHoraAula +
                '}';
    }
}
