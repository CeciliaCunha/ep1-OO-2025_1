package managers;

import models.Disciplina;
import java.util.*;

public class DisciplinaManager {
    private Map<String, Disciplina> disciplinas = new HashMap<>();

    public void cadastrarDisciplina(String codigo, String nome) {
        if (disciplinas.containsKey(codigo)) {
            System.out.println("Disciplina ja cadastrada.");
            return;
        }
        Disciplina d = new Disciplina(codigo, nome);
        disciplinas.put(codigo, d);
        System.out.println("Disciplina cadastrada.");
    }

    public boolean existe(String codigo) {
        return disciplinas.containsKey(codigo);
    }

    public Disciplina buscarDisciplina(String codigo) {
        return disciplinas.get(codigo);
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        for (Disciplina d : disciplinas.values()) {
            System.out.println(d);
        }
    }
}
