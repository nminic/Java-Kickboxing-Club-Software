/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Prisustvo;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class ZapamtiPrisustvoSO extends OpstaSistemskaOperacija{

    public ZapamtiPrisustvoSO() {
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            
            Long prisustvoID = db.vratiMaxID(odo);
            Prisustvo prisustvo = (Prisustvo) odo;
            
            prisustvo.setPrisustvoID(prisustvoID+1);
            
            db.noviObjekat(odo);
            
            so.setPoruka("Sistem je sačuvao podatke o novom prisustvu");
            so.setUspesnost(true);
        
        } catch(Exception e){
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem nije sačuvao podatke o novom prisustvu!!");
        }
        
        return so;
    }
    
}
