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
public class ObrisiGrupuSO extends OpstaSistemskaOperacija{

    public ObrisiGrupuSO() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            
            Grupa grupa = (Grupa) odo;
            db.obrisiObjekat(odo);
            so.setPoruka("Sistem je uspešno obrisao izabranu grupu!!");
            so.setUspesnost(true);
        }catch(Exception e){
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Neuspešno brisanje grupe!!");
        }
        
        return so;
    }
    
}
