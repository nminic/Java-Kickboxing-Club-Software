/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Clan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natasa
 */
public class TableModelClanEvidencija extends AbstractTableModel {

    ArrayList<Clan> listaClanova; 
    
    public TableModelClanEvidencija(ArrayList<Clan> listaClanova) {
        this.listaClanova = listaClanova;
    }

    @Override
    public int getRowCount() {
        return listaClanova.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan c = listaClanova.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getIme();
            case 1:
                return c.getPrezime();
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return sdf.format(c.getDatumRodjenja());
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ime";
            case 1:
                return "Prezime";
            case 2:
                return "Datum rođenja";
            default:
                return "n/a";
        }
    }

    public ArrayList<Clan> getListaClanova() {
        return listaClanova;
    }

    public void setListaClanova(ArrayList<Clan> listaClanova) {
        this.listaClanova = listaClanova;
        fireTableDataChanged();
    }
    
     public Clan uzmiClana(int red){
        Clan clan = listaClanova.get(red);
        return clan;
    }
        
}
