package models;

public class Turma {
    private String codigoDisciplina;
    private String professor;
    private String semestre;
    private String formaAvaliacao; 
    private boolean presencial;
    private String sala;
    private String horario;
    private int capacidadeMaxima;

    public Turma(String codigoDisciplina, String professor, String semestre, String formaAvaliacao, boolean presencial, String sala, String horario, int capacidadeMaxima){
        this.codigoDisciplina = codigoDisciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = sala;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getFormaAvaliacao() {
        return formaAvaliacao;
    }
    public void setFormaAvaliacao(String formaAvaliacao) {
        this.formaAvaliacao = formaAvaliacao;
    }

    public boolean isPresencial() {
        return presencial;
    }
    public void setPresencial(boolean presencial) {
        this.presencial = presencial;
    }

    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    @Override
    public String toString() {
        return "Turma da disciplina " + codigoDisciplina + ", Professor: " + professor + ", Semestre: " + semestre +
               ", Avaliação: " + formaAvaliacao + ", " + (presencial ? "Presencial" : "Remota") +
               ", Sala: " + sala + ", Horário: " + horario + ", Capacidade: " + capacidadeMaxima;
    }
}
