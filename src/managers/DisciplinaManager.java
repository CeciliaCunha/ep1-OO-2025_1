package managers;

import models.Disciplina;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia operações relacionadas ás disciplinas.
 */

public class DisciplinaManager {
    private List<Disciplina> disciplinas;

    public DisciplinaManager() {
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinas;
    }

    public Disciplina buscarPorCodigo(String codigo) {
        for(Disciplina d : disciplinas) {
            if(d.getCodigo().equals(codigo)) {
                return d;
            }
        }

        return null;
    }
}
