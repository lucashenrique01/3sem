package com.example.c202211042lucashenriquepaula.requisicao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsuarioAutenticadoRequisicao {

    @NotNull
    @NotBlank
    @Size(min = 4, max = 12)
    private String login;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 8)
    private String senha;

    public UsuarioAutenticadoRequisicao(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
