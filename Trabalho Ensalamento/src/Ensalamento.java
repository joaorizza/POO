import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ensalamento {

    public void executarEnsalamento() {
        Curso cursoTI = new Curso("TI", new ArrayList<>());
        Curso cursoADM = new Curso("ADM", new ArrayList<>());

        Disciplina poo = new Disciplina("POO", cursoTI);
        Disciplina estruturaDeDados = new Disciplina("Estrutura de Dados", cursoTI);
        Disciplina bi = new Disciplina("BI", cursoADM);

        cursoTI.getDisciplinas().addAll(Arrays.asList(poo, estruturaDeDados));
        cursoADM.getDisciplinas().add(bi);

        Professor professorMia = new Professor("Mia", poo);
        Professor professorSaulo = new Professor("Saulo", estruturaDeDados);
        Professor professorPaula = new Professor("Paula", bi);

        List<Aluno> alunosTI = Arrays.asList(
                new Aluno("Alfredo", cursoTI),
                new Aluno("Amélia", cursoTI),
                new Aluno("Bruno", cursoTI),
                new Aluno("Capitú", cursoTI),
                new Aluno("Debra", cursoTI),
                new Aluno("Iracema", cursoTI),
                new Aluno("Luciana", cursoTI),
                new Aluno("Norberto", cursoTI),
                new Aluno("Wendel", cursoTI),
                new Aluno("Zoey", cursoTI)
        );

        List<Aluno> alunosADM = Arrays.asList(
                new Aluno("Ana", cursoADM),
                new Aluno("Bentinho", cursoADM),
                new Aluno("Ian", cursoADM),
                new Aluno("Joelmir", cursoADM),
                new Aluno("Julieta", cursoADM),
                new Aluno("Luana", cursoADM),
                new Aluno("Majô", cursoADM),
                new Aluno("Maria", cursoADM),
                new Aluno("Paulo", cursoADM),
                new Aluno("Romeu", cursoADM)
        );

        Turma turmaPOO = new Turma(professorMia, poo, alunosTI);
        Turma turmaEstruturaDeDados = new Turma(professorSaulo, estruturaDeDados, alunosTI);
        Turma turmaBI = new Turma(professorPaula, bi, alunosADM);

        System.out.println("Ensalamento realizado:\n");
        turmaPOO.exibirTurma();
        System.out.println();
        turmaEstruturaDeDados.exibirTurma();
        System.out.println();
        turmaBI.exibirTurma();
    }
}
