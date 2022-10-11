/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Natasa
 */
public abstract class OpstiDomenskiObjekat implements Serializable {
    
    public abstract String vratiNazivTabele();
    
     public abstract ArrayList<OpstiDomenskiObjekat> ucitajRS(ResultSet rs);
     
     public abstract String vratiKoloneZaInsert();
     
     public abstract String vratiVrednostiZaInsert();
     
     public abstract String vratiVrednostiZaUpdate();
     
     public abstract String vratiPK();
     
     public abstract String vratiAlias();
     
     public abstract String vratiJoinUslov();
     
     public abstract String vratiWhereUslovSelect();
     
     public abstract String vratiWhereUslov();
     
     public abstract String vratiKolonuMax();
     
     public abstract String vratiWhereList();

     public abstract String vratiWhere();

    
     
}
