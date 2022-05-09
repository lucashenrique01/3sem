import java.util.Scanner;

public class Exercicio2 {

    public static Double calcMedia(int[] v){
        int soma = 0;
        double media = 0.0;
        for(int i : v) soma +=i;
        media = soma/v.length;
        return media;
    }

    public static void acimaMedia(int[] v){
        for(int i = 0; i < v.length; i++){
            if(v[i] > calcMedia(v)){
                System.out.println(String.format("%d valor acima da média", v[i]));
            }
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[10];

        System.out.println("Digete 10 numéros: ");
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = leitor.nextInt();
        }

        System.out.println("Média: " + calcMedia(vetor));
        acimaMedia(vetor);
    }
}
