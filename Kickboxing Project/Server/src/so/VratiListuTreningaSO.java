/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.sql.SQLException;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class VratiListuTreningaSO extends OpstaSistemskaOperacija{

    public VratiListuTreningaSO() {
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();
        
        try{
            ArrayList<OpstiDomenskiObjekat> lista = odo.ucitajRS(db.vratiObjekatSaUslovom(odo));
            so.setOdgovor(lista);
            so.setPoruka("Sistem je učitao listu treninga!");
            so.setUspesnost(true);
        }catch(SQLException e){
            e.printStackTrace();
            throw new Exception("Sistem ne može da učita treninge!");
        }
        return so;
    }
    
}
