package org.example;

public class Projektausschreibung {
    private String Kunde;
    private String Projektscope;
    private int Umfang;
    private String GesuchtePositionen;
    private String Bewerbungsfrist;

    // region Getters and Setters
    public String getKunde() {
        return Kunde;
    }

    public void setKunde(String kunde) {
        Kunde = kunde;
    }

    public String getProjektscope() {
        return Projektscope;
    }

    public void setProjektscope(String projektscope) {
        Projektscope = projektscope;
    }

    public int getUmfang() {
        return Umfang;
    }

    public void setUmfang(int umfang) {
        Umfang = umfang;
    }

    public String getGesuchtePositionen() {
        return GesuchtePositionen;
    }

    public void setGesuchtePositionen(String gesuchtePositionen) {
        GesuchtePositionen = gesuchtePositionen;
    }

    public String getBewerbungsfrist() {
        return Bewerbungsfrist;
    }

    public void setBewerbungsfrist(String bewerbungsfrist) {
        Bewerbungsfrist = bewerbungsfrist;
    }

    // endregion

    public String toString() {
        return "Projektausschreibungen{" +
                "Kunde='" + Kunde + '\'' +
                ", Projektscope='" + Projektscope + '\'' +
                ", Umfang='" + Umfang + '\'' +
                ", GesuchtePositionen='" + GesuchtePositionen + '\'' +
                ", Bewerbungsfrist='" + Bewerbungsfrist + '\'' +
                '}';
    }
}
