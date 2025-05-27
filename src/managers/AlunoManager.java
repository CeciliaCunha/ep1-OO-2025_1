package managers;

import models.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoManager {
    private List<Aluno> alunos;

    public AlunoManager() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void removerAluno(String matricula) {
        alunos.removeIf(a -> a.getMatricula().equals(matricula));
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public void salvarArquivo(String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Aluno a : alunos) {
                writer.write(a.toCSVString());
                writer.newLine();
            }
        }
    }

    public void carregarArquivo(String nomeArquivo) throws IOException {
        alunos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Aluno a = Aluno.fromCSVString(linha);
                alunos.add(a);
            }
        }
    }
}
