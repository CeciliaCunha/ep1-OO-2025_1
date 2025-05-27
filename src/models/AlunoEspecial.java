package models;

public class AlunoEspecial extends Aluno {

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public int maxDisciplinas() {
        return 2;
    }

    @Override
    public boolean recebeNotas() {
        return false;
    }
}
