// Idee: Sei t ein Teiler von Z = produkt_{k=1}^m p_k^{z_k}
//       mit Primzahlen p_k und natürlichen z_k aus IN = IN \ {0}.
//       Dann ist t = produkt_{k=1}^m p_k^{y_k} mit geeigneten
//       y_k aus IN_0. 
//       Ist r aus {0, ..., z_k} so, dass t | Z/p_k^{z_k-r}, so folgt
//       y_k <= z_k - r. Und wenn dann Z/p_k^{z_k-(r+1)} nicht mehr 
//       von t geteilt wird, dann folgt y_k = z_k - r.
package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.Primfaktorzerlegung;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class PrimfaktorzerlegungMitPFZEinesDividenden {

    private long zahl;
    private long dividend;
    private boolean zahlTeiltDividend;

    private List<Long> primfaktoren = new ArrayList<>();
    private List<Long> exponenten = new ArrayList<>();
    private List<List<Long>> primfaktorenExponenten = new ArrayList<>();

    public static void main(String[] args) {
        new PrimfaktorzerlegungMitPFZEinesDividenden().go();
    }

    private void go() {
        machePrimfaktorzerlegungMitDividend(10, 90);
    }

    public List<List<Long>> machePrimfaktorzerlegungMitDividend(long zahl, long dividend) {
        this.zahl = zahl;
        this.dividend = dividend;
        long[] primfaktorenDesDividenden = new long[0];
        long[] exponentenDesDividenden = new long[0];
        if (checkIfZahlTeiltDividend(zahl, dividend)) {
            Primfaktorzerlegung pfzDummy = new Primfaktorzerlegung();
            pfzDummy.zerlegeZahl(dividend);
            primfaktorenDesDividenden = pfzDummy.getPrimfaktorenAlsArray();
            exponentenDesDividenden = pfzDummy.getExponentenAlsArray();
//            System.out.println(Arrays.toString(primfaktorenDesDividenden));
//            System.out.println(Arrays.toString(exponentenDesDividenden));
            for (long primfaktor : primfaktorenDesDividenden) {
                primfaktoren.add(primfaktor);
            }
            for (long exponent : exponentenDesDividenden) {
                exponenten.add(exponent);
            }
            long exponentenReduzierer;
            for (int k = 0; k < primfaktoren.size(); k++) {
                exponentenReduzierer = 1;
                while (exponenten.get(k) > 0
                        && (dividend / potenziere(primfaktoren.get(k), exponentenReduzierer) % zahl == 0)) {
//                    System.out.println("k:       " + k);
//                    System.out.println("Divisor: "
//                            + (dividend / potenziere(primfaktoren.get(k), exponentenReduzierer) % zahl == 0));
                    exponenten.set(k, exponenten.get(k) - 1);
                    exponentenReduzierer++;
                }
            }
            entfernePrimfaktorenMitExponentenNull();
        }
        List<Long> primfaktorenCopy = primfaktoren;
        List<Long> exponentenCopy = exponenten;
        primfaktorenCopy = Collections.unmodifiableList(primfaktorenCopy);
        exponentenCopy = Collections.unmodifiableList(exponentenCopy);
        primfaktorenExponenten.add(primfaktorenCopy);
        primfaktorenExponenten.add(exponentenCopy);
//            System.out.println(primfaktoren);
//            System.out.println(exponenten);
//        System.out.println(primfaktorenExponenten);
        primfaktorenExponenten = Collections.unmodifiableList(primfaktorenExponenten);
        return primfaktorenExponenten;
    }

    private void entfernePrimfaktorenMitExponentenNull() {
        List<Integer> removeKeys = new ArrayList<>();
        for (int k = 0; k < exponenten.size(); k++) {
            if (exponenten.get(k) == 0) {
                removeKeys.add(k);
            }
        }
        for (int k = 0; k < removeKeys.size(); k++) {
            primfaktoren.remove(removeKeys.get(k) - k);
            exponenten.remove(removeKeys.get(k) - k);
            // Beachte, dass nach dem Entfernen des ersten Elementes
            // die nachfolgenden alle um 1 nach links rutschen, nach 
            // dem des zweiten rutschen alle rechts davon wieder alle 
            // um 1 nach links (also bzgl. der Ausgangsposition um 2)
            // usw. usf.
        }
    }

    private long potenziere(long z, long e) {
        long potenz = 1;
        for (int k = 0; k < e; k++) {
            potenz *= z;
        }
        return potenz;
    }

    private boolean checkIfZahlTeiltDividend(long zahl, long dividend) {
        zahlTeiltDividend = false;
        if (dividend % zahl == 0) {
            zahlTeiltDividend = true;
        }
        return zahlTeiltDividend;
    }

    public boolean isZahlTeiltDividend() {
        return zahlTeiltDividend;
    }

    public List<Long> getPrimfaktoren() {
        return primfaktoren;
    }

    public List<Long> getExponenten() {
        return exponenten;
    }

    public long getZahl() {
        return zahl;
    }

    public long getDividend() {
        return dividend;
    }

    public List<List<Long>> getPrimfaktorenExponenten() {
        return primfaktorenExponenten;
    }
}
