package models;

public class Turma {
    private String codigoTurma; // Ex: DISC01-2025-1
    private String codigoDisciplina;
    private String professor;
    private String semestre;
    private int tipoAvaliacao; // 1 ou 2 (definido na descrição)
    private boolean presencial;
    private String sala; // vazio se remoto
    private String horario;
    private int capacidade;

    public Turma(String codigoTurma, String codigoDisciplina, String professor,
                 String semestre, int tipoAvaliacao, boolean presencial,
                 String sala, String horario, int capacidade) {
        this.codigoTurma = codigoTurma;
        this.codigoDisciplina = codigoDisciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.tipoAvaliacao = tipoAvaliacao;
        this.presencial = presencial;
        this.sala = sala;
        this.horario = horario;
        this.capacidade = capacidade;
    }

    public String getCodigoTurma() { return codigoTurma; }
    public String getCodigoDisciplina() { return codigoDisciplina; }
    public String getProfessor() { return professor; }
    public String getSemestre() { return semestre; }
    public int getTipoAvaliacao() { return tipoAvaliacao; }
    public boolean isPresencial() { return presencial; }
    public String getSala() { return sala; }
    public String getHorario() { return horario; }
    public int getCapacidade() { return capacidade; }

    public void setProfessor(String professor) { this.professor = professor; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public void setTipoAvaliacao(int tipo) { this.tipoAvaliacao = tipo; }
    public void setPresencial(boolean presencial) { this.presencial = presencial; }
    public void setSala(String sala) { this.sala = sala; }
    public void setHorario(String horario) { this.horario = horario; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    // CSV: codigoTurma,codigoDisciplina,professor,semestre,tipoAvaliacao,presencial,sala,horario,capacidade
    public String toCSV() {
        return codigoTurma + "," + codigoDisciplina + "," + professor + "," + semestre + "," +
                tipoAvaliacao + "," + presencial + "," + (sala==null ? "" : sala) + "," + horario + "," + capacidade;
    }

    public static Turma fromCSV(String csvLine) {
        String[] parts = csvLine.split(",", -1);
        if (parts.length < 9) return null;
        String codigoTurma = parts[0];
        String codigoDisciplina = parts[1];
        String professor = parts[2];
        String semestre = parts[3];
        int tipoAvaliacao = Integer.parseInt(parts[4]);
        boolean presencial = Boolean.parseBoolean(parts[5]);
        String sala = parts[6].isEmpty() ? null : parts[6];
        String horario = parts[7];
        int capacidade = Integer.parseInt(parts[8]);
        return new Turma(codigoTurma, codigoDisciplina, professor, semestre, tipoAvaliacao,
                presencial, sala, horario, capacidade);
    }
}
