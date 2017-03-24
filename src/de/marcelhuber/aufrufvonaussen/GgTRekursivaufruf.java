package de.marcelhuber.aufrufvonaussen;

import de.marcelhuber.kleinetestprogramme.*;

/**
 *
 * @author Marcel
 */
public class GgTRekursivaufruf {

    static int[] argsInt, argsIntDurchGgT;
    static int ggT;

    public static void main(String[] args) {
        argsInt = new int[args.length];
        argsIntDurchGgT = new int[argsInt.length];
        for (int i = 0; i < argsInt.length; i++) {
            System.out.println(args[i]);
            try {
                argsInt[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException ex) {
                System.out.println("Fehlermeldung: " + ex);
                System.out.println("Übergeben Sie ein Feld von Integer-Werten!");
                return;
            }
        }
        ggT = new GgTRekursivaufruf().go(argsInt);
        if (ggT != 0) {
            for (int k = 0; k < argsIntDurchGgT.length; k++) {
                argsIntDurchGgT[k] = argsInt[k] / ggT;
            }
        }
        System.out.println("Die Ausgabe des Feldes nach Division durch den ggT!\n"
                + GgTRekursivaufruf.toStringWerte(argsIntDurchGgT));
    }

    private int go(int... argsInt) {
        GgTRekursiv hilfsRechenObjekt = new GgTRekursiv();
        int[] y;
        if (argsInt.length > 0) {
            y = argsInt;
        } else {
            System.out.print("Da das args[]-Feld leer ist --> Demonstration: ");
            y = new int[]{12, 4, 8, 18};
        }
//        System.out.println(y);
        GgTRekursivaufruf.toString(y);
        System.out.println("Besser lesbar:");
        System.out.println(GgTRekursivaufruf.toStringWerte(y) + "\n");
        return hilfsRechenObjekt.ggT(y);
    }

    private static void toString(int... y) {
        System.out.println("Folgendes Zahlenfeld wird behandelt:");
        for (int z : y) {
            System.out.print(z + " ");
        }
        System.out.println("");
    }

    private static String toStringWerte(int[] x) {
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
