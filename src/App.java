import managers.*;
import models.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AlunoManager alunoManager = new AlunoManager();
        DisciplinaManager disciplinaManager = new DisciplinaManager();
        TurmaManager turmaManager = new TurmaManager();
        MatriculaManager matriculaManager = new MatriculaManager();
        AvaliacaoManager avaliacaoManager = new AvaliacaoManager();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Disciplina");
            System.out.println("3. Cadastrar Turma");
            System.out.println("4. Matricular Aluno");
            System.out.println("5. Lancar Avaliacao");
            System.out.println("6. Listar Alunos");
            System.out.println("7. Listar Disciplinas");
            System.out.println("8. Listar Turmas");
            System.out.println("9. Listar Matriculas");
            System.out.println("10. Listar Avaliacoes");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Opcao invalida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Matricula: ");
                    String matricula = sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Aluno especial? (true/false): ");
                    boolean especial = Boolean.parseBoolean(sc.nextLine());
                    alunoManager.cadastrarAluno(matricula, nome, especial);
                    break;

                case 2:
                    System.out.print("Codigo da disciplina: ");
                    String codigoDisc = sc.nextLine();
                    System.out.print("Nome da disciplina: ");
                    String nomeDisc = sc.nextLine();
                    disciplinaManager.cadastrarDisciplina(codigoDisc, nomeDisc);
                    break;

                case 3:
                    System.out.print("Codigo da turma: ");
                    String codigoTurma = sc.nextLine();
                    System.out.print("Codigo da disciplina: ");
                    String codigoDiscTurma = sc.nextLine();
                    if (!disciplinaManager.existe(codigoDiscTurma)) {
                        System.out.println("Disciplina nao existe.");
                        break;
                    }
                    System.out.print("Numero de vagas: ");
                    int vagas = Integer.parseInt(sc.nextLine());
                    turmaManager.cadastrarTurma(codigoTurma, codigoDiscTurma, vagas);
                    break;

                case 4:
                    System.out.print("Matricula do aluno: ");
                    String matAluno = sc.nextLine();
                    if (!alunoManager.existe(matAluno)) {
                        System.out.println("Aluno nao existe.");
                        break;
                    }
                    System.out.print("Codigo da turma: ");
                    String codTurma = sc.nextLine();
                    if (!turmaManager.existe(codTurma)) {
                        System.out.println("Turma nao existe.");
                        break;
                    }
                    if (!turmaManager.temVaga(codTurma)) {
                        System.out.println("Nao ha vagas na turma.");
                        break;
                    }
                    int qtMat = matriculaManager.contarMatriculasDoAluno(matAluno);
                    if (alunoManager.ehEspecial(matAluno) && qtMat >= 8) {
                        System.out.println("Aluno especial atingiu limite de matriculas (8).");
                        break;
                    }
                    if (!alunoManager.ehEspecial(matAluno) && qtMat >= 6) {
                        System.out.println("Aluno normal atingiu limite de matriculas (6).");
                        break;
                    }
                    matriculaManager.cadastrarMatricula(matAluno, codTurma);
                    turmaManager.incrementarMatriculas(codTurma);
                    System.out.println("Aluno matriculado com sucesso.");
                    break;

                case 5:
                    System.out.print("Matricula do aluno: ");
                    String matAlunoAv = sc.nextLine();
                    System.out.print("Codigo da turma: ");
                    String codTurmaAv = sc.nextLine();
                    Avaliacao a = avaliacaoManager.buscarPorMatricula(matAlunoAv, codTurmaAv);
                    if (a == null) {
                        a = new Avaliacao(matAlunoAv, codTurmaAv);
                    }
                    System.out.print("Nota: ");
                    double nota = Double.parseDouble(sc.nextLine());
                    a.setNota(nota);
                    System.out.print("Presenca (%): ");
                    double presenca = Double.parseDouble(sc.nextLine());
                    a.setPresenca(presenca);
                    avaliacaoManager.adicionarOuAtualizar(a);
                    break;

                case 6:
                    alunoManager.listarAlunos();
                    break;

                case 7:
                    disciplinaManager.listarDisciplinas();
                    break;

                case 8:
                    turmaManager.listarTurmas();
                    break;

                case 9:
                    matriculaManager.listarMatriculas();
                    break;

                case 10:
                    avaliacaoManager.listarAvaliacoes();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }
        sc.close();
    }
}
