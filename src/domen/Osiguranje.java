/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.util.Date;

/**
 *
 * @author Milos Dragovic
 */
public class Osiguranje {
    
    private int osiguranjeID;
    private Vozilo vozilo;
    private Date datumPocetka;
    private Date datumUnosa;
    private String imePrezime;
    private double ukupnePremije;

    public Osiguranje() {
    }

    public Osiguranje(int osiguranjeID, Vozilo vozilo, Date datumPocetka, Date datumUnosa, String imePrezime, double ukupnePremije) {
        this.osiguranjeID = osiguranjeID;
        this.vozilo = vozilo;
        this.datumPocetka = datumPocetka;
        this.datumUnosa = datumUnosa;
        this.imePrezime = imePrezime;
        this.ukupnePremije = ukupnePremije;
    }

    public double getUkupnePremije() {
        return ukupnePremije;
    }

    public void setUkupnePremije(double ukupnePremije) {
        this.ukupnePremije = ukupnePremije;
    }

    public int getOsiguranjeID() {
        return osiguranjeID;
    }

    public void setOsiguranjeID(int osiguranjeID) {
        this.osiguranjeID = osiguranjeID;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumUnosa() {
        return datumUnosa;
    }

    public void setDatumUnosa(Date datumUnosa) {
        this.datumUnosa = datumUnosa;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    
    
}
