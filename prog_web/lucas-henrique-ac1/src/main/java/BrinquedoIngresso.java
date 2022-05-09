public class BrinquedoIngresso extends Brinquedo implements Tributavel{

    private Double valorIngresso;
    private Integer qtdIngressoVendido;

    public BrinquedoIngresso(String nome, Integer codigo, Double valorIngresso, Integer qtdIngressoVendido) {
        super(nome, codigo);
        this.valorIngresso = valorIngresso;
        this.qtdIngressoVendido = qtdIngressoVendido;
    }

    @Override
    public Double getRenda() {
        return this.valorIngresso * this.qtdIngressoVendido;
    }

    @Override
    public Double getValorImposto() {
        return this.getRenda() * 0.15;
    }

    @Override
    public String toString() {
        return String.format("%s \nValor Ingresso: %.2f\nQuantidade de ingressos vendidos: %d", super.toString(),
                this.valorIngresso, this.qtdIngressoVendido);
    }
}
