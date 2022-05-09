import java.util.Scanner;

public class Exercicio3 {

    public static void encontrarPorNome(String[] vetor, String nome){
        Boolean achou = false;
        String encontrado ="";
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i].equals(nome)){
                achou = true;
                encontrado = String.format("Nome encontrado no índice "+ i);
            }
        }
        if(achou){
            System.out.println(encontrado);
        }else {
            System.out.println("Nome não encontrado");
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        String[] vetor = new String[10];

        System.out.println("Digete 10 nomes: ");
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = leitor.nextLine();
        }

        encontrarPorNome(vetor, "nome");

    }
}
