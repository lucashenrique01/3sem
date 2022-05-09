import java.util.Scanner;

public class Mes {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int[] numeroDiasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        System.out.println("Digite um dia do mês: ");
        int diaEscolhido = leitor.nextInt();
        System.out.println("Digite o mês em númeral: ");
        int mesEscolhido = leitor.nextInt();
        leitor.close();

        int soma = 0;

        for(int i = 0; i < mesEscolhido-1; i++){
            soma += numeroDiasMes[i];
        }

        int diaFinal = soma + diaEscolhido;

        System.out.println(String.format("O dia %d/%d corresponde ao dia %d do ano.", diaEscolhido, mesEscolhido, diaFinal));
    }
}
