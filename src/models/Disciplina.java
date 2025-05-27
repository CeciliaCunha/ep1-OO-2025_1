package models;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private List<String> preRequisitos;

    public Disciplina(String codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getCargaHoraria() { return cargaHoraria; }
    public List<String> getPreRequisitos() { return preRequisitos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public void addPreRequisito(String codigoPre) {
        if (!preRequisitos.contains(codigoPre)) {
            preRequisitos.add(codigoPre);
        }
    }

    // CSV: codigo,nome,cargaHoraria,pre1|pre2|...
    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(codigo).append(",").append(nome).append(",").append(cargaHoraria).append(",");
        if (preRequisitos.size() > 0) {
            sb.append(String.join("|", preRequisitos));
        }
        return sb.toString();
    }

    public static Disciplina fromCSV(String csvLine) {
        String[] parts = csvLine.split(",", -1);
        if (parts.length < 4) return null;
        String codigo = parts[0];
        String nome = parts[1];
        int carga = Integer.parseInt(parts[2]);
        Disciplina d = new Disciplina(codigo, nome, carga);
        if (!parts[3].isEmpty()) {
            String[] pre = parts[3].split("\\|");
            for (String p : pre) d.addPreRequisito(p);
        }
        return d;
    }
}
