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
public class Vozilo {

    private int sifraVozila;
    private String regBroj;
    private int godinaProzivodnje;
    private String ime;
    private String prezime;

    public Vozilo() {
    }

    public Vozilo(int sifraVozila, String regBroj, int godinaProzivodnje, String ime, String prezime) {
        this.sifraVozila = sifraVozila;
        this.regBroj = regBroj;
        this.godinaProzivodnje = godinaProzivodnje;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getSifraVozila() {
        return sifraVozila;
    }

    public void setSifraVozila(int sifraVozila) {
        this.sifraVozila = sifraVozila;
    }

    public String getRegBroj() {
        return regBroj;
    }

    public void setRegBroj(String regBroj) {
        this.regBroj = regBroj;
    }

    public int getGodinaProzivodnje() {
        return godinaProzivodnje;
    }

    public void setGodinaProzivodnje(int godinaProzivodnje) {
        this.godinaProzivodnje = godinaProzivodnje;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return regBroj;
    }

}
