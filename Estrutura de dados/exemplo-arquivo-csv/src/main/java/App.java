import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {

    public static void gravaArquivoCsv(ListObj<Cachorro> lista, String nomeArquivo) {
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
                Cachorro dog = lista.getElemento(i);
                saida.format("%d;%s;%s;%.2f\n", dog.getId(), dog.getNome(), dog.getPorte(), dog.getPeso());
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

        try{
            System.out.printf("%-4s %-15s %-9s %5s\n", "ID", "NOME", "PORTE", "PESO");

            while (entrada.hasNext()){
                int id = entrada.nextInt();
                String nome = entrada.next();
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                System.out.printf("%-4d %-15s %-9s %5.2f\n", id, nome, porte, peso);
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

    public static void main(String[] args) {

        ListObj<Cachorro> listaDog = new ListObj(7);

        listaDog.adiciona(new Cachorro(1, "Johnny", "Pequeno", 5.5));
        listaDog.adiciona(new Cachorro(2, "Taylor", "Médio", 12.5));
        listaDog.adiciona(new Cachorro(3, "Fire Fox", "Médio", 14.5));
        listaDog.adiciona(new Cachorro(4, "Pacoca", "Pequeno", 5.0));
        listaDog.adiciona(new Cachorro(5, "Tobias", "Pequeno", 5.2));

        gravaArquivoCsv(listaDog, "Funciona");
        lerArquivoCsv("Funciona");
    }
}
