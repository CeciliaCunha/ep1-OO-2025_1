package models;

/**
 * Representa um aluno especial, que possui restrições específicas:
 * - Pode cursar no máximo duas disciplinas.
 * - Não recebe notas, apenas presença.
 */

public class AlunoEspecial extends Aluno {

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public boolean isAlunoEspecial() {
        return true;
    }

    @Override
    public String toString() {
        return "[Aluno Especial] " + super.toString();
    }
}
