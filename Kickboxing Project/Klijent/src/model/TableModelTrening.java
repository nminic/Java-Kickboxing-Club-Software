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
public class TableModelTrening extends AbstractTableModel {

    ArrayList<Trening> listaTreninga;

    public TableModelTrening(ArrayList<Trening> listaTreninga) {
        this.listaTreninga = listaTreninga;
    }

    @Override
    public int getRowCount() {
        return listaTreninga.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trening t = listaTreninga.get(rowIndex);

        switch (columnIndex) {
            case 0: return t.getTreningID();
            case 1:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                return sdf.format(t.getDatumVreme());
            case 2:
                return t.getOpis();
            case 3:
                return t.getGrupa();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Trening ID";
            case 1:
                return "Datum i vreme treninga";
            case 2:
                return "Opis";
            case 3:
                return "Grupa";
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

    public Trening uzmiTrening(int red) {
        Trening trening = listaTreninga.get(red);
        return trening;
    }
    
     public void obrisiTrening(int red) {
        listaTreninga.remove(red);
        fireTableDataChanged();
    }
}
