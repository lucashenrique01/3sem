public class Pilha {

    private Integer[] vetor;
    private Integer topo;

    public Pilha(int tam) {
        vetor = new Integer[tam];
        this.topo = -1;
    }

    public boolean isEmpty(){
        return this.topo == -1;
//        if(topo == -1){
//            return true;
//        }else {
//            return false;
//        }
    }

    public boolean isFull(){
        return this.topo == vetor.length -1;
    }

    public void push(int info){
        if(!isFull()){
            this.topo++;
            this.vetor[topo] = info;
        }else {
            System.out.println("Pilha cheia");
        }
    }

    public Integer pop(){
        if(!isEmpty()){
            return this.vetor[topo--];
        }else {
            return null;
        }
    }

    public Integer peek(){
        if(!isEmpty()){
            return this.vetor[topo];
        }else {
            return null;
        }
    }

    public void exibe(){
        if(!isEmpty()){
            for(Integer elemento : vetor) System.out.println(elemento);;
        }else{
            System.out.println("Pilha vazia");
        }
    }


}
