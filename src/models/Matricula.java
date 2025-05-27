package models;

public class Matricula {
    private Aluno aluno;
    private Turma turma;
    private boolean trancada;
    private Avaliacao avaliacao;

    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        this.trancada = false;
        this.avaliacao = new Avaliacao(aluno.recebeNotas());
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public boolean isTrancada() {
        return trancada;
    }

    public void setTrancada(boolean trancada) {
        this.trancada = trancada;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return aluno.getNome() + " matriculado na " + turma.getDisciplina().getCodigo() + " (" + turma.getSemestre() + ")" + (trancada ? " [Trancada]" : "");
    }
}
