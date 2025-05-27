package managers;

import java.util.List;

import models.Aluno;
import models.Disciplina;
import models.Matricula;
import models.Turma;

public class MatriculasManager {
    public void matricularAluno(Aluno aluno, Turma turma, List<Disciplina> disciplinas) {
        // Verificar se há vaga
        if (turma.getVagasDisponiveis() <= 0) {
            throw new IllegalStateException("Turma sem vagas disponíveis.");
        }

        // Verificar se aluno especial já está em 2 turmas
        if (aluno.isAlunoEspecial()) {
            long qtdMatriculas = aluno.getMatriculas().size();
            if (qtdMatriculas >= 2) {
                throw new IllegalStateException("Aluno especial não pode se matricular em mais de 2 turmas.");
            }
        }

        // Verificar pré-requisitos
        Disciplina disciplina = buscarDisciplinaPorCodigo(turma.getCodigoDisciplina(), disciplinas);
        if (disciplina == null) {
            throw new IllegalStateException("Disciplina não encontrada.");
        }

        for (String codPre : disciplina.getPreRequisitos()) {
            boolean cumpriu = aluno.cursouDisciplina(codPre);
            if (!cumpriu) {
                throw new IllegalStateException("Aluno não cumpre o pré-requisito: " + codPre);
            }
        }

        // Realizar a matrícula
        Matricula matricula = new Matricula(aluno, turma);
        turma.adicionarMatricula(matricula);
        aluno.adicionarMatricula(matricula);

        System.out.println("Aluno " + aluno.getNome() + " matriculado com sucesso na turma " + turma.getCodigoTurma());
    }

    private Disciplina buscarDisciplinaPorCodigo(String codigo, List<Disciplina> disciplinas) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }
}
