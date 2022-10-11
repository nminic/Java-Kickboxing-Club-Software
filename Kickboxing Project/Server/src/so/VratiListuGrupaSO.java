/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;
import java.util.ArrayList;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class VratiListuGrupaSO extends OpstaSistemskaOperacija{

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            ArrayList<OpstiDomenskiObjekat> lista = odo.ucitajRS(db.vratiObjekat(odo));
        so.setOdgovor(lista);
        so.setPoruka("Sistem je uspešno učitao grupe!");
        so.setUspesnost(true);
        } catch(SQLException e){
            so.setPoruka("Neuspešno učitavanje grupa!");
            e.printStackTrace();
            throw new Exception("Sistem nije pronašao grupe za učitavanje!");
        }
        return so;
    }
    
}
