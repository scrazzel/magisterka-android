package com.example.admin.albumsviewer;

public class Info {
    String gatunek;
    int cena;
    int rokWydania;

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
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

    public Info(String gatunek, int cena, int rokWydania) {
        this.gatunek = gatunek;
        this.cena = cena;
        this.rokWydania = rokWydania;
    }
}
