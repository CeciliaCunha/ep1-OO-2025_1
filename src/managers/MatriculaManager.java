package managers;

import models.Aluno;
import models.Matricula;
import models.Turma;

import java.util.ArrayList;
import java.util.List;

public class MatriculaManager {
    private List<Matricula> matriculas;

    public MatriculaManager() {
        matriculas = new ArrayList<>();
    }

    public boolean matricularAluno(Aluno aluno, Turma turma) {
        // Verifica limite do aluno
        if (aluno.getMatriculas().size() >= aluno.maxDisciplinas()) {
            return false;
        }

        // Verifica se turma está cheia
        if (turma.getMatriculas().size() >= turma.getCapacidadeMaxima()) {
            return false;
        }

        Matricula m = new Matricula(aluno, turma);
        aluno.adicionarMatricula(m);
        turma.adicionarMatricula(m);
        matriculas.add(m);
        return true;
    }

    public List<Matricula> listarMatriculas() {
        return matriculas;
    }

    public boolean cancelarMatricula(Matricula matricula) {
        Aluno aluno = matricula.getAluno();
        Turma turma = matricula.getTurma();

        if (matriculas.remove(matricula)) {
            aluno.trancarMatricula(matricula);
            turma.getMatriculas().remove(matricula);
            return true;
        }
        return false;
    }
}
