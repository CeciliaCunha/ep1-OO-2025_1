package models;

public abstract class Aluno {
    protected String matricula;
    protected String nome;
    protected String curso;

    public Aluno() {}

    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public abstract String getTipoAluno();

    // Método para converter para CSV
    public String toCSVString() {
        return matricula + "," + nome + "," + curso + "," + getTipoAluno();
    }

    // Método para criar Aluno a partir do CSV
    public static Aluno fromCSVString(String csv) {
        String[] parts = csv.split(",");
        String matricula = parts[0];
        String nome = parts[1];
        String curso = parts[2];
        String tipo = parts[3];

        if (tipo.equals("Normal")) {
            return new AlunoNormal(matricula, nome, curso);
        } else if (tipo.equals("Especial")) {
            return new AlunoEspecial(matricula, nome, curso);
        } else {
            throw new IllegalArgumentException("Tipo de aluno desconhecido: " + tipo);
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", tipo='" + getTipoAluno() + '\'' +
                '}';
    }
}
