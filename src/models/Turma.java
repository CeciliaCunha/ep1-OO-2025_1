package models;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Disciplina disciplina;
    private String professor;
    private String semestre;
    private String formaAvaliacao; // "media_simples" ou "media_ponderada"
    private boolean presencial;
    private String sala; // null se remota
    private String horario;
    private int capacidadeMaxima;
    private List<Matricula> matriculas;

    public Turma(Disciplina disciplina, String professor, String semestre,
                 String formaAvaliacao, boolean presencial, String sala,
                 String horario, int capacidadeMaxima) {
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

    public Disciplina getDisciplina() {
        return disciplina;
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

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public boolean temVaga() {
        return matriculas.size() < capacidadeMaxima;
    }

    public void adicionarMatricula(Matricula matricula) {
        if (temVaga()) {
            matriculas.add(matricula);
        }
    }

    @Override
    public String toString() {
        return "Turma de " + disciplina.getCodigo() + " - Prof: " + professor + 
               ", Semestre: " + semestre + ", Horário: " + horario + 
               (presencial ? ", Sala: " + sala : ", Remota") + ", Capacidade: " + capacidadeMaxima;
    }
}
