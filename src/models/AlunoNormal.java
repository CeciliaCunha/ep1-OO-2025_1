package models;

public class AlunoNormal extends Aluno {

    public AlunoNormal(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public int maxDisciplinas() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean recebeNotas() {
        return true;
    }
}
