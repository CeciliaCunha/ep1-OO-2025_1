package managers;

import models.Avaliacao;

import java.io.*;
import java.util.*;

public class AvaliacaoManager {
    private Map<String, Avaliacao> avaliacoes;
    private final String arquivo = "avaliacoes.txt";

    public AvaliacaoManager() {
        avaliacoes = new HashMap<>();
        carregarArquivo();
    }

    public boolean adicionarAvaliacao(Avaliacao a) {
        if (avaliacoes.containsKey(a.getIdMatricula())) return false;
        avaliacoes.put(a.getIdMatricula(), a);
        salvarArquivo();
        return true;
    }

    public Avaliacao buscarAvaliacao(String idMatricula) {
        return avaliacoes.get(idMatricula);
    }

    public boolean atualizarAvaliacao(Avaliacao a) {
        if (!avaliacoes.containsKey(a.getIdMatricula())) return false;
        avaliacoes.put(a.getIdMatricula(), a);
        salvarArquivo();
        return true;
    }

    public void salvarArquivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Avaliacao a : avaliacoes.values()) {
                pw.println(a.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar avaliacoes: " + e.getMessage());
        }
    }

    public void carregarArquivo() {
        avaliacoes.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Avaliacao a = Avaliacao.fromCSV(linha);
                if (a != null) avaliacoes.put(a.getIdMatricula(), a);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar avaliacoes: " + e.getMessage());
        }
    }
}
