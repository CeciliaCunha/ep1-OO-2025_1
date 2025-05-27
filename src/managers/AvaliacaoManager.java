package managers;

import models.Avaliacao;
import models.Matricula;
import models.Turma;

public class AvaliacaoManager {

    public void atualizarNotas(Matricula matricula, double p1, double p2, double p3, double listas, double seminario,
                               int presencas, int aulasMinistradas) {
        Avaliacao a = matricula.getAvaliacao();
        a.setP1(p1);
        a.setP2(p2);
        a.setP3(p3);
        a.setListas(listas);
        a.setSeminario(seminario);
        a.setPresencas(presencas);
        a.setAulasMinistradas(aulasMinistradas);

        Turma turma = matricula.getTurma();
        boolean mediaPonderada = "MediaPonderada".equalsIgnoreCase(turma.getFormaAvaliacao());

        a.avaliar(mediaPonderada);
    }
}
