/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Trener;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class ZapamtiTreneraSO extends OpstaSistemskaOperacija{

    public ZapamtiTreneraSO() {
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try{
        long trenerID = db.vratiMaxID(odo);
        Trener t = (Trener) odo;
        t.setTrenerID(trenerID+1);
        db.noviObjekat(odo);
        
        so.setPoruka("Sistem je uspešno zapamtio Vaše registracione podatke!!");
        so.setUspesnost(true);
    }catch(Exception ex){
    so.setUspesnost(false);
    ex.printStackTrace();
    throw new Exception("Greška, sistem ne može da zapamti Vaše registracione podatke!!");
}
    
    return so;
    }
}
