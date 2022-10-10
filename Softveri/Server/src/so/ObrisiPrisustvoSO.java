/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Prisustvo;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class ObrisiPrisustvoSO extends OpstaSistemskaOperacija{

    public ObrisiPrisustvoSO() {
        super();
    }

    @Override
    protected ServerskiOdgovor obradiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        ServerskiOdgovor so = new ServerskiOdgovor();

        try {
            Prisustvo prisustvo = (Prisustvo) odo;
            db.obrisiObjekatSaUslovom(odo);

            so.setPoruka("Sistem je obrisao odabrano prisustvo!!");
            so.setUspesnost(true);

        } catch (Exception e) {
            so.setUspesnost(false);
            e.printStackTrace();
            throw new Exception("Sistem nije uspeo da obriše odabrano prisustvo!!");
        }

        return so;
}
}
