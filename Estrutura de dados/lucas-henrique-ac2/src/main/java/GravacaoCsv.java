import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class GravacaoCsv {
    public static void gravaArquivoCsv(ListObj<Jogador> lista, String nomeArquivo) {
        FileWriter arq = null;// objeto que representa o arquivo que será usado para escrita.
        Formatter saida = null; //objeto que será usado para escrever no arquivo.
        Boolean deuRuim = false;
        nomeArquivo += ".csv";

        //Bloco try-catch parar abrir o arquivo.

        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        } catch (IOException e){
            System.out.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }

        //Bloco try-catch para gravar no arquivo.

        try{
            for(int i = 0; i < lista.getTamanho(); i++){
                Jogador jogador = lista.getElemento(i);
                saida.format("%d;%s;%d;%s;%s;%s;%.2f;%s\n", jogador.getId(), jogador.getNome(), jogador.getIdade(),
                        jogador.getNickname(), jogador.getPosicao(), jogador.getMain(), jogador.getMediaAMA(), jogador.getOrganizacao());
                System.out.println("Arquivo CSV gravado com sucesso");
            }
        } catch (FormatterClosedException e){
            System.out.println("Erro ao gravor arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException e){
                System.out.println("Erro ao fechar o arquivo!");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }
        }
    }
}
