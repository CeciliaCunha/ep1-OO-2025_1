package models;

import java.util.List;

/**
 * Representa uma disciplina.
 */

public class Disciplina {
    private String nome;
    private String codigo;
    private int cargaHoraria;
    private List<String> preRequisitos;
    
    public Disciplina(String nome, String codigo, int cargaHoraria, List<String> preRequisitos) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria =  cargaHoraria;
        this.preRequisitos = preRequisitos;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<String> getPreRequisitos() {
        return preRequisitos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setPreRequisitos(List<String> preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    @Override
    public String toString() {
        return "Disciplina: " + nome + " (" + codigo + ") | Carga Horaria: " + cargaHoraria + " | Pre-requisitos: " + preRequisitos;
    }
}
