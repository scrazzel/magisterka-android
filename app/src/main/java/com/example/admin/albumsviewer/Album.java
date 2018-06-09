package com.example.admin.albumsviewer;

public class Album {
    String nazwa;
    String wykonawca;
    String gatunek;
    int cena;
    int rokWydania;
    String okladkaAlbumu;
    String logoZespolu;

    public Album(){

    }

    public Album(String nazwa, String wykonawca, String gatunek, int cena, int rokWydania, String okladkaAlbumu, String logoZespolu) {
        this.nazwa = nazwa;
        this.wykonawca = wykonawca;
        this.gatunek = gatunek;
        this.cena = cena;
        this.rokWydania = rokWydania;
        this.okladkaAlbumu = okladkaAlbumu;
        this.logoZespolu = logoZespolu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWykonawca() {
        return wykonawca;
    }

    public void setWykonawca(String wykonawca) {
        this.wykonawca = wykonawca;
    }

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

    public String getOkladkaAlbumu() {
        return okladkaAlbumu;
    }

    public void setOkladkaAlbumu(String okladkaAlbumu) {
        this.okladkaAlbumu = okladkaAlbumu;
    }

    public String getLogoZespolu() {
        return logoZespolu;
    }

    public void setLogoZespolu(String logoZespolu) {
        this.logoZespolu = logoZespolu;
    }
}
