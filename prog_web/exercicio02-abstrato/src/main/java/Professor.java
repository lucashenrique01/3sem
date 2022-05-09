public class Professor extends Educadores {

    public Professor(String nome, Integer qtdeAulas, Double valorHoraAula) {
        super(nome, qtdeAulas, valorHoraAula);
    }

    @Override //presente o polimorfismo
    public Double getValorBonus() {
        return getValorHoraAula() + getQtdeAulas() * 4.5 * 0.15;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
