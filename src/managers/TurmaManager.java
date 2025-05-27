package managers;

import models.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaManager {
    private List<Turma> turmas;

    public TurmaManager() {
        turmas = new ArrayList<>();
    }

    public boolean adicionarTurma(Turma t) {
        if (buscarTurma(t.getDisciplina().getCodigo(), t.getSemestre()) != null) {
            return false; // Já existe turma dessa disciplina no semestre
        }
        turmas.add(t);
        return true;
    }

    public Turma buscarTurma(String codigoDisciplina, String semestre) {
        for (Turma t : turmas) {
            if (t.getDisciplina().getCodigo().equals(codigoDisciplina) && t.getSemestre().equals(semestre)) {
                return t;
            }
        }
        return null;
    }

    public List<Turma> listarTurmas() {
        return turmas;
    }

    public boolean removerTurma(String codigoDisciplina, String semestre) {
        Turma t = buscarTurma(codigoDisciplina, semestre);
        if (t != null) {
            turmas.remove(t);
            return true;
        }
        return false;
    }
}
