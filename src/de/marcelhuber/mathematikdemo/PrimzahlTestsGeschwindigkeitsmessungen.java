package de.marcelhuber.mathematikdemo;

import de.marcelhuber.mathematik.PrimzahlTest;
import de.marcelhuber.mathematik.SiebDesEratosthenes;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class PrimzahlTestsGeschwindigkeitsmessungen {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new PrimzahlTestsGeschwindigkeitsmessungen().go();
    }

    private void go() {
        long zahl = 53;   // das Produkt der erten Primzahlen < 53 geht noch!!
        //
        long timeSiebDesEratosthenes;
        SiebDesEratosthenes dummySiebEratosthenes = new SiebDesEratosthenes();
        timeSiebDesEratosthenes = System.currentTimeMillis();
        dummySiebEratosthenes.calculateSiebDesEratosthenes(zahl);
        timeSiebDesEratosthenes = System.currentTimeMillis() - timeSiebDesEratosthenes;
        //
        long timePrimzahlMitProduktUndGgT;
        PrimzahlTest dummyPrimzahlTest = new PrimzahlTest();
        timePrimzahlMitProduktUndGgT = System.currentTimeMillis();
        dummyPrimzahlTest.primZahlTestMitProduktUndGgT(zahl);
        timePrimzahlMitProduktUndGgT = System.currentTimeMillis() - timePrimzahlMitProduktUndGgT;
        //
        System.out.println("timeSieb:        " + (long) ((1000 * timeSiebDesEratosthenes) / 1000));
        System.out.println("timePrimzahl...: " + (long) ((1000 * timePrimzahlMitProduktUndGgT) / 1000));
        System.out.println("");
        //
        System.out.println("Primzahlarray mit Sieb:            "
                + dummyPrimzahlTest.getPrimzahlListe());
        System.out.println("Primzahlarray mit Produkt und GgT: "
                + Arrays.toString(dummySiebEratosthenes.calculateSiebDesEratosthenes(zahl)));
    }
}
