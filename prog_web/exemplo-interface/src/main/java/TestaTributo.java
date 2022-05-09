public class TestaTributo {

    public static void main(String[] args) {

        Alimento a1 = new Alimento(123, "Pão de forma", 7.5, 12);
        Perfume p1 = new Perfume(123, "100ml", 159.9, "Malbec");
        Servico s1 = new Servico("Entrega", 25.0);

        Tributo t1 = new Tributo();

        t1.adicionaTributavel(a1);
        t1.adicionaTributavel(p1);
        t1.adicionaTributavel(s1);

        System.out.println(a1.getValorTributo());
        System.out.println(p1.getValorTributo());
        System.out.println(s1.getValorTributo());

        System.out.println(String.format("Total de tributos R$%.2f", t1.calculaTotalTributo()));

        t1.exibeTodos();
    }
}
