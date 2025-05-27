package managers;

import models.Disciplina;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaManager {
    private List<Disciplina> disciplinas;

    public DisciplinaManager() {
        disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        return null;
    }

    public void removerDisciplina(String codigo) {
        disciplinas.removeIf(d -> d.getCodigo().equals(codigo));
    }

    public void salvarArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Disciplina d : disciplinas) {
                writer.write(d.toCSVString());
                writer.newLine();
            }
        }
    }

    public void carregarArquivo(String nomeArquivo) throws IOException {
        disciplinas.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Disciplina d = Disciplina.fromCSVString(linha);
                disciplinas.add(d);
            }
        }
    }
}
