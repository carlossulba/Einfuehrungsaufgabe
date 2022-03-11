package org.example;

public class Anmeldung {
    private int Event;
    private String Stand;

    // region Getters and Setters

    public int getEvent() {
        return Event;
    }

    public void setEvent(int event) {
        Event = event;
    }

    public String getStand() {
        return Stand;
    }

    public void setStand(String stand) {
        Stand = stand;
    }

    // endregion

    public String toString() {
        return "Anmeldungen{" +
                "Event=" + Event +
                ", Stand='" + Stand + '\'' +
                '}';
    }
}
