public class PartidaGc {
  private int id;
  private String data;
  private int idPlayer;
  private String nickname;
  private String kda;
  private Double adr;


  //ESSE CONSTRUTOR NÃO DEVE SER ALTERADO, POIS É USADO NOS TESTES, DESTA FORMA
  public PartidaGc(int id, String data) {
    this.id = id;
    this.data = data;
  }

  //Esse construtor deve ser cheio (receber todos os atributos criados na classe)
  //Esse construtor (cheio) deve ser usado na classe com método main para testar o método de exportação
  public PartidaGc(int id, String data, int idPlayer, String nickname, String kda, Double adr) {
    this.id = id;
    this.data = data;
    this.idPlayer = idPlayer;
    this.nickname = nickname;
    this.kda = kda;
    this.adr = adr;
  }

  //Complete os getters e setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public int getIdPlayer() {
    return idPlayer;
  }

  public void setIdPlayer(int idPlayer) {
    this.idPlayer = idPlayer;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getKda() {
    return kda;
  }

  public void setKda(String kda) {
    this.kda = kda;
  }

  public Double getAdr() {
    return adr;
  }

  public void setAdr(Double adr) {
    this.adr = adr;
  }
}
