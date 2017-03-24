package de.marcelhuber.aufrufvonaussen;

import de.marcelhuber.kleinetestprogramme.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Marcel
 */
public class GgTRekursivaufruf {

    static int[] argsInt, argsIntDurchGgT;
    static int ggT;
    static int firstIndexOfDelimiter;
    static List<String> liste = new ArrayList<>();

    public static void main(String[] args) {
        argsInt = new int[args.length];
        argsIntDurchGgT = new int[argsInt.length];
        try {
            argsInt = parseArgsToArgsInt(args);
        } catch (NumberFormatException ex) {
            System.out.println("PROGRAMM-ABBRUCH!!");
            return;
        }
        GgTRekursivaufruf hilfsObjekt = new GgTRekursivaufruf();
        ggT = hilfsObjekt.go(argsInt);
        if (ggT != 0) {
            for (int k = 0; k < argsIntDurchGgT.length; k++) {
                argsIntDurchGgT[k] = argsInt[k] / ggT;
                System.out.print(argsIntDurchGgT[k] + " ;");
            }
        }
        System.out.println("Die Ausgabe des Feldes nach Division durch den ggT!\n"
                + toStringWerte(argsIntDurchGgT));
        String readStr;
        int strVonInts;
        System.out.println("Ihre Eingabe neuer Werte zur Berechnung des ggT's "
                + "eben dieser: ");
        readStr = readString();
//        TODO: den gelesenen String readStr in die Form des args[] bringen
//        hier wollen wir den obigen String in ein Feld von Strings umwandeln
        makeArrayListFromString(readStr, " ");
//        hier werden wir später mit der ArrayList-liste ein entsprechendes Array
//        anlegen
        String[] strListe = new String[liste.size()];
        liste.toArray(strListe);
        marker();
        System.out.println(Arrays.toString(strListe));
        marker();
        try {
            parseArgsToArgsInt(strListe);
        } catch (NumberFormatException nFex) {
            System.out.println("Geben Sie vernünftige Zahlen ein!");
            System.out.println("Fehlermeldung:");
            System.out.println(nFex);
            return;
        };
        hilfsObjekt.go(argsInt);
//        System.out.println("Ihre Eingabe einer Zahl: ");
//        strVonInts = readInt();
//        System.out.println(strVonInts);
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

    static String readString() {
        // Mit Kanonen auf Spatzen schiessen
//        return new Scanner(System.in).nextLine();

        // effizienter:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException ex) {
            return "";
        }
    }

    static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    static int[] parseArgsToArgsInt(String... args) throws NumberFormatException {
//        System.out.println("parseArgsAufruf mit args.length" + args.length);
        argsInt = new int[args.length];
        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
            argsInt[i] = Integer.parseInt(args[i]);
        }
        return argsInt;
    }

    static void makeArrayListFromString(String readStr, String delimiter) {
//        System.out.println("Ich bin die makeArrayListFromString-Methode!");
//        System.out.println(""+readStr.indexOf(delimiter));
//        System.out.println(""+readStr.length());
        firstIndexOfDelimiter = readStr.indexOf(delimiter);
        String subStr;
        while (firstIndexOfDelimiter == 0){
            readStr = readStr.substring(1);
             firstIndexOfDelimiter = readStr.indexOf(delimiter);
        }
        if (firstIndexOfDelimiter > 0) {
            if (firstIndexOfDelimiter < readStr.length()) {
                subStr = readStr.substring(0, firstIndexOfDelimiter);
                liste.add(subStr);
//                System.out.println("Ab :" + firstIndexOfDelimiter + " kommt der Rest:" + readStr.substring(firstIndexOfDelimiter + 1));
                makeArrayListFromString(readStr.substring(firstIndexOfDelimiter + 1),
                        delimiter);
            }
        } else if (readStr.length() > 0){
            subStr = readStr;
            liste.add(subStr);
        }
        System.out.println("");
    }

    static void marker() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
