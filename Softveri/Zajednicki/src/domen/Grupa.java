/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasa
 */
public class Grupa extends OpstiDomenskiObjekat {
    
    private Long grupaID;
    private String naziv;
    private int kapacitet;
    private int brojClanova;
    private Trener trener;

    public Grupa() {
    }

    public Grupa(Long grupaID, String naziv, int kapacitet, int brojClanova, Trener trener) {
        this.grupaID = grupaID;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.brojClanova = brojClanova;
        this.trener = trener;
    }


    public Long getGrupaID() {
        return grupaID;
    }

    public void setGrupaID(Long grupaID) {
        this.grupaID = grupaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupa other = (Grupa) obj;
        if (!Objects.equals(this.grupaID, other.grupaID)) {
            return false;
        }
        return true;
    }

    


    public int getBrojClanova() {
        return brojClanova;
    }

    public void setBrojClanova(int brojClanova) {
        this.brojClanova = brojClanova;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return " Grupa";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> listaGrupa = new ArrayList<>();
        
        try {
            while(rs.next()){
                Trener trener = new Trener(rs.getLong("trenerID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("password"), new java.sql.Date(rs.getDate("datumRodjenja").getTime()));
                Grupa grupa = new Grupa(rs.getLong("grupaID"), rs.getString("naziv"), rs.getInt("kapacitet"), rs.getInt("brojClanova"), trener);
                listaGrupa.add(grupa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Grupa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaGrupa;
             
    }

    @Override
    public String vratiKoloneZaInsert() {
        return " (grupaID, naziv, kapacitet, brojClanova, trenerID)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "" + grupaID + ", '" + naziv + "', '" + kapacitet + "', '" + brojClanova + "', '" + trener.getTrenerID() + "'";
    }

    @Override
    public String vratiPK() {
        return "grupaID='" + grupaID+"'";
    }

    @Override
    public String vratiAlias() {
        return "";
    }

    @Override
    public String vratiJoinUslov() {
        return "";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return " g JOIN Trener t ON g.TrenerID = t.TrenerID ORDER BY t.ime";
    }

    @Override
    public String vratiKolonuMax() {
        return "grupaID";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return " brojClanova="+brojClanova;
    }

    @Override
    public String vratiWhereUslov() {
        return " grupaID="+grupaID;
    }

    @Override
    public String vratiWhereList() {
        return "";
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    @Override
    public String vratiWhere() {
        return "";
    }

    

}
