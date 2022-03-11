package org.example;

public class Workshop {
    private String Anbieter;
    private String Thema;
    private String Datum;
    private String Zeit;
    private String Ort;

    // region Getters and Setters

    public String getAnbieter() {
        return Anbieter;
    }

    public void setAnbieter(String anbieter) {
        Anbieter = anbieter;
    }

    public String getThema() {
        return Thema;
    }

    public void setThema(String thema) {
        Thema = thema;
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
        return "Workshops{" +
                "Anbieter='" + Anbieter + '\'' +
                ", Thema='" + Thema + '\'' +
                ", Datum='" + Datum + '\'' +
                ", Zeit='" + Zeit + '\'' +
                ", Ort='" + Ort + '\'' +
                '}';
    }
}
