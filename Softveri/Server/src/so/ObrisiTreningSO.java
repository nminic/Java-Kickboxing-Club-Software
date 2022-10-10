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
public class ObrisiTreningSO extends OpstaSistemskaOperacija{

    public ObrisiTreningSO() {
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
         
        try{
            Trening trening = (Trening) odo;
            db.obrisiObjekatSaUslovom(odo);
            
            so.setPoruka("Sistem je obrisao odabrani trening!!");
            so.setUspesnost(true);
        
        } catch(Exception e){
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem nije uspeo da obriše odabrani trening!!");
        }
        
        return so;
    }
    
}
