/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Trening;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natasa
 */
public class TableModelTreningEvidencija extends AbstractTableModel {

    ArrayList<Trening> listaTreninga;

    public TableModelTreningEvidencija(ArrayList<Trening> listaTreninga) {
        this.listaTreninga = listaTreninga;
    }

    @Override
    public int getRowCount() {
        return listaTreninga.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trening t = listaTreninga.get(rowIndex);

        switch (columnIndex) {
            case 0:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                return sdf.format(t.getDatumVreme());
            case 1:
                return t.getOpis();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Datum i vreme treninga";
            case 1:
                return "Opis";
            default:
                return "n/a";
        }
    }

    public void setListaTreninga(ArrayList<Trening> listaTreninga) {
        this.listaTreninga = listaTreninga;
        fireTableDataChanged();
    }

    public ArrayList<Trening> getListaTreninga() {
        return listaTreninga;
    }
    
     public Trening uzmiTrening(int red){
        Trening trening = listaTreninga.get(red);
        return trening;
    }
    
}
