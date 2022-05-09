import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Escola {
    private String nome;
    private List<Aluno> alunos;


    public Escola(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionaAluno(Aluno a){
        if(!Objects.isNull(a)){
            this.alunos.add(a);
        }
    }

    public void exibeTodos(){
        for(Aluno a : alunos){
            System.out.println(a);
        }
    }

    public void exibeAlunosGraduacao(){
        for(Aluno a : alunos) {
            if(a instanceof AlunoGraduacao) {
                System.out.println(a);
            }
        }
    }

    public void exibeAprovados(){
        for(Aluno a : alunos){
            if(a.calculaMedia() >= 6){
                System.out.println(a);
            }
        }
    }

    public void buscaAluno(Integer ra){
        if(!Objects.isNull(ra)){
            for(Aluno a : alunos){
                if(a.getRa() == ra){
                    System.out.println(a);
                }
            }
        }
    }
}
