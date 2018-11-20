/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import domen.VrstaOsiguranja;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milos Dragovic
 */
public class ModelTabeleVrsta extends AbstractTableModel {
    
    
    ArrayList<VrstaOsiguranja> vrste;

    public ModelTabeleVrsta() {
        vrste=new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return vrste.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VrstaOsiguranja vs = vrste.get(rowIndex);
        switch(columnIndex){
            case 0: return vs.getNaziv();
            case 1: return vs.getCena();
            default: return " greska";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Naziv";
            case 1: return "Cena";
            default: return " greska";
        }
    }

    public ArrayList<VrstaOsiguranja> getVrste() {
        return vrste;
    }
    

    public void dodaj(VrstaOsiguranja vs){
        if(!vrste.contains(vs)){
            vrste.add(vs);
        }
        fireTableDataChanged();
    }

    public void obrisi(int red) {
         vrste.remove(red);
         fireTableDataChanged();
    }
    
    
    
}
