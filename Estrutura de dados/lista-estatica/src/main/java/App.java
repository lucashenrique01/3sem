public class App {

    public static void main(String[] args) {

        ListaEstatica lista = new ListaEstatica(4);

        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
//        lista.adiciona(30);

//        lista.removePeloIndice(0);
//        lista.exibe();
        lista.removeElemento(10);
        lista.exibe();
        lista.adicionaNoInicio(70);
        lista.exibe();
    }
}
