package models;

public class Avaliacao {
    private double p1, p2, p3, listas, seminario;
    private double frequencia;
    private String status;

    public Avaliacao() {
        p1 = p2 = p3 = listas = seminario = frequencia = 0.0;
        status = "Indefinido";
    }

    public Avaliacao(double p1, double p2, double p3, double listas, double seminario, double frequencia, String status) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.listas = listas;
        this.seminario = seminario;
        this.frequencia = frequencia;
        this.status = status;
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getP2() {
        return p2;
    }

    public void setP2(double p2) {
        this.p2 = p2;
    }

    public double getP3() {
        return p3;
    }

    public void setP3(double p3) {
        this.p3 = p3;
    }

    public double getListas() {
        return listas;
    }

    public void setListas(double listas) {
        this.listas = listas;
    }

    public double getSeminario() {
        return seminario;
    }

    public void setSeminario(double seminario) {
        this.seminario = seminario;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toCSVString() {
        return p1 + "," + p2 + "," + p3 + "," + listas + "," + seminario + "," + frequencia + "," + status;
    }

    public static Avaliacao fromCSVString(String csv) {
        String[] parts = csv.split(",", 7);
        double p1 = Double.parseDouble(parts[0]);
        double p2 = Double.parseDouble(parts[1]);
        double p3 = Double.parseDouble(parts[2]);
        double listas = Double.parseDouble(parts[3]);
        double seminario = Double.parseDouble(parts[4]);
        double frequencia = Double.parseDouble(parts[5]);
        String status = parts[6];
        return new Avaliacao(p1, p2, p3, listas, seminario, frequencia, status);
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", listas=" + listas +
                ", seminario=" + seminario +
                ", frequencia=" + frequencia +
                ", status='" + status + '\'' +
                '}';
    }
}
