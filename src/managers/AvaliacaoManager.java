package managers;

import models.Matricula;
import models.Avaliacao;

public class AvaliacaoManager {

    public void lancarNotas(Matricula matricula, double p1, double p2, double p3, double listas, double seminario) {
        matricula.getAvaliacao().lancarNotas(p1, p2, p3, listas, seminario);
    }

    public void lancarFrequencia(Matricula matricula, double frequencia) {
        matricula.getAvaliacao().lancarFrequencia(frequencia);
    }

    public void calcularMedia(Matricula matricula, String forma) {
        matricula.getAvaliacao().calcularMedia(forma);
    }

    public void avaliarSituacao(Matricula matricula) {
        matricula.getAvaliacao().avaliarSituacao();
    }

    public void exibirAvaliacao(Matricula matricula) {
        Avaliacao a = matricula.getAvaliacao();
        System.out.println("Média: " + a.getMedia());
        System.out.println("Frequência: " + a.getFrequencia());
        System.out.println("Situação: " + a.getSituacao());
    }
}
