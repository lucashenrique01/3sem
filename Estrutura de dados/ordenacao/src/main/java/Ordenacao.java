public class Ordenacao {

    public static void ordernarVet(int[] v){

        int comparacao = 0;
        int trocas = 0;
        int aux = 0;
        for(int i = 0; i < v.length; i++){
            for (int j = i+1; j < v.length; j++){
                comparacao++;
                if(v[j] < v[i]){
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                    trocas++;
                }
            }
        }

        for(int i : v) System.out.print(i+"\t");
        System.out.println("");
        System.out.println("Trocas: "+trocas+" Comparações: "+comparacao);
    }

    public static void ordernarVetOtimizado(int[] vetor) {
        int comparacao = 0;
        int trocas = 0;
        int indMenor = 0;
        int aux = 0;
        for(int i = 0; i < vetor.length-1; i++){
            indMenor = i;
            for(int j = i+1; j < vetor.length; j++){
                comparacao++;
                if(vetor[j] < vetor[indMenor]){
                    trocas++;
                    indMenor = j;
                }
            }
            aux = vetor[i];
            vetor[i] = vetor[indMenor];
            vetor[indMenor] = aux;
        }
        for(int i : vetor) System.out.print(i+"\t");
        System.out.println("");
        System.out.println("Trocas: "+trocas+" Comparações: "+comparacao);
    }

    public static void bubbleSort(int[] v){
        int aux = 0;
        int trocas = 0;
        int comparacao =0;
        for(int i = 0; i < v.length-1; i++){
            for(int j = 1; j < v.length-i; j++){
                comparacao++;
                if(v[j-1] > v[j]){
                    aux = v[j-1];
                    v[j-1] = v[j];
                    v[j] = aux;
                    trocas++;
                }
            }
        }
        for(int i : v) System.out.print(i+"\t");
        System.out.println("");
        System.out.println("Trocas: "+trocas+" Comparações: "+comparacao);
    }

    public static void main(String[] args) {
        int[] vetor = {4,7,5,2,8,1,6,3};
        int[] vetor2 = {4,7,5,2,8,1,6,3};
        int[] vetor3 = {4,7,5,2,8,1,6,3};

        ordernarVet(vetor);
        ordernarVetOtimizado(vetor2);
        bubbleSort(vetor3);
    }


}
