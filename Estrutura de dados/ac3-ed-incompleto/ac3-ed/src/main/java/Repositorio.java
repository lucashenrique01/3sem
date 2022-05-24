import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Repositorio {
  private List<PartidaGc> objetosTemaLivre;
  private PilhaObj<Integer> pilhaOperacao ;
  private FilaObj<PartidaGc> filaOperacao;
  private int contadorOperacoes;

  public Repositorio() {
      this.objetosTemaLivre = new ArrayList<>();
      this.pilhaOperacao = new PilhaObj<>(10);
      this.filaOperacao = new FilaObj<>(10);
      contadorOperacoes = 0;
  }

  public void save(PartidaGc objetoAdicionar){
      if(Objects.isNull(objetoAdicionar)){
          throw new IllegalArgumentException();
      }
      objetosTemaLivre.add(objetoAdicionar);
      pilhaOperacao.push(objetoAdicionar.getId());
      contadorOperacoes++;
  }

  public void deleteById(int id){
    boolean entrou = false;
    for(int i = 0; i < objetosTemaLivre.size(); i++){
          if(objetosTemaLivre.get(i).getId() == id){
              objetosTemaLivre.remove(objetosTemaLivre.get(i));
              entrou = true;
          }
    }
    if(!entrou){
      throw new IllegalArgumentException();
    }
  }

  public void updateDate(int id, String dataNova){
    boolean entrou = false;
    for(PartidaGc partida : objetosTemaLivre){
      if(partida.getId() == id){
        partida.setData(dataNova);
        entrou = true;
      }
    }
    if(!entrou){
      throw new IllegalArgumentException();
    }
  }

  public void undo(int qtdOperacoes){
      if(contadorOperacoes < qtdOperacoes){
          throw new IllegalArgumentException();
      }
      for(int i = 0; i < qtdOperacoes; i++){
          int idDaVez = pilhaOperacao.pop();
          for(PartidaGc partida : objetosTemaLivre){
              if(partida.getId() == idDaVez){
                  objetosTemaLivre.remove(partida);
                  contadorOperacoes--;
                  break;
              }
          }
      }
  }


  public void delaySave(PartidaGc objetoTemaLivre){
      if(!Objects.isNull(objetoTemaLivre)){
          filaOperacao.insert(objetoTemaLivre);
      }

  }

  public void flush(){
      if(filaOperacao.isEmpty()){
          throw new IllegalStateException();
      }
      while (!filaOperacao.isEmpty()){
          save(filaOperacao.poll());
      }
  }

  public Boolean exportTXT(String s){
      int contaRegistroCorpo = 0;
      Boolean gravou = false;

      String header = "10PARTIDASGC";
      header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
      header += "01";
      if(gravaRegistro(header, s)){
          gravou = true;
      }

      for(PartidaGc a : objetosTemaLivre) {
          String corpo = "11";
          corpo += String.format("%03d", a.getId());
          corpo += String.format("%-10.10s", a.getData());
          corpo += String.format("%-20.20s", a.getNickname());
          corpo += String.format("%05d", a.getIdPlayer());
          corpo += String.format("%05.1f", a.getAdr());
          corpo += String.format("%-20.20s", a.getKda());
          if(gravaRegistro(corpo, s)){
              gravou = true;
          }
          contaRegistroCorpo++;
      }
      String trailer = "12";
      trailer += String.format("%06d", contaRegistroCorpo);
      if (gravaRegistro(trailer, s)) {
          gravou = true;
      }

      return gravou;
  }

    private static Boolean gravaRegistro(String registro, String nomeArq){
        BufferedWriter saida = null;

        try{
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException e){
            System.out.println("Erro ao abrir o arquivo: " + e);
        }

        try
        {
            saida.append(registro + "\n");
            saida.close();
            return true;
        }catch (IOException e){
            System.out.println("Erro ao gravar no arquivo: "+ e);
            return false;
        }
    }

  //GETTERS e SETTERS
  public List<PartidaGc> getObjetosTemaLivre() {
    return objetosTemaLivre;
  }

  public PilhaObj<Integer> getPilhaOperacao() {
    return pilhaOperacao;
  }

  public FilaObj<PartidaGc> getFilaOperacao() {
    return filaOperacao;
  }

  public int getContadorOperacoes() {
    return contadorOperacoes;
  }
}
