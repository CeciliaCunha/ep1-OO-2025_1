package models;

public class Avaliacao {
    private String idMatricula; // referência à matrícula
    private Double p1, p2, p3, l, s;
    private int presencas;
    private int totalAulas;

    public Avaliacao(String idMatricula) {
        this.idMatricula = idMatricula;
        p1 = p2 = p3 = l = s = null;
        presencas = 0;
        totalAulas = 0;
    }

    public String getIdMatricula() { return idMatricula; }

    public Double getP1() { return p1; }
    public void setP1(Double p1) { this.p1 = p1; }
    public Double getP2() { return p2; }
    public void setP2(Double p2) { this.p2 = p2; }
    public Double getP3() { return p3; }
    public void setP3(Double p3) { this.p3 = p3; }
    public Double getL() { return l; }
    public void setL(Double l) { this.l = l; }
    public Double getS() { return s; }
    public void setS(Double s) { this.s = s; }

    public int getPresencas() { return presencas; }
    public void setPresencas(int presencas) { this.presencas = presencas; }
    public int getTotalAulas() { return totalAulas; }
    public void setTotalAulas(int totalAulas) { this.totalAulas = totalAulas; }

    public double calcularMedia(int tipoAvaliacao) {
        // tipo 1 = (P1 + P2 + P3 + L + S)/5
        // tipo 2 = (P1 + P2*2 + P3*3 + L + S)/8
        double np1 = p1 == null ? 0 : p1;
        double np2 = p2 == null ? 0 : p2;
        double np3 = p3 == null ? 0 : p3;
        double nl = l == null ? 0 : l;
        double ns = s == null ? 0 : s;

        if (tipoAvaliacao == 1) {
            return (np1 + np2 + np3 + nl + ns) / 5.0;
        } else {
            return (np1 + np2*2 + np3*3 + nl + ns) / 8.0;
        }
    }

    public double calcularFrequencia() {
        if (totalAulas == 0) return 0;
        return ((double) presencas / totalAulas) * 100.0;
    }

    // CSV: idMatricula,p1,p2,p3,l,s,presencas,totalAulas
    public String toCSV() {
        return idMatricula + "," +
                (p1 == null ? "" : p1) + "," +
                (p2 == null ? "" : p2) + "," +
                (p3 == null ? "" : p3) + "," +
                (l == null ? "" : l) + "," +
                (s == null ? "" : s) + "," +
                presencas + "," +
                totalAulas;
    }

    public static Avaliacao fromCSV(String csvLine) {
        String[] parts = csvLine.split(",", -1);
        if (parts.length < 8) return null;
        String idMatricula = parts[0];
        Avaliacao a = new Avaliacao(idMatricula);
        a.p1 = parts[1].isEmpty() ? null : Double.parseDouble(parts[1]);
        a.p2 = parts[2].isEmpty() ? null : Double.parseDouble(parts[2]);
        a.p3 = parts[3].isEmpty() ? null : Double.parseDouble(parts[3]);
        a.l = parts[4].isEmpty() ? null : Double.parseDouble(parts[4]);
        a.s = parts[5].isEmpty() ? null : Double.parseDouble(parts[5]);
        a.presencas = Integer.parseInt(parts[6]);
        a.totalAulas = Integer.parseInt(parts[7]);
        return a;
    }
}
