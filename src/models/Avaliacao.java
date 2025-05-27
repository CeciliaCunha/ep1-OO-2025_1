package models;

public class Avaliacao {
    private double p1, p2, p3, listas, seminario;
    private int presencas;
    private int aulasMinistradas;
    private double mediaFinal;
    private boolean aprovado;

    public Avaliacao() {
        p1 = p2 = p3 = listas = seminario = 0.0;
        presencas = 0;
        aulasMinistradas = 0;
        mediaFinal = 0.0;
        aprovado = false;
    }

    public double getP1() { return p1; }
    public void setP1(double p1) { this.p1 = p1; }

    public double getP2() { return p2; }
    public void setP2(double p2) { this.p2 = p2; }

    public double getP3() { return p3; }
    public void setP3(double p3) { this.p3 = p3; }

    public double getListas() { return listas; }
    public void setListas(double listas) { this.listas = listas; }

    public double getSeminario() { return seminario; }
    public void setSeminario(double seminario) { this.seminario = seminario; }

    public int getPresencas() { return presencas; }
    public void setPresencas(int presencas) { this.presencas = presencas; }

    public int getAulasMinistradas() { return aulasMinistradas; }
    public void setAulasMinistradas(int aulasMinistradas) { this.aulasMinistradas = aulasMinistradas; }

    public double getMediaFinal() { return mediaFinal; }
    public boolean isAprovado() { return aprovado; }

    public void calcularMediaSimples() {
        this.mediaFinal = (p1 + p2 + p3 + listas + seminario) / 5.0;
    }

    public void calcularMediaPonderada() {
        this.mediaFinal = (p1 + 2 * p2 + 3 * p3 + listas + seminario) / 8.0;
    }

    public double calcularFrequencia() {
        if (aulasMinistradas == 0) return 0;
        return (presencas * 100.0) / aulasMinistradas;
    }

    public void avaliar(boolean mediaPonderada) {
        if (mediaPonderada) {
            calcularMediaPonderada();
        } else {
            calcularMediaSimples();
        }
        double frequencia = calcularFrequencia();
        this.aprovado = mediaFinal >= 5.0 && frequencia >= 75.0;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", listas=" + listas +
                ", seminario=" + seminario +
                ", presencas=" + presencas +
                ", aulasMinistradas=" + aulasMinistradas +
                ", mediaFinal=" + mediaFinal +
                ", aprovado=" + aprovado +
                '}';
    }
}
