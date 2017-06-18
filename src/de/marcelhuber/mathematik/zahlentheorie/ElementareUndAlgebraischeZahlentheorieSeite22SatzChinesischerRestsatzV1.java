package de.marcelhuber.mathematik.zahlentheorie;

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber
 */
public class ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1 {

    private long a;
    private long n;
    private long b;
    private long m;
    private long x;
    private boolean loesbar;
    private long newModul;
    private String hinweis;

    private String grundFuerNichtloesbar;

    public static void main(String[] args) {
//        long a = 8;
        long a = 30;
//        long n = 14;
        long n = 7;
//        long b = 12;
        long b = 44;
//        long m = 21;
        long m = 29;
        System.out.println("Wir wollen das System der folgenden beiden "
                + "simultanen Kongruenzen lösen:\n");
        System.out.println("    x kongruent " + a + " (mod " + n + ")     und     "
                + "x kongruent " + b + " (mod " + m + ").\n\n");
        ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1 dummy
                = new ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1();
        dummy.loeseKongruenzsystemChinesischerRestzsatzV1(a, n, b, m);
        if (!dummy.isLoesbar()) {
            System.out.println("Das System der Kongruenzen ist nicht lösbar. Grund:");
            System.out.println(dummy.getGrundFuerNichtloesbar());
        } else {
            System.out.println("Die Lösung lautet:\n\n"
                    + "    x kongruent " + dummy.getX() + " (mod "
                    + dummy.getNewModul() + ").");
            if (dummy.getX() != dummy.findPositiveXMinimal(dummy.getX(), dummy.getNewModul())) {
                System.out.println("(Formuliert mit der kleinsten positive Lösung bedeutet das "
                        + "x kongruent "
                        + dummy.findPositiveXMinimal(dummy.getX(), dummy.getNewModul())
                        + " (mod " + dummy.getNewModul() + ").)\n\n");
            } else {
                System.out.println("\n");
            }
        }
        if (dummy.getHinweis() != null && dummy.getHinweis().length() > 0) {
            System.out.println("[Hinweis:".toUpperCase()
                    + " " + dummy.getHinweis() + "]");
        }
    }

    public boolean loeseKongruenzsystemChinesischerRestzsatzV1(long a, long n, long b, long m) {
        // Methode gibt den Rückgabewert false, falls das Kongruenzsystem nicht lösbar ist
        //                                      andernfalls setzt sie x und newModul 
        // bei der Übergabe sollten m > 0 und n > 0 sein!
        loesbar = false;
        this.a = a;
        this.n = n;
        this.b = b;
        this.m = m;
        if ((m == 0) || (n == 0)) {
            return loesbar;
        }
        if (Math.abs(a) > n) {
            hinweis = "\nSie sollten bei der 1. Kongruenz "
                    + a + " durch " + (a % n) + " ersetzen.";
        }
        if (Math.abs(b) > m) {
            if (hinweis == null) {
                hinweis = "";
            }
            hinweis +=
                    "\nSie sollten bei der 2. Kongruenz "
                    + b + " durch " + (b % m) + " ersetzen.";
        }
        long d;                                  // gemäß des Buches: d = ggT(n,m)
        GgT dummyGgT = new GgT();
        dummyGgT.ggTEuclidExtended(n, m);        // erweiterten eukl. Alg. durchführen
        long y;                                  // gemäß des Buches: d = yn+zm
        d = dummyGgT.getGgT();                   // für m,n > 0 kann d==0 nicht mehr wahr sein!
//        System.out.println("(a-b)%d = " + ((a - b) % d));
        if (!(((a - b) % d) == 0)) {
            loesbar = false;
            grundFuerNichtloesbar = "d = " + d + " = ggT(n,m) = ggT(" + n + ","
                    + m + ") ist kein Teiler von (a-b) = "
                    + "(" + a + "-" + b + ") = " + (a - b) + ".";
//            System.out.println(grundFuerNichtloesbar);
            return loesbar;
        }
        // Das System der simultanen Kongruenzen ist lösbar
        loesbar = true;
        y = dummyGgT.getX();
        // siehe oben - das ist das x im eukl. Algorithmus, 
        // im Buch heißt in dem chin. Restsatz V1.0 halt y
        // newModul=m*n/d wird gerechnet - Verzweigung aus Effizienzgründen
        //                                 und ist so besser wegen Zahlenbereichen
        if (Math.abs(m) > Math.abs(n)) {
            newModul = n * (m / d);
        } else {
            newModul = m * (n / d);
        }
        x = a - ((a - b) / d) * y * n;
        return loesbar;
    }

    public long findPositiveXMinimal(long xLocal, long nModul) {
        if (xLocal % nModul > 0) {
            return (xLocal % nModul);
        } else {
            return ((xLocal % nModul) + nModul);
        }
    }

    public long getA() {
        return a;
    }

    public long getN() {
        return n;
    }

    public long getB() {
        return b;
    }

    public long getM() {
        return m;
    }

    public long getX() {
        return x;
    }

    public String getGrundFuerNichtloesbar() {
        return grundFuerNichtloesbar;
    }

    public boolean isLoesbar() {
        return loesbar;
    }

    public long getNewModul() {
        return newModul;
    }

    public String getHinweis() {
        return hinweis;
    }

    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }
}
