public class App {
    public static void main(String[] args) {

        Professor p1 = new Professor("Lucas Henrique", 20, 78.5);
        Coordenador c1 = new Coordenador("Gerson", 30, 95.2);

        ControleBonus controleBonus = new ControleBonus();

        controleBonus.addFuncBonus(p1);
        controleBonus.addFuncBonus(c1);
        controleBonus.verLista();
        System.out.println(controleBonus.totalBonus());
    }
}
