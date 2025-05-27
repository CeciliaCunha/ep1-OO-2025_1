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

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public boolean cursouDisciplina(String codigoDisciplina) {
        return disciplinasCursadas.contains(codigoDisciplina);
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void adicionarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    // Retorna só as matrículas em turmas ainda cursando (exemplo: situação diferente de finalizada)
    public List<Matricula> getMatriculasAtivas() {
        List<Matricula> ativas = new ArrayList<>();
        for (Matricula m : matriculas) {
            String situacao = m.situacaoFinal();
            // Considere "Aprovado" ou "Reprovado" como finalizadas, outras como ativas
            if (!situacao.startsWith("Aprovado") && !situacao.startsWith("Reprovado")) {
                ativas.add(m);
            }
        }
        return ativas;
    }

    // Atualizar disciplinas cursadas com base nas matrículas aprovadas
    public void atualizarDisciplinasCursadas() {
        for (Matricula m : matriculas) {
            if (m.situacaoFinal().startsWith("Aprovado")) {
                String codigoDisc = m.getTurma().getCodigoDisciplina();
                if (!disciplinasCursadas.contains(codigoDisc)) {
                    disciplinasCursadas.add(codigoDisc);
                }
            }
        }
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
