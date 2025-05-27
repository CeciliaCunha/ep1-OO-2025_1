package models;

public class Turma {
    private Disciplina disciplina;
    private String codigoTurma;

    public Turma(Disciplina disciplina, String codigoTurma) {
        this.disciplina = disciplina;
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }
}
