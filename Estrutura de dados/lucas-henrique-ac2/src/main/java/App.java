import java.util.Objects;
import java.util.Scanner;


public class App {

    public static Jogador addJogadorComScanner(){
        Integer id;
        String nome;
        Integer idade;
        String nickname;
        String posicao;
        String main;
        Double mediaAMA;
        String organizacao;

        Scanner leitorString = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);

        System.out.println("Digite o id do jogador: ");
        id = leitorNumerico.nextInt();

        System.out.println("Digite o nome do jogador: ");
        nome = leitorString.nextLine();

        System.out.println("Digite a idade do jogador: ");
        idade = leitorNumerico.nextInt();

        System.out.println("Digite o nickname do jogador: ");
        nickname = leitorString.nextLine();

        System.out.println("Digite a posicao(rota) do jogador: ");
        posicao = leitorString.nextLine();

        System.out.println("Digite o principal campeão(main) do jogador: ");
        main = leitorString.nextLine();

        System.out.println("Digite o AMA do jogador: ");
        mediaAMA = leitorNumerico.nextDouble();

        System.out.println("Digite a qual organização esse jogador pertence: ");
        organizacao = leitorString.nextLine();

        return new Jogador(id, nome, idade, nickname, posicao, main, mediaAMA, organizacao);
    }

    public static void main(String[] args) {

        Integer opçãoMenu;
        Boolean fim = false;

        Scanner leitorString = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);

        ListObj<Jogador> lista = new ListObj(10);

        while (!fim){
            System.out.println("-----------------------------");
            System.out.println("1. Adicionar um jogador\n" +
                    "2. Exibir a lista\n" +
                    "3. Gravar o arquivo CSV a partir dessa lista\n" +
                    "4. Exibir o arquivo CSV\n" +
                    "5. Alterar a organização dos jogadores que jogam com um determinado Main.\n" +
                    "6. Adicionar um jogador no meio da lista\n"+
                    "7. Fim");
            System.out.println("-----------------------------");
            opçãoMenu = leitorNumerico.nextInt();

            switch (opçãoMenu){
                case 1:
                    lista.adiciona(addJogadorComScanner());
                    System.out.println("Jogador adicionado com sucesso");
                    break;

                case 2:
                    lista.exibe();
                    break;

                case 3:
                    GravacaoCsv.gravaArquivoCsv(lista, "jogadorCSV");
                    break;

                case 4:
                    LeituraCsv.lerArquivoCsv("jogadorCSV");
                    break;

                case 5:
                    Boolean entrou = false;
                    System.out.println("Digte o Main a ser procurado: ");
                    String mainProcurado = leitorString.nextLine();
                    System.out.println("Informe para qual organização esses jogadores vão: ");
                    String novaOrg = leitorString.nextLine();
                    for(int i = 0; i < lista.getTamanho();i++){
                        if(lista.getElemento(i).getMain().equals(mainProcurado)){
                            lista.getElemento(i).setOrganizacao(novaOrg);
                            entrou = true;
                        }
                    }
                    if(!entrou){
                        System.out.println("Nenhum jogador encontrado com esse main");
                    }else {
                        System.out.println("Alteração concluida com sucesso.");
                    }
                    break;

                case 6:
                    lista.adicionaNoMeio(addJogadorComScanner());
                    break;

                case 7:
                    fim = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        }



    }
}
