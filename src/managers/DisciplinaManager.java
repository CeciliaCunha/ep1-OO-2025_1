package managers;

import java.util.ArrayList;
import models.Disciplina;

public class DisciplinaManager {
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public void adicionarDisciplina(String nome, String codigo) {
        disciplinas.add(new Disciplina(nome, codigo));
    }

    public Disciplina buscarDisciplina(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }

    public void listarDisciplinas() {
        for (Disciplina d : disciplinas) {
            System.out.println(d.getNome() + " - " + d.getCodigo());
        }
    }
}
