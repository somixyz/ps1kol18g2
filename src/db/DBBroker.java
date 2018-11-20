/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.helper.DBHelper;
import db.helper.Konstante;
import domen.Osiguranje;
import domen.Vozilo;
import domen.VrstaOsiguranja;
import java.io.IOException;
import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milos Dragovic
 */
public class DBBroker {

    private DBHelper dbhelper;
    private Connection konekcija;

    public DBBroker() {
        try {
            dbhelper = new DBHelper();
        } catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ucitajDrajver() {
        try {
            Class.forName(dbhelper.vratiVrednost(Konstante.DRIVER));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void uspostaviKonekciju() {
        try {
            konekcija = DriverManager.getConnection(dbhelper.vratiVrednost(Konstante.URL),
                    dbhelper.vratiVrednost(Konstante.USER), dbhelper.vratiVrednost(Konstante.PASS));
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void commit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Vozilo> vratiListuVozila() {
        ArrayList<Vozilo> lista = new ArrayList<>();
        try {
            String upit = "SELECT * FROM Vozilo ORDER BY Prezime ASC";
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                lista.add(new Vozilo(rs.getInt("sifraVozila"), rs.getString("regBroj"), rs.getInt("godinaProizvodnje"), rs.getString("ime"), rs.getString("prezime")));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    public ArrayList<VrstaOsiguranja> vratiListuVrstaOsiguranja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sacuvaj(Osiguranje o) throws SQLException {
        String upit = "INSERT INTO osiguranje (sifraVozila,datumPocetka,datumUnosa,imePrezime,ukupnaPremija) VALUES (?,?,?,?,?)";
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setInt(1, o.getVozilo().getSifraVozila());
        ps.setDate(2, new Date(o.getDatumPocetka().getTime()));
        ps.setDate(3, new Date(o.getDatumUnosa().getTime()));
        ps.setString(4, o.getImePrezime());
        ps.setDouble(5, o.getUkupnePremije());

        ps.executeUpdate();

    }

    public ArrayList<Osiguranje> vratiOsiguranje(Vozilo vozilo) {
        ArrayList<Osiguranje> list = new ArrayList<>();
        
        String upit = "SELECT * FROM osiguranje o JOIN vozilo v ON o.sifraVozila=v.sifraVozila WHERE v.sifraVozila="+vozilo.getSifraVozila()+" ORDER BY o.datumPocetka DESC ";
        Statement st;
        try {
            st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {                
                Vozilo v = new Vozilo(rs.getInt("sifraVozila"), rs.getString("regBroj"), rs.getInt("godinaProizvodnje"), rs.getString("ime"), rs.getString("prezime"));
                list.add(new Osiguranje(rs.getInt("osiguranjeID"), v, new java.util.Date(rs.getDate("datumPocetka").getTime()), new java.util.Date(rs.getDate("datumUnosa").getTime()), rs.getString("imePrezime"),rs.getDouble("ukupnaPremija")));
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list;
    }

    
    
    
    
    
    
    
}
