package managers;

import models.Turma;
import java.util.*;

public class TurmaManager {
    private Map<String, Turma> turmas = new HashMap<>();

    public void cadastrarTurma(String codigo, String codigoDisciplina, int vagas) {
        if (turmas.containsKey(codigo)) {
            System.out.println("Turma ja cadastrada.");
            return;
        }
        Turma t = new Turma(codigo, codigoDisciplina, vagas);
        turmas.put(codigo, t);
        System.out.println("Turma cadastrada.");
    }

    public boolean existe(String codigo) {
        return turmas.containsKey(codigo);
    }

    public Turma buscarTurma(String codigo) {
        return turmas.get(codigo);
    }

    public boolean temVaga(String codigoTurma) {
        Turma t = turmas.get(codigoTurma);
        if (t == null) return false;
        return t.getMatriculados() < t.getVagas();
    }

    public void incrementarMatriculas(String codigoTurma) {
        Turma t = turmas.get(codigoTurma);
        if (t != null) {
            t.setMatriculados(t.getMatriculados() + 1);
        }
    }

    public void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }
        for (Turma t : turmas.values()) {
            System.out.println(t);
        }
    }
}
