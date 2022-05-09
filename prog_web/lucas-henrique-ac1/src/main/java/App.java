public class App {

    public static void main(String[] args) {

        BrinquedoIngresso b1 = new BrinquedoIngresso("Montanha Russa", 1010, 12.5, 120);
        BrinquedoIngresso b2 = new BrinquedoIngresso("Barco Vinking", 1011, 8.5, 150);
        BrinquedoAlugado b3 = new BrinquedoAlugado("Bicicleta", 2010, 5.0, 180.0);
        Socio s1 = new Socio("Celia", 7300.50);
        Socio s2 = new Socio("Giuliana", 4735.90);

        ControleImposto controlador = new ControleImposto();

        controlador.addTributavel(b1);
        controlador.addTributavel(b2);
        controlador.addTributavel(b3);
        controlador.addTributavel(s1);
        controlador.addTributavel(s2);

        controlador.exibeImpostos();
        System.out.println("-----------------------------------");
        System.out.println("Total de impostos R$:" + controlador.getTotalImposto());

        // classe Lanchonete, onde todas as lanconhetes ou estabelecimento que venda comida tenha um valor de imposto
        // sobre o valor total de itens vendidos. No uml ela seria ligada apenas a Interface Tributavel assim como a
        // classe socio.
    }
}
