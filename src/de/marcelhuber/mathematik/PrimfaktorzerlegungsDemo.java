package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.*;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class PrimfaktorzerlegungsDemo {

    boolean zahlEingabe;
    long zahl;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new PrimfaktorzerlegungsDemo().go();
    }

    private void go() {
//        System.out.println(Integer.MAX_VALUE);
        zahl = 92233726L; // 447483647; // 547483647; // 1347483647; // 4323422L; // 67534856847L;
        zahlEingabe = true;
        if (zahlEingabe) {
            System.out.println("Geben Sie bitte eine Zahl ein:");
            zahl = ReadInput.readLong();
        }
//        PressEnter.toContinue();
        Primfaktorzerlegung pfz = new Primfaktorzerlegung();
        long time = System.nanoTime();
        pfz.zerlegeZahl(zahl);
        time = System.nanoTime() - time;
        System.out.printf("Die Berechnungen dauerten [s] %n%1$8.2f %n%n",
                time * 1.0 / Math.pow(10, 9));
        System.out.println(Arrays.toString(pfz.getPrimzahlenAlsArray()));
        System.out.println(Arrays.toString(pfz.getExponentenAlsArray()));
        System.out.println("Es gilt also (die Zahl war " + pfz.getZahl() + "):");
        pfz.zeigeZahlDarstellung();
        System.out.println("Kontrolle durch Ausrechnen der rechten Seite:");
        pfz.kontrolliereZahlDarstellung();
    }
}
