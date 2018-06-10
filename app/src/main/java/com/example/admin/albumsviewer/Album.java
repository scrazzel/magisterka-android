package com.example.admin.albumsviewer;

import java.util.ArrayList;
import java.util.List;

public class Album {
    String nazwa;
    String wykonawca;
    String okladkaAlbumu;
    String logoZespolu;
    Info info;
    ArrayList<String> utwory;

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

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<String> getUtwory() {
        return utwory;
    }

    public void setUtwory(ArrayList<String> utwory) {
        this.utwory = utwory;
    }

    public Album(){}

    public Album(String nazwa, String wykonawca, String okladkaAlbumu, String logoZespolu, Info info, ArrayList<String> utwory) {
        this.nazwa = nazwa;
        this.wykonawca = wykonawca;
        this.okladkaAlbumu = okladkaAlbumu;
        this.logoZespolu = logoZespolu;
        this.info = info;
        this.utwory = utwory;
    }
}