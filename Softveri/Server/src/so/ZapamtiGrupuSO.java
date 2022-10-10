/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Grupa;
import domen.OpstiDomenskiObjekat;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class ZapamtiGrupuSO extends OpstaSistemskaOperacija{

    public ZapamtiGrupuSO() {
        super();
    }
    

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
        Long grupaID = db.vratiMaxID(odo);
        Grupa grupa = (Grupa) odo;
        grupa.setGrupaID(grupaID+1);
        db.noviObjekat(odo);
        
        so.setOdgovor(grupa);
        so.setPoruka("Sistem je uspešno sačuvao novu grupu!!");
        so.setUspesnost(true);
        }catch(Exception e){
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem nije sačuvao novu grupu!!");
        }
        return so;
    }
    
}
