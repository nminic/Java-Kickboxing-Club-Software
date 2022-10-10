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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasa
 */
public class Trener extends OpstiDomenskiObjekat {

    private Long trenerID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String email;
    private String password;

    public Trener() {
    }

    public Trener(Long trenerID, String ime, String prezime, String email, String password, Date datumRodjenja) {
        this.trenerID = trenerID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.datumRodjenja = datumRodjenja;
    }

    public Long getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(Long trenerID) {
        this.trenerID = trenerID;
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

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "Trener";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "(TrenerID, Ime, Prezime, Email, Password, DatumRodjenja)";
                }

    @Override
    public String vratiVrednostiZaInsert() {
        return "" + trenerID + ",'" + ime + "','" + prezime + "','" + email + "','" + password + "','" + new java.sql.Date(datumRodjenja.getTime()) + "'";
    }

    @Override
    public String vratiPK() {
        return "TrenerID=" +trenerID;
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
        return " where Email = '" +email+ "' and Password = '" + password + "'";
     }

    @Override
    public String vratiKolonuMax() {
        return "TrenerID";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> ucitajRS(ResultSet rs) {
        ArrayList<OpstiDomenskiObjekat> listaTrenera = new ArrayList<>();

        try {
            while (rs.next()) {
                long trenerID = rs.getLong("TrenerID");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                Date datumRodjenja = new Date(rs.getDate("DatumRodjenja").getTime());

                Trener t = new Trener(trenerID, ime, prezime, email, password, datumRodjenja);
                listaTrenera.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Trener.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTrenera;}

    @Override
    public String vratiVrednostiZaUpdate() {
        return " ime='"+ime+"', prezime='"+prezime+"', datumRodjenja='"+new java.sql.Date(datumRodjenja.getTime())+"', email='"+email+"', password='"+password+"'";
    
    }

    @Override
    public String vratiWhereUslov() {
        return "";
    }

    @Override
    public String vratiWhereList() {
         return "";
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
        final Trener other = (Trener) obj;
        if (!Objects.equals(this.trenerID, other.trenerID)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiWhere() {
       return "";
    }

    
}
