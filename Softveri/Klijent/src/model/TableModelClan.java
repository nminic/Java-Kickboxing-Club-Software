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
public class TableModelClan extends AbstractTableModel {

    ArrayList<Clan> listaClanova;

    //Konstruktor sa parametrom listaClanova
    public TableModelClan(ArrayList<Clan> listaClanova) {
        this.listaClanova = listaClanova;
    }

    @Override
    public int getRowCount() {
        return listaClanova.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan c = listaClanova.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return c.getClanID();
            case 1:
                return c.getIme();
            case 2:
                return c.getPrezime();
            case 3:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                return sdf.format(c.getDatumRodjenja());
            case 4:
                return c.getTelefon();
            case 5:
                return c.getEmail();
            case 6:
                return c.getGrupa();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Član ID";
            case 1:
                return "Ime";
            case 2:
                return "Prezime";
            case 3:
                return "Datum rodjenja";
            case 4:
                return "Telefon";
            case 5:
                return "E-mail";
            case 6:
                return "Grupa";
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

    public void obrisiClana(int red) {
        listaClanova.remove(red);
        fireTableDataChanged();
    }

    public Clan uzmiClana(int red) {
        Clan clan = listaClanova.get(red);
        return clan;
    }

}
