package managers;

import models.Aluno;
import models.AlunoNormal;
import models.AlunoEspecial;

import java.io.*;
import java.util.*;

public class AlunoManager {
    private Map<String, Aluno> alunos;
    private final String arquivo = "alunos.txt";

    public AlunoManager() {
        alunos = new HashMap<>();
        carregarArquivo();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (alunos.containsKey(aluno.getMatricula())) {
            return false;
        }
        alunos.put(aluno.getMatricula(), aluno);
        salvarArquivo();
        return true;
    }

    public Aluno buscarAluno(String matricula) {
        return alunos.get(matricula);
    }

    public boolean removerAluno(String matricula) {
        if (alunos.containsKey(matricula)) {
            alunos.remove(matricula);
            salvarArquivo();
            return true;
        }
        return false;
    }

    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos.values());
    }

    public void salvarArquivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Aluno a : alunos.values()) {
                pw.println(a.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

    public void carregarArquivo() {
        alunos.clear();
        File f = new File(arquivo);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Aluno a = Aluno.fromCSV(linha);
                if (a != null) alunos.put(a.getMatricula(), a);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar alunos: " + e.getMessage());
        }
    }
}
