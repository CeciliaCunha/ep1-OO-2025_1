import managers.AlunoManager;
import managers.DisciplinaManager;
import managers.AvaliacaoManager;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    private static AlunoManager alunoManager = new AlunoManager();
    private static DisciplinaManager disciplinaManager = new DisciplinaManager();
    private static AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    modoAluno();
                    break;
                case 2:
                    modoDisciplinaTurma();
                    break;
                case 3:
                    modoAvaliacaoFrequencia();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Sistema Acadêmico FCTE ===");
        System.out.println("1 - Modo Aluno (Normal e Especial)");
        System.out.println("2 - Modo Disciplina/Turma");
        System.out.println("3 - Modo Avaliação/Frequência");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void modoAluno() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Modo Aluno --");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Matricular aluno");
            System.out.println("4 - Trancar disciplina/semestre");
            System.out.println("5 - Salvar dados");
            System.out.println("6 - Carregar dados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    alunoManager.cadastrarAluno(scanner);
                    break;
                case 2:
                    alunoManager.listarAlunos();
                    break;
                case 3:
                    alunoManager.matricularAluno(scanner);
                    break;
                case 4:
                    alunoManager.trancarDisciplinaOuSemestre(scanner);
                    break;
                case 5:
                    alunoManager.salvarDados();
                    break;
                case 6:
                    alunoManager.carregarDados();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void modoDisciplinaTurma() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Modo Disciplina/Turma --");
            System.out.println("1 - Cadastrar disciplina");
            System.out.println("2 - Criar turma");
            System.out.println("3 - Listar turmas");
            System.out.println("4 - Listar alunos por turma");
            System.out.println("5 - Salvar dados");
            System.out.println("6 - Carregar dados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    disciplinaManager.cadastrarDisciplina(scanner);
                    break;
                case 2:
                    disciplinaManager.criarTurma(scanner);
                    break;
                case 3:
                    disciplinaManager.listarTurmas();
                    break;
                case 4:
                    disciplinaManager.listarAlunosPorTurma(scanner);
                    break;
                case 5:
                    disciplinaManager.salvarDados();
                    break;
                case 6:
                    disciplinaManager.carregarDados();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void modoAvaliacaoFrequencia() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Modo Avaliação/Frequência --");
            System.out.println("1 - Lançar notas e presença");
            System.out.println("2 - Exibir relatório por turma");
            System.out.println("3 - Exibir relatório por disciplina");
            System.out.println("4 - Exibir relatório por professor");
            System.out.println("5 - Exibir boletim do aluno");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    avaliacaoManager.lancarNotasFrequencia(scanner);
                    break;
                case 2:
                    avaliacaoManager.relatorioPorTurma(scanner);
                    break;
                case 3:
                    avaliacaoManager.relatorioPorDisciplina(scanner);
                    break;
                case 4:
                    avaliacaoManager.relatorioPorProfessor(scanner);
                    break;
                case 5:
                    avaliacaoManager.exibirBoletim(scanner);
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
import managers.AlunoManager;
import managers.DisciplinaManager;
import managers.AvaliacaoManager;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    private static AlunoManager alunoManager = new AlunoManager();
    private static DisciplinaManager disciplinaManager = new DisciplinaManager();
    private static AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

    public static void main(String[] args) {
        boolean rodando = true;

        while (rodando) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    modoAluno();
                    break;
                case 2:
                    modoDisciplinaTurma();
                    break;
                case 3:
                    modoAvaliacaoFrequencia();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até logo!");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n=== Sistema Acadêmico FCTE ===");
        System.out.println("1 - Modo Aluno (Normal e Especial)");
        System.out.println("2 - Modo Disciplina/Turma");
        System.out.println("3 - Modo Avaliação/Frequência");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void modoAluno() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Modo Aluno --");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Matricular aluno");
            System.out.println("4 - Trancar disciplina/semestre");
            System.out.println("5 - Salvar dados");
            System.out.println("6 - Carregar dados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    alunoManager.cadastrarAluno(scanner);
                    break;
                case 2:
                    alunoManager.listarAlunos();
                    break;
                case 3:
                    alunoManager.matricularAluno(scanner);
                    break;
                case 4:
                    alunoManager.trancarDisciplinaOuSemestre(scanner);
                    break;
                case 5:
                    alunoManager.salvarDados();
                    break;
                case 6:
                    alunoManager.carregarDados();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void modoDisciplinaTurma() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Modo Disciplina/Turma --");
            System.out.println("1 - Cadastrar disciplina");
            System.out.println("2 - Criar turma");
            System.out.println("3 - Listar turmas");
            System.out.println("4 - Listar alunos por turma");
            System.out.println("5 - Salvar dados");
            System.out.println("6 - Carregar dados");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    disciplinaManager.cadastrarDisciplina(scanner);
                    break;
                case 2:
                    disciplinaManager.criarTurma(scanner);
                    break;
                case 3:
                    disciplinaManager.listarTurmas();
                    break;
                case 4:
                    disciplinaManager.listarAlunosPorTurma(scanner);
                    break;
                case 5:
                    disciplinaManager.salvarDados();
                    break;
                case 6:
                    disciplinaManager.carregarDados();
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void modoAvaliacaoFrequencia() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n-- Modo Avaliação/Frequência --");
            System.out.println("1 - Lançar notas e presença");
            System.out.println("2 - Exibir relatório por turma");
            System.out.println("3 - Exibir relatório por disciplina");
            System.out.println("4 - Exibir relatório por professor");
            System.out.println("5 - Exibir boletim do aluno");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    avaliacaoManager.lancarNotasFrequencia(scanner);
                    break;
                case 2:
                    avaliacaoManager.relatorioPorTurma(scanner);
                    break;
                case 3:
                    avaliacaoManager.relatorioPorDisciplina(scanner);
                    break;
                case 4:
                    avaliacaoManager.relatorioPorProfessor(scanner);
                    break;
                case 5:
                    avaliacaoManager.exibirBoletim(scanner);
                    break;
                case 0:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
