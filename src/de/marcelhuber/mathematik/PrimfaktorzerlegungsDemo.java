package de.marcelhuber.mathematik;

import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class PrimfaktorzerlegungsDemo {

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
        System.out.println(Long.MAX_VALUE);
        long zahl = 92233726L; // 4323422L; // 67534856847L;
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
