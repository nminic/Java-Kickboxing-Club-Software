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
public class PronadjiClanaSO extends OpstaSistemskaOperacija{
    
    public PronadjiClanaSO(){
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
        ArrayList<OpstiDomenskiObjekat> listaClanova = odo.ucitajRS(db.vratiObjekat(odo));
        if(listaClanova.isEmpty()){
            throw new Exception("Sistem ne može da pronađe člana na osnovu unetih kredencijala!");
        }   
        so.setOdgovor(listaClanova.get(0));
        so.setPoruka("Uspešna prijava!");
        so.setUspesnost(true);
        }
        
        catch(Exception e){
            so.setUspesnost(false);
            throw new Exception("Sistem ne može da pronađe člana!!");
        }
        return so;
    }
    
}
