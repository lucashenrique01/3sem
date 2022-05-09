package sptech.projeto02;

public class Pais {

    private String nome;
    private int medalhaOuros;
    private int medalhaPatra;
    private int medalhaBronze;


    public Pais(String nome, int medalhaOuros, int medalhPatra, int medalhaBronze) {
        this.nome = nome;
        this.medalhaOuros = medalhaOuros;
        this.medalhaPatra = medalhPatra;
        this.medalhaBronze = medalhaBronze;
    }
    public Pais() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMedalhaOuros() {
        return medalhaOuros;
    }

    public void setMedalhaOuros(int medalhaOuros) {
        this.medalhaOuros = medalhaOuros;
    }

    public int getMedalhaPatra() {
        return medalhaPatra;
    }

    public void setMedalhaPatra(int medalhaPatra) {
        this.medalhaPatra = medalhaPatra;
    }

    public int getMedalhaBronze() {
        return medalhaBronze;
    }

    public void setMedalhaBronze(int medalhaBronze) {
        this.medalhaBronze = medalhaBronze;
    }

    public int getTotalMedalhas(){
        return this.medalhaOuros + this.medalhaPatra + this.medalhaBronze;
    }
}
