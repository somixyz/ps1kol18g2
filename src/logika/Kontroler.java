/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Korisnik;
import domen.Osiguranje;
import domen.Vozilo;
import domen.VrstaOsiguranja;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milos Dragovic
 */
public class Kontroler {

    private static Kontroler instanca;
    private ArrayList<Korisnik> listaKorisnika;
    private ArrayList<VrstaOsiguranja> listaVrsteOsiguranja;
    private DBBroker dbbroker;

    public Kontroler() {
        dbbroker = new DBBroker();

        listaKorisnika = new ArrayList<>();
        listaKorisnika.add(new Korisnik("Milos Dragovic", "somi", "somi193"));
        listaKorisnika.add(new Korisnik("Petar petrovic", "pera", "pera123"));
        listaKorisnika.add(new Korisnik("filip djordjevic", "djordjevic", "djordjevic"));

        listaVrsteOsiguranja = new ArrayList<>();
        listaVrsteOsiguranja.add(new VrstaOsiguranja(1, "Osnovno osiguranje", 100));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(2, "Mini kasko", 200));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(3, "Kasko", 300));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(1, "Pomoc na putu RS", 150));
        listaVrsteOsiguranja.add(new VrstaOsiguranja(1, "Pomoc na putu neRS", 3500));

    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ArrayList<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public Korisnik login(Korisnik korisnikSaForme) {
        for (Korisnik korisnik : listaKorisnika) {
            if (korisnik.equals(korisnikSaForme)) {
                return korisnik;
            }
        }
        return null;
    }

    public ArrayList<VrstaOsiguranja> getListaVrsteOsiguranja() {
        return listaVrsteOsiguranja;
    }

    public ArrayList<Vozilo> vratiListuVozila() {
        dbbroker.ucitajDrajver();
        dbbroker.uspostaviKonekciju();
        ArrayList<Vozilo> lista = dbbroker.vratiListuVozila();
        dbbroker.zatvoriKonekciju();
        return lista;
    }

    public boolean sacuvajOSiguranje(Osiguranje o) {
        boolean uspesno = false;
        dbbroker.ucitajDrajver();
        dbbroker.uspostaviKonekciju();
        try {
            dbbroker.sacuvaj(o);
            dbbroker.commit();
            uspesno=true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            dbbroker.rollback();
        }
        dbbroker.zatvoriKonekciju();
        return uspesno;
    }

    public ArrayList<Osiguranje> vratiOsiguranja(Vozilo vozilo) {
        dbbroker.ucitajDrajver();
        dbbroker.uspostaviKonekciju();
        ArrayList<Osiguranje> lista = dbbroker.vratiOsiguranje(vozilo);
        dbbroker.zatvoriKonekciju();
        
        return lista;
    }
 

}
