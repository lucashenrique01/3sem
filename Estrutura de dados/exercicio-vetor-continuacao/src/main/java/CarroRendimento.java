import java.util.Scanner;

public class CarroRendimento {

    public static String exibirMaiorRendimento(int[] v, String[] v2){
        int maior = 0;
        int indice = 0;
        for(int i = 0; i <v.length; i++){
            if(v[i] > maior) {
                maior = v[i];
                indice = i;
            }
        }
        return String.format("Modelo %s mais economio com rendimento %s km/L", v2[indice], maior);
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        String[] carros =  new String[5];
        int[] rendimentos = new int[5];

        System.out.println("Digite 5 modelos de carros: ");
        for(int i = 0; i < carros.length; i++) carros[i] = leitor.nextLine();

        for(int i = 0; i < rendimentos.length; i++){
            System.out.println(String.format("Digete o rendimento para o carro %s: ", carros[i]));
            rendimentos[i] = leitor.nextInt();
        }

        System.out.println(exibirMaiorRendimento(rendimentos, carros));


    }
}
