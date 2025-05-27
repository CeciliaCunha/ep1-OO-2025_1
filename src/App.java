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
        alunoManager.adicionarAluno(new AlunoNormal("A001", "João Silva", "Engenharia"));
        alunoManager.adicionarAluno(new AlunoEspecial("A002", "Maria Souza", "Computação"));

        // 🔹 Cadastrando disciplinas
        disciplinaManager.adicionarDisciplina(new Disciplina("POO001", "Programação Orientada a Objetos"));

        // 🔹 Criando turma
        Disciplina disciplina = disciplinaManager.buscarDisciplinaPorCodigo("POO001");
        if (disciplina != null) {
            turmaManager.adicionarTurma(new Turma("TURMA1", disciplina.getCodigo()));
        } else {
            System.out.println("Disciplina não encontrada para criar turma.");
            return;
        }

        // 🔹 Realizando matrícula
        Aluno aluno = alunoManager.buscarAlunoPorMatricula("A001");
        Turma turma = turmaManager.buscarTurmaPorCodigo("TURMA1");

        if (aluno != null && turma != null) {
            matriculaManager.adicionarMatricula(new Matricula(aluno.getMatricula(), turma.getCodigoDisciplina()));
        } else {
            System.out.println("Aluno ou Turma não encontrado para matrícula.");
            return;
        }

        // 🔹 Lançando notas e frequência
        Matricula matricula = matriculaManager.buscarPorAluno("A001").stream()
                .filter(m -> m.getCodigoTurma().equals("TURMA1"))
                .findFirst()
                .orElse(null);

        if (matricula != null) {
            // Criando Avaliação para a matrícula
            Avaliacao avaliacao = new Avaliacao(8.0, 7.5, 9.0, 10.0, 9.5, 90, "");
            avaliacaoManager.adicionarAvaliacao(avaliacao);

            // Aqui você pode fazer chamadas para calcular média e status, se quiser
            // Por exemplo, calcular média simples
            double media = (avaliacao.getP1() + avaliacao.getP2() + avaliacao.getP3() + avaliacao.getListas() + avaliacao.getSeminario()) / 5.0;

            String status = media >= 7.0 && avaliacao.getFrequencia() >= 75 ? "Aprovado" : "Reprovado";
            avaliacao.setStatus(status);

            // Exibir avaliação
            System.out.println("\n===== Avaliação =====");
            System.out.println(avaliacao);
        } else {
            System.out.println("Matrícula não encontrada para lançamento de avaliação.");
        }

        // 🔹 Exibindo dados
        System.out.println("\n===== Dados dos Alunos =====");
        for (Aluno a : alunoManager.getAlunos()) {
            System.out.println(a);
        }

        System.out.println("\n===== Disciplinas =====");
        for (Disciplina d : disciplinaManager.getDisciplinas()) {
            System.out.println(d);
        }

        System.out.println("\n===== Turmas =====");
        for (Turma t : turmaManager.getTurmas()) {
            System.out.println(t);
        }

        System.out.println("\n===== Matrículas =====");
        for (Matricula m : matriculaManager.getMatriculas()) {
            System.out.println(m);
        }
    }
}
