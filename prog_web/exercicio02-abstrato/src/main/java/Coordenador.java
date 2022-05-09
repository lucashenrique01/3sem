public class Coordenador extends Professor{

    private Integer qtdeHorasCoord;
    private Double valorHoraCoord;

    public Coordenador(String nome, Integer qtdeAulas, Double valorHoraAula, Integer qtdeHorasCoord, Double valorHoraCoord) {
        super(nome, qtdeAulas, valorHoraAula);
        this.qtdeHorasCoord = qtdeHorasCoord;
        this.valorHoraCoord = valorHoraCoord;
    }

    @Override //presente o polimorfismo
    public Double getValorBonus() {
        return super.getValorBonus() + (this.valorHoraCoord * this.qtdeHorasCoord * 4.5 * 0.2);
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdeHorasCoord=" + qtdeHorasCoord +
                ", valorHoraCoord=" + valorHoraCoord +
                "} " + super.toString();
    }
}
