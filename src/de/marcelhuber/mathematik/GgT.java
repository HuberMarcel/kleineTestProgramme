package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.*;
import static de.marcelhuber.systemtools.PressEnter.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author Marcel Huber Stand: 02.04.2017, 02:10 Uhr
 */
public class GgT {

    static private final StringBuilder programmStart = new StringBuilder("PROGRAMM-START");
    static private final StringBuilder programmEnde = new StringBuilder("PROGRAMM-ENDE");
    static private String ausrufeZeichen = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    static private boolean repeater;

    static {
        programmStartUndEndeAnpasser();
    }

    private long ggT;         // variable für den ggT
    private long x, y;         // x*a+y*b=ggT soll später gelten
    private long tauscher;
    private long[] argsLong;  // long-Feld für Eingabewerte über Konsolenaufruf
    private long[] argsLongDurchGgT;  // long-Feld für Eingabewerte über Konsolenaufruf

    private boolean konsolenparameter;
//                    boolsche Variable, die anzeigt, ob Konsolenparameter sinnvoll waren 

    public static void main(String[] args) {
//        new GgT().ggTEuclidExtended(455, -12);
        marker();
        System.out.println(programmStart);
        marker();
        System.out.println("\n");
//        Die folgende Zeile einkommentieren, wenn Demonstration bei 
//        Programmstart erwünscht
        new GgT().go(args);
        long x, y, ggT;
        long[] ggTEuclid;
        long a = 24, b = 72;
        System.out.println("\n\n");
        marker();
        marker();
        System.out.println("Weitere Demo mit a=" + a + " und b=" + b);
        marker();
        marker();
        System.out.println("\n\n");
        String[] argsAB = {"" + a, "" + b};
        new GgT().go(argsAB);
        ggTEuclid = new GgT().ggTEuclidExtended(a, b);
        x = ggTEuclid[0];
        y = ggTEuclid[1];
        ggT = ggTEuclid[2];
        long kontrolle = x * a + y * b;
        System.out.println(x + " * (" + a + ") + (" + y + ") * (" + b + ") "
                + "ist " + kontrolle + "\n"
                + "          und der ggT ist " + ggT);
        System.out.println(new GgT().ggTEuclid(a, b));
        System.out.println(new GgT().ggTNaiv(a, b));
    }

    private void go(String[] args) {
        repeater = false; // damit die while-Schleife auch angesprochen wird,
        List<String> liste = new ArrayList<>();
        String readStr = "";
        // wenn die Methode erneut aufgerufen wird
        // Einlesen von Eingabewerten mittels des Funktionsaufrufes inklusive
        // eines parsen auf long-Werte
        if (args.length > 0) {
            try {
                argsLong = new long[args.length];
                argsLong = parseArgsToArgsLong(args);
                argsLongDurchGgT = new long[argsLong.length];
                konsolenparameter = true;
            } catch (NumberFormatException ex) {
                System.out.println("PROGRAMM-ABBRUCH - FEHLERHAFTE EINGABE!!");
            }
        }
//        // Testausgabe der Eingabewerte
//        for (int i = 0; i < argsLong.length; i++) {
//            System.out.println(argsLong[i]);
//        }
        // Ende des Lesen der Eingabewerte über die Konsole per Aufruf

        while (!repeater) {
// falls keine sinnvollen Werte übergeben wurden, wollen wir dem Nutzer dies nun ermöglichen
            if (!konsolenparameter) {
                System.out.println("\nIhre Eingabe neuer Werte zur Berechnung des ggT's "
                        + "eben dieser (Leerzeichen als Delimiter): ");
                readStr = ReadInput.readString();
//
                marker();
                marker();
                liste = goTesteMakeArrayListFromString(readStr);
                marker();
                marker();

//        hier werden wir später mit der ArrayList-liste ein entsprechendes Array
//        anlegen
                String[] strListe = new String[liste.size()];
                liste.toArray(strListe);
                marker();
                System.out.println(Arrays.toString(strListe));
                marker();
                try {
                    argsLong = parseArgsToArgsLong(strListe);
                    argsLongDurchGgT = new long[strListe.length];
                    repeater = true;
                } catch (NumberFormatException nFex) {
                    System.out.println("Geben Sie vernünftige Zahlen ein, erst "
                            + "danach wird eine Abbruchmöglichkeit zur Verfügung "
                            + "gestellt !");
                    System.out.println("Fehlermeldung:");
                    System.out.println(nFex);
                    repeater = false;
                    continue;
                }
            }
            konsolenparameter = false;
            if (argsLong.length > 0) {
                ggT = this.goGgTNaivArray(argsLong);
            } else {
                ggT = 0;
                System.out.println("Sie haben keine Zahlen eingegeben, dann "
                        + "setzen wir den ggT auf 0!!");
            }
            System.out.println("Der ggT ist: " + ggT);
//        System.out.println("Ihre Eingabe einer Zahl: ");
//        strVonInts = readInt();
//        System.out.println(strVonInts);
            System.out.println("");
//            marker();
//            System.out.println("GGT " + ggT);
//            marker();
            if (ggT != 0) {
                for (int k = 0; k < argsLongDurchGgT.length; k++) {
                    argsLongDurchGgT[k] = argsLong[k] / ggT;
//                    System.out.print(argsLongDurchGgT[k] + " ;");
                }
            }
            System.out.println("Die Ausgabe des Feldes nach Division durch den ggT!\n"
                    + toStringWerte(argsLongDurchGgT));
            System.out.println("");
            System.out.println("Zusammenfassung: ");
            System.out.println("Sie haben folgendes Zahlenfeld eingegeben:");
            System.out.println(Arrays.toString(argsLong));
            System.out.println("Zahlenfeld durch den ggT (mit ggT=" + ggT + "):\n"
                    + Arrays.toString(argsLongDurchGgT));
            System.out.println("\nDer ggT der Zahlen des ersten Zahlenfeldes "
                    + "war: " + ggT);
            repeater = repeaterSetzer();
        }
        System.out.println("\n");
        marker();
        marker();
        System.out.println("Das Programm wurde von Ihnen beendet");
        marker();
        marker();
    }

    public long[] ggTEuclidExtended(long a, long b) {
        long[] rueckgabeFeld = {0, 0, 0};
        // an Stelle [0]: Vorfaktor von a
        // an Stelle [1]: Vorfaktor von b
        // an Stelle [2]: ggT(a,b,)
        long x0 = 1, x1 = 0, y0 = 0, y1 = 1;
        if (a == 0 || b == 0) {
            if ((a == 0) & (b != 0)) {
                x = 0;
                rueckgabeFeld[1] = 1;
                y = 1;
                rueckgabeFeld[2] = b;
                ggT = b;
            } else if ((a != 0) && (b == 0)) {
                rueckgabeFeld[0] = 1;
                x = 1;
                y = 0;
                rueckgabeFeld[2] = a;
                ggT = a;
            }
//            System.out.println("x: " + x);
//            System.out.println("y: " + y);
            return rueckgabeFeld;
        }
        if (a % b == 0) {
            x = 0;
            rueckgabeFeld[1] = 1;
            y = 1;
            rueckgabeFeld[2] = b;
            ggT = b;
//            System.out.println("x: " + x);
//            System.out.println("y: " + y);
            return rueckgabeFeld;
        }
        long q; // q=[a/b]
        long r = b; // Rest, also a=q*b+r mit 0 <= r < b 
        while (a % b != 0) {
            q = a / b;
            r = a - q * b;
            a = b;
            b = r;
            rueckgabeFeld[0] = x0 - q * x1;
            rueckgabeFeld[1] = y0 - q * y1;
            x0 = x1;
            y0 = y1;
            x1 = rueckgabeFeld[0];
            y1 = rueckgabeFeld[1];
        }
        rueckgabeFeld[2] = b;
        x = rueckgabeFeld[0];
//        System.out.println("x: " + x);
        y = rueckgabeFeld[1];
//        System.out.println("y: " + y);
        ggT = rueckgabeFeld[2];
        return rueckgabeFeld;
    }

    public long ggTEuclid(long a, long b) {
        if (a == 0 || b == 0) {
            return Math.max(Math.abs(a), Math.abs(b));
        }
        long q; // q=[a/b]
        long r = b; // Rest, also a=q*b+r mit 0 <= r < b 
        while (a % b != 0) {
            q = a / b;
            r = a - q * b;
            a = b;
            b = r;
        }
        return b;
    }

    private long goGgTNaivArray(long[] argsLong) {
        for (int i = 0; i < argsLong.length; i++) {
            if (i == 0) {
                ggT = argsLong[0];
            } else {
                System.out.println("ggT: " + ggT);
                if (ggT == 1) { // ggT kann nur kleiner werden im Durchlauf, daher hier direkter Abbruch
//                    i = argsLong.length-1;
//                    continue;
                    break;
                }
                ggT = ggTNaiv(ggT, argsLong[i]);
                System.out.println("ggT im Durchlauf Nr. " + i + " ist: " + ggT);
            }
        }

        return ggT;
    }

    public long ggTNaiv(long a, long b) {
        if (a == 0 || b == 0) {
            return Math.max(Math.abs(a), Math.abs(b));
        }
        long x = Math.max(Math.abs(a), Math.abs(b));
        long y = Math.min(Math.abs(a), Math.abs(b));
        a = x;
        b = y;
        long time = System.currentTimeMillis();
        while (a != b) {
//            Alle 5 Sekunden Bildschirmausgabe
//            if (System.currentTimeMillis() - time > 5000) {
//                System.out.println("a: " + a);
//                System.out.println("b: " + b);
//                time = System.currentTimeMillis();
//            }
            a = a - b;
            if (a < b) {
                tauscher = b;
                b = a;
                a = tauscher;
//                System.out.println("a:" + a);
            }
        }
        return a;
    }

    private long[] parseArgsToArgsLong(String... args) throws NumberFormatException {
//        System.out.println("parseArgsAufruf mit args.length" + args.length);        
        argsLong = new long[args.length];
//        hier wird das Feld mit Nullen initialisiert, da new... --> Heap
//        Ausgabe des eingelesenen Feldes + Initial-0-Werte
        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//            System.out.println(Long.parseLong(args[i]));
            argsLong[i] = Long.parseLong(args[i]);
        }
        return argsLong;
    }

    private List<String> makeArrayListFromString(List<String> newListe, String readStr,
            String delimiter) {
//        System.out.println("Ich bin die makeArrayListFromString-Methode!");
//        System.out.println(""+readStr.indexOf(delimiter));
//        System.out.println(""+readStr.length());
        int firstIndexOfDelimiter = readStr.indexOf(delimiter);
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

    private List<String> goTesteMakeArrayListFromString(String readStr) {
//        rein aus didaktischen Gründen das this. ergänzt
        List<String> newListe = new ArrayList<>();
        newListe = makeArrayListFromString(newListe, readStr, " ");
        // Hilfsausgabe
        String[] strListe = new String[newListe.size()];
        newListe.toArray(strListe);
        System.out.println(Arrays.toString(strListe));
        // Ende der Hilfsausgabe
        return newListe;
    }

    private boolean repeaterSetzer() {
        marker();
        marker();
        System.out.println("Erneute Berechnung? Abbruch mit Eingabe der 1:");
        long eingeleseneZahl = ReadInput.readLong();
        if (eingeleseneZahl == 1) {
            repeater = true;
        } else {
            repeater = false;
        }
        return repeater;
    }

    private static void marker() {
        System.out.println(ausrufeZeichen);
    }

    private static String toStringWerte(long[] x) {
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

    private static void programmStartUndEndeAnpasser() {
        ausrufeZeichen += ausrufeZeichen + "!";
        int i = ausrufeZeichen.length() - programmEnde.length();
        for (int j = 0; j < i / 2; j++) {
            programmStart.insert(0, " ");
            programmStart.insert(programmStart.length(), " ");
            programmEnde.insert(0, " ");
            programmEnde.insert(programmEnde.length(), " ");
        }
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getGgT() {
        return ggT;
    }
}
