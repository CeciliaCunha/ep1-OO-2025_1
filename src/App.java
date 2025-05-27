import models.*;
import managers.*;

import java.util.*;

public class App {
    private static Scanner sc = new Scanner(System.in);

    private static AlunoManager alunoManager = new AlunoManager();
    private static DisciplinaManager disciplinaManager = new DisciplinaManager();
    private static TurmaManager turmaManager = new TurmaManager();
    private static MatriculaManager matriculaManager = new MatriculaManager();
    private static AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

    public static void main(String[] args) {
        int op;
        do {
            op = menuPrincipal();
            switch (op) {
                case 1: menuAlunos(); break;
                case 2: menuDisciplinas(); break;
                case 3: menuTurmas(); break;
                case 4: menuMatriculas(); break;
                case 5: menuAvaliacoes(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static int menuPrincipal() {
        System.out.println("\n=== Sistema de Gestão Acadêmica ===");
        System.out.println("1. Gerenciar Alunos");
        System.out.println("2. Gerenciar Disciplinas");
        System.out.println("3. Gerenciar Turmas");
        System.out.println("4. Gerenciar Matrículas");
        System.out.println("5. Gerenciar Avaliações");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
        return lerInt();
    }

    private static void menuAlunos() {
        int op;
        do {
            System.out.println("\n--- Menu Alunos ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Consultar Aluno");
            System.out.println("3. Listar Alunos");
            System.out.println("4. Remover Aluno");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1: cadastrarAluno(); break;
                case 2: consultarAluno(); break;
                case 3: listarAlunos(); break;
                case 4: removerAluno(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void cadastrarAluno() {
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine().trim();
        if (alunoManager.buscarAluno(matricula) != null) {
            System.out.println("Aluno já cadastrado.");
            return;
        }
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("Tipo (1 = Normal, 2 = Especial): ");
        int tipo = lerInt();
        Aluno aluno;
        if (tipo == 2) {
            System.out.print("Descrição da Especialidade: ");
            String desc = sc.nextLine().trim();
            aluno = new AlunoEspecial(matricula, nome, desc);
        } else {
            aluno = new AlunoNormal(matricula, nome);
        }
        if (alunoManager.adicionarAluno(aluno)) {
            System.out.println("Aluno cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar aluno.");
        }
    }

    private static void consultarAluno() {
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine().trim();
        Aluno a = alunoManager.buscarAluno(matricula);
        if (a == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        System.out.println(a);
    }

    private static void listarAlunos() {
        List<Aluno> lista = alunoManager.listarAlunos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : lista) {
            System.out.println(a);
        }
    }

    private static void removerAluno() {
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine().trim();
        if (alunoManager.removerAluno(matricula)) {
            System.out.println("Aluno removido.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void menuDisciplinas() {
        int op;
        do {
            System.out.println("\n--- Menu Disciplinas ---");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Consultar Disciplina");
            System.out.println("3. Listar Disciplinas");
            System.out.println("4. Remover Disciplina");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1: cadastrarDisciplina(); break;
                case 2: consultarDisciplina(); break;
                case 3: listarDisciplinas(); break;
                case 4: removerDisciplina(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void cadastrarDisciplina() {
        System.out.print("Código: ");
        String codigo = sc.nextLine().trim();
        if (disciplinaManager.buscarDisciplina(codigo) != null) {
            System.out.println("Disciplina já cadastrada.");
            return;
        }
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        Disciplina d = new Disciplina(codigo, nome);
        if (disciplinaManager.adicionarDisciplina(d)) {
            System.out.println("Disciplina cadastrada.");
        } else {
            System.out.println("Erro ao cadastrar disciplina.");
        }
    }

    private static void consultarDisciplina() {
        System.out.print("Código: ");
        String codigo = sc.nextLine().trim();
        Disciplina d = disciplinaManager.buscarDisciplina(codigo);
        if (d == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }
        System.out.println(d);
    }

    private static void listarDisciplinas() {
        List<Disciplina> lista = disciplinaManager.listarDisciplinas();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        for (Disciplina d : lista) {
            System.out.println(d);
        }
    }

    private static void removerDisciplina() {
        System.out.print("Código: ");
        String codigo = sc.nextLine().trim();
        if (disciplinaManager.removerDisciplina(codigo)) {
            System.out.println("Disciplina removida.");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void menuTurmas() {
        int op;
        do {
            System.out.println("\n--- Menu Turmas ---");
            System.out.println("1. Cadastrar Turma");
            System.out.println("2. Consultar Turma");
            System.out.println("3. Listar Turmas");
            System.out.println("4. Remover Turma");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1: cadastrarTurma(); break;
                case 2: consultarTurma(); break;
                case 3: listarTurmas(); break;
                case 4: removerTurma(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void cadastrarTurma() {
        System.out.print("Código da Turma: ");
        String codigoTurma = sc.nextLine().trim();
        if (turmaManager.buscarTurma(codigoTurma) != null) {
            System.out.println("Turma já cadastrada.");
            return;
        }
        System.out.print("Código da Disciplina: ");
        String codigoDisciplina = sc.nextLine().trim();
        if (disciplinaManager.buscarDisciplina(codigoDisciplina) == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }
        Turma t = new Turma(codigoTurma, codigoDisciplina);
        if (turmaManager.adicionarTurma(t)) {
            System.out.println("Turma cadastrada.");
        } else {
            System.out.println("Erro ao cadastrar turma.");
        }
    }

    private static void consultarTurma() {
        System.out.print("Código da Turma: ");
        String codigoTurma = sc.nextLine().trim();
        Turma t = turmaManager.buscarTurma(codigoTurma);
        if (t == null) {
            System.out.println("Turma não encontrada.");
            return;
        }
        System.out.println(t);
    }

    private static void listarTurmas() {
        List<Turma> lista = turmaManager.listarTurmas();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }
        for (Turma t : lista) {
            System.out.println(t);
        }
    }

    private static void removerTurma() {
        System.out.print("Código da Turma: ");
        String codigoTurma = sc.nextLine().trim();
        if (turmaManager.removerTurma(codigoTurma)) {
            System.out.println("Turma removida.");
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void menuMatriculas() {
        int op;
        do {
            System.out.println("\n--- Menu Matrículas ---");
            System.out.println("1. Cadastrar Matrícula");
            System.out.println("2. Consultar Matrícula");
            System.out.println("3. Listar Matrículas");
            System.out.println("4. Remover Matrícula");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1: cadastrarMatricula(); break;
                case 2: consultarMatricula(); break;
                case 3: listarMatriculas(); break;
                case 4: removerMatricula(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void cadastrarMatricula() {
        System.out.print("ID da Matrícula: ");
        String idMatricula = sc.nextLine().trim();
        if (matriculaManager.buscarMatricula(idMatricula) != null) {
            System.out.println("Matrícula já cadastrada.");
            return;
        }
        System.out.print("Matrícula do Aluno: ");
        String matriculaAluno = sc.nextLine().trim();
        if (alunoManager.buscarAluno(matriculaAluno) == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }
        System.out.print("Código da Turma: ");
        String codigoTurma = sc.nextLine().trim();
        if (turmaManager.buscarTurma(codigoTurma) == null) {
            System.out.println("Turma não encontrada.");
            return;
        }
        Matricula m = new Matricula(idMatricula, matriculaAluno, codigoTurma);
        if (matriculaManager.adicionarMatricula(m)) {
            System.out.println("Matrícula cadastrada.");
        } else {
            System.out.println("Erro ao cadastrar matrícula.");
        }
    }

    private static void consultarMatricula() {
        System.out.print("ID da Matrícula: ");
        String idMatricula = sc.nextLine().trim();
        Matricula m = matriculaManager.buscarMatricula(idMatricula);
        if (m == null) {
            System.out.println("Matrícula não encontrada.");
            return;
        }
        System.out.println(m);
    }

    private static void listarMatriculas() {
        List<Matricula> lista = matriculaManager.listarMatriculas();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma matrícula cadastrada.");
            return;
        }
        for (Matricula m : lista) {
            System.out.println(m);
        }
    }

    private static void removerMatricula() {
        System.out.print("ID da Matrícula: ");
        String idMatricula = sc.nextLine().trim();
        if (matriculaManager.removerMatricula(idMatricula)) {
            System.out.println("Matrícula removida.");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }

    private static void menuAvaliacoes() {
        int op;
        do {
            System.out.println("\n--- Menu Avaliações ---");
            System.out.println("1. Cadastrar Avaliação");
            System.out.println("2. Consultar Avaliação");
            System.out.println("3. Listar Avaliações");
            System.out.println("4. Remover Avaliação");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1: cadastrarAvaliacao(); break;
                case 2: consultarAvaliacao(); break;
                case 3: listarAvaliacoes(); break;
                case 4: removerAvaliacao(); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    private static void cadastrarAvaliacao() {
        System.out.print("ID da Avaliação: ");
        String idAvaliacao = sc.nextLine().trim();
        if (avaliacaoManager.buscarAvaliacao(idAvaliacao) != null) {
            System.out.println("Avaliação já cadastrada.");
            return;
        }
        System.out.print("ID da Matrícula: ");
        String idMatricula = sc.nextLine().trim();
        if (matriculaManager.buscarMatricula(idMatricula) == null) {
            System.out.println("Matrícula não encontrada.");
            return;
        }
        System.out.print("Nota: ");
        double nota = lerDouble();
        Avaliacao a = new Avaliacao(idAvaliacao, idMatricula, nota);
        if (avaliacaoManager.adicionarAvaliacao(a)) {
            System.out.println("Avaliação cadastrada.");
        } else {
            System.out.println("Erro ao cadastrar avaliação.");
        }
    }

    private static void consultarAvaliacao() {
        System.out.print("ID da Avaliação: ");
        String idAvaliacao = sc.nextLine().trim();
        Avaliacao a = avaliacaoManager.buscarAvaliacao(idAvaliacao);
        if (a == null) {
            System.out.println("Avaliação não encontrada.");
            return;
        }
        System.out.println(a);
    }

    private static void listarAvaliacoes() {
        List<Avaliacao> lista = avaliacaoManager.listarAvaliacoes();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma avaliação cadastrada.");
            return;
        }
        for (Avaliacao a : lista) {
            System.out.println(a);
        }
    }

    private static void removerAvaliacao() {
        System.out.print("ID da Avaliação: ");
        String idAvaliacao = sc.nextLine().trim();
        if (avaliacaoManager.removerAvaliacao(idAvaliacao)) {
            System.out.println("Avaliação removida.");
        } else {
            System.out.println("Avaliação não encontrada.");
        }
    }

    private static int lerInt() {
        while (true) {
            try {
                String linha = sc.nextLine();
                return Integer.parseInt(linha.trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                String linha = sc.nextLine();
                return Double.parseDouble(linha.trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número decimal: ");
            }
        }
    }
}

