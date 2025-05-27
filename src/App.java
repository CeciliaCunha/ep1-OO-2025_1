import managers.AlunoManager;
import managers.DisciplinaManager;
import managers.TurmaManager;

import models.Aluno;
import models.Disciplina;
import models.Turma;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // ----- Alunos -----
        AlunoManager alunoManager = new AlunoManager();

        Aluno aluno1 = new Aluno("Ana", "2025001", "Engenharia");
        Aluno aluno2 = new Aluno("Bruno", "2025002", "Computacao");

        alunoManager.adicionarAluno(aluno1);
        alunoManager.adicionarAluno(aluno2);

        System.out.println("\n--- Lista de Alunos ---");
        for(Aluno a : alunoManager.listarAlunos()) {
            System.out.println(a);
        }

        // ----- Disciplinas -----
        DisciplinaManager disciplinaManager = new DisciplinaManager();

        Disciplina disciplina1 = new Disciplina(
            "Programacao orientada a objetos",
            "POO101",
            60,
            Arrays.asList() 
        );
        
        disciplinaManager.adicionarDisciplina(disciplina1);

        System.out.println("\n--- Lista de Disciplinas ---");
        for(Disciplina d : disciplinaManager.listarDisciplinas()) {
            System.out.println(d);
        }

        // ----- Turmas -----
        TurmaManager turmaManager = new TurmaManager();
        
        Turma turma1 = new Turma(
            "POO0101",
            "Prof. Lucas",
            "2025.1",
            "Prova e Projeto",
            true,
            "Sala 101",
            "Segunda 10h",
            40
        );

        turmaManager.adicionarTurma(turma1);

        System.out.println("\n--- Lista de Turmas ---");
        for(Turma t : turmaManager.listarTurmas()) {
            System.out.println(t);
        }
    }
}
