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
public class IzmeniTreneraSO extends OpstaSistemskaOperacija {

    public IzmeniTreneraSO() {
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
         ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            
            db.izmeniObjekat(odo);
          
            so.setPoruka("Sistem je uspešno izmenio podatke o treneru!!");
            so.setUspesnost(true);
        
        }catch(Exception e){
            Logger.getLogger(IzmeniTreneraSO.class.getName()).log(Level.SEVERE, null, e);
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem je neuspešno izmenio podatke o treneru!!");
        }
        return so;
    }

}
