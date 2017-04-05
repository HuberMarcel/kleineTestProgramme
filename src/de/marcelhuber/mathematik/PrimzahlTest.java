/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.marcelhuber.mathematik;

import de.marcelhuber.mathematischeHilfsprogramme.*;
import de.marcelhuber.systemtools.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class PrimzahlTest {

    static private boolean hilfsAnzeige;// = true;
// einschalten (auf true setzen), um 
// Zwischenergebnisse anzuzeigen
    private long pruefZahl;
    private boolean isPossiblePrim;
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
        boolean primPossible;
        for (long j = 100_001; j < 1000_001; j += 2) {
            System.out.println("\nZahl " + j + ":");
            primPossible = primAusscheidungsverfahren(j);
            System.out.println("Status als mögliche Primzahl: " + primPossible
                    + " für " + getPruefZahl() + "!");
            if (!primPossible) {
                PressEnter.toContinue();
            }
        }
        System.out.println("");
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

    public boolean primAusscheidungsverfahren(long checkNumber) {
        pruefZahl = checkNumber;
        if (checkNumber < 3) {
            switch ((int) checkNumber) {
                case 0:
                case 1:
                    isPossiblePrim = false;
                case 2:
                default:
                    System.out.println("Wir untersuchen hier nur "
                            + "positive Zahlen > 2, Sie haben " + checkNumber + " "
                            + "eingegeben!");
                    return isPossiblePrim;
            }
        }
        long gegenKontrolle = checkNumber - 1;
        long z = gegenKontrolle;
        double bHalbe;
        long m = 0;
        long p, q;
        isPossiblePrim = true;
        if (checkNumber % 2 == 0) {
            System.out.println("Die Zahl " + checkNumber + " ist als "
                    + "gerade Zahl sicher nicht prim!");
            isPossiblePrim = false;
        } else {
            while (z % 2 == 0) {
                m++;
                z /= 2;
            }
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + "m: " + m);
            // Nun Test, ob pruefzahl-1 die Form b^m hatte
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + "Prüfzahl: " + pruefzahl);
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + m + "-e Wurzel aus z=" + z);
            bHalbe = Math.pow(z, (double) 1 / m);
//            System.out.println("bHalbe=" + bHalbe);
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + Math.abs(Math.pow((long) bHalbe, m) - gegenKontrolle / Math.pow(2, m)));
            if (Math.abs(Math.pow((long) bHalbe, m) - gegenKontrolle / Math.pow(2, m)) > 0.1) {
                System.out.println("(PrimzahlTest|primAusscheidungsverfahren): Die "
                        + m + "-e Wurzel aus " + z + " ist " + bHalbe + " und damit "
                        + "sicher keine positive ganze Zahl\n(PrimzahlTest|primAusscheidungsverfahren): "
                        + "Voraussetzungen zur Verneinung des Primzahlstatus sind nicht erfüllt!");
                isPossiblePrim = true;
            } else {
                System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                        + "Gewünschte Form ist vorhanden:");
                System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                        + gegenKontrolle + "=(2*" + (long) bHalbe + ")^{" + m + "}");
                if (!hilfsmethoden.getResultCheckIs2erPotenz(m)) {
                    System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                            + "Das kann keine Primzahl sein, da die Frage, ob "
                            + "\n(PrimzahlTest|primAusscheidungsverfahren): "
                            + m + " eine 2er-Potenz ist, beantwortet werden muss "
                            + "mit " + hilfsmethoden.getResultCheckIs2erPotenz(m));
                    p = m;
                    q = 1;
                    while (p % 2 == 0) {
                        p /= 2;
                        q *= 2;
                    }
                    System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                            + m + "=(p*q) mit p=" + p + ", q=" + q + " liefert, dass "
                            + (long) (1 + Math.pow(2 * bHalbe, q)) + "=(" + (long) (2 * bHalbe)
                            + "^{" + q + "}+1) ein Teiler von " + checkNumber + " ist!");
                    System.out.println("(PrimzahlTest|primAusscheidungsverfahren): Kontrolle: "
                            + checkNumber + "/" + (long) (1 + Math.pow(2 * bHalbe, q)) + "="
                            + (double) checkNumber / (long) (1 + Math.pow(2 * bHalbe, q)));
                    isPossiblePrim = false;
                }
            }
        }
        return isPossiblePrim;
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

    public long getPruefZahl() {
        return pruefZahl;
    }

    public boolean getIsPossiblePrim() {
        return isPossiblePrim;
    }

    public boolean getIsPrim() {
        return isPrim;
    }

    public boolean isHilfsAnzeige() {
        return hilfsAnzeige;
    }

    public void setHilfsAnzeige(boolean bool) {
        hilfsAnzeige = bool;
    }
}
