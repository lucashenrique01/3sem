public class Coordenador implements IBonus{
    private String nome;
    private Integer qtdeHorasCoord;
    private Double valorHoraCoord;

    public Coordenador(String nome, Integer qtdeHorasCoord, Double valorHoraCoord) {
        this.nome = nome;
        this.qtdeHorasCoord = qtdeHorasCoord;
        this.valorHoraCoord = valorHoraCoord;
    }

    @Override
    public Double getValorBonus() {
        return this.qtdeHorasCoord * this.valorHoraCoord * 4.5 * 0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "nome='" + nome + '\'' +
                ", qtdeHorasCoord=" + qtdeHorasCoord +
                ", valorHoraCoord=" + valorHoraCoord +
                '}';
    }
}
