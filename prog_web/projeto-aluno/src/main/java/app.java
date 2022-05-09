public class app {

    public static void main(String[] args) {
        AlunoFundamental aluno1 = new AlunoFundamental(123, "Lucas", 9.5, 8.9,9.0,9.4);
        AlunoGraduacao aluno2 = new AlunoGraduacao(122, "Larissa", 3.5, 5.0);
        AlunoPos aluno3 = new AlunoPos(121, "Eunilia", 9.9, 8.7, 10.0);

        Escola escola1 = new Escola("Academy");

        escola1.adicionaAluno(aluno1);
        escola1.adicionaAluno(aluno2);
        escola1.adicionaAluno(aluno3);

//      escola1.exibeTodos();
//      escola1.buscaAluno(123);
//      escola1.exibeAprovados();
        escola1.exibeAlunosGraduacao();
    }


}
