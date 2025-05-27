package managers;

import java.util.ArrayList;
import models.Aluno;
import models.AlunoEspecial;
import models.AlunoNormal;

public class AlunoManager {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(String tipo, String nome, String matricula, String curso) {
        Aluno aluno = tipo.equalsIgnoreCase("especial")
                ? new AlunoEspecial(nome, matricula, curso)
                : new AlunoNormal(nome, matricula, curso);

        alunos.add(aluno);
    }

    public Aluno buscarAluno(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public void editarAluno(String matricula, String novoNome, String novoCurso) {
        Aluno aluno = buscarAluno(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setCurso(novoCurso);
        }
    }

    public void listarAlunos() {
        for (Aluno a : alunos) {
            System.out.println(a.getNome() + " - " + a.getMatricula() + " - " + a.getTipoAluno());
        }
    }
}
