/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class IzmeniClanaSO extends OpstaSistemskaOperacija{

    public IzmeniClanaSO() {
        super();
    }
    

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            
            db.izmeniObjekat(odo);
          
            so.setPoruka("Sistem je uspešno izmenio podatke o članu!!");
            so.setUspesnost(true);
        
        }catch(Exception e){
            Logger.getLogger(IzmeniClanaSO.class.getName()).log(Level.SEVERE, null, e);
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem je neuspešno izmenio podatke o članu!!");
        }
        return so;
    }
    
}
