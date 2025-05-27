package models;

public class Avaliacao {
    private double p1;
    private double p2;
    private double p3;
    private double listas;
    private double seminario;
    private int frequencia; // em percentual, 0-100
    private boolean recebeNotas;

    public Avaliacao(boolean recebeNotas) {
        this.recebeNotas = recebeNotas;
        this.p1 = 0;
        this.p2 = 0;
        this.p3 = 0;
        this.listas = 0;
        this.seminario = 0;
        this.frequencia = 0;
    }

    public double getP1() { return p1; }
    public double getP2() { return p2; }
    public double getP3() { return p3; }
    public double getListas() { return listas; }
    public double getSeminario() { return seminario; }
    public int getFrequencia() { return frequencia; }
    public boolean recebeNotas() { return recebeNotas; }

    public void setP1(double p1) { this.p1 = p1; }
    public void setP2(double p2) { this.p2 = p2; }
    public void setP3(double p3) { this.p3 = p3; }
    public void setListas(double listas) { this.listas = listas; }
    public void setSeminario(double seminario) { this.seminario = seminario; }
    public void setFrequencia(int frequencia) { this.frequencia = frequencia; }

    public double calcularMediaFinal(String formaAvaliacao) {
        if (!recebeNotas) return 0.0;

        if ("media_simples".equalsIgnoreCase(formaAvaliacao)) {
            return (p1 + p2 + p3 + listas + seminario) / 5.0;
        } else if ("media_ponderada".equalsIgnoreCase(formaAvaliacao)) {
            return (p1 + p2*2 + p3*3 + listas + seminario) / 8.0;
        } else {
            return 0.0;
        }
    }

    public boolean aprovado(String formaAvaliacao) {
        double media = calcularMediaFinal(formaAvaliacao);
        return media >= 5 && frequencia >= 75;
    }

    public boolean reprovadoPorNota(String formaAvaliacao) {
        double media = calcularMediaFinal(formaAvaliacao);
        return media < 5;
    }

    public boolean reprovadoPorFalta() {
        return frequencia < 75;
    }
}
