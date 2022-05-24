package com.example.c202211042lucashenriquepaula.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int in;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 12)
    private String login;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 8)
    private String senha;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 30)
    private String nome;

    @NotNull
    private boolean autenticado;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
