package de.marcelhuber.raetsel;

import de.marcelhuber.systemtools.PressEnter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// folgendes Raetsel: Wir starten mit der Zahl 1
// darunter schreiben wir immer, wie oft die Zahl der Zeile drüber vorkommt
// Also 1
// 1 Mal die 1:                                             Wir schreiben 11
// 2 Mal die 1:                                             Wir schreiben 21
// 1 Mal die 2 UND 1 Mal die 1:                             Wir schreiben 1211
// 1 Mal die 1 UND 1 Mal die 2 UND 2 Mal die 1:             Wir schreiben 111221       
// 3 Mal die 1 UND 2 Mal die 2 UND 1 Mal die 1:             Wir schreiben 312211
// ...

/**
 *
 * @author Marcel Huber
 */
public class RaetselMitZahlen {

    List<StringBuilder> liste = new ArrayList<>();
    List<Long> ziffernZaehler = new ArrayList<>();
    int anzahl;

    boolean endless;
    boolean zusatzInfos;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new RaetselMitZahlen().go();
    }

    public void go(int anzahl) {
        this.anzahl = anzahl;
        go();
    }
    
    private void go() {
        if (anzahl == 0) {
            anzahl = 20;
        }
        int numberCounter;
        String actualNumber;
        StringBuilder letzteZeile = new StringBuilder("1");
//        letzteZeile.delete(0,1);
//        System.out.println(letzteZeile.length());
//        PressEnter.toContinue();
        StringBuilder neueZeile = new StringBuilder("");
//        neueZeile.append("a");
//        neueZeile.append("b");
//        System.out.println(neueZeile);
        int j = -1;
        endless = false;
        while (++j < anzahl || endless) {
            liste.add(new StringBuilder(letzteZeile));
            ziffernZaehler.add((long) letzteZeile.length());
//            System.out.print("Zeile " + (j + 1) + " :   ");
//            System.out.println(liste.get(j));
            if (zusatzInfos) {
                System.out.println("Zeile Nr." + (j + 1));
            }
            System.out.println(letzteZeile);
            while (letzteZeile.length() > 0) {
                actualNumber = letzteZeile.substring(0, 1);
                numberCounter = 0;
                while (letzteZeile.length() > 0
                        && letzteZeile.substring(0, 1).equals(actualNumber)) {
                    numberCounter++;
                    letzteZeile.delete(0, 1);
                }
                neueZeile.append("" + numberCounter);
                neueZeile.append(actualNumber);
            }
            letzteZeile = new StringBuilder(neueZeile);
            neueZeile.delete(0, neueZeile.length());
//            if (j > 0 && (j + 1) % 5 == 0) {
//                PressEnter.toContinue();
//            }
        }
        if (zusatzInfos) {
            System.out.println("");
            System.out.println("");
            System.out.println("Erneut die Ausgabe:");
//        // Möglichkeit mit enhanced for-Schleide
//        for (StringBuilder listenElement : liste) {
//            System.out.println(listenElement);
//        }
//        for (int i = 0; i < liste.size(); i++) {
//            System.out.println(liste.get(i));
//        }
            // schlechte for-Schleife, da sich die Listengröße während des Durchlaufs ändert
//        for (int i = 0; i < liste.size(); i++) {
//            System.out.println(liste.remove(0));
//        }
            // so würde die vorangegangene Schleife sinnvoll sein
            int size = liste.size();
            for (int i = 0; i < size; i++) {
                System.out.println(liste.remove(0));
            }
            System.out.println("Die Zeile Nr." + ziffernZaehler.size() + " besteht "
                    + "aus " + ziffernZaehler.get(ziffernZaehler.size() - 1)
                    + " Ziffern!");
            Long[] ziffernZaehlerAsArray = new Long[ziffernZaehler.size()];
            ziffernZaehler.toArray(ziffernZaehlerAsArray);
            System.out.println("\n\nHier alle berechneten Zahlen-Werte!");
            System.out.println(Arrays.toString(ziffernZaehlerAsArray));
        }
    }
}
