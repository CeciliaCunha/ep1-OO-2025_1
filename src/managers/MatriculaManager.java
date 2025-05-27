package managers;

import java.util.ArrayList;
import models.Aluno;
import models.Matricula;
import models.Turma;

public class MatriculaManager {
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    public void realizarMatricula(Aluno aluno, Turma turma) {
        matriculas.add(new Matricula(aluno, turma));
    }

    public Matricula buscarMatricula(String matriculaAluno, String codigoTurma) {
        for (Matricula m : matriculas) {
            if (m.getAluno().getMatricula().equals(matriculaAluno) &&
                m.getTurma().getCodigoTurma().equals(codigoTurma)) {
                return m;
            }
        }
        return null;
    }

    public void listarMatriculas() {
        for (Matricula m : matriculas) {
            System.out.println(m.getAluno().getNome() + " - " + m.getTurma().getCodigoTurma());
        }
    }
}
