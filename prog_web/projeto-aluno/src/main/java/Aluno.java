public abstract class Aluno {
    private Integer ra;
    private String nome;

    public Aluno(Integer ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    public abstract Double calculaMedia();

    public Integer getRa() {
        return ra;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                '}';
    }


}
