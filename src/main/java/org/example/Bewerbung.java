package org.example;

public class Bewerbung {
    private int Projekt;
    private String Stand;

    // region Getters and Setters

    public int getProjekt() {
        return Projekt;
    }

    public void setProjekt(int projekt) {
        Projekt = projekt;
    }

    public String getStand() {
        return Stand;
    }

    public void setStand(String stand) {
        Stand = stand;
    }

    // endregion

    public String toString() {
        return "Bewerbungen{" +
                "Projekt=" + Projekt +
                ", Stand='" + Stand + '\'' +
                '}';
    }
}
