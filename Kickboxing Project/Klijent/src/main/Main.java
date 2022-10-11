/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import kontroler.Kontroler;

/**
 *
 * @author Natasa
 */
public class Main {
    public static void main(String[] args) {
        //new FrmPocetna().setVisible(true); //tačka ulaza
        
        //u pocetku smo pisali direktno setVisible, ali sad imamo Controller preko koga ide sve, pa pisemo
        Kontroler.getInstance().start(); //pokretanje aplikacije - premestili smo u Controller
    }
}
