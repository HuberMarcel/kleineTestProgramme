// Siehe Buchmann, Einführung in die Kryptographie: 
// Theorem 3.8.4 auf Seite 34
//     Das ist die Aussage, dass
//     die Summe der Teiler von m über die Werte phi(t) gerade wieder m
//     ergibt:
//     m = summe_{t|m} phi(t) mit der Eulerschen phi-Funktion, die definiert
//     ist als 
//         phi(t) = |{b aus IN: ggT(b,t)==1}|.
// Alles fertig!!! ...
package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.TeilerMengeBerechnen;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Marcel Huber
 */
public class BeweisDemoZurAussageZurEulerschenPhiFunktion {

    static private long zahl;
    private List<Long> arrayT;
    private TreeMap<Long, List<Long>> mySetsMapped;

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
        dummy.goBeweisschritt02();
        dummy.goBeweisschritt03();
        dummy.goBeweisschritt04();
    }

    public void goBeweisschritt01a() {
        System.out.println("");
        Marker.marker();
        System.out.println("Beweisschritt 01".toUpperCase() + "a:");
        Marker.marker();
        System.out.println("");

        System.out.println("Es gilt: ");
        System.out.print("{ 1, 2, ..., zahl } = ");
        System.out.print("{ ");
        for (int k = 0; k < zahl - 1; k++) {
            System.out.print((k + 1) + ", ");
        }
        System.out.print(zahl + " }\n");
        System.out.println("\n= ( Vereinigung_über_{ t aus IN: t | zahl })_"
                + "die_Mengen_M(t)");
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
        System.out.println("");
        Marker.marker();
        System.out.println("Beweisschritt 01".toUpperCase() + "b");
        Marker.marker();
        System.out.println("");

        System.out.println("Für t1 != t2 sind M(t1) = M_" + zahl + "(t1) und M(t2) = M_" + zahl + "(t2) "
                + " paarweise disjunkt: Seien t1, t2 ganze Zahlen > 0 und t1 < t2.");
        System.out.println("Angenommen, es gäbe ein Element x mit 1 <= x <= " + zahl + " so, dass "
                + "ggT(x," + zahl + ") = t1\nund ggT(x," + zahl + ") = t2.");
        System.out.print("Dann folgte t1 | t2 und t2 | t1, also wären t1 und t2 einander assoziiert.");
        System.out.println("Da t1, t2 beide > 0 sind, würde das \nzum Widerspruch t1 == t2 führen. %");
        System.out.println("");
        System.out.println("Wir schauen uns die obigen Ergebnisse en detail hier an:");
        System.out.println("Es gibt also " + arrayT.size() + " Mengen, die wir im "
                + "Folgenden begutachten werden:");
        List<List<Long>> listSetM = new ArrayList<>();
        mySetsMapped = new TreeMap<>();
        List<Long> mySet;
        for (long t : arrayT) {
            mySet = calculateSetM(t, zahl);
            listSetM.add(mySet);
            mySetsMapped.put(t, mySet);
        }
        for (Long t : mySetsMapped.keySet()) {
            System.out.printf("arrayM_" + zahl + "(%1$" + ("" + zahl).length() + "d) = "
                    + mySetsMapped.get(t) + "%n", t);
        }
    }

    public void goBeweisschritt02() {
        PressEnter.toContinue();
        System.out.println("");
        System.out.println("");
        Marker.marker();
        System.out.println("Beweisschritt 02:".toUpperCase());
        Marker.marker();
        System.out.println("");

        System.out.println("Man erkennt, dass die letzten " + arrayT.size() + " Mengen "
                + "in der Tat paarweise disjunkt\nsind - begründet hatten wir diese "
                + "Aussage ja schon vorab.");
        System.out.println("");
        System.out.println("Es gilt folgende Charakterisierung:");
        System.out.println("Für t | zahl (hier zahl=" + zahl + ", d.h. hier: ist t ein Glied von "
                + arrayT + "), gilt:");
        System.out.print("Für jedes b aus "
                + "M(t) = { y: 1 <= y <= zahl(=" + zahl + ") und ggT(y,zahl) = t } ");
        System.out.println("gilt per Definitionem:");
        System.out.println("Es ist 1 <= b <= zahl(=" + zahl + ") und ggT(b,zahl) = t.");
        System.out.println("");
        System.out.println("Offensichtlich gilt: b ist aus M(t) genau dann, wenn ggT(b/t,zahl/t)=1. ");
        System.out.print("Wir begründen nun Folgendes: ");
        System.out.println("M(t) = { r: 1 <= r <= zahl/t: ggT(r,zahl/t)=1 }.");
        System.out.println("Denn:".toUpperCase());
        System.out.println("\"==>:\" Ist b aus M(t), so gilt 1 <= b <= zahl und ggT(b,zahl)=t. Wegen"
                + "t | b und t | zahl\nfolgt ggT(b/t,zahl/t)=1. [Ausführlicher: Es existieren ganze "
                + "Zahlen x,y mit x*b+y*zahl=t.\nEs folgt x*(b/t)+y*(zahl/t)=1 und damit ist 1 ein Element "
                + "der Menge\n(b/t)*IZ + (zahl/t)*IZ = ggT(b/t,zahl/t)*IZ, woraus ggT(b/t,zahl/t)=1 folgt. %");
        System.out.println("\"<==\": Sei nun r mit 1 <= r <= zahl/t und ggT(r,zahl/t)=1 gegeben. Wie eben sieht "
                + "\nman, dass ggT(rt,zahl)=t gelten muss. Wir begründen noch, dass für 1 <= b <= zahl und \n"
                + "b keinElement aus t*IZ sicher nicht ggT(b,zahl)=t gelten wird:");
        System.out.println("Wäre ggT(b,zahl)=t, so folgte insbesondere t | b und damit b aus t*IZ. %");
    }

    public void goBeweisschritt03() {
        PressEnter.toContinue();
        System.out.println("");
        System.out.println("");
        Marker.marker();
        System.out.println("Beweisschritt 03:".toUpperCase());
        Marker.marker();
        System.out.println("");

        System.out.println("Offenbar gilt: t | zahl <==> zahl/t | zahl. Wir demonstrieren das an unserer "
                + "Menge der Teiler\nvon zahl=" + zahl + ":");
        for (Long teiler : arrayT) {
            if (teiler < zahl) {
                System.out.println(teiler + " | zahl=" + zahl + " und es gilt auch " + (zahl / teiler) + " | zahl=" + zahl);
            } else {
                System.out.println(teiler + " | zahl=" + zahl + " und es gilt auch " + (zahl / teiler) + " | zahl=" + zahl + ".");
            }
        }
        System.out.println("Die Begründung ist offensichtlich: Es gilt genau dann t | zahl, wenn es ein "
                + "k aus IN\n(beachte: t, zahl > 0) so gibt, dass zahl = k * t. Also t | zahl <==> k=zahl/t aus IN.");
    }

    public void goBeweisschritt04() {
        PressEnter.toContinue();
        System.out.println("");
        System.out.println("");
        Marker.marker();
        System.out.println("Beweisschritt 04:".toUpperCase());
        Marker.marker();
        System.out.println("");

        System.out.print("Nun gilt für jedes t | zahl(=" + zahl + "): M(t)=M(zahl/t)=M(" + zahl + "/t). ");
        System.out.println("Dann ist, siehe " + "Beweisschritt 01".toUpperCase() + "a, folglich:");
        System.out.println("zahl = |{ 1, ..., zahl }| = "
                + "|( Vereinigung_über_{ t aus IN: t | zahl })_die_Mengen_M(zahl/t)|.");
        System.out.println("Weil die Mengen M(zahl/t) alle paarweise disjunkt sind:");
        System.out.println("zahl=( Summe_über_{ t aus IN: t | zahl })_( | M(zahl/t) | )");
        System.out.println("Hierbei beachte man, dass die Reihenfolge der Summation keine Rolle spielt, d.h. wir "
                + "denken\nan die Kommutativität der Addition! (Im Vergleich zum " + "Beweisschritt 01".toUpperCase()
                + "a addieren wir ja nun\nrückwärts über das Feld " + arrayT + "!).");
        System.out.println("Aus " + "Beweisschritt 02".toUpperCase() + " folgt, dass  | M(zahl/t) | = phi(zahl/t) gilt. Damit "
                + "ergibt sich sodann gänzlich die Behauptung. %%");
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
