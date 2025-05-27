package models;

public abstract class Aluno {
    protected String matricula;
    protected String nome;
    protected String curso;

    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getCurso() { return curso; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCurso(String curso) { this.curso = curso; }

    public abstract boolean podeMatricularMais(int qtdMatriculas);

    public abstract boolean recebeNotas();

    // CSV (matricula,nome,curso,tipo)
    public String toCSV() {
        return matricula + "," + nome + "," + curso + "," + getTipo();
    }

    public static Aluno fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length < 4) return null;
        String matricula = parts[0];
        String nome = parts[1];
        String curso = parts[2];
        String tipo = parts[3];
        if (tipo.equalsIgnoreCase("normal")) {
            return new AlunoNormal(matricula, nome, curso);
        } else if (tipo.equalsIgnoreCase("especial")) {
            return new AlunoEspecial(matricula, nome, curso);
        }
        return null;
    }

    public abstract String getTipo();
}
