package models;

public class Avaliacao {
    private String matriculaAluno;
    private String codigoTurma;
    private double nota;
    private double presenca;

    public Avaliacao(String matriculaAluno, String codigoTurma) {
        this.matriculaAluno = matriculaAluno;
        this.codigoTurma = codigoTurma;
        this.nota = 0;
        this.presenca = 0;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPresenca() {
        return presenca;
    }

    public void setPresenca(double presenca) {
        this.presenca = presenca;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
               "matriculaAluno='" + matriculaAluno + '\'' +
               ", codigoTurma='" + codigoTurma + '\'' +
               ", nota=" + nota +
               ", presenca=" + presenca +
               '}';
    }
}
