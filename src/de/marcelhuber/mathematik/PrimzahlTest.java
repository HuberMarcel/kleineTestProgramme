/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.*;
import java.util.*;

/**
 *
 * @author viona25
 */
public class PrimzahlTest {

    static private boolean hilfsAnzeige;// = true;
// einschalten (auf true setzen), um 
// Zwischenergebnisse anzuzeigen
    private long pruefZahl;
    private boolean isPrim;
    private List<Long> primzahlListe = new ArrayList<>();

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new PrimzahlTest().go();
    }

    private void go() {
        System.out.print("Geben Sie die Zahl ein, von der Sie wissen wollen, "
                + "ob es eine Primzahl ist: ");
        pruefZahl = ReadInput.readLong();
        String ausgabeDesErgebnisses;
        ausgabeDesErgebnisses = naiverPrimzahlTest(pruefZahl);
        System.out.println(ausgabeDesErgebnisses);
        long endZahl;
//        System.out.println("Bis zu welcher Zahl wollen Sie Primzahlen sehen? "
//                + "Ihre Eingabe: " + (endZahl = ReadInput.readLong()));
        System.out.println("Bis zu welcher Zahl wollen Sie Primzahlen sehen? "
                + "Ihre Eingabe: ");
        endZahl = ReadInput.readLong();
        for (long k = 0 * (-endZahl); k < endZahl + 1; k++) {
            if (hilfsAnzeige) {
                System.out.println(naiverPrimzahlTest(k));
            } else {
                naiverPrimzahlTest(k);
            }
            if (isPrim) {
                primzahlListe.add(k);
            }
//            if (k % 25 == 0) {
//                PressEnter.toContinue();
//            }
        }
        Long[] primzahlArray = new Long[primzahlListe.size()];
        primzahlListe.toArray(primzahlArray);
        System.out.println(Arrays.toString(primzahlArray));
    }

    public long naivElementareWurzel(long z) {
        // berechnet die größte ganze Zahl x mit x <= |z| und x^2 < |z|
        int x;
        for (x = 1; x * x <= Math.abs(z); x++) {
        }
        return x - 1;
    }

    public String naiverPrimzahlTest(long z) {
        pruefZahl = z;
        long letzteTestzahl = naivElementareWurzel(z);
//        System.out.println("Letzte Testzahl " + letzteTestzahl + " für " + z);
        isPrim = true;
        long t = 0;
        for (t = 2; t <= letzteTestzahl; t++) {
            if (z % t == 0) {
                isPrim = false;
                break;
            }
        }
        if (z == 0) {
            isPrim = false;
            t = 2;
        }
        if (z != 0) {
            assert (t <= letzteTestzahl + 1) : "\nSchleifendurchlauf funktioniert nicht "
                    + "korrekt oder t wurde manipuliert: t = " + t;
        }
        String ergebnis = "Die Zahl " + z + " ist ";
        ergebnis += (isPrim) ? "prim!" : "nicht prim, sie hat den Teiler " + t + "!";
        if (Math.abs(z) == 1) {
            isPrim = false;
            t = 1;
            ergebnis = ergebnis.substring(0, ergebnis.length() - 5) + "nicht prim!";
        }
        return ergebnis;
    }
    
    public long getPruefZahl(){
        return pruefZahl;
    }
    
    public boolean isPrim(){
        return isPrim;
    }
    
    public boolean isHilfsAnzeige(){
        return hilfsAnzeige;
    }
    
    public void setHilfsAnzeige(boolean bool){
        hilfsAnzeige = bool;
    }
}
