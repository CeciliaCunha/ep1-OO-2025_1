package models;

public abstract class Aluno {
    protected String nome;
    protected String matricula;
    protected String curso;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public abstract boolean podeCursarMaisDisciplinas(int matriculasAtuais);

    public abstract boolean recebeNotas();

    @Override
    public String toString() {
        return nome + " (" + matricula + ") - " + curso;
    }
}
