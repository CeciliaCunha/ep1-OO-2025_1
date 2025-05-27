package managers;

import models.Aluno;
import java.util.*;

public class AlunoManager {
    private Map<String, Aluno> alunos = new HashMap<>();

    public void cadastrarAluno(String matricula, String nome, boolean especial) {
        if (alunos.containsKey(matricula)) {
            System.out.println("Aluno ja cadastrado.");
            return;
        }
        Aluno a = new Aluno(matricula, nome, especial);
        alunos.put(matricula, a);
        System.out.println("Aluno cadastrado.");
    }

    public boolean existe(String matricula) {
        return alunos.containsKey(matricula);
    }

    public Aluno buscarAluno(String matricula) {
        return alunos.get(matricula);
    }

    public boolean ehEspecial(String matricula) {
        Aluno a = alunos.get(matricula);
        if (a == null) return false;
        return a.isEspecial();
    }

    public void editarAluno(String matricula, String novoNome, Boolean especial) {
        Aluno a = alunos.get(matricula);
        if (a == null) {
            System.out.println("Aluno nao encontrado.");
            return;
        }
        if (novoNome != null) a.setNome(novoNome);
        if (especial != null) a.setEspecial(especial);
        System.out.println("Aluno editado.");
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : alunos.values()) {
            System.out.println(a);
        }
    }
}
