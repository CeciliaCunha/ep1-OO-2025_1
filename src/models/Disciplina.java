package models;

public class Disciplina {
    private String codigo;
    private String nome;

    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
               "codigo='" + codigo + '\'' +
               ", nome='" + nome + '\'' +
               '}';
    }
}
