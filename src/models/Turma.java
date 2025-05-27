package models;

/**
 * Representa uma turma de uma disciplina.
 */

public class Turma {
    private String codigoTurma;
    private String codigoDisciplina;
    private String professor;
    private String semestre;
    private String formaAvaliacao; 
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidadeMaxima;

    public Turma(String codigoDisciplina, String professor, String semestre, String formaAvaliacao, boolean presencial, String sala, String horario, int capacidadeMaxima){
        this.codigoTurma = codigoTurma;
        this.codigoDisciplina = codigoDisciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = sala;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getFormaAvaliacao() {
        return formaAvaliacao;
    }

    public boolean isPresencial() {
        return presencial;
    }

    public String getSala() {
        return sala;
    }

    public String getHorario() {
        return horario;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setFormaAvaliacao(String formaAvaliacao) {
        this.formaAvaliacao = formaAvaliacao;
    }

    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    @Override
    public String toString() {
        return "Turma: " + codigoTurma + "| Disciplina: " + codigoDisciplina + " | Professor: " + professor + 
            " | Semestre: " + semestre + " | Avaliacao: " + formaAvaliacao + " | " + (presencial ? "Presencial" : "Remota") 
            + " | Sala: " + sala + " | Horario: " + horario + " | Capacidade: " + capacidadeMaxima;
    }
}
