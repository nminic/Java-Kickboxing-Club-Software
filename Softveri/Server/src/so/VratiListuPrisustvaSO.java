/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class VratiListuPrisustvaSO extends OpstaSistemskaOperacija{

    public VratiListuPrisustvaSO() {
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            ArrayList<OpstiDomenskiObjekat> listaPrisustva = odo.ucitajRS(db.vratiObjekatSaUslovom(odo));
            so.setPoruka("Sistem je pronašao prisustva!!");
            so.setUspesnost(true);
            so.setOdgovor(listaPrisustva);
        
        } catch(Exception e){
            so.setUspesnost(false);
            so.setPoruka("Sistem nije pronašao prisusva!!");
            e.printStackTrace();
            throw new Exception("Sistem ne može da vrati prisustva!!");
        }
        
        return so;
    }
    
}
