package models;

public class AlunoEspecial extends Aluno {
    public AlunoEspecial(String matricula, String nome, String curso) {
        super(matricula, nome, curso);
    }

    @Override
    public boolean podeMatricularMais(int qtdMatriculas) {
        return qtdMatriculas < 2; // Máximo 2 disciplinas
    }

    @Override
    public boolean recebeNotas() {
        return false; // Não recebe notas
    }

    @Override
    public String getTipo() {
        return "especial";
    }
}
