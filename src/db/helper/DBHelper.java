/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Milos Dragovic
 */
public class DBHelper {

    private Properties pros;

    public DBHelper() throws FileNotFoundException, IOException {
        pros = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        pros.load(fis);
    }

    public String vratiVrednost(String kljuc) {
        return pros.getProperty(kljuc);
    }

}
