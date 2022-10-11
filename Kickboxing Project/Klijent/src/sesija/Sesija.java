/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Trener;

/**
 *
 * @author Natasa
 */

//Trener, singleton pattern
public class Sesija {
    private static Sesija instance;
    public Trener trener;
    
    private Sesija(){
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public static Sesija getInstance() {
        if(instance == null){
            instance = new Sesija();
        }
        return instance;
    }

    
    
}
