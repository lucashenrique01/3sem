import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Carrinho car1 = new Carrinho();

        Scanner leitor = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);





        Boolean menu = true;

        while(menu){
            System.out.println("=".repeat(30));
            System.out.println("1. Adicionar livro \n2. Adicionar DVD\n3. Adicionar Servico\n4. Exibir itens do carrinho\n5. Exibir total devenda \n6. Fim");
            System.out.println("=".repeat(30));
            Integer opcaoMenu = leitor.nextInt();
            switch (opcaoMenu){
                case 1:
                    System.out.println("Adicionando livro...");
                    System.out.println("Codigo:");
                    Integer codigo = leitor.nextInt();
                    System.out.println("Nome: ");
                    String nome = leitorString.nextLine();
                    System.out.println("Preço de custo:");
                    Double precoCusto = leitor.nextDouble();
                    System.out.println("Autor: ");
                    String autor = leitorString.nextLine();
                    System.out.println("ISBN: ");
                    String isbn = leitorString.nextLine();

                    Livro l1 = new Livro(codigo, nome, precoCusto, autor, isbn);
                    car1.adicionarVenda(l1);
                    System.out.println("Cadrastado com sucesso");
                    break;

                case 2:
                    System.out.println("Adicionando DVD...");
                    System.out.println("Codigo:");
                    Integer codigoDVd = leitor.nextInt();
                    System.out.println("Nome: ");
                    String nomeDVD = leitorString.nextLine();
                    System.out.println("Preço de custo:");
                    Double precoCustoDVD = leitor.nextDouble();
                    System.out.println("Gravadora: ");
                    String gravadora = leitorString.nextLine();

                    DVD d1 = new DVD(codigoDVd, nomeDVD, precoCustoDVD, gravadora);
                    car1.adicionarVenda(d1);
                    System.out.println("Cadrastado com sucesso");
                    break;

                case 3:
                    System.out.println("Adicionando serviço...");
                    System.out.println("Descrição:");
                    String descricao = leitorString.nextLine();
                    System.out.println("Codigo:");
                    Integer codigoServico = leitor.nextInt();
                    System.out.println("Quantida de horas:");
                    Integer qtdeHoras = leitor.nextInt();
                    System.out.println("Gravadora: ");
                    Double valorHoras = leitor.nextDouble();

                    Servico s1 = new Servico(descricao, codigoServico, qtdeHoras, valorHoras);
                    car1.adicionarVenda(s1);
                    System.out.println("Cadrastado com sucesso");
                    break;

                case 4:
                    car1.exibeIntesCarrinho();
                    System.out.println("");
                    break;

                case 5:
                    System.out.printf("Total de vendas: %.2f", car1.calculaTotalVenda());
                    System.out.println("");
                    break;

                case 6:
                    menu = false;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;

            }
        }
    }
}
