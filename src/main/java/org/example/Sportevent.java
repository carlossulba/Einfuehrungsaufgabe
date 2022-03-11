package org.example;

public class Sportevent {
    private String Titel;
    private int MaximaleTeilnehmerzahl;
    private String Datum;
    private String Zeit;
    private String Ort;

    // region Getters and Setters

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public int getMaximaleTeilnehmerzahl() {
        return MaximaleTeilnehmerzahl;
    }

    public void setMaximaleTeilnehmerzahl(int maximaleTeilnehmerzahl) {
        MaximaleTeilnehmerzahl = maximaleTeilnehmerzahl;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String datum) {
        Datum = datum;
    }

    public String getZeit() {
        return Zeit;
    }

    public void setZeit(String zeit) {
        Zeit = zeit;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    // endregion

    public String toString() {
        return "Sportevents{" +
                "Titel='" + Titel + '\'' +
                ", MaximaleTeilnehmerzahl='" + MaximaleTeilnehmerzahl + '\'' +
                ", Datum='" + Datum + '\'' +
                ", Zeit='" + Zeit + '\'' +
                ", Ort='" + Ort + '\'' +
                '}';
    }
}
