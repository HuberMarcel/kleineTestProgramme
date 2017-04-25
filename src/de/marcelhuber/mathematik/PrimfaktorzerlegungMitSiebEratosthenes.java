package de.marcelhuber.mathematik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class PrimfaktorzerlegungMitSiebEratosthenes {

    private List<List<Long>> primfaktorenUndExponten = new ArrayList<>();
    private Long zahl = 133L;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new PrimfaktorzerlegungMitSiebEratosthenes().go();
    }

    private void go() {
//        List<List<Long>> primUndExpo = zerlegeZahl(8);
//        Long[] prim = new Long[primUndExpo.get(0).size()];
//        Long[] expo = new Long[primUndExpo.get(1).size()];
//        primUndExpo.get(0).toArray(prim);
//        primUndExpo.get(1).toArray(expo);
//        System.out.println("Primzahlen: " + Arrays.toString(prim));
//        System.out.println("Exponenten: " + Arrays.toString(expo));
        zerlegeZahl(zahl);
        System.out.println(Arrays.toString(getPrimfaktorenAlsArray()));
        System.out.println(Arrays.toString(getExponentenAlsArray()));
        System.out.println("");
        System.out.println("Es gilt also: ");
        zeigeZahlDarstellung();
        System.out.println("\nKontrolle durch Ausrechnen der rechten Seite:");
        kontrolliereZahlDarstellung();
    }

    public List<List<Long>> zerlegeZahl(long zahl) {
        zahl = Math.abs(zahl);
        this.zahl = zahl;
//        System.out.println("zahl: " + zahl);
        List<Long> primfaktoren = new ArrayList<>();
        List<Long> exponenten = new ArrayList<>();
        Long counter;
        SiebDesEratosthenes sDE = new SiebDesEratosthenes();
        Long[] primzahlenRelevant = sDE.calculateSiebDesEratosthenes(zahl);
//        System.out.println("Ausgabe");
//        System.out.println(Arrays.toString(primzahlenRelevant));
        for (int k = 0; k < primzahlenRelevant.length; k++) {
            if (zahl % primzahlenRelevant[k] == 0) {
                primfaktoren.add(0L + primzahlenRelevant[k]);
                counter = 0L;
                do {
                    zahl /= primzahlenRelevant[k];
                    counter++;
                } while (zahl % primzahlenRelevant[k] == 0);
                exponenten.add(counter);
            }
//            System.out.println("");
        }
        primfaktorenUndExponten.add(primfaktoren);
        primfaktorenUndExponten.add(exponenten);
        return primfaktorenUndExponten;
    }

    public long[] getPrimfaktorenAlsArray() {
        Long[] primzahlenLong
                = new Long[primfaktorenUndExponten.get(0).size()];
        long[] primzahlen = new long[primzahlenLong.length];
        primfaktorenUndExponten.get(0).toArray(primzahlenLong);
        for (int k = 0; k < primzahlen.length; k++) {
            primzahlen[k] = primzahlenLong[k];
        }
        return primzahlen;
    }

    public long[] getExponentenAlsArray() {
        Long[] exponentenLong
                = new Long[primfaktorenUndExponten.get(1).size()];
        long[] exponenten = new long[exponentenLong.length];
        primfaktorenUndExponten.get(1).toArray(exponentenLong);
        for (int k = 0; k < exponenten.length; k++) {
            exponenten[k] = exponentenLong[k];
        }
        return exponenten;
    }

    public void zeigeZahlDarstellung() {
        System.out.print(zahl + " = ");
        for (int i = 0; i < getPrimfaktorenAlsArray().length; i++) {
            System.out.print(getPrimfaktorenAlsArray()[i] + "^{" + getExponentenAlsArray()[i] + "}");
            if (i < getPrimfaktorenAlsArray().length - 1) {
                System.out.print(" * ");
            } else {
                System.out.println("");
            }
        }
    }

    public void kontrolliereZahlDarstellung() {
        long sum = 1L;
        for (int i = 0; i < getPrimfaktorenAlsArray().length; i++) {
            sum = sum * (long) Math.pow(getPrimfaktorenAlsArray()[i], getExponentenAlsArray()[i]);
        }
        System.out.println(sum);
    }

    public Long getZahl() {
        return zahl;
    }
}
