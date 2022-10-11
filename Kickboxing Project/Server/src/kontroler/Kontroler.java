/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;


import db.DBBroker;
import domen.Clan;
import domen.Grupa;
import domen.Prisustvo;
import domen.Trener;
import domen.Trening;
import so.IzmeniClanaSO;
import so.IzmeniGrupuSO;
import so.IzmeniTreneraSO;
import so.ObrisiClanaSO;
import so.ObrisiGrupuSO;
import so.ObrisiPrisustvoSO;
import so.ObrisiTreningSO;
import so.PretraziClanoveSO;
import so.PretraziGrupeSO;
import so.PretraziPrisustvaSO;
import so.PretraziTreningeSO;
import so.PronadjiClanaSO;
import so.PronadjiTreneraSO;
import so.VratiListuClanovaSO;
import so.VratiListuGrupaSO;
import so.VratiListuPrisustvaSO;
import so.VratiListuTreningaSO;
import so.ZapamtiClanaSO;
import so.ZapamtiGrupuSO;
import so.ZapamtiPrisustvoSO;
import so.ZapamtiTreneraSO;
import so.ZapamtiTreningSO;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Natasa
 */

//SERVER
public class Kontroler {
    DBBroker db;
    private static Kontroler instanca; //SINGLETON PATTERN - klasa ima samo jednu instancu, može da se pozove od spolja samo getInstance();

    private Kontroler() {
        db = new DBBroker();
    }
    
    public static Kontroler getInstance(){
        if(instanca==null){
            instanca = new Kontroler();
        }
        
        return instanca; //osigurali smo da niko ne može da napravi kopije naših podataka
        //Na ovaj način, gde god da nam treba kontroler: Kontroler.getInstance().
        //Dobijamo uvek istu instancu kontrolera
    }
    
    public ServerskiOdgovor zapamtiTrenera(Trener t) {
        return new ZapamtiTreneraSO().obradiTransakciju(t);
    }

    public ServerskiOdgovor pronadjiTrenera(Trener trener) {
        return new PronadjiTreneraSO().obradiTransakciju(trener);
    }

    public ServerskiOdgovor pronadjiClana(Clan clan) {
       return new PronadjiClanaSO().obradiTransakciju(clan);
    }
    
    public ServerskiOdgovor vratiListuGrupa(Grupa gru) {
        return new VratiListuGrupaSO().obradiTransakciju(gru);
    }
    
    public ServerskiOdgovor vratiListuClanova(Clan cla) {
        return new VratiListuClanovaSO().obradiTransakciju(cla);
    }
    
    public ServerskiOdgovor vratiListuTreninga(Trening tr) {
        return new VratiListuTreningaSO().obradiTransakciju(tr);
    }
    
    public ServerskiOdgovor zapamtiClana(Clan c) {
        return new ZapamtiClanaSO().obradiTransakciju(c);
    }
   

    public ServerskiOdgovor izmeniGrupu(Grupa g) {
        return new IzmeniGrupuSO().obradiTransakciju(g);
    }
    
    public ServerskiOdgovor zapamtiGrupu(Grupa grupa) {
       return new ZapamtiGrupuSO().obradiTransakciju(grupa);
    }
    
    public ServerskiOdgovor obrisiGrupu(Grupa gr) {
        return new ObrisiGrupuSO().obradiTransakciju(gr);
    }
    
    public ServerskiOdgovor obrisiClana(Clan clanObrisi) {
        return new ObrisiClanaSO().obradiTransakciju(clanObrisi);
    }
    
    public ServerskiOdgovor izmeniClana(Clan cl) {
       return new IzmeniClanaSO().obradiTransakciju(cl);
    }
    
    public ServerskiOdgovor zapamtiTrening(Trening trening) {
        return new ZapamtiTreningSO().obradiTransakciju(trening);
    }
    
    public ServerskiOdgovor vratiListuPrisusva(Prisustvo p) {
        return new VratiListuPrisustvaSO().obradiTransakciju(p);
    }

    public ServerskiOdgovor zapamtiPrisustvo(Prisustvo prisustvo) {
        return new ZapamtiPrisustvoSO().obradiTransakciju(prisustvo);
    }

    public ServerskiOdgovor izmeniTrenera(Trener tr) {
        return new IzmeniTreneraSO().obradiTransakciju(tr);
    }

    public ServerskiOdgovor obrisiPrisustvo(Prisustvo pObrisi) {
        return new ObrisiPrisustvoSO().obradiTransakciju(pObrisi);
    }

    public ServerskiOdgovor obrisiTrening(Trening tObrisi) {
        return new ObrisiTreningSO().obradiTransakciju(tObrisi);
    }

    public ServerskiOdgovor pretraziClanove(Clan clan1) {
        return new PretraziClanoveSO().obradiTransakciju(clan1);
    }

    public ServerskiOdgovor pretraziPrisustva(Prisustvo pr) {
        return new PretraziPrisustvaSO().obradiTransakciju(pr);
    }

    public ServerskiOdgovor pretraziGrupe(Grupa grup) {
        return new PretraziGrupeSO().obradiTransakciju(grup);
    }

    public ServerskiOdgovor pretraziTreninge(Trening tre) {
       return new PretraziTreningeSO().obradiTransakciju(tre);
    }

    

    
}
