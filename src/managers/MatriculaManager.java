package managers;

import models.Matricula;

import java.io.*;
import java.util.*;

public class MatriculaManager {
    private Map<String, Matricula> matriculas;
    private final String arquivo = "matriculas.txt";

    public MatriculaManager() {
        matriculas = new HashMap<>();
        carregarArquivo();
    }

    public boolean adicionarMatricula(Matricula m) {
        if (matriculas.containsKey(m.getIdMatricula())) return false;
        matriculas.put(m.getIdMatricula(), m);
        salvarArquivo();
        return true;
    }

    public Matricula buscarMatricula(String id) {
        return matriculas.get(id);
    }

    public boolean removerMatricula(String id) {
        if (matriculas.containsKey(id)) {
            matriculas.remove(id);
            salvarArquivo();
            return true;
        }
        return false;
    }

    public List<Matricula> listarMatriculas() {
        return new ArrayList<>(matriculas.values());
    }

    public List<Matricula> listarMatriculasPorAluno(String matriculaAluno) {
        List<Matricula> lista = new ArrayList<>();
        for (Matricula m : matriculas.values()) {
            if (m.getMatriculaAluno().equals(matriculaAluno)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public List<Matricula> listarMatriculasPorTurma(String codigoTurma) {
        List<Matricula> lista = new ArrayList<>();
        for (Matricula m : matriculas.values()) {
            if (m.getCodigoTurma().equals(codigoTurma)) {
                lista.add(m);
            }
        }
        return lista;
    }

    public void salvarArquivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Matricula m : matriculas.values()) {
                pw.println(m.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar matriculas: " + e.getMessage());
        }
    }

    public void carregarArquivo() {
        matriculas.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Matricula m = Matricula.fromCSV(linha);
                if (m != null) matriculas.put(m.getIdMatricula(), m);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar matriculas: " + e.getMessage());
        }
    }
}
