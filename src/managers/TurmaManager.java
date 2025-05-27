package managers;

import models.Turma;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia operações relacionadas ás turmas.
 */

public class TurmaManager {
    private List<Turma> turmas;

    public TurmaManager() {
        turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma t) {
        turmas.add(t);
    }

    public List<Turma> listarTurmas() {
        return turmas;
    }

    // Busca turmas por código da disciplina
    public List<Turma> buscarPorCodigoDisciplina(String codigo) {
        List<Turma> resultado = new ArrayList<>();
        for (Turma t : turmas) {
            if (t.getCodigoDisciplina().equals(codigo)) {
                resultado.add(t);
            }
        }
        return resultado;
    }
}