import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploThrows{

    public static int divide(int numerador, int demoniador)throws ArithmeticException{
        return numerador/demoniador;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int numerador, denominador, resultado;
        boolean continua = true;

        do {
            try{
                System.out.println("Digite o valor do numerador: ");
                numerador = leitor.nextInt();
                System.out.println("Digite o valor do denominador: ");
                denominador = leitor.nextInt();

                resultado = divide(numerador, denominador);

                System.out.println(resultado);
                continua=false;
            } catch (InputMismatchException e){
                System.out.println("Exceção: "+ e);
                System.out.println("Você deve digitar um valor inteiro. Tente novamente!");
                leitor.nextLine(); //decarta o restante do buffer lido.
            } catch (ArithmeticException e){
                System.out.println("Exceção: "+ e);
                System.out.println("O denominador não pode ser zero. Tente novamente!");
            }
        }while (continua);
    }
}
