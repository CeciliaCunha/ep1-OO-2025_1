package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um aluno.
 */

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    private List<String> disciplinasCursadas;

    private List<Matricula> matriculas = new ArrayList<>();

    public boolean cursouDisciplina(String codigoDisciplina) {
        if (disciplinasCursadas == null) {
            return false;
        }
        return disciplinasCursadas.contains(codigoDisciplina);
    }
    
    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void adicionarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }


    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isAlunoEspecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " | Matricula: " + matricula + " | Curso: " + curso;
    }
}
