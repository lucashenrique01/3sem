package sptech.projetojpa06.rest.mockapi;

import java.time.LocalDateTime;

public class LogResposta {

    private String descricao;
    private long identificador;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
}
