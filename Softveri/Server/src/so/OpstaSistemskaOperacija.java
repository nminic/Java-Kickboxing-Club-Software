/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public abstract class OpstaSistemskaOperacija {

    public DBBroker db;

    public OpstaSistemskaOperacija() {
        db = new DBBroker();
    }

    public ServerskiOdgovor obradiTransakciju(OpstiDomenskiObjekat odo) {
        ServerskiOdgovor so = new ServerskiOdgovor();

        try {
            db.ucitajDrajver();
            db.otvoriKonekciju();
            so = obradiOperaciju(odo);
            db.commit();
        } catch (Exception ex) {
            db.rollback();
            so.setUspesnost(false);
            so.setPoruka(ex.getMessage());
            Logger.getLogger(OpstaSistemskaOperacija.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.zatvoriKonekciju();
        }

        return so;
    }

    protected abstract ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception;

}
