package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;

/**
 *
 * @author Marcel Huber
 */
public class KgV {

    long kgV;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }

        new KgV().go();
    }

    void go() {
        long a, b;
        System.out.print("Eingabe der Zahl a: ");
        a = ReadInput.readLong();
        System.out.print("Eingabe der Zahl b: ");
        b = ReadInput.readLong();
        System.out.println("\nIhre Eingaben waren a=" + a + " ("
                + Long.toString(a).length() + " Stellen) und "
                + "b=" + b + " (" + Long.toString(b).length() + " Stellen)");
        long kgV = kgVNaiv(a, b);
        System.out.println("Der kgV von a=" + a + " und b=" + b
                + " ist: " + kgV);
        System.out.println("\nZum ggT von a=" + a + " und b=" + b + ":");
        if (kgV != 0) {
            System.out.println("Damit ergibt sich übrigens auch der ggT "
                    + "der Zahlen a=" + a + " und b=" + b + " mit |a*b/kgV(a,b)| "
                    + "zu: "
                    + (Math.abs(a * b) / (double) kgV));
        }
        System.out.println("Das Ergebnis der ggT-Berechnung aus der "
                + "naiven ggT-Methode: " + new GgT().ggTNaiv(a, b));
        System.out.print("Die Methode nach Euklid liefert als ggT: ");
        System.out.println(new GgT().ggTEuclid(a, b));
        System.out.println("\nDie schnellere kgV-Berechnung liefert: "
                + kgVNaivFaster(a, b));
        System.out.println("\nZeitvergleich: kgVNaiv-Methode: ");
        long timeKgVNaiv, timeKgVFaster, timeggTNaiv, timeggTEuclid;
        long time = System.nanoTime();
        kgV = kgVNaiv(a, b);
        timeKgVNaiv = System.nanoTime() - time;
        System.out.printf("Berechnung dauerte %3.9f", timeKgVNaiv / Math.pow(10, 9));
        System.out.println(" Sekunden und kgV-Wert: " + kgV);
        System.out.println("kgVNaivFaster-Methode: ");
        time = System.nanoTime();
        kgV = kgVNaivFaster(a, b);
        timeKgVFaster = System.nanoTime() - time;
        System.out.printf("Berechnung dauerte %3.9f", timeKgVFaster / Math.pow(10, 9));
        System.out.println(" Sekunden und kgV-Wert: " + kgV);
        System.out.println("Verhältnis (kgVNaiv zu kgVNaivFaster): "
                + ((double) timeKgVNaiv / time));
        System.out.println("\n\nZeitanalyse bei den GGT-BERECHNUNGEN");
        GgT ggTRechenObjekt = new GgT();
        time = System.nanoTime();
        long ggT = ggTRechenObjekt.ggTNaiv(a, b);
        timeggTNaiv = System.nanoTime() - time;
        System.out.printf("Berechnung dauerte %3.9f", timeggTNaiv / Math.pow(10, 9));
        System.out.println(" Sekunden und kgV-Wert: " + ggT);
        time = System.nanoTime();
        ggT = ggTRechenObjekt.ggTEuclid(a, b);
        timeggTEuclid = System.nanoTime() - time;
        System.out.printf("Berechnung dauerte %3.9f", timeggTEuclid / Math.pow(10, 9));
        System.out.println(" Sekunden und kgV-Wert: " + ggT);
        System.out.println("");
        System.out.println("");
        System.out.println("Interessant ist das Verhältnis der schnellen kgV-"
                + "Berechnung zur ggT-Euklid-Berechnung:");
        System.out.println(((double) timeKgVFaster / timeggTEuclid));
        System.out.println("kgV mit ggT berechnet: " + new KgV().kgVWithGgT(a, b));
    }

    public long kgVNaiv(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        long x = Math.abs(a);
        long y = Math.abs(b);
        while (x != y) {
            while (x < y) {
                x += Math.abs(a);
            }
            while (y < x) {
                y += Math.abs(b);
            }
        }
        return x;
    }

    public long kgVNaivFaster(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        long x = Math.abs(a);
        long y = Math.abs(b);
        while (x != y && y % Math.abs(a) != 0 && x % Math.abs(b) != 0) {
            if (x < y) {
                x = (1 + y / Math.abs(a)) * Math.abs(a);
            } else if (y < x) {
                y = (1 + x / Math.abs(b)) * Math.abs(b);
            }
//            System.out.println("x: " + x);
//            System.out.println("y: " + y);
//            PressEnter.toContinue();
        }
        return Math.max(x, y);
    }

    public long kgVWithGgT(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        long ggT = new GgT().ggTEuclid(a, b);
        assert (ggT != 0) : "Fehler: ggT=0 ist doch passiert!";
        System.out.println("ggT:" + ggT);
        return a * b / ggT;
    }
}
