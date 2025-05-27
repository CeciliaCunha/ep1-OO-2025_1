package models;

public class Avaliacao {
    private double p1, p2, p3, listas, seminario;
    private double frequencia;
    private double media;
    private String situacao;

    public Avaliacao() {
        this.frequencia = 0;
        this.media = 0;
        this.situacao = "Em andamento";
    }

    public void lancarNotas(double p1, double p2, double p3, double listas, double seminario) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.listas = listas;
        this.seminario = seminario;
    }

    public void lancarFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public void calcularMedia(String forma) {
        if (forma.equalsIgnoreCase("media")) {
            this.media = (p1 + p2 + p3 + listas + seminario) / 5.0;
        }
    }

    public void avaliarSituacao() {
        if (frequencia < 75) {
            situacao = "Reprovado por falta";
        } else if (media >= 6) {
            situacao = "Aprovado";
        } else {
            situacao = "Reprovado por nota";
        }
    }

    public double getMedia() {
        return media;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public String getSituacao() {
        return situacao;
    }
}
