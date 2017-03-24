package de.marcelhuber.kleinetestprogramme;

import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class GgTRekursiv {

    static int summenWert;
//    static int counter;
    static int ggT;
    static int[] ggTFeld = {0, 0, 0};

    public static void main(String[] args) {
        int[] argsInt = new int[args.length];
        int[] argsIntDurchGgT = new int[argsInt.length];

        for (int i = 0; i < argsInt.length; i++) {
            argsInt[i] = Integer.parseInt(args[i]);
        }
//        for (int i : argsInt) {
//            System.out.println("" + i);
//        }
        GgTRekursiv hilfsObjekt = new GgTRekursiv();
        if (args.length > 0) {
            hilfsObjekt.summiereDasFeld(argsInt);
        }
        System.out.println("\nWerte des Eingabefeldes x: \n"
                + GgTRekursiv.toString(argsInt));
        System.out.println("Die Summe aller über alle diese Zahlen ergibt: "
                + summenWert);
//        Testausgabe für'n Array als String
//        System.out.println(Arrays.toString(hilfsObjekt.ggT(2, 3)));
//        System.out.println(GgTRekursiv.toString(hilfsObjekt.ggT(36, 14)));
        System.out.println("Der ggT über alle diese Zahlen ist: "
                + hilfsObjekt.ggT(argsInt));
        System.out.println("ggT statisch: " + ggT + "\n");
        if (ggT > 0) {
            for (int m = 0; m < argsInt.length; m++) {
                argsIntDurchGgT[m] = argsInt[m] / ggT;
            }
        }
        System.out.println("Alle Zahlen durch den ggT!=0 dividiert ergibt das neue "
                + "Feld x: \n");
        System.out.println(GgTRekursiv.toString(argsIntDurchGgT));
        System.out.println("\nZum Vergleich: Zunächst die Werte des übergebenen "
                + "Eingabefeldes:\n" + GgTRekursiv.toStringWerte(argsInt));
        System.out.println("\nNur nochmal kurz die Werte des Feldes nach der oben "
                + "genannten Division:");
        System.out.println(GgTRekursiv.toStringWerte(argsIntDurchGgT));
    }

    int summiereDasFeld(int... x) {
//        ++counter;
        summenWert = sum(summenWert, x[0]);
        int[] y = new int[x.length - 1];
//        System.out.println("y.length: " + y.length);
        for (int k = 0; k < y.length;) {
            y[k] = x[++k];
//            System.out.println("y[" + (k - 1) + "]=" + y[k - 1]);
        }
        int s = x[0];
        if (y.length > 0) {
//            summiereDasFeld(y);
            s = sum(s, summiereDasFeld(y));
        }
        System.out.println("Aktueller Summenwert: " + s);
        return s;
//        System.out.println("counter: " + counter + "; summenWert: " + summenWert);
    }

    private int sum(int a, int b) {
        return a + b;
    }

    int ggT(int... x) {
        if (x.length > 2) {
            int[] y = new int[x.length - 1];
            for (int k = 0; k < y.length; k++) {
                y[k] = x[k + 1];
            }
            ggTFeld = ggT(x[0], ggT(y));
        } else if (x.length == 2) {
            ggTFeld = ggT(x[0], x[1]);
        } else if (x.length == 1) {
            ggTFeld[0] = 0;
            ggTFeld[1] = 1;
            ggTFeld[2] = x[0];
        }
        ggT = ggTFeld[2];
        return ggTFeld[2];
    }

    int[] ggT(int a, int b) {
        int tauschHelfer;
        int[] rueckgabefeld = new int[3];
        int[] xVorf = new int[2];
        int[] yVorf = new int[2];
        int x1, y1;
        int q;
        xVorf[0] = 1;
        xVorf[1] = 0;
        yVorf[0] = 0;
        yVorf[1] = 1;
        int ggT = a;
        rueckgabefeld[0] = xVorf[0];
        rueckgabefeld[1] = yVorf[0];
        if (b != 0) {
            while (!(a % b == 0)) {
                q = a / b;
                tauschHelfer = b;
                b = a % b;
                a = tauschHelfer;
                tauschHelfer = xVorf[1];
                xVorf[1] = xVorf[0] - q * xVorf[1];
                xVorf[0] = tauschHelfer;
                tauschHelfer = yVorf[1];
                yVorf[1] = yVorf[0] - q * yVorf[1];
                yVorf[0] = tauschHelfer;
            }
            ggT = b;
            rueckgabefeld[0] = xVorf[1];
            rueckgabefeld[1] = yVorf[1];
        }

        rueckgabefeld[2] = ggT;

        x1 = xVorf[1];
        y1 = yVorf[1];
        return rueckgabefeld;
    }

    static String toString(int[] x) {
        String str = "";
        for (int i = 0; i < x.length; i++) {
            str += "x[" + i + "]=" + x[i];
            if (i < x.length - 1) {
                str += ", ";
            } else {
                str += "; ";
            }
        }
        return str;
    }

    static String toStringWerte(int[] x) {
        String str = "";
        for (int i = 0; i < x.length; i++) {
            str += "" + x[i];
            if (i < x.length - 1) {
                str += ", ";
            } else {
                str += "; ";
            }
        }
        return str;
    }
}
