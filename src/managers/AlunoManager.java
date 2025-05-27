package managers;

import models.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 *  Gerencia operações relacionadas aos alunos.
 */
public class AlunoManager {
    private List<Aluno> alunos;
    
    public AlunoManager() {
        alunos = new ArrayList<>();
    }

    /**
     * Adiciona um aluno na lista, verificando se já existe pela matrícula.
     * @param aluno Objeto Aluno a ser adicionado.
     * @return true se adicionou, false se matrícula já existe.
     */

    public boolean adicionarAluno(Aluno aluno) {
        //verifica duplicidade pela matrícula
        for(Aluno a : alunos) {
            if(a.getMatricula(). equals(aluno.getMatricula())) {
                return false; //ja existe aluno com essa matricula
            }
        }
        alunos.add(aluno);
        return true;
    }

    public List<Aluno> listarAlunos() {
        return alunos;
    }

    public Aluno buscarPorMatricula(String matricula) {
        for(Aluno a : alunos) {
            if(a.getMatricula().equals(matricula)) {
                return a;
            }
        }

        return null; //nao encontrado
    }
}
