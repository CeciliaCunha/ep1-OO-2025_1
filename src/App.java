import managers.*;
import models.*;

public class App {
    public static void main(String[] args) {
        // Instanciando os managers
        AlunoManager alunoManager = new AlunoManager();
        DisciplinaManager disciplinaManager = new DisciplinaManager();
        TurmaManager turmaManager = new TurmaManager();
        MatriculaManager matriculaManager = new MatriculaManager();
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

        // 🔹 Cadastrando alunos
        alunoManager.adicionarAluno("normal", "João Silva", "A001", "Engenharia");
        alunoManager.adicionarAluno("especial", "Maria Souza", "A002", "Computação");

        // 🔹 Cadastrando disciplinas
        disciplinaManager.adicionarDisciplina("Programação Orientada a Objetos", "POO001");

        // 🔹 Criando turma
        Disciplina disciplina = disciplinaManager.buscarDisciplina("POO001");
        turmaManager.adicionarTurma(disciplina, "TURMA1");

        // 🔹 Realizando matrícula
        Aluno aluno = alunoManager.buscarAluno("A001");
        Turma turma = turmaManager.buscarTurma("TURMA1");
        matriculaManager.realizarMatricula(aluno, turma);

        // 🔹 Lançando notas e frequência
        Matricula matricula = matriculaManager.buscarMatricula("A001", "TURMA1");
        avaliacaoManager.lancarNotas(matricula, 8.0, 7.5, 9.0, 10.0, 9.5);
        avaliacaoManager.lancarFrequencia(matricula, 90);

        // 🔹 Calculando média e avaliando situação
        avaliacaoManager.calcularMedia(matricula, "media");
        avaliacaoManager.avaliarSituacao(matricula);

        // 🔹 Exibindo dados
        System.out.println("\n===== Dados do Aluno =====");
        alunoManager.listarAlunos();

        System.out.println("\n===== Disciplinas =====");
        disciplinaManager.listarDisciplinas();

        System.out.println("\n===== Turmas =====");
        turmaManager.listarTurmas();

        System.out.println("\n===== Matrículas =====");
        matriculaManager.listarMatriculas();

        System.out.println("\n===== Avaliação =====");
        avaliacaoManager.exibirAvaliacao(matricula);
    }
}
