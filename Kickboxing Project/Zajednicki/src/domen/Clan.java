/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasa
 */
public class Clan extends OpstiDomenskiObjekat {
    
    private Long clanID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String telefon;
    private String email;
    private String password;
    private Grupa grupa;

    public Clan() {
    }
    
    public Clan(Long clanID, String ime, String prezime, Date datumRodjenja, String telefon, String email, String password, Grupa grupa) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.telefon = telefon;
        this.email = email;
        this.password = password;
        this.grupa = grupa;
    }

    public Clan(Long clanID, String ime, String prezime, Date datumRodjenja, String telefon, String email, String password) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.telefon = telefon;
        this.email = email;
        this.password = password;
    }


    public Long getClanID() {
        return clanID;
    }

    public void setClanID(Long clanID) {
        this.clanID = clanID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return " Clan";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
       ArrayList<OpstiDomenskiObjekat> listaClanova = new ArrayList<>();
       
        try {
            while(rs.next()){
                Trener trener = new Trener(rs.getLong("trenerID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("password"), rs.getDate("datumRodjenja"));
                Grupa grupa = new Grupa(rs.getLong("grupaID"), rs.getString("naziv"), rs.getInt("kapacitet"), rs.getInt("brojClanova"), trener);
                Long clanID = rs.getLong("clanID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                Date datumRodjenja = new java.sql.Date(rs.getDate("datumRodjenja").getTime());
                String brojTelefona = rs.getString("brojTelefona");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Clan clan = new Clan(clanID, ime, prezime, datumRodjenja, brojTelefona, email, password, grupa);
                listaClanova.add(clan);
            }} catch (SQLException ex) {
            Logger.getLogger(Clan.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaClanova;
    }

    @Override
    public String vratiKoloneZaInsert() {
       return " (clanID, ime, prezime, datumRodjenja, brojTelefona, email, password, grupaID)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "" + clanID + ",'"+ime+"','"+prezime+"','"+new java.sql.Date(datumRodjenja.getTime()) + "','" + telefon + "','" + email+ "','" + password + "','" + grupa.getGrupaID() +"'";
    }

    @Override
    public String vratiPK() {
       return "clanID=" + clanID;
    }

    @Override
    public String vratiAlias() {
       return " c ";
    }

    @Override
    public String vratiJoinUslov() {
        return "JOIN Grupa g ON c.GrupaID=g.GrupaID";
    }

    @Override
    public String vratiWhereUslov() {
         return " ORDER BY g.Naziv";
    }

    @Override
    public String vratiKolonuMax() {
        return "clanID";
    }
    

    @Override
    public String vratiVrednostiZaUpdate() {
        return " ime='"+ime+"', prezime='"+prezime+"', datumRodjenja='"+new java.sql.Date(datumRodjenja.getTime())+"', brojTelefona='"+telefon+"', email='"+email+"', password='"+password+"'";
    }

    @Override
    public String vratiWhereUslovSelect() {
        return "c JOIN Grupa g ON c.GrupaID=g.GrupaID where Email = '" +email+ "' and Password = '" + password + "'";
        //return "c JOIN Grupa g ON c.GrupaID=g.GrupaID JOIN Trener t ON g.TrenerID = t.TrenerID";
    }

    @Override
    public String vratiWhereList() {
        return "c JOIN Grupa g ON c.GrupaID = g.GrupaID";
    }

    @Override
    public String vratiWhere() {
        return "";
    }
}
