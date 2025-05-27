import managers.*;
import models.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // Cria managers
        AlunoManager alunoManager = new AlunoManager();
        DisciplinaManager disciplinaManager = new DisciplinaManager();
        TurmaManager turmaManager = new TurmaManager();
        MatriculasManager matriculasManager = new MatriculasManager();

        // Cria algumas disciplinas com pré-requisitos
        Disciplina d1 = new Disciplina("Matemática Básica", "MAT101", 60, new ArrayList<>());
        Disciplina d2 = new Disciplina("Cálculo I", "MAT102", 60, Arrays.asList("MAT101"));
        Disciplina d3 = new Disciplina("Física I", "FIS101", 60, new ArrayList<>());

        disciplinaManager.adicionarDisciplina(d1);
        disciplinaManager.adicionarDisciplina(d2);
        disciplinaManager.adicionarDisciplina(d3);

        // Cria turmas para as disciplinas
        Turma t1 = new Turma(d1, "TURMA1", "MAT101", "Prof. Silva", "2025/1", "1", true, "Sala 101", "08:00", 2);
        Turma t2 = new Turma(d2, "TURMA2", "MAT102", "Prof. Costa", "2025/1", "1", true, "Sala 102", "10:00", 2);
        Turma t3 = new Turma(d3, "TURMA3", "FIS101", "Prof. Souza", "2025/1", "1", true, "Sala 103", "14:00", 2);

        turmaManager.adicionarTurma(t1);
        turmaManager.adicionarTurma(t2);
        turmaManager.adicionarTurma(t3);

        // Cria alunos
        Aluno a1 = new Aluno("João", "123", "Engenharia");
        AlunoEspecial a2 = new AlunoEspecial("Maria", "456", "Engenharia");

        alunoManager.adicionarAluno(a1);
        alunoManager.adicionarAluno(a2);

        // Aluno João já cursou MAT101, para simular pré-requisito cumprido
        a1.getMatriculas().add(new Matricula(a1, t1));
        a1.atualizarDisciplinasCursadas();

        try {
            // Matricular João em Cálculo I (que tem pré-requisito MAT101)
            matriculasManager.matricularAluno(a1, t2, disciplinaManager.listarDisciplinas());

            // Matricular Maria (AlunoEspecial) na Física I
            matriculasManager.matricularAluno(a2, t3, disciplinaManager.listarDisciplinas());

            // Testar trancamento de disciplina
            matriculasManager.trancarDisciplina(a1, "MAT102");

            // Listar alunos matriculados na turma 2
            System.out.println("Alunos na turma " + t2.getCodigoTurma() + ":");
            for (Matricula m : t2.getMatriculas()) {
                System.out.println(m);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Listar todos alunos
        System.out.println("\nLista de alunos:");
        for (Aluno aluno : alunoManager.listarAlunos()) {
            System.out.println(aluno);
        }

        // Listar todas disciplinas
        System.out.println("\nLista de disciplinas:");
        for (Disciplina disc : disciplinaManager.listarDisciplinas()) {
            System.out.println(disc);
        }

        // Listar turmas por disciplina
        System.out.println("\nTurmas da disciplina MAT102:");
        for (Turma turma : turmaManager.buscarPorCodigoDisciplina("MAT102")) {
            System.out.println(turma);
        }
    }
}
