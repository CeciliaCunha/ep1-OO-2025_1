package managers;

import models.Turma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaManager {
    private List<Turma> turmas;

    public TurmaManager() {
        turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma t) {
        turmas.add(t);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public Turma buscarTurmaPorCodigo(String codigoDisciplina) {
        for (Turma t : turmas) {
            if (t.getCodigoDisciplina().equals(codigoDisciplina)) {
                return t;
            }
        }
        return null;
    }

    public void removerTurma(String codigoDisciplina) {
        turmas.removeIf(t -> t.getCodigoDisciplina().equals(codigoDisciplina));
    }

    public void salvarArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Turma t : turmas) {
                writer.write(t.toCSVString());
                writer.newLine();
            }
        }
    }

    public void carregarArquivo(String nomeArquivo) throws IOException {
        turmas.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Turma t = Turma.fromCSVString(linha);
                turmas.add(t);
            }
        }
    }
}
