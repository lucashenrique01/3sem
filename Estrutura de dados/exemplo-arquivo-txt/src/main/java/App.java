import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

    private static void gravaRegistro(String registro, String nomeArq){
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
        }catch (IOException e){
            System.out.println("Erro ao gravar no arquivo: "+ e);
        }
    }

    private static void gravarArquivo(List<Aluno> lista, String s) {
        int contaRegistroCorpo = 0;

        String header = "00NOTA20221";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        gravaRegistro(header, s);

        for(Aluno a : lista) {
            String corpo = "02";
            corpo += String.format("%-5.5s", a.getCurso());
            corpo += String.format("%-8.8s", a.getRa());
            corpo += String.format("%-50.50s", a.getNome());
            corpo += String.format("%-40.40s", a.getDisciplina());
            corpo += String.format("%05.2f", a.getMedia());
            corpo += String.format("%03d", a.getQtdFalta());
            gravaRegistro(corpo, s);
            contaRegistroCorpo++;
        }
        String trailer = "01";
        trailer += String.format("%010d", contaRegistroCorpo);
        gravaRegistro(trailer, s);
    }


    private static void leArquivoTxT(String s) {
        BufferedReader entrada = null;

        String registro, tipoRegistro;
        String curso, ra, nome, disciplina;
        Double media;
        Integer qtdFalta;
        int contaRegDadoLido = 0;
        int qtdRegGravado;
        List<Aluno> listaLida = new ArrayList();

        try{
            entrada = new BufferedReader(new FileReader(s));
        } catch (IOException e){
            System.out.println("Erro ao abrir o arquivo: " + e);
        }

        try{
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0,2);
                if(tipoRegistro.equals("00")){
                    System.out.println("É um registro de header");
                    System.out.println("Tipo do arquivo: "+ registro.substring(2,6));
                    System.out.println("Ano/Semestre: "+ registro.substring(6,11));
                    System.out.println("Data e hora de gravação do arquivo: " + registro.substring(11,30));
                    System.out.println("Versão: "+ registro.substring(30,32));
                } else if(tipoRegistro.equals("02")) {
                    System.out.println("É um registro de corpo");
                    curso = registro.substring(2, 7).trim();
                    ra = registro.substring(7,15).trim();
                    nome = registro.substring(15, 65).trim();
                    disciplina = registro.substring(65, 105).trim();
                    media = Double.valueOf(registro.substring(105,110).replace(',','.'));
                    qtdFalta = Integer.valueOf(registro.substring(110, 113));
                    contaRegDadoLido++;

                    Aluno a = new Aluno(ra, nome, curso, disciplina, media, qtdFalta);
                    listaLida.add(a);

                } else if(tipoRegistro.equals("01")) {
                    System.out.println("É um registro de trailer");
                    qtdRegGravado = Integer.parseInt(registro.substring(2, 12));
                    if(contaRegDadoLido == qtdRegGravado){
                        System.out.println("Quantidade de registros lidos compativél com a quantidade de registros" +
                                "gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos incompatível com a quantidade de registros" +
                                "gravados");
                    }
                } else {
                    System.out.println("Tipo de registro inválido");
                }
                registro = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e){
            System.out.println("Erro na leitura do arquivo: "+ e);
        }
        System.out.println("\nConteudo da lista lida: ");
        for(Aluno aluno : listaLida) System.out.println(aluno);
    }

    public static void main(String[] args) {

        List<Aluno> lista = new ArrayList();
        Stack <Integer> gg = new Stack();

        lista.add(new Aluno("02211042", "CCO", "Lucas Henrique", "Banco de dados", 9.0,4));
        lista.add(new Aluno("02211055", "SIS", "Rafaella Amancio", "Banco de dados", 9.0,2));
        lista.add(new Aluno("02211017", "CCO", "Flavia Oliveira", "Banco de dados", 9.3,2));
        lista.add(new Aluno("02211031", "REDES", "Isabella Souza", "Banco de dados", 9.5,1));
        lista.add(new Aluno("02211002", "CCO", "Ana Freitas", "Banco de dados", 10.0,0));
        lista.add(new Aluno("02211019", "ADS", "Gabriel Lima", "Banco de dados", 8.5,1));


        //for(Aluno a : lista) System.out.println(a);

        //gravarArquivo(lista, "aluno.txt");
        leArquivoTxT("aluno.txt");

    }


}
