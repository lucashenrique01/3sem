public class ListaEstatica {

    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tam) {
        this.nroElem = 0;
        vetor = new int[tam];
    }

    public void adiciona(int valor){
        if(this.nroElem >= vetor.length){
            System.out.println("Lista cheia!");
        } else {
            this.vetor[nroElem++] = valor;
        }

    }

    public void exibe(){
        System.out.print("[");
        for(int i = 0; i < this.nroElem; i++){
            System.out.print(this.vetor[i]+"\t" );
        }
        System.out.println("]");
    }

    public int busca(int valorProcurado){
        for(int i = 0; i < this.nroElem; i++){
            if(vetor[i] == valorProcurado){
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

    public Boolean removeElemento(int Elemento){
       return removePeloIndice(busca(Elemento));
    }

    public Boolean substitui(int valorAntigo, int novoValor){
        int indice = busca(valorAntigo);
        if(indice != -1){
            this.vetor[indice] = novoValor;
            return true;
        }

        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(int ocorrencia){
        int contador = 0;
        for(int i = 0; i < this.nroElem;i++){
            if(ocorrencia == this.vetor[i]){
                contador++;
            }
        }
        return contador;
    }

    public Boolean adicionaNoInicio(int novoElemento){
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




}
