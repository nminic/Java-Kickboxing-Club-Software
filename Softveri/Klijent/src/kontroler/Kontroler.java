/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Clan;
import domen.Grupa;
import domen.Prisustvo;
import domen.Trener;
import domen.Trening;
import forma.FrmPocetna;
import javax.swing.JOptionPane;
import komunikacija.KomunikacijaSaServerom;
import konstanta.Operacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */
//KLIJENT
public class Kontroler {

    private static Kontroler instanca; //SINGLETON PATTERN - klasa ima samo jednu instancu, može da se pozove od spolja samo getInstance();
    Clan trenutnoUlogovanClan;
    Trener trenutnoUlogovanTrener;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instanca == null) {
            instanca = new Kontroler();
        }

        return instanca; //osigurali smo da niko ne može da napravi kopije naših podataka
        //Na ovaj način, gde god da nam treba kontroler: Kontroler.getInstance().
        //Dobijamo uvek istu instancu kontrolera
    }

    public void start() {
        new FrmPocetna().setVisible(true);
    }

    public ServerskiOdgovor zapamtiTrenera(Trener t) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.ZAPAMTI_TRENERA);
        kz.setParametar(t);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor pronadjiTrenera(Trener t) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.PRIJAVI_SE_TRENER);
        kz.setParametar(t);

        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        Trener trener = (Trener) so.getOdgovor(); //parametar

        if (trener == null) {
            so.setUspesnost(false);
        } else {
            trenutnoUlogovanTrener = trener;
            so.setOdgovor(trenutnoUlogovanTrener);
            so.setUspesnost(true);
        }

        return so;
    }

    public ServerskiOdgovor pronadjiClana(Clan c) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.PRIJAVI_SE_CLAN);
        kz.setParametar(c);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);

        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        //ArrayList<Clan> lista = (ArrayList<Clan>) so.getOdgovor();
        //Clan clan = lista.get(0);
        Clan clan = (Clan) so.getOdgovor();
        JOptionPane.showMessageDialog(null, so.getPoruka());

        if (clan == null) {
            so.setUspesnost(false);
            so.setPoruka("Nepostojeći član!");
        } else {
            trenutnoUlogovanClan = clan;
            so.setOdgovor(trenutnoUlogovanClan);
            so.setUspesnost(true);
        }
        return so;

    }

    public ServerskiOdgovor vratiListuGrupa() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_GRUPA);
        kz.setParametar(new Grupa());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor vratiListuTreninga() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_TRENINGA);
        kz.setParametar(new Trening());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor vratiListuClanova() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_CLANOVA);
        kz.setParametar(new Clan());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor zapamtiClana(Clan clan) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.ZAPAMTI_CLANA);
        kz.setParametar(clan);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }
    
     public ServerskiOdgovor pretraziClanove() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.PRETRAZI_CLANOVE);
        kz.setParametar(new Clan());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniGrupu(Grupa grupa) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.IZMENI_GRUPU);
        kz.setParametar(grupa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor zapamtiGrupu(Grupa grupa) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.ZAPAMTI_GRUPU);
        kz.setParametar(grupa);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiGrupu(Grupa obrisana) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_GRUPU);
        kz.setParametar(obrisana);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiClana(Clan obrisan) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_CLANA);
        kz.setParametar(obrisan);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }
    
     public ServerskiOdgovor pretraziTreninge() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.PRETRAZI_TRENINGE);
        kz.setParametar(new Trening());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniClana(Clan izmenjen) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.IZMENI_CLANA);
        kz.setParametar(izmenjen);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor vratiTreninge() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_TRENINGE);
        kz.setParametar(new Trening());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor zapamtiTrening(Trening trening) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.ZAPAMTI_TRENING);
        kz.setParametar(trening);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor vratiListuPrisustva() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.VRATI_LISTU_PRISUSVA);
        kz.setParametar(new Prisustvo());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor zapamtiPrisustvo(Prisustvo prisustvo) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.ZAPAMTI_PRISUSTVO);
        kz.setParametar(prisustvo);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }
    
     public ServerskiOdgovor pretraziGrupe() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.PRETRAZI_GRUPE);
        kz.setParametar(new Grupa());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor izmeniTrenera(Trener izmenjen) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.IZMENI_TRENERA);
        kz.setParametar(izmenjen);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiPrisustvo(Prisustvo obrisano) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_PRISUSTVO);
        kz.setParametar(obrisano);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

    public ServerskiOdgovor obrisiTrening(Trening obrisan) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.OBRISI_TRENING);
        kz.setParametar(obrisan);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

     public ServerskiOdgovor pretraziPrisustva() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacija.PRETRAZI_PRISUSTVA);
        kz.setParametar(new Prisustvo());
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        return so;
    }

}
