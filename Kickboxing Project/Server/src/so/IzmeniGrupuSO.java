/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class IzmeniGrupuSO extends OpstaSistemskaOperacija{

    public IzmeniGrupuSO() {
        super();
    }
    
 
    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
        db.izmeniObjekat(odo);
        so.setPoruka("Sistem je uspešno izmenio grupu!!");
        so.setUspesnost(true);
        } catch(Exception e){
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Neuspešna izmena grupe!!");
        } 
        
        return so;
    }
    
}
