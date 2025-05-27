package managers;

import models.Matricula;
import java.util.*;

public class MatriculaManager {
    private List<Matricula> matriculas = new ArrayList<>();

    public void cadastrarMatricula(String matriculaAluno, String codigoTurma) {
        Matricula m = new Matricula(matriculaAluno, codigoTurma);
        matriculas.add(m);
        System.out.println("Matricula cadastrada.");
    }

    public int contarMatriculasDoAluno(String matriculaAluno) {
        int count = 0;
        for (Matricula m : matriculas) {
            if (m.getMatriculaAluno().equals(matriculaAluno)) count++;
        }
        return count;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void listarMatriculas() {
        if (matriculas.isEmpty()) {
            System.out.println("Nenhuma matricula cadastrada.");
            return;
        }
        for (Matricula m : matriculas) {
            System.out.println(m);
        }
    }
}
