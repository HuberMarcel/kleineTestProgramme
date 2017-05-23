// Siehe Buchmann, Einführung in die Kryptographie: 
// Theorem 3.8.4 auf Seite 34
//     Das ist die Aussage, dass
//     die Summe der Teiler von m über die Werte phi(t) gerade wieder m
//     ergibt:
//     m = summe_{t|m} phi(t) mit der Eulerschen phi-Funktion, die definiert
//     ist als 
//         phi(t) = |{b aus IN: ggT(b,t)==1}|.
// TODO: Die restlichen Beweisschritte ...
package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.TeilerMengeBerechnen;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Marcel
 */
public class BeweisDemoZurAussageZurEulerschenPhiFunktion {

    static private long zahl;
    private List<Long> arrayT;

    public static void main(String[] args) {
        boolean gueltigeEingabe = false;
        while (!gueltigeEingabe) {
            System.out.print("Geben Sie eine ganze Zahl > 0 ein: ");
            zahl = ReadInput.readLong();
            if (zahl > 0) {
                gueltigeEingabe = true;
            } else {
                System.out.println("Ungültige Eingabe - neuer Versuch!\n");
            }
        }
        BeweisDemoZurAussageZurEulerschenPhiFunktion dummy = new BeweisDemoZurAussageZurEulerschenPhiFunktion();
        dummy.goBeweisschritt01a();
        dummy.goBeweisschritt01b();
    }

    public void goBeweisschritt01a() {
        System.out.println("");
        Marker.marker();
        System.out.println("Beweisschritt 01".toUpperCase() + "a:");
        Marker.marker();
        System.out.println("");

        System.out.println("Es gilt: ");
        System.out.print("{ ");
        for (int k = 0; k < zahl - 1; k++) {
            System.out.print((k + 1) + ", ");
        }
        System.out.print(zahl + " } ");
        System.out.println("\n= ( Vereinigung_über_{ t aus IN: t | " + zahl + "})_"
                + "die_Mengen_M(t);\ndabei M(t) = M_" + zahl + "(t) := {b: 1 <= b <= " + zahl + " "
                + "und ggT(b," + zahl + ") = t }");
        System.out.println("");
        System.out.println("Wir berechnen zunächst die Menge T der Teiler der Zahl " + zahl + ":");
//        TeilerMengeBerechnen teilerMengeBerechnen = new TeilerMengeBerechnen();
//        teilerMengeBerechnen.setZahl(zahl);
//        teilerMengeBerechnen.berechneTeilerDerZahl();
//        arrayT = teilerMengeBerechnen.getTeilerDerZahl();
        // kürzer:
        TeilerMengeBerechnen teilerMengeBerechnen = new TeilerMengeBerechnen();
        teilerMengeBerechnen.berechneTeilerDerZahl(zahl);
        arrayT = teilerMengeBerechnen.getTeilerDerZahl();
        System.out.println("Hier sind die Elemente der Menge T in einem Array:");
        System.out.print("arrayT = ");
        System.out.println(arrayT);
    }

    public void goBeweisschritt01b() {
        PressEnter.toContinue();
        System.out.println("");
        Marker.marker();
        System.out.println("Beweisschritt 01".toUpperCase() + "b");
        Marker.marker();
        System.out.println("");
        System.out.println("Für t1 != t2 sind M(t1) = M_" + zahl + "(t1) und M(t2) = M_" + zahl + "(t2) "
                + " paarweise dijunkt: Seien t1, t2 ganze Zahlen > 0 und t1 < t2.");
        System.out.println("Angenommen, es gäbe ein Element x mit 1 <= x <= " + zahl + " so, dass "
                + "ggT(x," + zahl + ") = t1\nund ggT(x," + zahl + ") = t2.");
        System.out.print("Dann folgte t1 | t2 und t2 | t1, also wären t1 und t2 einander assoziiert.");
        System.out.println("Da t1, t2 beide > 0 sind, würde das \nzum Widerspruch t1 == t2 führen. %");
        System.out.println("");
        System.out.println("Wir schauen uns die obigen Ergebnisse en detail hier an:");
        System.out.println("Es gibt also " + arrayT.size() + " Mengen, die wir im "
                + "Folgenden begutachten werden:");
        List<List<Long>> listSetM = new ArrayList<>();
        TreeMap<Long, List<Long>> mySetsMapped = new TreeMap<>();
        List<Long> mySet;
        for (long t : arrayT) {
            mySet = calculateSetM(t, zahl);
            listSetM.add(mySet);
            mySetsMapped.put(t, mySet);
        }
        for (Long t : mySetsMapped.keySet()) {
            System.out.printf("arrayM" + zahl + "(%1$" + ("" + zahl).length() + "d) = "
                    + mySetsMapped.get(t) + "%n", t);
        }
    }

    private List<Long> calculateSetM(long t, long zahl) {
        List<Long> aSetM = new ArrayList<>();
        GgT ggTCalc = new GgT();
        if (t > 0) {
            for (long b = 0; b < zahl; b++) {
                if (ggTCalc.ggTEuclid(b + 1, zahl) == t) {
                    aSetM.add(b + 1);
                }
            }
        }
        return aSetM;
    }

    public long getZahl() {
        return zahl;
    }

    public void setZahl(long zahl) {
        this.zahl = zahl;
    }

    public List<Long> getArrayT() {
        return arrayT;
    }
}
