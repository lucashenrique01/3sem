public class Jogador {

    private Integer id;
    private String nome;
    private Integer idade;
    private String nickname;
    private String posicao;
    private String main;
    private Double mediaAMA;
    private String organizacao;

    public Jogador(Integer id, String nome, Integer idade, String nickname, String posicao, String main, Double mediaAMA, String organizacao) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.nickname = nickname;
        this.posicao = posicao;
        this.main = main;
        this.mediaAMA = mediaAMA;
        this.organizacao = organizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Double getMediaAMA() {
        return mediaAMA;
    }

    public void setMediaAMA(Double mediaAMA) {
        this.mediaAMA = mediaAMA;
    }

    public String getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(String organizacao) {
        this.organizacao = organizacao;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nickname='" + nickname + '\'' +
                ", posicao='" + posicao + '\'' +
                ", main='" + main + '\'' +
                ", mediaAMA=" + mediaAMA +
                ", organizacao='" + organizacao + '\'' +
                '}';
    }
}
