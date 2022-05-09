package sptech.projetojpa03.entidade;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity // do pacote javax.persistence
public class AnimalEstimacao {

    @Id // do pacote javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 15)
    private String nome;

    @PastOrPresent
    private LocalDate dataNascimento;

//    @DecimalMin("0")
    @Positive
    @DecimalMax("100")
    private Double peso;

    @NotNull
    private boolean castrado;

    @Email
    private String emailDono;

    @CPF
    @Size(min = 11, message = "Informe somente números")
    private String cpfDono;

    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})",
            message = "Informe um telefone válido com ou sem DDD")
    private String telefoneDono;

    public String getTelefoneDone() {
        return telefoneDono;
    }

    public void setTelefoneDone(String telefoneDone) {
        this.telefoneDono = telefoneDone;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public String getEmailDono() {
        return emailDono;
    }

    public void setEmailDono(String emailDono) {
        this.emailDono = emailDono;
    }

    public String getCpf() {
        return cpfDono;
    }

    public void setCpf(String cpf) {
        this.cpfDono = cpf;
    }
}
