/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import forma.FrmServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Natasa
 */
public class PokreniServer extends Thread{
    
    FrmServer formaServer;

    public PokreniServer(FrmServer formaServer) {
        this.formaServer = formaServer;
    }

     @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            formaServer.pokrenut();
            
            NitZaZatvaranje nz = new NitZaZatvaranje(ss, this);
            nz.start();
            
            System.out.println("Server je pokrenut!");
            System.out.println("Čekam klijente...");
            
            while(!isInterrupted()){
            Socket socket = ss.accept();
            System.out.println("Klijent se povezao sa serverom!");
            
            //pozivanje klase ObradaKlijentskogZahteva
            ObradaKlijentskogZahteva okz = new ObradaKlijentskogZahteva(socket);
            okz.start();
            }
            
        } catch (IOException ex) {
            formaServer.nijePokrenut();
            System.out.println("Server je zaustavljen!");
            //Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
