package managers;

import models.Aluno;
import models.Matricula;
import models.Turma;

public class AvaliacaoManager {

    private MatriculasManager matriculasManager;

    public AvaliacaoManager(MatriculasManager matriculasManager) {
        this.matriculasManager = matriculasManager;
    }

    /**
     * Método para lançar notas e frequência de um aluno em uma turma.
     */
    public void lancarNotasFrequencia(Aluno aluno, Turma turma, double p1, double p2, double p3,
                                      double listas, double seminario, double frequencia) throws Exception {
        Matricula matricula = matriculasManager.buscarMatricula(aluno, turma);
        if (matricula == null) {
            throw new Exception("Aluno não está matriculado nesta turma");
        }
        // Atualiza as notas e frequência na avaliação da matrícula
        matricula.getAvaliacao().setP1(p1);
        matricula.getAvaliacao().setP2(p2);
        matricula.getAvaliacao().setP3(p3);
        matricula.getAvaliacao().setListas(listas);
        matricula.getAvaliacao().setSeminario(seminario);
        matricula.getAvaliacao().setFrequencia(frequencia);
    }
}
