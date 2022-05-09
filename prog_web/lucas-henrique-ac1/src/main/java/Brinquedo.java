public abstract class Brinquedo implements Tributavel{

    private String nome;
    private Integer codigo;

    public Brinquedo(String nome, Integer codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public abstract Double getRenda();

    @Override
    public String toString() {
        return String.format("Nome: %s \nCódigo: %d", this.nome, this.codigo);
    }
}