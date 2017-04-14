package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.*;

/**
 *
 * @author Marcel Huber
 */
public class LoesungGleichungaxPlusbyGleichn {

    boolean showCalculation;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new LoesungGleichungaxPlusbyGleichn().go();
    }

    private void go() {
//        showCalculation = true;
        long a = (long) ((Math.random() - 0.5) * Math.pow(10, 3));
        long b = (long) ((Math.random() - 0.5) * Math.pow(10, 3));
        long n = (long) ((Math.random() - 0.5) * Math.pow(10, 3));
        Long[] ergebnisfeld = LoeseGanzzahligeGleichung(a, b, n);
        Long x = ergebnisfeld[0];
        Long y = ergebnisfeld[1];
        String stringB = erstelleStringMitVorzeichen(b);
        String stringX = "", stringY = "";
        if (x != null) {
            stringX = erstelleStringMitVorzeichen(x);
            stringY = erstelleStringMitVorzeichen(y);
        }
        System.out.println("Wir suchen ganzzahlige x,y so, dass die Gleichung\n\n"
                + a + "*x+" + stringB + "*y = " + n + "\n\ngilt, falls sie überhaupt "
                + "lösbar ist!");
        if (x == null) {
            System.out.println("Da ggT(" + a + "," + b + ")="
                    + new GgT().ggTEuclid(a, b) + " kein Teiler von der Zahl " + n
                    + " ist,\ngibt es keine Lösung der obigen Gleichung!");
        } else {
            printErfolgreicheRechnung();
            System.out.println("\nEs ist\n\n" + a + "*" + stringX + "+" + stringB
                    + "*" + stringY + " = " + (a * x + b * y) + ";");
            System.out.println("also  x=" + x + ", y=" + y + ";\n");
            if (a * x + b * y != n) {
                System.out.println("!!!WARNUNG - BITTE NOCHMAL "
                        + "ALLES KONTROLLIEREN!!!");
            }
            System.out.println();
        }
    }

    private String erstelleStringMitVorzeichen(long r) {
        if (r >= 0) {
            return "" + r;
        } else {
            return "(" + r + ")";
        }
    }

    private Long[] LoeseGanzzahligeGleichung(long a, long b, long n) {
        Long[] rueckgabeFeld = new Long[2];
        long[] hilfsfeld;
        Long x = null, y = null;
        GgT ggTDummy = new GgT();
        long d = ggTDummy.ggTEuclid(a, b);
        if (showCalculation) {
            System.out.println("a=" + a);
            System.out.println("b=" + b);
            System.out.println("n=" + n);
            System.out.println("d=ggT(a,b)=" + d);
        }
        // es gilt d|n  <==> ggT(d,n)=d für d,n aus IN, denn:
        // aus d|n folgt ggT(d,n) >= d, da ja auch d|d gilt;
        // Ist nun t aus IN mit t|d und t|n, so gilt natürlich 
        // sowieso schon t|d und damit ist in der Tat ggT(d,n)=d.
        if (Math.abs(ggTDummy.ggTEuclid(d, n)) != Math.abs(d)) {
            if (showCalculation) {
                System.out.print("Die Kongruenz " + a + "*x+" + b + "*y = " + n + " ");
                System.out.println("hat keine Lösung in (x,y) aus IZ².");
            }
            return rueckgabeFeld;
        }
        // nun sind a/d und b/d teilerfremd, mit dem erweiterten eukldischen
        // Algorithmus kann man ganze x', y' mit x'*a/d + y'*b/d = 1 berechnen;
        // dann ist a* (x'*n/d) + b*(y'*n/d) = n
        hilfsfeld = ggTDummy.ggTEuclidExtended(a / d, b / d);
        x = hilfsfeld[0];
        y = hilfsfeld[1];
        x *= n / d;
        y *= n / d;
        if (showCalculation) {
            printErfolgreicheRechnung();
            System.out.println("Test: Es war n=" + n);
            System.out.println("Nun ist " + x + "*(" + a + ")+(" + y + ")*(" + b
                    + ")=" + (x * a + y * b));
        }
        rueckgabeFeld = new Long[]{x, y};
        return rueckgabeFeld;
    }

    private void printErfolgreicheRechnung() {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!RECHNUNG ERFLOGREICH!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!\n");
    }
}
