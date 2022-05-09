public class BrinquedoAlugado extends Brinquedo implements Tributavel{

    private Double valorHora;
    private Double qtdHoraAlugada;

    public BrinquedoAlugado(String nome, Integer codigo, Double valorHora, Double qtdHoraAlugada) {
        super(nome, codigo);
        this.valorHora = valorHora;
        this.qtdHoraAlugada = qtdHoraAlugada;
    }

    @Override
    public Double getRenda() {
        return this.valorHora * this.qtdHoraAlugada;
    }

    @Override
    public Double getValorImposto() {
        return this.getRenda() * 0.10;
    }

    @Override
    public String toString() {
        return String.format("%s \nValor hora: %.2f\nQuantidad de horas alugadas: %.2f", super.toString(), this.valorHora,
                this.qtdHoraAlugada);
    }
}
