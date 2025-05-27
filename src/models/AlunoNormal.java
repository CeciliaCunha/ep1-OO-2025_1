package models;

public class AlunoNormal extends Aluno {

    public AlunoNormal(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public boolean podeCursarMaisDisciplinas(int matriculasAtuais) {
        // Aluno normal não tem limite de disciplinas
        return true;
    }

    @Override
    public boolean recebeNotas() {
        return true;
    }
}
