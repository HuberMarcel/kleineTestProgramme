package de.marcelhuber.kryptographiedemo;

import de.marcelhuber.kryptographie.PrimfaktorzerlegungMitPFZEinesDividenden;
import de.marcelhuber.mathematik.Primfaktorzerlegung;
import de.marcelhuber.systemtools.PressEnter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class PrimfaktorzerlegungMitPFZEinesDividendenDemo {

    long zahl = 10;
    long dividend = 90;

    public static void main(String[] args) {
        PrimfaktorzerlegungMitPFZEinesDividendenDemo dummy
                = new PrimfaktorzerlegungMitPFZEinesDividendenDemo();
        System.out.println("1. Durchlauf:");
        dummy.setZahl(3_424);
        dummy.setDividend(6_704_192);
        dummy.go();
        System.out.println("");
        System.out.println("");
        PressEnter.toContinue();
        System.out.println("2. Durchlauf:");
        dummy.setZahl(3_500);
//        dummy.setDividend(6_706_500);   // das geht nicht
        dummy.setDividend(6_706_000);   // das geht
        dummy.go();
        System.out.println("");
        System.out.println("");
        PressEnter.toContinue();
        System.out.println("3. Durchlauf:");
        dummy.setZahl(3_500);
        dummy.setDividend(6_706_500);   // das geht nicht
//        dummy.setDividend(6_706_000);   // das geht
        dummy.go();
//        System.out.println("");
//        System.out.println("");
    }

    public void go() {
        PrimfaktorzerlegungMitPFZEinesDividenden pfzMitDividendDummy
                = new PrimfaktorzerlegungMitPFZEinesDividenden();
        List<Long> primfaktoren;
        List<Long> exponenten;
        List<List<Long>> ergebnis;
        ergebnis = pfzMitDividendDummy.machePrimfaktorzerlegungMitDividend(zahl, dividend);
        primfaktoren = ergebnis.get(0);
        exponenten = ergebnis.get(1);
        System.out.println("Ihre Zahl war:                          "
                + pfzMitDividendDummy.getZahl());
        System.out.println("Ihr Dividend war:                       "
                + pfzMitDividendDummy.getDividend());
        long[] primfaktorenDividend;
        long[] exponentenDividend;
        Primfaktorzerlegung pfzDummy = new Primfaktorzerlegung();
        pfzDummy.zerlegeZahl(dividend);
        primfaktorenDividend = pfzDummy.getPrimfaktorenAlsArray();
        exponentenDividend = pfzDummy.getExponentenAlsArray();
        System.out.println("");
        System.out.println("Die Primfaktoren des Dividenden:        "
                + Arrays.toString(primfaktorenDividend));
        System.out.println("Die Exponenten des Dividenden:          "
                + Arrays.toString(exponentenDividend));
        System.out.println("");
        System.out.println("Teilt die Zahl wirklich den Dividenden? "
                + pfzMitDividendDummy.isZahlTeiltDividend());
        if (pfzMitDividendDummy.isZahlTeiltDividend()) {
            System.out.println("");
            System.out.println("Die Primfaktoren der obigen Zahl:       "
                    + primfaktoren);
            System.out.println("Die Exponenten der obigen Zahl:         "
                    + exponenten);
        } else {
            System.out.println("Da die Zahl " + zahl + " kein Teiler von "
                    + dividend + " ist, ist die Berechnung der PFZ von "
                    + zahl + " auf diesem\nWege hier "
                    + "nicht möglich!".toUpperCase());
        }
    }

    public long getZahl() {
        return zahl;
    }

    public void setZahl(long zahl) {
        this.zahl = zahl;
    }

    public long getDividend() {
        return dividend;
    }

    public void setDividend(long dividend) {
        this.dividend = dividend;
    }
}
