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

    private List<Matricula> disciplinasTrancadas = new ArrayList<>();

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public void trancarDisciplina(String codigoDisciplina) {
        Matricula matriculaEncontrada = null;
        for (Matricula m : matriculas) {
            if (m.getTurma().getDisciplina().getCodigo().equals(codigoDisciplina)) {
                matriculaEncontrada = m;
                break;
            }
        }
        if (matriculaEncontrada != null) {
            matriculas.remove(matriculaEncontrada);
            if (!disciplinasTrancadas.contains(matriculaEncontrada)) {
                disciplinasTrancadas.add(matriculaEncontrada);
            }
            matriculaEncontrada.getTurma().removerMatricula(matriculaEncontrada);
            System.out.println("Disciplina " + codigoDisciplina + " trancada com sucesso.");
        } else {
            System.out.println("Disciplina " + codigoDisciplina + " não encontrada na matrícula.");
        }
    }

    public void trancarSemestre() {
        for (Matricula m : new ArrayList<>(matriculas)) {
            if (!disciplinasTrancadas.contains(m)) {
                disciplinasTrancadas.add(m);
            }
            m.getTurma().removerMatricula(m);
        }
        matriculas.clear();
        System.out.println("Semestre trancado com sucesso.");
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
