package models;

public class Turma {
    private String codigoDisciplina;
    private String professor;
    private String semestre;
    private int formaAvaliacao; // 1 ou 2
    private boolean presencial;
    private String sala; // se remota, pode ser null ou ""
    private String horario;
    private int capacidadeMaxima;

    public Turma() {}

    public Turma(String codigoDisciplina, String professor, String semestre, int formaAvaliacao,
                 boolean presencial, String sala, String horario, int capacidadeMaxima) {
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

    public int getFormaAvaliacao() {
        return formaAvaliacao;
    }

    public void setFormaAvaliacao(int formaAvaliacao) {
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

    public String toCSVString() {
        return codigoDisciplina + "," + professor + "," + semestre + "," + formaAvaliacao + "," +
                presencial + "," + (sala == null ? "" : sala) + "," + horario + "," + capacidadeMaxima;
    }

    public static Turma fromCSVString(String csv) {
        String[] parts = csv.split(",", 8);
        String codigoDisciplina = parts[0];
        String professor = parts[1];
        String semestre = parts[2];
        int formaAvaliacao = Integer.parseInt(parts[3]);
        boolean presencial = Boolean.parseBoolean(parts[4]);
        String sala = parts[5].isEmpty() ? null : parts[5];
        String horario = parts[6];
        int capacidadeMaxima = Integer.parseInt(parts[7]);

        return new Turma(codigoDisciplina, professor, semestre, formaAvaliacao, presencial, sala, horario, capacidadeMaxima);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "codigoDisciplina='" + codigoDisciplina + '\'' +
                ", professor='" + professor + '\'' +
                ", semestre='" + semestre + '\'' +
                ", formaAvaliacao=" + formaAvaliacao +
                ", presencial=" + presencial +
                ", sala='" + sala + '\'' +
                ", horario='" + horario + '\'' +
                ", capacidadeMaxima=" + capacidadeMaxima +
                '}';
    }
}

