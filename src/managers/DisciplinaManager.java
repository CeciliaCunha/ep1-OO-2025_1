package managers;

import models.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaManager {
    private List<Disciplina> disciplinas;

    public DisciplinaManager() {
        disciplinas = new ArrayList<>();
    }

    public boolean adicionarDisciplina(Disciplina d) {
        if (buscarPorCodigo(d.getCodigo()) != null) {
            return false;
        }
        disciplinas.add(d);
        return true;
    }

    public Disciplina buscarPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinas;
    }

    public boolean removerDisciplina(String codigo) {
        Disciplina d = buscarPorCodigo(codigo);
        if (d != null) {
            disciplinas.remove(d);
            return true;
        }
        return false;
    }
}
