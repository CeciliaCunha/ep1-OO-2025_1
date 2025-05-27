package models;

public class AlunoNormal extends Aluno {

    public AlunoNormal(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public String getTipoAluno() {
        return "Normal";
    }
}
