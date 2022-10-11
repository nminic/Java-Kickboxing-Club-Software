/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Trening;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class ZapamtiTreningSO extends OpstaSistemskaOperacija{

    public ZapamtiTreningSO() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            
            Long treningID = db.vratiMaxID(odo);
            Trening trening = (Trening) odo;
            trening.setTreningID(treningID+1);
            db.noviObjekat(odo);
            
            so.setPoruka("Sistem je uspešno zapamtio trening sa unetim podacima!!");
            so.setUspesnost(true);
        
        } catch(Exception e){
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem nije zapamtio trening sa unetim podacima!!");
        }
        
        return so;
    }
    
}
