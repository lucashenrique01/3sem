import java.util.Scanner;


public class Exercicio1 {

    public static void exibeVetor(int[] v){
        for(int i : v) System.out.println(i);
        System.out.println();
    }

    public static void exibeVetorContrario(int[] v){
        for(int i = v.length-1; i >= 0; i--){
            System.out.println(v[i]);
        }

    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[7];

        System.out.println("Digete 7 numéros: ");
        for(int i = 0; i < vetor.length; i++){
            vetor[i] = leitor.nextInt();
        }

        exibeVetor(vetor);
        exibeVetorContrario(vetor);
    }
}
