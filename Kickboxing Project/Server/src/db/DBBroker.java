/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;
import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasa
 */
public class DBBroker {
    
    private Connection konekcija;
    
    public void ucitajDrajver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drajver je ucitan!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greška, drajver nije učitan!");
        }
    }
    
    public void otvoriKonekciju(){
      
      
            String url = "jdbc:mysql://localhost:3306/dbkikboksklub";
            String user = "natasa";
            String password = "sifra";
            
        try {
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false); //mi zelimo da radimo commit
            System.out.println("Uspesno uspostavljanje konekcije!");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska, konekcija nije uspostavljena!");
        }
            
    }
        
    public void zatvoriKonekciju(){
        try {
            konekcija.close();
            System.out.println("Uspesno zatvaranje konekcije!");
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska, konekcija nije zatvorena!");
        }
    }
    
    public void commit(){
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska, commit se nije izvršio!");
        }
    }
    
    public void rollback(){
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska, rollback se nije izvršio!");
        }
    }

    public long vratiMaxID(OpstiDomenskiObjekat odo) throws SQLException {
        long max = 0L;
        String upit = "SELECT max("+odo.vratiKolonuMax()+") AS maxID FROM "+odo.vratiNazivTabele();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        while(rs.next()){
            max = rs.getLong("maxID");
        }
        
        return max;
    }

    public void noviObjekat(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "INSERT INTO "+odo.vratiNazivTabele()+odo.vratiKoloneZaInsert()+"VALUES ("+odo.vratiVrednostiZaInsert()+")";
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
     public ResultSet vratiObjekat(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + " " + odo.vratiWhereUslovSelect();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        return s.executeQuery(upit);
    }

    public ResultSet vratiObjekatSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + odo.vratiAlias() + " " + odo.vratiJoinUslov() + odo.vratiWhereUslov();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return rs;
    }

    public void izmeniObjekat(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate() + " WHERE " +odo.vratiPK();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
                
    }

    public void obrisiObjekat(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM "+odo.vratiNazivTabele()+ " WHERE "+odo.vratiWhereUslov();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }
    
    public void obrisiObjekatSaUslovom(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "DELETE FROM "+odo.vratiNazivTabele()+ " WHERE "+odo.vratiPK();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
    }

    public ResultSet vratiObjekatUslov(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "SELECT * FROM " + odo.vratiNazivTabele() + odo.vratiAlias() + " " + odo.vratiJoinUslov() + odo.vratiWhere();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return rs;
    }
    
        
    
}
