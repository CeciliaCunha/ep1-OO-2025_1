package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private List<String> preRequisitos;

    public Disciplina() {
        preRequisitos = new ArrayList<>();
    }

    public Disciplina(String codigo, String nome, int cargaHoraria, List<String> preRequisitos) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = preRequisitos == null ? new ArrayList<>() : preRequisitos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<String> getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(List<String> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public String toCSVString() {
        String preReqStr = String.join(";", preRequisitos);
        return codigo + "," + nome + "," + cargaHoraria + "," + preReqStr;
    }

    public static Disciplina fromCSVString(String csv) {
        String[] parts = csv.split(",", 4);
        String codigo = parts[0];
        String nome = parts[1];
        int cargaHoraria = Integer.parseInt(parts[2]);
        List<String> preRequisitos = new ArrayList<>();
        if (parts.length == 4 && !parts[3].isEmpty()) {
            preRequisitos = Arrays.asList(parts[3].split(";"));
        }
        return new Disciplina(codigo, nome, cargaHoraria, preRequisitos);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", preRequisitos=" + preRequisitos +
                '}';
    }
}
