package models;

public class Turma {
    private String codigo;
    private String codigoDisciplina;
    private int vagas;
    private int matriculados;

    public Turma(String codigo, String codigoDisciplina, int vagas) {
        this.codigo = codigo;
        this.codigoDisciplina = codigoDisciplina;
        this.vagas = vagas;
        this.matriculados = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public int getVagas() {
        return vagas;
    }

    public int getMatriculados() {
        return matriculados;
    }

    public void setMatriculados(int matriculados) {
        this.matriculados = matriculados;
    }

    @Override
    public String toString() {
        return "Turma{" +
               "codigo='" + codigo + '\'' +
               ", codigoDisciplina='" + codigoDisciplina + '\'' +
               ", vagas=" + vagas +
               ", matriculados=" + matriculados +
               '}';
    }
}
