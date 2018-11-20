/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Osiguranje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milos Dragovic
 */
public class ModelTabeleOsiguranja extends AbstractTableModel {

    private ArrayList<Osiguranje> lista;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public ModelTabeleOsiguranja() {
        lista = new ArrayList<>(); 
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Osiguranje o = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return o.getVozilo();
            case 1:
                return o.getImePrezime();
            case 2:
                return o.getUkupnePremije();
            case 3:
                return o.getDatumPocetka();
            default:
                return "asdasd";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Vozilo";
            case 1:
                return "ImePrezime";
            case 2:
                return "Ukupna premija";
            case 3:
                return "Pocetak vazenja osiguranja";
            default:
                return "asdasd";
        }
    }

    public void setLista(ArrayList<Osiguranje> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

}
