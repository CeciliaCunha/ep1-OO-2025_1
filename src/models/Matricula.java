package models;

public class Matricula {
    private Aluno aluno;
    private Turma turma;
    private Avaliacao avaliacao;

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        this.avaliacao = new Avaliacao();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }
}
