public class Teste {

    public static void main(String[] args) {

        ListObj<String> listaNomes = new ListObj(5);
        ListObj<Double> listaGastos = new ListObj(5);

        listaNomes.adiciona("Lucas");
        listaNomes.adiciona("Rafaela");
        listaNomes.adiciona("Flavia");
        listaNomes.adiciona("Isabella");

        listaGastos.adiciona(200.0);
        listaGastos.adiciona(230.0);
        listaGastos.adiciona(85.70);
        listaGastos.adiciona(120.4);

        listaNomes.exibe();
        listaGastos.exibe();

        listaNomes.adicionaNoInicio("Leo");
        listaNomes.exibe();

        System.out.println(listaNomes.getTamanho());;
        System.out.println( listaNomes.getElemento(0));;
        listaNomes.limpa();
        listaNomes.exibe();

    }
}
