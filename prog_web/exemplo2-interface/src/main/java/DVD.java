public class DVD extends Produto{

    private String gravadora;

    public DVD(Integer codigo, String nome, Double precoCusto, String gravadora) {
        super(codigo, nome, precoCusto);
        this.gravadora = gravadora;
    }

    @Override
    public Double getValorVenda() {
        return super.getPrecoCusto() * 1.20;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "gravadora='" + gravadora + '\'' +
                "} " + super.toString();
    }
}
