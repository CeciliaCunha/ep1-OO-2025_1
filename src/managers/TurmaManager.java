package managers;

import models.Turma;

import java.io.*;
import java.util.*;

public class TurmaManager {
    private Map<String, Turma> turmas;
    private final String arquivo = "turmas.txt";

    public TurmaManager() {
        turmas = new HashMap<>();
        carregarArquivo();
    }

    public boolean adicionarTurma(Turma t) {
        if (turmas.containsKey(t.getCodigoTurma())) return false;
        turmas.put(t.getCodigoTurma(), t);
        salvarArquivo();
        return true;
    }

    public Turma buscarTurma(String codigoTurma) {
        return turmas.get(codigoTurma);
    }

    public boolean removerTurma(String codigoTurma) {
        if (turmas.containsKey(codigoTurma)) {
            turmas.remove(codigoTurma);
            salvarArquivo();
            return true;
        }
        return false;
    }

    public List<Turma> listarTurmas() {
        return new ArrayList<>(turmas.values());
    }

    public void salvarArquivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Turma t : turmas.values()) {
                pw.println(t.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar turmas: " + e.getMessage());
        }
    }

    public void carregarArquivo() {
        turmas.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Turma t = Turma.fromCSV(linha);
                if (t != null) turmas.put(t.getCodigoTurma(), t);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar turmas: " + e.getMessage());
        }
    }
}
