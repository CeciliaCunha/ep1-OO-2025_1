package models;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private String professor;
    private String semestre;
    private String formaAvaliacao;  // "MediaSimples" ou "MediaPonderada"
    private boolean presencial;
    private String sala; // null se remoto
    private String horario;
    private int capacidadeMaxima;
    private List<Matricula> matriculas;

    public Turma(Disciplina disciplina, String professor, String semestre, String formaAvaliacao,
                 boolean presencial, String sala, String horario, int capacidadeMaxima) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.formaAvaliacao = formaAvaliacao;
        this.presencial = presencial;
        this.sala = presencial ? sala : null;
        this.horario = horario;
        this.capacidadeMaxima = capacidadeMaxima;
        this.matriculas = new ArrayList<>();
    }

    public Disciplina getDisciplina() { return disciplina; }
    public String getProfessor() { return professor; }
    public String getSemestre() { return semestre; }
    public String getFormaAvaliacao() { return formaAvaliacao; }
    public boolean isPresencial() { return presencial; }
    public String getSala() { return sala; }
    public String getHorario() { return horario; }
    public int getCapacidadeMaxima() { return capacidadeMaxima; }
    public List<Matricula> getMatriculas() { return matriculas; }

    public boolean adicionarMatricula(Matricula matricula) {
        if (matriculas.size() >= capacidadeMaxima) {
            return false;
        }
        matriculas.add(matricula);
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "disciplina=" + disciplina.getCodigo() +
                ", professor='" + professor + '\'' +
                ", semestre='" + semestre + '\'' +
                ", formaAvaliacao='" + formaAvaliacao + '\'' +
                ", presencial=" + presencial +
                ", sala='" + sala + '\'' +
                ", horario='" + horario + '\'' +
                ", capacidadeMaxima=" + capacidadeMaxima +
                ", matriculas=" + matriculas.size() +
                '}';
    }
}
