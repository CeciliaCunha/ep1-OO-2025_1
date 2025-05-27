package models;

public class Matricula {
    private String idMatricula; // pode ser matricula+codigoTurma para simplificar
    private String matriculaAluno;
    private String codigoTurma;
    private boolean trancada;

    public Matricula(String idMatricula, String matriculaAluno, String codigoTurma) {
        this.idMatricula = idMatricula;
        this.matriculaAluno = matriculaAluno;
        this.codigoTurma = codigoTurma;
        this.trancada = false;
    }

    public String getIdMatricula() { return idMatricula; }
    public String getMatriculaAluno() { return matriculaAluno; }
    public String getCodigoTurma() { return codigoTurma; }
    public boolean isTrancada() { return trancada; }

    public void setTrancada(boolean trancada) { this.trancada = trancada; }

    // CSV: idMatricula,matriculaAluno,codigoTurma,trancada
    public String toCSV() {
        return idMatricula + "," + matriculaAluno + "," + codigoTurma + "," + trancada;
    }

    public static Matricula fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length < 4) return null;
        String id = parts[0];
        String matriculaAluno = parts[1];
        String codigoTurma = parts[2];
        boolean trancada = Boolean.parseBoolean(parts[3]);
        Matricula m = new Matricula(id, matriculaAluno, codigoTurma);
        m.setTrancada(trancada);
        return m;
    }
}
