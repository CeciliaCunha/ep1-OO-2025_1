package managers;

import models.Matricula;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaManager {
    private List<Matricula> matriculas;

    public MatriculaManager() {
        matriculas = new ArrayList<>();
    }

    public void adicionarMatricula(Matricula m) {
        matriculas.add(m);
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void removerMatricula(String matriculaAluno, String codigoTurma) {
        matriculas.removeIf(m -> m.getMatriculaAluno().equals(matriculaAluno) && m.getCodigoTurma().equals(codigoTurma));
    }

    public List<Matricula> buscarPorAluno(String matriculaAluno) {
        List<Matricula> resultado = new ArrayList<>();
        for (Matricula m : matriculas) {
            if (m.getMatriculaAluno().equals(matriculaAluno)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public void salvarArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Matricula m : matriculas) {
                writer.write(m.toCSVString());
                writer.newLine();
            }
        }
    }

    public void carregarArquivo(String nomeArquivo) throws IOException {
        matriculas.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Matricula m = Matricula.fromCSVString(linha);
                matriculas.add(m);
            }
        }
    }
}
