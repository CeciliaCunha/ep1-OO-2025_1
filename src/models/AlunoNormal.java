package models;

public class AlunoNormal extends Aluno {
    public AlunoNormal(String matricula, String nome, String curso) {
        super(matricula, nome, curso);
    }

    @Override
    public boolean podeMatricularMais(int qtdMatriculas) {
        return true; // Normal não tem limite
    }

    @Override
    public boolean recebeNotas() {
        return true;
    }

    @Override
    public String getTipo() {
        return "normal";
    }
}
