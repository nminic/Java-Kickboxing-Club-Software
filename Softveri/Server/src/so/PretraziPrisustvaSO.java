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
public class PretraziPrisustvaSO extends OpstaSistemskaOperacija{

    public PretraziPrisustvaSO() {
        super();
    }
    
    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            ArrayList<OpstiDomenskiObjekat> listaPrisustva = odo.ucitajRS(db.vratiObjekatSaUslovom(odo));
            so.setPoruka("Sistem je pronašao prisustva po zadatim kriterijumima!!");
            so.setUspesnost(true);
            so.setOdgovor(listaPrisustva);
        
        } catch(Exception e){
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem nije pronašao prisustva po zadatim kriterijumima!!");
        }
        
        return so;
    }
    
}
