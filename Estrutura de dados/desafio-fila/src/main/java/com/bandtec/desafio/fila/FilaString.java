package com.bandtec.desafio.fila;

public class FilaString {
    // Atributos
    private int tamanho;
    private String[] fila;

    // Construtor
    public FilaString(int capaciade) {
       this.tamanho = 0;
       this.fila = new String[capaciade];
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() { return this.tamanho==0; }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return this.tamanho==this.fila.length;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Retornar IllegalStateException caso a fila esteja cheia
     */
    public void insert(String info) {
        if(isFull()){
            throw new IllegalStateException();
        } else {
            this.fila[tamanho++] = info;
        }

    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public String peek() {
        return this.fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
     */
    public String poll() {
        String aux = null;
        if(!isEmpty()){
            aux = this.fila[0];
            for(int i = 1; i < this.tamanho-1;i++){
                this.fila[i-1] = this.fila[i];
            }
            this.tamanho--;
        }

        return aux;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        for(String elemento : fila)System.out.println(elemento);
    }

    public int getTamanho(){
        return this.tamanho;
    }
}
