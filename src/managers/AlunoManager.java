package managers;

import models.Aluno;
import models.AlunoNormal;
import models.AlunoEspecial;

import java.util.ArrayList;
import java.util.List;

public class AlunoManager {
    private List<Aluno> alunos;

    public AlunoManager() {
        alunos = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (buscarPorMatricula(aluno.getMatricula()) != null) {
            return false; // já existe matrícula
        }
        alunos.add(aluno);
        return true;
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    public boolean removerAluno(String matricula) {
        Aluno a = buscarPorMatricula(matricula);
        if (a != null) {
            alunos.remove(a);
            return true;
        }
        return false;
    }
}
