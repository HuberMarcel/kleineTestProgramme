package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class Primfaktorzerlegung {

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
        new Primfaktorzerlegung().go();
    }

    private void go() {
        zerlegeZahl(12);
    }

    public List<List<Long>> zerlegeZahl(long zahl) {
        zahl = Math.abs(zahl);
        this.zahl = zahl;
//        System.out.println("zahl: " + zahl);
        List<Long> primfaktoren = new ArrayList<>();
        List<Long> exponenten = new ArrayList<>();
        PrimzahlTest pzTest = new PrimzahlTest();
        long teiler = 2;
        long exponent;
        while (zahl > 1) {
            // Finde die nächste Primzahl
            while (!pzTest.primAusscheidungsverfahren(teiler)) {
                ++teiler;
            }
            exponent = 0;
            if (zahl % teiler == 0) {
                while (zahl % teiler == 0) {
                    zahl /= teiler;
                    ++exponent;
//                    System.out.println("zahl:     " + zahl);
//                    System.out.println("exponent: " + exponent);
//                    System.out.println("teiler:   " + teiler);
//                    PressEnter.toContinue();
                }
                primfaktoren.add(teiler);
                exponenten.add(exponent);
            }
            ++teiler;
        }
//        Long[] primfaktorenArray = new Long[primfaktoren.size()];
//        Long[] exponentenArray = new Long[exponenten.size()];
//        primfaktoren.toArray(primfaktorenArray);
//        exponenten.toArray(exponentenArray);
//        System.out.println(Arrays.toString(primfaktorenArray));
//        System.out.println(Arrays.toString(exponentenArray));
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
