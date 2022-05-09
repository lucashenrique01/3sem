public class App {

    public static void main(String[] args) {

        ListObj<Produto> listaProdutos = new ListObj(5);

        Produto p1 = new Produto(123, "Mesa", 250.0, "***");
        Produto p2 = new Produto(245, "Lapis", 250.0, "****");
        Produto p3 = new Produto(321, "Notebook", 3.200, "*****");
        Produto p4 = new Produto(654, "Mouse", 35.5, "**");
        Produto p5 = new Produto(2345, "Caderno", 23.5, "***");

        p1.comprar(10);
        p2.comprar(50);
        p3.comprar(7);
        p4.comprar(20);
        p5.comprar(40);

        listaProdutos.adiciona(p1);
        listaProdutos.adiciona(p2);
        listaProdutos.adiciona(p3);
        listaProdutos.adiciona(p5);
        listaProdutos.adiciona(p5);

        System.out.printf("--------------------------------------------------------------\n");
        System.out.printf("%-6s %-14s %7s %7s %14s\n", "CÓDIGO", "NOME", "PREÇO", "NOTA", "FATURAMENETO");
        listaProdutos.exibe();
    }
}
