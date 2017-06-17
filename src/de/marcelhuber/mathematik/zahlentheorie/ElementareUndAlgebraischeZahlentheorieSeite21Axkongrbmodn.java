package de.marcelhuber.mathematik.zahlentheorie;

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.systemtools.ReadInput;

/**
 *
 * @author Marcel Huber
 */
public class ElementareUndAlgebraischeZahlentheorieSeite21Axkongrbmodn {

    private long a;
    private long b;
    private long n;
    private long d;

    private long xKlassenGlobal;
    private boolean nIspositiv;

    public static void main(String[] args) {
        new ElementareUndAlgebraischeZahlentheorieSeite21Axkongrbmodn().go();
    }

    private void go() {
        goEingaben();
        System.out.println("");
        if (!loeseDieKongruenzgleichung(a, b, n)) {
            System.out.println("Da ggT(" + a + "," + n + ") = " + d
                    + " kein Teiler von " + b + " ist, "
                    + "ist die Kongruenz"
                    + "\n\n    " + a + " * x kongruent " + b
                    + " (mod " + n + ")\n\n"
                    + "nicht lösbar!");
        } else {
            System.out.println("Die Kongruenz\n\n    " + a + " * x kongruent " + b
                    + " (mod " + n + ")\n\n"
                    + "hat modulo " + (n / d) + " genau die Lösung "
                    + "x = " + xKlassenGlobal + ".");
            System.out.println("(Eine weitere Lösung wäre also bspw. x = "
                    + (xKlassenGlobal + (n / d)) + ").");
        }
        if (b > n) {
            System.out.println("[Hinweis: ".toUpperCase()
                    + "Sie sollten b = " + b + " durch (b % n) = "
                    + b + " % " + n + " = " + (b % n)
                    + " ersetzen!)]");
        }
    }

    private void goEingaben() {
        System.out.println("Aufgabe: Gesucht sind alle ganzzahligen Lösungen x "
                + "der Kongruenz");
        System.out.println("\n    a * x kongruent b (mod n).");
        System.out.println("");
        System.out.print("Geben Sie a ein:     ");
        a = ReadInput.readLong();
        System.out.print("Geben Sie b ein:     ");
        b = ReadInput.readLong();
        nIspositiv = false;
        do {
            System.out.print("Geben Sie n > 0 ein: ");
            n = ReadInput.readLong();
            if (!(n > 0)) {
                System.out.println("Fehler".toUpperCase()
                        + " - n muss > 0 sein!");
            } else {
                nIspositiv = true;
            }
        } while (!nIspositiv);
    }

    public boolean loeseDieKongruenzgleichung(long a, long b, long n) {
        long x;
        long ggT;
        GgT ggTDummy = new GgT();
        ggTDummy.ggTEuclidExtended(a, n);
        // Vorsicht: Bei ggTEuclid werden die Vorfaktoren der Linearkombination nicht berechnet
        ggT = ggTDummy.getGgT();            // entspricht d aus Satz 4.8
        d = ggT;
        if (b % ggT != 0) {
            return false;
        }
        // Satz 4.8: Falls ggT(a,n) kein Teiler von b ist,
        //           ist die Kongruenz nicht lösbar
        long ggTX = ggTDummy.getX();        // entspricht dem y aus Satz 4.8
        long ggTY = ggTDummy.getY();        // besitzt hier eigentlich keine Bedeutung
        x = (ggTX * (b / ggT)) % (n / ggT);
        xKlassenGlobal = x;
        return true;
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public long getN() {
        return n;
    }

    public long getD() {
        return d;
    }

    public long getxKlassenGlobal() {
        return xKlassenGlobal;
    }
}
