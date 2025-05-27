import models.*;
import managers.*;

public class App {
    public static void main(String[] args) {
        AlunoManager alunoManager = new AlunoManager();
        DisciplinaManager disciplinaManager = new DisciplinaManager();
        TurmaManager turmaManager = new TurmaManager();
        MatriculaManager matriculaManager = new MatriculaManager();
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

        // Criar alunos
        Aluno aluno1 = new AlunoNormal("João Silva", "2025001", "Engenharia");
        Aluno aluno2 = new AlunoEspecial("Maria Santos", "2025002", "Ciência da Computação");

        alunoManager.adicionarAluno(aluno1);
        alunoManager.adicionarAluno(aluno2);

        // Criar disciplinas
        Disciplina d1 = new Disciplina("Programação I", "PROG101", 60);
        Disciplina d2 = new Disciplina("Matemática Discreta", "MAT102", 60);
        disciplinaManager.adicionarDisciplina(d1);
        disciplinaManager.adicionarDisciplina(d2);

        // Criar turma
        Turma t1 = new Turma(d1, "Prof. Carlos", "2025.1", "MediaSimples", true, "Sala 101", "Seg 10h-12h", 30);
        turmaManager.adicionarTurma(t1);

        // Matricular alunos
        boolean matriculaSucesso1 = matriculaManager.matricularAluno(aluno1, t1);
        boolean matriculaSucesso2 = matriculaManager.matricularAluno(aluno2, t1);

        System.out.println("Matrícula João: " + matriculaSucesso1);
        System.out.println("Matrícula Maria: " + matriculaSucesso2);

        // Atualizar notas do João
        Matricula matriculaJoao = aluno1.getMatriculas().get(0);
        avaliacaoManager.atualizarNotas(matriculaJoao, 7.0, 8.0, 6.0, 9.0, 10.0, 28, 30);

        Avaliacao avaliacaoJoao = matriculaJoao.getAvaliacao();
        System.out.println("Avaliação João: " + avaliacaoJoao);

        // Mostrar alunos cadastrados
        System.out.println("Lista de alunos:");
        for (Aluno a : alunoManager.listarAlunos()) {
            System.out.println(a);
        }
    }
}
