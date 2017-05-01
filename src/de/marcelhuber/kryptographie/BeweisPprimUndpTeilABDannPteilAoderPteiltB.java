package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.Primfaktorzerlegung;
import de.marcelhuber.mathematik.PrimzahlTest;
import de.marcelhuber.systemtools.ReadInput;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class BeweisPprimUndpTeilABDannPteilAoderPteiltB {

    private long a;
    private long b;
    private long p;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new BeweisPprimUndpTeilABDannPteilAoderPteiltB().go();
    }

    private void go() {
        Primfaktorzerlegung pfz1 = new Primfaktorzerlegung();
//        pfz1.zerlegeZahl(31548001);
//        System.out.println(Arrays.toString(pfz1.getPrimfaktorenAlsArray()));
//        System.out.println(Arrays.toString(pfz1.getExponentenAlsArray()));
//        System.out.println(pfz1.getPrimfaktorenAlsArray().length == 1);
//        pfz1.zerlegeZahl(3);
//        System.out.println(Arrays.toString(pfz1.getPrimfaktorenAlsArray()));
//        System.out.println(Arrays.toString(pfz1.getExponentenAlsArray()));
//        System.out.println(pfz1.getPrimfaktorenAlsArray().length == 1);
        System.out.print("Eingabe a: ");
        a = ReadInput.readLong();
        System.out.println("Ihre Eingabe von a war: " + a);
        System.out.print("Eingabe b: ");
        b = ReadInput.readLong();
        System.out.println("Ihre Eingabe von b war: " + b);
        System.out.println("Es ist a*b = " + (a * b));
        boolean pIsprim = false;
        boolean pDividesAB = false;
        Primfaktorzerlegung pfz = new Primfaktorzerlegung();
        while (!(pIsprim && pDividesAB)) {
            System.out.print("Eingabe Primzahl p: ");
            p = ReadInput.readLong();
            System.out.println("Ihre Eingabe von p war: " + p);
            pfz.zerlegeZahl(p);
//            System.out.println(Arrays.toString(pfz.getPrimfaktorenAlsArray()));
//            System.out.println(Arrays.toString(pfz.getExponentenAlsArray()));
            if (pfz.getPrimfaktorenAlsArray().length == 1
                    && pfz.getExponentenAlsArray()[0] == 1) {
                pIsprim = true;
            } else {
                pIsprim = false;
            }
            System.out.println("Ist " + p + " prim? " + pIsprim);
            if (!pIsprim) {
                System.out.println("Wählen Sie p als Primzahl!");
            }
//            pDividesAB = ((a * b) % p == 0) ? true : false;
            pDividesAB = ((a * b) % p == 0);
            System.out.println("Teilt p das Produkt ab? " + pDividesAB);
//            pDividesAB = ((a * b) % p == 0) ? true : false;
            if (!pDividesAB) {
                System.out.println(p + " = p ist kein Teiler von a*b = " + (a * b) + "!");
            }
        }
        startProof(a, b, p);
    }

    private void startProof(long a, long b, long p) {
        if (a % p == 0) {
            System.out.print("a war " + a + ", p war " + p
                    + " und p teilt a:  ");
            System.out.println("Es gilt "
                    + "" + a + "/" + p + " = " + (a / p));
        } else {
            long[] euclidExtended = new long[3];
            euclidExtended = new GgT().ggTEuclidExtended(a, p);
            long x = euclidExtended[0];
            long y = euclidExtended[1]; // jetzt gilt 1 = xa+yp ==> b = xab+ybp
            System.out.println("ab/p = " + ((a * b) / p));
            System.out.println("Es ist " + b + "/" + p
                    + " = " + x + " * " + ((a * b) / p) + " + " + y + " * " + b
                    + " = " + (x * ((a * b) / p) + y * b));
        }
    }

    /**
     * @return the a
     */
    public long getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(long a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public long getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(long b) {
        this.b = b;
    }

    /**
     * @return the p
     */
    public long getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(long p) {
        this.p = p;
    }
}
