/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Grupa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natasa
 */
public class TableModelGrupa extends AbstractTableModel {

    ArrayList<Grupa> listaGrupa;

    public TableModelGrupa(ArrayList<Grupa> listaGrupa) {
        this.listaGrupa = listaGrupa;
    }

    @Override
    public int getRowCount() {
        return listaGrupa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Grupa g = listaGrupa.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return g.getGrupaID();
            case 1:
                return g.getNaziv();
            case 2:
                return g.getKapacitet();
            case 3:
                return g.getBrojClanova();
            case 4:
                return g.getTrener();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Grupa ID";
            case 1:
                return "Naziv";
            case 2:
                return "Kapacitet";
            case 3:
                return "Broj članova";
            case 4:
                return "Trener";
            default:
                return "n/a";
        }
    }
    
    public void obrisiGrupu(int red){
        listaGrupa.remove(red);
        fireTableDataChanged();
    }
    
    public void dodajGrupu(Grupa grupa){
        listaGrupa.add(grupa);
        fireTableDataChanged();
    }
    
    public Long vratiIDGrupe(int red){
        Grupa grupa = listaGrupa.get(red);
        return grupa.getGrupaID();
    }

     public Grupa uzmiGrupu(int red){
        Grupa grupa = listaGrupa.get(red);
        return grupa;
    }
}
