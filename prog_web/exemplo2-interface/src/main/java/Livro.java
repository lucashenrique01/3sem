public class Livro extends Produto{

    private String autor;
    private String isbn;

    public Livro(Integer codigo, String nome, Double precoCusto, String autor, String isbn) {
        super(codigo, nome, precoCusto);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public Double getValorVenda() {
        return super.getPrecoCusto() * 1.1;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", isbn=" + isbn +
                "} " + super.toString();
    }
}
