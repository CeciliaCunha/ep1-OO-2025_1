package models;

public class Matricula {
    private String matriculaAluno;
    private String codigoTurma;

    public Matricula(String matriculaAluno, String codigoTurma) {
        this.matriculaAluno = matriculaAluno;
        this.codigoTurma = codigoTurma;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    @Override
    public String toString() {
        return "Matricula{" +
               "matriculaAluno='" + matriculaAluno + '\'' +
               ", codigoTurma='" + codigoTurma + '\'' +
               '}';
    }
}
