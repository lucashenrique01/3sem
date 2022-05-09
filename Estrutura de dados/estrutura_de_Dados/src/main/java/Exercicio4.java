import java.util.Scanner;

public class Exercicio4 {

    public static void encontrarNumero(int[] v){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o número: ");
        int numeroDigitado = leitor.nextInt();
        int contador = 0;
        Boolean achou = false;
        for(int i = 0; i < v.length; i++){
            if(v[i] == numeroDigitado){
                achou = true;
                contador ++;
            }
        }
        if(achou){
            System.out.println(String.format("o número %d ocorre %d vezes", numeroDigitado, contador));
        } else if (achou && contador ==1){
            System.out.println(String.format("o número %d ocorre %d vez", numeroDigitado, contador));
        } else {
            System.out.println(String.format("o número %d não ocorre nenhuma vez", numeroDigitado));
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] vetor = new int[10];

        System.out.println("Digete 10 numeros: ");
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = leitor.nextInt();
        }
        encontrarNumero(vetor);
    }
}
