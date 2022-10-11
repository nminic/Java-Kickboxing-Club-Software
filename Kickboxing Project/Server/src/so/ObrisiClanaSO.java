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
public class ObrisiClanaSO extends OpstaSistemskaOperacija{

    public ObrisiClanaSO() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            Clan clan = (Clan) odo;
            db.obrisiObjekatSaUslovom(odo);
            so.setPoruka("Sistem je uspešno obrisao izabranog člana!!");
            so.setUspesnost(true);
        
        }catch(Exception e){
            e.printStackTrace();
            so.setUspesnost(false);
            throw new Exception("Neuspešno brisanje člana!!");
        }
        
        return so;
    }
    
}
