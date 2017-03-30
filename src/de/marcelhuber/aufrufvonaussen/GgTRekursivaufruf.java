package de.marcelhuber.aufrufvonaussen;

import de.marcelhuber.kleinetestprogramme.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Marcel
 * Stand: 30.03.2017, 18:00 Uhr
 * 
 */
public class GgTRekursivaufruf {

    static int[] argsInt, argsIntDurchGgT;
    static int ggT;
    static int firstIndexOfDelimiter;
    static List<String> liste = new ArrayList<>();
    List<String> newListe;
    static boolean repeater;

    public static void main(String[] args) {
        argsInt = new int[args.length];
        argsIntDurchGgT = new int[argsInt.length];
        try {
            argsInt = parseArgsToArgsInt(args);
        } catch (NumberFormatException ex) {
            System.out.println("PROGRAMM-ABBRUCH!!");
        }
        GgTRekursivaufruf hilfsObjekt = new GgTRekursivaufruf();
        ggT = hilfsObjekt.goGgT(argsInt);
        if (ggT != 0) {
//            System.out.println(argsIntDurchGgT.length);
            for (int k = 0; k < argsIntDurchGgT.length; k++) {
                argsIntDurchGgT[k] = argsInt[k] / ggT;
//                System.out.print(argsIntDurchGgT[k] + " ;");
            }
        }
        System.out.println("Die Ausgabe des Feldes nach Division durch den ggT! "
                + "(Nur, sofern Übergabeparameter vorhanden waren!)\n"
                + toStringWerte(argsIntDurchGgT));
        String readStr;
        int strVonInts;
//        in der repeaterSetzer()-Methode wollen wir abfragen, wie der Wert
//        der Variablen repeater zu setzen ist - dies ist für/in der folgenden
//        while()-Schleife wichtig
        repeater = repeaterSetzer();
        while (!repeater) {
            liste = new ArrayList<>();
            readStr = "";
            System.out.println("\nIhre Eingabe neuer Werte zur Berechnung des ggT's "
                    + "eben dieser (Leerzeichen als Delimiter): ");
            readStr = readString();
//
            marker();
            marker();
            hilfsObjekt.goTesteMakeArrayListFromString(readStr);
            marker();
            marker();

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
                repeater = true;
            } catch (NumberFormatException nFex) {
                System.out.println("Geben Sie vernünftige Zahlen ein!");
                System.out.println("Fehlermeldung:");
                System.out.println(nFex);
                repeater = false;
            };
            ggT = hilfsObjekt.goGgT(argsInt);
            argsIntDurchGgT = new int[argsInt.length];
//        System.out.println("Ihre Eingabe einer Zahl: ");
//        strVonInts = readInt();
//        System.out.println(strVonInts);
            System.out.println("");
//            marker();
//            System.out.println("GGT " + ggT);
//            marker();
            if (ggT != 0) {
                for (int k = 0; k < argsIntDurchGgT.length; k++) {
                    argsIntDurchGgT[k] = argsInt[k] / ggT;
//                    System.out.print(argsIntDurchGgT[k] + " ;");
                }
            }
            System.out.println("Die Ausgabe des Feldes nach Division durch den ggT!\n"
                    + toStringWerte(argsIntDurchGgT));
            System.out.println("");
            repeater = repeaterSetzer();
        }
        System.out.println("\n");
        marker();
        marker();
        System.out.println("Das Programm wurde von Ihnen beendet");
        marker();
        marker();
    }

//    in der folgenden Methode wollen wir das MakeArrayToString mal mit einem
//    Objekt realisieren, anstatt einer statischen Methode und (Klassen-)"globalen"
//    Variablen
    private void goTesteMakeArrayListFromString(String readStr) {
//        rein aus didaktischen Gründen das this. ergänzt
        this.newListe = new ArrayList<>();
        this.newListe = makeArrayListFromString(this.newListe, readStr, " ");
        String[] strListe = new String[this.newListe.size()];
        this.newListe.toArray(strListe);
        System.out.println(Arrays.toString(strListe));
    }

    private int goGgT(int... argsInt) {
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
        while (firstIndexOfDelimiter == 0) {
            readStr = readStr.substring(1);
            firstIndexOfDelimiter = readStr.indexOf(delimiter);
        }
        if (firstIndexOfDelimiter > 0) {
            if (firstIndexOfDelimiter < readStr.length()) {
                subStr = readStr.substring(0, firstIndexOfDelimiter);
                liste.add(subStr);
//                System.out.println("Ab :" + firstIndexOfDelimiter + " kommt der "
//                        + "Rest:" + readStr.substring(firstIndexOfDelimiter + 1));
                makeArrayListFromString(readStr.substring(firstIndexOfDelimiter + 1),
                        delimiter);
            }
        } else if (readStr.length() > 0) {
            subStr = readStr;
            liste.add(subStr);
//            System.out.println("");
        }
    }

    private List<String> makeArrayListFromString(List<String> newListe, String readStr,
            String delimiter) {
//        System.out.println("Ich bin die makeArrayListFromString-Methode!");
//        System.out.println(""+readStr.indexOf(delimiter));
//        System.out.println(""+readStr.length());
        firstIndexOfDelimiter = readStr.indexOf(delimiter);
        String subStr;
        while (firstIndexOfDelimiter == 0) {
            readStr = readStr.substring(1);
            firstIndexOfDelimiter = readStr.indexOf(delimiter);
        }
        if (firstIndexOfDelimiter > 0) {
            if (firstIndexOfDelimiter < readStr.length()) {
                subStr = readStr.substring(0, firstIndexOfDelimiter);
                newListe.add(subStr);
//                System.out.println("Ab :" + firstIndexOfDelimiter + " kommt der Rest:"
//                        + readStr.substring(firstIndexOfDelimiter + 1));
                makeArrayListFromString(newListe, readStr.substring(firstIndexOfDelimiter + 1),
                        delimiter);
            }
        } else if (readStr.length() > 0) {
            subStr = readStr;
            newListe.add(subStr);
//            System.out.println("");
        }
        return newListe;
    }

    static void marker() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    static boolean repeaterSetzer() {
        marker();
        marker();
        System.out.println("Erneute Berechnung? Abbruch mit Eingabe der 1:");
        int eingeleseneZahl = readInt();
        if (eingeleseneZahl == 1) {
            repeater = true;
        } else {
            repeater = false;
        }
        return repeater;
    }
}
