import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeituraCsv {
    public static void lerArquivoCsv(String nomeArqv){
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        nomeArqv += ".csv";

        try{
            arq = new FileReader(nomeArqv);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não econtrado");
            System.exit(1);

        }

        try{            System.out.printf("%-4s %-30s %-5s %-12s %-7s %-12s %5s %-15s\n", "ID", "NOME", "IDADE", "NICKNAME",
                "POSIÇÃO", "MAIN", "AMA", "ORG");


            while (entrada.hasNext()){
                int id = entrada.nextInt();
                String nome = entrada.next();
                Integer idade = entrada.nextInt();
                String nickname = entrada.next();
                String posicao = entrada.next();
                String main = entrada.next();
                Double mediaAMA = entrada.nextDouble();
                String organizacao = entrada.next();
                System.out.printf("%-4s %-30s %-5d %-12s %-7s %-12s %5.2f %-15s\n", id, nome, idade, nickname, posicao,
                        main, mediaAMA, organizacao);
            }
        }
        catch (NoSuchElementException e){
            System.out.println("Arquivo com problemas!");
            deuRuim=true;
        }
        catch (IllegalStateException e){
            System.out.println("Erro com o scanner");
            deuRuim=true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException e){
                System.out.println("Erro ao abrir o arquivo!");
                deuRuim = true;
            }
            if(deuRuim){
                System.exit(1);
            }
        }
    }
}
