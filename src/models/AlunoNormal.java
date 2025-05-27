package models;

public class AlunoNormal extends Aluno {

    public AlunoNormal() {}

    public AlunoNormal(String matricula, String nome, String curso) {
        super(matricula, nome, curso);
    }

    @Override
    public String getTipoAluno() {
        return "Normal";
    }
}
