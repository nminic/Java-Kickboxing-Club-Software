/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Natasa
 */
public class ServerskiOdgovor implements Serializable{
    
    private String poruka;
    private Object odgovor;
    private int operacija;
    private boolean uspesnost;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(String poruka, Object odgovor, int operacija, boolean uspesnost) {
        this.poruka = poruka;
        this.odgovor = odgovor;
        this.operacija = operacija;
        this.uspesnost = uspesnost;
    }


    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public boolean isUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(boolean uspesnost) {
        this.uspesnost = uspesnost;
    }

   
    
}
