public class Aluno {

    private String ra;
    private String curso;
    private String nome;
    private String disciplina;
    private Double media;
    private Integer qtdFalta;

    public Aluno(String ra, String curso, String nome, String disciplina, Double media, Integer qtdFalta) {
        this.ra = ra;
        this.curso = curso;
        this.nome = nome;
        this.disciplina = disciplina;
        this.media = media;
        this.qtdFalta = qtdFalta;
    }

    public String getRa() {
        return ra;
    }

    public String getCurso() {
        return curso;
    }

    public String getNome() {
        return nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public Double getMedia() {
        return media;
    }

    public Integer getQtdFalta() {
        return qtdFalta;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra='" + ra + '\'' +
                ", curso='" + curso + '\'' +
                ", nome='" + nome + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", media=" + media +
                ", qtdFalta=" + qtdFalta +
                '}';
    }
}
