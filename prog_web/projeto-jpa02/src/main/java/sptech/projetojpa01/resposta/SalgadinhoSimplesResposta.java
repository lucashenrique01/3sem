package sptech.projetojpa01.resposta;

public class SalgadinhoSimplesResposta {

    private Integer codigo;
    private String nome;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public SalgadinhoSimplesResposta(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
}
