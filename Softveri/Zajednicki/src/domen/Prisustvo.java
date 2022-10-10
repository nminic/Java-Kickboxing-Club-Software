/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasa
 */
public class Prisustvo extends OpstiDomenskiObjekat {

    private Long prisustvoID;
    private Trening trening;
    private boolean status;
    private String napomena;
    private Clan clan;

    public Prisustvo() {
    }

    public Prisustvo(Long prisustvoID, Trening trening, boolean status, String napomena, Clan clan) {
        this.prisustvoID = prisustvoID;
        this.trening = trening;
        this.status = status;
        this.napomena = napomena;
        this.clan = clan;
    }


    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   
    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
    
    

    @Override
    public String vratiNazivTabele() {
        return " Prisustvo ";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> prisustvo = new ArrayList<>();
        try {
            while (rs.next()) {
                Trener trener = new Trener(rs.getLong("trenerID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("password"), rs.getDate("datumRodjenja"));
                Grupa grupa = new Grupa(rs.getLong("grupaID"), rs.getString("naziv"), rs.getInt("kapacitet"), rs.getInt("brojClanova"), trener);
                Clan clan = new Clan(rs.getLong("clanID"), rs.getString("ime"), rs.getString("prezime"), rs.getDate("datumRodjenja"), rs.getString("brojTelefona"), rs.getString("email"), rs.getString("password"), grupa);
                Trening trening = new Trening(rs.getLong("treningID"), new Timestamp(rs.getTimestamp("datumVreme").getTime()), rs.getString("opis"), trener, grupa);
                
                Long prisustvoID = rs.getLong("prisustvoID");
                boolean status = rs.getBoolean("status");
                String napomena = rs.getString("napomena");
                
              
                Prisustvo pr = new Prisustvo(prisustvoID, trening, status, napomena, clan);
                prisustvo.add(pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prisustvo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prisustvo;
    }

    @Override
    public String vratiKoloneZaInsert() {
        return " (prisustvoID, clanID, treningID, napomena, status) ";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'"+prisustvoID+"', '"+clan.getClanID()+"', '"+trening.getTreningID()+"', '"+napomena+"', '"+status+"'";
    }

    @Override
    public String vratiPK() {
        return "prisustvoID=" + prisustvoID;
    }

    @Override
    public String vratiAlias() {
        return " p ";
    }

    @Override
    public String vratiJoinUslov() {
        return "JOIN Trening tr ON tr.TreningID = p.TreningID JOIN Clan c ON c.ClanID = p.ClanID JOIN Grupa g ON c.GrupaID = g.GrupaID";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return "";
    }

    @Override
    public String vratiKolonuMax() {
       return "prisustvoID";
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

    public Long getPrisustvoID() {
        return prisustvoID;
    }

    public void setPrisustvoID(Long prisustvoID) {
        this.prisustvoID = prisustvoID;
    }

    
}
