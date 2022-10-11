/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Clan;

/**
 *
 * @author Natasa
 */

//Clan, singleton pattern
public class SesijaClan {
    private static SesijaClan instance;
    public Clan clan;
    
    private SesijaClan(){
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
    
    public static SesijaClan getInstance() {
        if(instance == null){
            instance = new SesijaClan();
        }
        return instance;
    }
}
