package managers;

import models.Avaliacao;
import java.util.*;

public class AvaliacaoManager {
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Avaliacao buscarPorMatricula(String matriculaAluno, String codigoTurma) {
        for (Avaliacao a : avaliacoes) {
            if (a.getMatriculaAluno().equals(matriculaAluno) && a.getCodigoTurma().equals(codigoTurma)) {
                return a;
            }
        }
        return null;
    }

    public void adicionarOuAtualizar(Avaliacao avaliacao) {
        Avaliacao existente = buscarPorMatricula(avaliacao.getMatriculaAluno(), avaliacao.getCodigoTurma());
        if (existente == null) {
            avaliacoes.add(avaliacao);
        } else {
            existente.setNota(avaliacao.getNota());
            existente.setPresenca(avaliacao.getPresenca());
        }
        System.out.println("Avaliacao atualizada.");
    }

    public void listarAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliacao cadastrada.");
            return;
        }
        for (Avaliacao a : avaliacoes) {
            System.out.println(a);
        }
    }
}
