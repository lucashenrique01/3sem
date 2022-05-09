public class App {

    public static void main(String[] args) {

        Professor p1 = new Professor("Celia", 50, 85.9);
        Coordenador c1 = new Coordenador("Gerson", 20, 85.9, 20, 92.5);

        ControleBonus controleBonus = new ControleBonus();

        controleBonus.addEducador(p1);
        controleBonus.addEducador(c1);

        controleBonus.verLista();
        System.out.println(controleBonus.totalBonus());
    }


}
