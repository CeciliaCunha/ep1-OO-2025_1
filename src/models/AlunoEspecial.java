package models;

public class AlunoEspecial extends Aluno {

    public AlunoEspecial() {}

    public AlunoEspecial(String matricula, String nome, String curso) {
        super(matricula, nome, curso);
    }

    @Override
    public String getTipoAluno() {
        return "Especial";
    }
}
