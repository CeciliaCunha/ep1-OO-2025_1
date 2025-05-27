package managers;

import models.Disciplina;

import java.io.*;
import java.util.*;

public class DisciplinaManager {
    private Map<String, Disciplina> disciplinas;
    private final String arquivo = "disciplinas.txt";

    public DisciplinaManager() {
        disciplinas = new HashMap<>();
        carregarArquivo();
    }

    public boolean adicionarDisciplina(Disciplina d) {
        if (disciplinas.containsKey(d.getCodigo())) return false;
        disciplinas.put(d.getCodigo(), d);
        salvarArquivo();
        return true;
    }

    public Disciplina buscarDisciplina(String codigo) {
        return disciplinas.get(codigo);
    }

    public boolean removerDisciplina(String codigo) {
        if (disciplinas.containsKey(codigo)) {
            disciplinas.remove(codigo);
            salvarArquivo();
            return true;
        }
        return false;
    }

    public List<Disciplina> listarDisciplinas() {
        return new ArrayList<>(disciplinas.values());
    }

    public void salvarArquivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Disciplina d : disciplinas.values()) {
                pw.println(d.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar disciplinas: " + e.getMessage());
        }
    }

    public void carregarArquivo() {
        disciplinas.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Disciplina d = Disciplina.fromCSV(linha);
                if (d != null) disciplinas.put(d.getCodigo(), d);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar disciplinas: " + e.getMessage());
        }
    }
}
