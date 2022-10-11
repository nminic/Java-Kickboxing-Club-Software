/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Clan;
import domen.OpstiDomenskiObjekat;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class ZapamtiClanaSO extends OpstaSistemskaOperacija{

    public ZapamtiClanaSO() {
        super();
    }
    
   
    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
        Long clanID = db.vratiMaxID(odo);
        Clan clan = (Clan) odo;
        clan.setClanID(clanID+1);
        db.noviObjekat(odo);
        
        so.setPoruka("Sistem je uspešno sačuvao novog člana!!");
        so.setUspesnost(true);
        }catch(Exception e){
            e.printStackTrace();
            so.setUspesnost(false);
            throw new Exception("Sistem ne može da zapamti novog člana!!");
            
        } 
        return so;
    }
    
}
