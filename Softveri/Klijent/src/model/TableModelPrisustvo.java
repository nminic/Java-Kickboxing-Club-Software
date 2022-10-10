/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Prisustvo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natasa
 */
public class TableModelPrisustvo extends AbstractTableModel {

    ArrayList<Prisustvo> listaPrisustva;

    
    public TableModelPrisustvo(ArrayList<Prisustvo> listaPrisustva) {
        this.listaPrisustva = listaPrisustva;
    }

    @Override
    public int getRowCount() {
        return listaPrisustva.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prisustvo p = listaPrisustva.get(rowIndex);
        switch (columnIndex) {
            
            case 0:
                return p.getPrisustvoID();
            case 1:
                return p.getClan();
            case 2:
                return p.getTrening();
            case 3:
                return p.isStatus();
            case 4:
                return p.getNapomena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Prisustvo ID";
            case 1:
                return "Član";
            case 2:
                return "Datum i vreme treninga";
            case 3:
                return "Prisutan?";
            case 4:
                return "Napomena";
            default:
                return "n/a";
        }
    }

    public void setListaPrisustva(ArrayList<Prisustvo> listaPrisustva) {
        this.listaPrisustva = listaPrisustva;
        fireTableDataChanged();
    }

    public ArrayList<Prisustvo> getListaPrisustva() {
        return listaPrisustva;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 3) return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    public Prisustvo uzmiPrisustvo(int red) {
       Prisustvo prisustvo = listaPrisustva.get(red);
       return prisustvo;
    }
    
     public void obrisiPrisustvo(int red) {
        listaPrisustva.remove(red);
        fireTableDataChanged();
    }

}
