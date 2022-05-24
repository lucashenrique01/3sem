public class ListObj<T> {

    private T[] vetor;
    private int nroElem;

    public ListObj(int tam) {
        this.nroElem = 0;
        vetor =(T[]) new Object[tam];
    }

    public void adiciona(T valor){
        if(this.nroElem >= vetor.length){
            System.out.println("Lista cheia!");
        } else {
            this.vetor[nroElem++] = valor;
        }

    }

    public void exibe(){

        for(int i = 0; i < this.nroElem; i++){
            System.out.print(this.vetor[i]+"\n" );
        }

    }

    public int busca(T valorProcurado){
        for(int i = 0; i < this.nroElem; i++){
            if(vetor[i].equals(valorProcurado)){
                return i;
            }
        }

        return -1;
    }

    public Boolean removePeloIndice(int indiceRemovido){
        if(indiceRemovido < 0 || indiceRemovido > this.nroElem){
            return false;
        } else {
            for(int i = indiceRemovido; i < this.nroElem-1; i++){
                this.vetor[i] = this.vetor[i+1];
            }
            this.nroElem--;
            return true;
        }

    }

    public Boolean removeElemento(T Elemento){
        return removePeloIndice(busca(Elemento));
    }

    public Boolean substitui(T valorAntigo, T novoValor){
        int indice = busca(valorAntigo);
        if(indice != -1){
            this.vetor[indice] = novoValor;
            return true;
        }

        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(T ocorrencia){
        int contador = 0;
        for(int i = 0; i < this.nroElem;i++){
            if(ocorrencia == this.vetor[i]){
                contador++;
            }
        }
        return contador;
    }

    public Boolean adicionaNoInicio(T novoElemento){
        if(this.nroElem >= this.vetor.length){
            return false;
        }else {
            for(int i = this.nroElem; i > 0; i--){
                this.vetor[i] = this.vetor[i-1];
            }
            this.vetor[0] = novoElemento;
            this.nroElem++;
            return true;
        }

    }

    public void adicionaNoMeio(T novoElemento){
        if(this.nroElem >= this.vetor.length){
            System.out.println("Lista cheia!");
        }else {
         Integer posicao = this.nroElem/2;

         for(int i = this.nroElem; i > posicao;i--){
             this.vetor[i] = this.vetor[i-1];
         }
         this.vetor[posicao] = novoElemento;
         this.nroElem++;
        }
    }

    public int getTamanho(){
        return this.nroElem;
    }

    public T getElemento(int indice){
        return this.vetor[indice];
    }

    public void limpa(){
        this.nroElem = 0;
    }




}
