package models;

/**
 * Representa a matrícula de um aluno em uma turma,
 * contendo dados de notas, frequência e situação.
 */
public class Matricula {
    private Aluno aluno;
    private Turma turma;

    // Notas
    private double p1;
    private double p2;
    private double p3;
    private double listas;
    private double seminario;

    // Frequência
    private int presencas;
    private int totalAulas;

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        this.presencas = 0;
        this.totalAulas = 0;
    }

    // Getters e setters
    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public double getP1() { return p1; }
    public void setP1(double p1) { this.p1 = p1; }

    public double getP2() { return p2; }
    public void setP2(double p2) { this.p2 = p2; }

    public double getP3() { return p3; }
    public void setP3(double p3) { this.p3 = p3; }

    public double getListas() { return listas; }
    public void setListas(double listas) { this.listas = listas; }

    public double getSeminario() { return seminario; }
    public void setSeminario(double seminario) { this.seminario = seminario; }

    public int getPresencas() { return presencas; }
    public void adicionarPresenca() { this.presencas++; }

    public int getTotalAulas() { return totalAulas; }
    public void adicionarAula() { this.totalAulas++; }

    // Calcular frequência em porcentagem
    public double calcularFrequencia() {
        if (totalAulas == 0) return 100.0;
        return (presencas * 100.0) / totalAulas;
    }

    // Calcular média
    public double calcularMedia() {
        if (aluno.isAlunoEspecial()) {
            return 0.0;
        }

        if (turma.getFormaAvaliacao().equals("1")) {
            return (p1 + p2 + p3 + listas + seminario) / 5.0;
        } else {
            return (p1 + (p2 * 2) + (p3 * 3) + listas + seminario) / 8.0;
        }
    }

    // Verificar situação final
    public String situacaoFinal() {
        double frequencia = calcularFrequencia();

        if (aluno.isAlunoEspecial()) {
            return (frequencia >= 75.0) ? "Aprovado (Frequência OK)" : "Reprovado (Falta)";
        }

        double media = calcularMedia();

        if (frequencia < 75.0) {
            return "Reprovado (Falta)";
        } else if (media >= 5.0) {
            return "Aprovado";
        } else {
            return "Reprovado (Nota)";
        }
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno.getNome() + 
               ", Turma: " + turma.getCodigoTurma() + 
               ", Média: " + calcularMedia() + 
               ", Frequência: " + calcularFrequencia() + "%" + 
               ", Situação: " + situacaoFinal();
    }
}
