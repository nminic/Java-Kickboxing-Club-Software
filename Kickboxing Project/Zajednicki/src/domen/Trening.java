/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasa
 */
public class Trening extends OpstiDomenskiObjekat {
    
    private Long treningID;
    private Date datumVreme;
    private String opis;
    private  Trener trener;
    private  Grupa grupa;
    ArrayList<Grupa> listaGrupa;

    public Trening() {
    }

    public Trening(Long treningID, Date datumVreme, String opis, Trener trener, Grupa grupa, ArrayList<Grupa> listaGrupa) {
        this.treningID = treningID;
        this.datumVreme = datumVreme;
        this.opis = opis;
        this.trener = trener;
        this.grupa = grupa;
        this.listaGrupa = listaGrupa;
    }

    public Trening(Long treningID, Date datumVreme, String opis, Trener trener, Grupa grupa) {
        this.treningID = treningID;
        this.datumVreme = datumVreme;
        this.opis = opis;
        this.trener = trener;
        this.grupa = grupa;
    }
    
    

    public Long getTreningID() {
        return treningID;
    }

    public void setTreningID(Long treningID) {
        this.treningID = treningID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public ArrayList<Grupa> getListaGrupa() {
        return listaGrupa;
    }

    public void setListaGrupa(ArrayList<Grupa> listaGrupa) {
        this.listaGrupa = listaGrupa;
    }
    
    

    @Override
    public String toString() {
        SimpleDateFormat simpleDF = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String datumVremeT = simpleDF.format(datumVreme);
        return datumVremeT;
    }

    @Override
    public String vratiNazivTabele() {
        return " Trening ";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> listaTreninga = new ArrayList<>();
        try {
            while(rs.next()){
                Trener trener = new Trener(rs.getLong("trenerID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("password"), rs.getDate("datumRodjenja"));
                Grupa grupa = new Grupa(rs.getLong("grupaID"), rs.getString("naziv"), rs.getInt("kapacitet"), rs.getInt("brojClanova"), trener);
                
                Trening trening = new Trening(rs.getLong("treningID"), new Timestamp(rs.getTimestamp("datumVreme").getTime()), rs.getString("opis"), trener, grupa);
                listaTreninga.add(trening);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Trening.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTreninga;
    }

    @Override
    public String vratiKoloneZaInsert() {
        return " (treningID, datumVreme, opis, trenerID, grupaID) ";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "" +treningID+",'"+new java.sql.Timestamp(datumVreme.getTime())+"','"+opis+"','"+trener.getTrenerID()+"','"+grupa.getGrupaID()+"'";
    }

    @Override
    public String vratiPK() {
       return "TreningID="+treningID;
    }

    @Override
    public String vratiAlias() {
        return " tr ";
    }

    @Override
    public String vratiJoinUslov() {
        return " JOIN Trener t ON tr.TrenerID=t.TrenerID JOIN Grupa g ON g.GrupaID=tr.GrupaID JOIN Clan c ON c.GrupaID = g.GrupaID  GROUP BY tr.treningID";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return "";
    }

    @Override
    public String vratiKolonuMax() {
        return "treningID";
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiWhereUslov() {
        return " ORDER BY tr.datumVreme";
    }

    @Override
    public String vratiWhereList() {
        return "";
    }

    @Override
    public String vratiWhere() {
       return "";
    }

}
