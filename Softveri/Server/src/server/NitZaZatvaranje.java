/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Natasa
 */
public class NitZaZatvaranje extends Thread{
    ServerSocket serverSocket;
    PokreniServer ps;
    boolean kraj=false;

    public NitZaZatvaranje(ServerSocket serverSocket, PokreniServer ps) {
        this.serverSocket = serverSocket;
        this.ps = ps;
    }

    @Override
    public void run() {
        while(!kraj){
            if(ps.isInterrupted()){
                try {
                    System.out.println("Klijent se iskljucuje!");
                    serverSocket.close();
                    kraj=true;
                } catch (IOException ex) {
                    Logger.getLogger(NitZaZatvaranje.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                sleep(1000); //1s
            } catch (InterruptedException ex) {
                Logger.getLogger(NitZaZatvaranje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    
    
}
