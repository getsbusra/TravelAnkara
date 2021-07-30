package com.example.travelAnkara.Model;

import java.io.Serializable;

public class CardViewObject implements Serializable {
    private int id;
    private String mekanResim;
    private String mekanAdi;
    private String adres;
    private String mekanIlce;
    private String mekanAciklama;
    private String mekanAdresLink;
    private String resimLink;



    public CardViewObject() {
    }

    public CardViewObject(int id, String mekanResim, String mekanAdi, String adres, String mekanIlce, String mekanAciklama,String mekanAdresLink,String resimLink) {
        this.id = id;
        this.mekanResim = mekanResim;
        this.mekanAdi = mekanAdi;
        this.mekanIlce = mekanIlce;
        this.adres = adres;
        this.mekanAciklama = mekanAciklama;
        this.mekanAdresLink = mekanAdresLink;
        this.resimLink = resimLink;

    }

    public String getResimLink() {
        return resimLink;
    }

    public void setResimLink(String resimLink) {
        this.resimLink = resimLink;
    }

    public String getMekanAdresLink() {
        return mekanAdresLink;
    }

    public void setMekanAdresLink(String mekanAdresLink) {
        this.mekanAdresLink = mekanAdresLink;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMekanResim() {
        return mekanResim;
    }

    public void setMekanResim(String mekanResim) {
        this.mekanResim = mekanResim;
    }

    public String getMekanAdi() {
        return mekanAdi;
    }

    public void setMekanAdi(String mekanAdi) {
        this.mekanAdi = mekanAdi;
    }

    public String getMekanIlce() {
        return mekanIlce;
    }

    public void setMekanIlce(String mekanIlce) {
        this.mekanIlce = mekanIlce;
    }

    public String getMekanAciklama() {
        return mekanAciklama;
    }

    public void setMekanAciklama(String mekanAciklama) {
        this.mekanAciklama = mekanAciklama;
    }
}
