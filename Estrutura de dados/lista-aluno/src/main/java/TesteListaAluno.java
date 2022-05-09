import java.util.Objects;
import java.util.Scanner;

public class TesteListaAluno {



    public static void main(String[] args) {

        Scanner leitorString = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);

        Boolean fim = false;

        Integer novoRa;
        String novoNome;
        Double novaNota;

        Integer indice;
        int ra;

        Integer opçãoMenu;

        ListObj<Aluno> listaAlunos = new ListObj(10);

        while (!fim){
            System.out.println("-----------------------------");
            System.out.println("1. Adicionar um aluno\n" +
                    "2. Exibir a lista\n" +
                    "3. Exibir um aluno da lista\n" +
                    "4. Limpar a lista\n" +
                    "5. Buscar um aluno pelo RA\n" +
                    "6. Fim");
            System.out.println("-----------------------------");
            opçãoMenu = leitorNumerico.nextInt();

            switch (opçãoMenu){
                case 1:
                    System.out.println("Digite o ra do aluno: ");
                    novoRa = leitorNumerico.nextInt();

                    System.out.println("Digite o nome do aluno: ");
                    novoNome = leitorString.nextLine();

                    System.out.println("Digite a nota do aluno: ");
                    novaNota = leitorNumerico.nextDouble();

                    Aluno novoAluno = new Aluno(novoRa, novoNome, novaNota);
                    listaAlunos.adiciona(novoAluno);
                    System.out.println("Aluno adicionado com sucesso");
                    break;

                case 2:
                    System.out.printf("%-10s %-30s %5s\n", "RA", "NOME", "NOTA");
                    listaAlunos.exibe();
                    break;

                case 3:
                    System.out.println("Digite o indice: ");
                    indice = leitorNumerico.nextInt();
                    if(Objects.isNull(listaAlunos.getElemento(indice))){
                        System.out.println("índice inválido");
                        break;
                    }
                    System.out.println(listaAlunos.getElemento(indice));
                    break;

                case 4:
                    listaAlunos.limpa();
                    System.out.println("Lista limpada com sucesso!");
                    break;

                case 5:
                    Boolean encontrou = false;
                    System.out.println("Digete o ra: ");
                    ra = leitorNumerico.nextInt();
                    for(int i = 0; i < listaAlunos.getTamanho(); i++){
                        if(listaAlunos.getElemento(i).getRa().equals(ra)){
                            System.out.println(listaAlunos.getElemento(i));
                            encontrou = true;
                            break;
                        }
                    }
                    if(!encontrou){
                        System.out.println("Aluno não encontrado");
                    }
                    break;

                case 6:
                    fim = true;
                    break;

                default:
                System.out.println("Opção inválida!");
            }

        }

    }
}
