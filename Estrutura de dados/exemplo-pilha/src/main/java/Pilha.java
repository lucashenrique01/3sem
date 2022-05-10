public class Pilha <T>{

    private T[] pilha;
    private Integer topo;

    public Pilha(int tam) {
        pilha = (T[]) new Object[tam];
        this.topo = -1;
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }

    public boolean isFull(){
        return this.topo == pilha.length -1;
    }

    public void push(T info){
        if(!isFull()){
            this.topo++;
            this.pilha[topo] = info;
        }else {
            System.out.println("Pilha cheia");
        }
    }

    public T pop(){
        if(!isEmpty()){
            return this.pilha[topo--];
        }else {
            return null;
        }
    }

    public T peek(){
        if(!isEmpty()){
            return this.pilha[topo];
        }else {
            return null;
        }
    }

    public void exibe(){
        if(!isEmpty()){
            for(T elemento : pilha) System.out.println(elemento);;
        }else{
            System.out.println("Pilha vazia");
        }
    }

    public Pilha <T> multiPop (int n){
        return null;
    }


}
