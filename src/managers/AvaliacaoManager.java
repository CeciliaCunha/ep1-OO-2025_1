package managers;

import models.Avaliacao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoManager {
    private List<Avaliacao> avaliacoes;

    public AvaliacaoManager() {
        avaliacoes = new ArrayList<>();
    }

    public void adicionarAvaliacao(Avaliacao a) {
        avaliacoes.add(a);
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void removerAvaliacao(int index) {
        if (index >= 0 && index < avaliacoes.size()) {
            avaliacoes.remove(index);
        }
    }

    public void salvarArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Avaliacao a : avaliacoes) {
                writer.write(a.toCSVString());
                writer.newLine();
            }
        }
    }

    public void carregarArquivo(String nomeArquivo) throws IOException {
        avaliacoes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Avaliacao a = Avaliacao.fromCSVString(linha);
                avaliacoes.add(a);
            }
        }
    }
}
