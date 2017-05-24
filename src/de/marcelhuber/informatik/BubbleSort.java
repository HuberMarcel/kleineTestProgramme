package de.marcelhuber.informatik;

import de.marcelhuber.systemtools.Marker;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class BubbleSort {

    static private int vergleichsZaehler = 0;
    private int feldLaenge;
    private Long[] unsortiertesFeld;
    private Long tauschHelfer;
    private boolean arrayIsSorted;

    public static void main(String[] args) {
        new BubbleSort().go();
    }

    void go() {
// Spaßeshalber mal ein vorsortiertes halbes Feld erzeugen: mit Einkommentieren von Z1 und Z2
        feldLaenge = 10;
        unsortiertesFeld = new Long[feldLaenge];
        Long[] teilFeld = new Long[feldLaenge / 2];
//        do {                                                   // Z1
        for (int i = 0; i < feldLaenge; i++) {
            unsortiertesFeld[i] = (long) (Math.random() * 10_000);
        }
//            for (int i = 0; i < teilFeld.length; i++) {        // Z2
//                teilFeld[i] = unsortiertesFeld[feldLaenge/2+i];// Z3 
//            }                                                  // Z4
//        } while (!checkIfMyArrayIsSorted(teilFeld));           // Z5
        System.out.println("Unsortiertes Feld:                                         "
                + "                        \n" + Arrays.toString(unsortiertesFeld));
        System.out.println("Die Frage, ob das Feld zufällig doch vorsortiert ist, muss "
                + "beantwortet werden mit: \n" + checkIfMyArrayIsSorted(unsortiertesFeld));
        new BubbleSort().sortiereMitBubbleSort(0, unsortiertesFeld);
        System.out.println("Mit BubbleSort sortiertes Feld:                            "
                + "                        \n" + Arrays.toString(unsortiertesFeld));
        System.out.println("");
        Marker.marker();
        Marker.marker();
        System.out.print("Der Test, ob mein Feld wirklich aufsteigend sortiert ist, ergibt: ");
        System.out.println(checkIfMyArrayIsSorted(unsortiertesFeld));
        Marker.marker();
        Marker.marker();
        System.out.println("");
        System.out.println("");
        System.out.println("Es gab " + vergleichsZaehler + " Vergleiche!");
    }

    public Long[] sortiereMitBubbleSort(int untereGrenze, Long[] feld) {
        arrayIsSorted = true;
        /* wenn kein Tausch in der nächsten Schleife notwendig ist,
         dann ist das Feld bereits sortiert */
        for (int i = feld.length - 1; i > untereGrenze; --i) {
            vergleichsZaehler++;
            if (feld[i] < feld[i - 1]) {  // doch Tausch notwendig
                arrayIsSorted = false;
                tauschHelfer = feld[i];
                feld[i] = feld[i - 1];
                feld[i - 1] = tauschHelfer;
            }
        }
        if (arrayIsSorted) {
            return feld;
        }
        untereGrenze++;
        if (untereGrenze < feld.length) {
            sortiereMitBubbleSort(untereGrenze, feld);
        }
        return feld;
    }

    public boolean checkIfMyArrayIsSorted(Long[] feld) {
        for (int i = 0; i < feld.length - 1; i++) {
            if (feld[i] > feld[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
