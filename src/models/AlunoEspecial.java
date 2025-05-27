package models;

public class AlunoEspecial extends Aluno {

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public String getTipoAluno() {
        return "Especial";
    }
}
