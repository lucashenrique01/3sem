import java.util.Scanner;

public class Exercicio0 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[5];
        String[] semana = {"Domingo", "Segunda","Terça", "Quarta", "Quinta","Sexta", "Sabado"};

        System.out.println("Digete um dia da semana: ");
        int user_dia = leitor.nextInt();
        while (user_dia <= 0 || user_dia >7){
            System.out.println("Digete um número válido");
            user_dia = leitor.nextInt();
        }
        System.out.println("Dia da semana escolhido: "+semana[user_dia-1]);
    }
}
