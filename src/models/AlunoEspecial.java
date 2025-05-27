package models;

public class AlunoEspecial extends Aluno {

    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public boolean podeCursarMaisDisciplinas(int matriculasAtuais) {
        // Aluno especial pode cursar no máximo 2 disciplinas
        return matriculasAtuais < 2;
    }

    @Override
    public boolean recebeNotas() {
        // Aluno especial não recebe notas, só frequência
        return false;
    }
}
