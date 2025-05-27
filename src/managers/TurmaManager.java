package managers;

import java.util.ArrayList;
import models.Disciplina;
import models.Turma;

public class TurmaManager {
    private ArrayList<Turma> turmas = new ArrayList<>();

    public void adicionarTurma(Disciplina disciplina, String codigoTurma) {
        turmas.add(new Turma(disciplina, codigoTurma));
    }

    public Turma buscarTurma(String codigoTurma) {
        for (Turma t : turmas) {
            if (t.getCodigoTurma().equals(codigoTurma)) {
                return t;
            }
        }
        return null;
    }

    public void listarTurmas() {
        for (Turma t : turmas) {
            System.out.println(t.getCodigoTurma() + " - " + t.getDisciplina().getNome());
        }
    }
}
