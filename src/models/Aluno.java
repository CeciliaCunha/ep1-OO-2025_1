package models;

public class Aluno {
    private String matricula;
    private String nome;
    private boolean especial; // "normal" ou "especial"

    public Aluno(String matricula, String nome, boolean tipo) {
        this.matricula = matricula;
        this.nome = nome;
        this.especial = especial;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", especial ='" + especial + '\'' +
                '}';
    }
}
