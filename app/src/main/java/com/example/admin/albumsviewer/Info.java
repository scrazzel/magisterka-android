package com.example.admin.albumsviewer;

public class Info {
    String gatunek;
    double cena;
    int rokWydania;

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public Info() {
    }

    public Info(String gatunek, double cena, int rokWydania) {
        this.gatunek = gatunek;
        this.cena = cena;
        this.rokWydania = rokWydania;
    }
}