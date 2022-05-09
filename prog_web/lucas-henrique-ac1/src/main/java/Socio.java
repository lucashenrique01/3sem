public class Socio implements Tributavel{

    private String nome;
    private Double honorario;

    public Socio(String nome, Double honorario) {
        this.nome = nome;
        this.honorario = honorario;
    }

    @Override
    public Double getValorImposto() {
        return this.honorario * 0.25;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nHonorario: %.2f", this.nome, this.honorario);
    }
}
