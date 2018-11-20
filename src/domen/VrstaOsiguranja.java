/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Milos Dragovic
 */
public class VrstaOsiguranja {

    private int sifra;
    private String naziv;
    private double cena;

    public VrstaOsiguranja() {
    }

    public VrstaOsiguranja(int sifra, String naziv, double cena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
 

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VrstaOsiguranja other = (VrstaOsiguranja) obj;
        if (this.sifra != other.sifra) {
            return false;
        }
        return true;
    }
    
    
    
}
