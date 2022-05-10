public class Livro {

    private String nome;
    private String autor;

    public Livro(String nome, String autor) {
        this.nome = nome;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
