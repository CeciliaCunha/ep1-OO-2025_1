package models;

public class Matricula {
    private String matriculaAluno;
    private String codigoTurma;

    public Matricula() {}

    public Matricula(String matriculaAluno, String codigoTurma) {
        this.matriculaAluno = matriculaAluno;
        this.codigoTurma = codigoTurma;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String toCSVString() {
        return matriculaAluno + "," + codigoTurma;
    }

    public static Matricula fromCSVString(String csv) {
        String[] parts = csv.split(",");
        return new Matricula(parts[0], parts[1]);
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "matriculaAluno='" + matriculaAluno + '\'' +
                ", codigoTurma='" + codigoTurma + '\'' +
                '}';
    }
}
