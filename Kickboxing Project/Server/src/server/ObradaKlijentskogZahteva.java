/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Clan;
import domen.Grupa;
import domen.Prisustvo;
import domen.Trener;
import domen.Trening;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstanta.Operacija;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
public class ObradaKlijentskogZahteva extends Thread {

    Socket socket;

    public ObradaKlijentskogZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Pokrenuta je klijentska nit!\n");
        while (true) {

            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();

            switch (kz.getOperacija()) {
                case Operacija.PRIJAVI_SE_TRENER:
                    Trener trener = (Trener) kz.getParametar();
                    so = Kontroler.getInstance().pronadjiTrenera(trener);
                    break;

                case Operacija.PRIJAVI_SE_CLAN:
                    Clan clan = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().pronadjiClana(clan);
                    break;

                case Operacija.ZAPAMTI_TRENERA:
                    Trener t = (Trener) kz.getParametar();
                    so = Kontroler.getInstance().zapamtiTrenera(t);
                    break;

                case Operacija.IZMENI_TRENERA:
                    Trener tren = (Trener) kz.getParametar();
                    so = Kontroler.getInstance().izmeniTrenera(tren);
                    break;

                case Operacija.ZAPAMTI_CLANA:
                    Clan c = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().zapamtiClana(c);
                    break;
                    
                case Operacija.PRETRAZI_CLANOVE:
                    Clan clan1 = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().pretraziClanove(clan1);
                    break;
                    

                case Operacija.IZMENI_CLANA:
                    Clan cl = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().izmeniClana(cl);
                    break;

                case Operacija.OBRISI_CLANA:
                    Clan clanObrisi = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().obrisiClana(clanObrisi);
                    break;

                case Operacija.OBRISI_PRISUSTVO:
                    Prisustvo pObrisi = (Prisustvo) kz.getParametar();
                    so = Kontroler.getInstance().obrisiPrisustvo(pObrisi);
                    break;
                    
                case Operacija.PRETRAZI_PRISUSTVA:
                    Prisustvo pr = (Prisustvo) kz.getParametar();
                    so = Kontroler.getInstance().pretraziPrisustva(pr);
                    break;

                case Operacija.OBRISI_TRENING:
                    Trening tObrisi = (Trening) kz.getParametar();
                    so = Kontroler.getInstance().obrisiTrening(tObrisi);
                    break;
                    
                case Operacija.PRETRAZI_TRENINGE:
                    Trening tre = (Trening) kz.getParametar();
                    so = Kontroler.getInstance().pretraziTreninge(tre);
                    break;

                case Operacija.VRATI_LISTU_CLANOVA:
                    Clan cla = (Clan) kz.getParametar();
                    so = Kontroler.getInstance().vratiListuClanova(cla);
                    break;

                case Operacija.ZAPAMTI_GRUPU:
                    Grupa grupa = (Grupa) kz.getParametar();
                    so = Kontroler.getInstance().zapamtiGrupu(grupa);
                    break;
                    
                case Operacija.PRETRAZI_GRUPE:
                    Grupa grup = (Grupa) kz.getParametar();
                    so = Kontroler.getInstance().pretraziGrupe(grup);
                    break;

                case Operacija.IZMENI_GRUPU:
                    Grupa g = (Grupa) kz.getParametar();
                    so = Kontroler.getInstance().izmeniGrupu(g);
                    break;

                case Operacija.OBRISI_GRUPU:
                    Grupa gr = (Grupa) kz.getParametar();
                    so = Kontroler.getInstance().obrisiGrupu(gr);
                    break;

                case Operacija.VRATI_LISTU_GRUPA:
                    Grupa gru = (Grupa) kz.getParametar();
                    so = Kontroler.getInstance().vratiListuGrupa(gru);
                    break;

                case Operacija.ZAPAMTI_TRENING:
                    Trening trening = (Trening) kz.getParametar();
                    so = Kontroler.getInstance().zapamtiTrening(trening);
                    break;

                case Operacija.VRATI_LISTU_TRENINGA:
                    Trening tr = (Trening) kz.getParametar();
                    so = Kontroler.getInstance().vratiListuTreninga(tr);
                    break;

                case Operacija.ZAPAMTI_PRISUSTVO:
                    Prisustvo prisustvo = (Prisustvo) kz.getParametar();
                    so = Kontroler.getInstance().zapamtiPrisustvo(prisustvo);
                    break;

                case Operacija.VRATI_LISTU_PRISUSVA:
                    Prisustvo p = (Prisustvo) kz.getParametar();
                    so = Kontroler.getInstance().vratiListuPrisusva(p);
                    break;

            }

            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
