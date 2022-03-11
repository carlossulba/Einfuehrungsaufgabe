package org.example;

public class Schulung {
    private String Titel;
    private String Trainer;
    private String Niveau;
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

    public String getTrainer() {
        return Trainer;
    }

    public void setTrainer(String trainer) {
        Trainer = trainer;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
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
        return "Schulungen{" +
                "Titel='" + Titel + '\'' +
                ", Trainer='" + Trainer + '\'' +
                ", Niveau='" + Niveau + '\'' +
                ", Datum='" + Datum + '\'' +
                ", Zeit='" + Zeit + '\'' +
                ", Ort='" + Ort + '\'' +
                '}';
    }
}
