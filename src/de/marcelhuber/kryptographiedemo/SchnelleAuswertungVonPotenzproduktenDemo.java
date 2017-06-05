package de.marcelhuber.kryptographiedemo;

import de.marcelhuber.kryptographie.SchnelleAuswertungVonPotenzprodukten;
import de.marcelhuber.systemtools.Marker;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class SchnelleAuswertungVonPotenzproduktenDemo {

    private List<Long> b = new ArrayList<>();                 // die Basen
    private List<Long> e = new ArrayList<>();                 // die Exponenten
    private long result;                                      // das Ergebnis 
    private long result02;
    private long resultKontrolle;
    private long timeSchnelleBerechnung;
    private long time;
    private long m;                                           // das Modul m > 0

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new SchnelleAuswertungVonPotenzproduktenDemo().go();
    }

    private void go() {
        b.add(2L);
        b.add(3L);
        b.add(7L);
        b.add(5L);
        b.add(3L);
        //
        e.add(2L);
        e.add(4L);
        e.add(2L);
        e.add(3L);
        e.add(2L);
        m = 123_117;
        System.out.println("Wir wollen");
        for (int s = 0; s < b.size() - 1; s++) {
            System.out.print(b.get(s) + "^" + e.get(s) + " * ");
        }
        System.out.println(b.get(b.size() - 1) + "^" + e.get(e.size() - 1));
        if (m > 0) {
            System.out.print("... und zwar mod " + m + " ");
        }
        System.out.println("berechnen");
        SchnelleAuswertungVonPotenzprodukten dummyObjekt
                = new SchnelleAuswertungVonPotenzprodukten();
        if (m >= 0) {
            dummyObjekt.setCalcWithModul(true);
            dummyObjekt.setModul(m);
        }
        timeSchnelleBerechnung = System.currentTimeMillis();
        result = dummyObjekt.calcSchnelleAuswertungDerPotenzprodukte(b, e);
        timeSchnelleBerechnung = System.currentTimeMillis() - timeSchnelleBerechnung;
        System.out.println("Das Ergebnis lautet:");
        System.out.println(result);
        Marker.marker();
        System.out.println("Kontrolle:".toUpperCase());
        System.out.println("Die direkte Berechnung liefert: ");
        resultKontrolle = 1;
        time = System.currentTimeMillis();
        for (int s = 0; s < b.size(); s++) {
            resultKontrolle *= Math.pow(b.get(s), e.get(s));
        }
        if (m > 0) {
            resultKontrolle %= m;
        }
        time = System.currentTimeMillis() - time;
        System.out.println(resultKontrolle);
        System.out.println("Zeit für \"Schnelle Auswertung der Potenzprodukte\":  "
                + timeSchnelleBerechnung);
        System.out.println("Zeit für die direkte Berechnung der Potenzprodukte: "
                + time);
        System.out.println("");
        System.out.println("");
        System.out.println("Eine zweite Berechnungsmöglichkeit: ");
        SchnelleAuswertungVonPotenzprodukten dummyObjekt02
                = new SchnelleAuswertungVonPotenzprodukten(b, e, m);
        result02 = dummyObjekt02.calcSchnelleAuswertungDerPotenzProdukte();
        System.out.println("Die zweite Berechnungsmethode liefert: ");
        System.out.println(result02);
        System.out.println("Wurde mit Modul gerechnet? "
                + dummyObjekt02.isCalcWithModul());
        System.out.println("Das Modul war:             "
                + dummyObjekt02.getModul());
    }
}
