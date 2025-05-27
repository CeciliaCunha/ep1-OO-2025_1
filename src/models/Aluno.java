package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Aluno {
    private String nome;
    private String matricula;
    private String curso;
    private List<Matricula> matriculas;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.matriculas = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public List<Matricula> getMatriculas() { return matriculas; }

    public void adicionarMatricula(Matricula m) {
        matriculas.add(m);
    }

    public boolean trancarMatricula(Matricula m) {
        return matriculas.remove(m);
    }

    public abstract int maxDisciplinas();

    public abstract boolean recebeNotas();

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                ", matriculas=" + matriculas.size() +
                '}';
    }
}
