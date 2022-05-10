public class Teste {

    public static Boolean isPalindromo(Integer[] vet){
        Pilha pilha = new Pilha(vet.length);
        for(Integer elemento : vet){
            pilha.push(elemento);
        }
        for(int i = 0; i < vet.length;i++){
            if(!(vet[i] == pilha.pop())){
                return false;
            }
        }
        return true;
    }

    public static int[] decimalToBinary(int[] vet){
        Pilha pilha = new Pilha(vet.length);
        return null;
    }

    public static void main(String[] args) {

        Pilha pilha = new Pilha(5);
        System.out.println(pilha.isEmpty());
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.pop();
        pilha.pop();
        pilha.push(40);
        pilha.push(50);
        pilha.push(60);
        pilha.push(70);
        pilha.push(80);

        pilha.exibe();
        System.out.println(pilha.isEmpty());
        System.out.println(pilha.isFull());
        System.out.println(pilha.peek());
        Integer[] vet1 = {1,3,3,1};
        Integer[] vet2 = {1,2,3,1};;
        Integer[] vet3 = {1,2,4,3,4,2,1};

        System.out.println(isPalindromo(vet1));
        System.out.println(isPalindromo(vet2));
        System.out.println(isPalindromo(vet3));
    }
}
