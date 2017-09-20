// Definition: Siehe Algebra von Meyberg/Karpfinger, Seite 118
//             Diese Implementierung hier ist nicht optimal, aber etwas
//             effizienter als die Quick-And-Dirty-Implementierung
package de.marcelhuber.mathematik.algebra;

import de.marcelhuber.systemtools.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Marcel Huber; 17.09.2017
 * letzte Änderung: 20.09.2017
 */
public class PartitionierungEinerNatuerlichenZahlEtwasEffizienter {

    ArrayList<HashSet<ArrayList<Long>>> partitionList = new ArrayList<>();

    public static void main(String[] args) {
        PartitionierungEinerNatuerlichenZahlEtwasEffizienter dummyObject
                = new PartitionierungEinerNatuerlichenZahlEtwasEffizienter();
        long[] xWerte;
        xWerte = new long[]{7, 8, 9, 10,};// 45,};
        // erwartete Ausgaben gemäß https://de.wikipedia.org/wiki/Partitionsfunktion
        long[] yWerte = new long[]{15, 22, 30, 42,};// 89134,};
//        dummyObject.showAllPartitions();
        long y = xWerte[xWerte.length - 1];
        dummyObject.createPartitionToNumber(y);
        for (long x : xWerte) {
            dummyObject.showPartitionOfNumber(x);
            Marker.marker('_');
        }
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
        int counter = 0;
        for (long x : xWerte) {
            System.out.println("Berechnete Anzahl der Partitionen der Zahl "
                    + x + ": "
                    + dummyObject.showPartitionNumber(x));
            if (counter < yWerte.length) {
                System.out.printf(("Vergleich mit Wiki:                        %"
                        + (("" + x).length()) + "s  "
                        + yWerte[counter++] + "\n"), "");
            }
            Marker.marker('_');
        }
    }

    private void createPartitionToNumber(long x) {
        partitionList.clear();
        HashSet<ArrayList<Long>> help01;
        HashSet<ArrayList<Long>> help02;
        ArrayList<Long> onePartitionList = new ArrayList<>();
        HashSet<ArrayList<Long>> everyPartitionSet = new HashSet<>();
        if (x == 1) {
            onePartitionList.add(1L);
            everyPartitionSet.add(onePartitionList);
            partitionList.add(everyPartitionSet);
            return;
        }
//        // Mal testen, ob der Code richtig bleibt, wenn der Fall x == 2
//        //             auskommentiert wird
//        //             (scheint O.K. zu sein)
//        if (x == 2) {
//            createPartitionToNumber(1L);
//            onePartitionList.add(2L);
//            everyPartitionSet.add(onePartitionList);
//            onePartitionList = new ArrayList<>();
//            onePartitionList.add(1L);
//            onePartitionList.add(1L);
//            everyPartitionSet.add(onePartitionList);
//            partitionList.add(everyPartitionSet);
//            return;
//        }
        createPartitionToNumber(x - 1);
        HashSet<ArrayList<Long>> thisPartitionSet = new HashSet<>();
//        // folgende Zeile kompiliert nicht, daher wurden die drunter geschrieben
//        thisPartitionSet.add(new ArrayList<>().add(x));
        ArrayList<Long> eintragX = new ArrayList<>();
        eintragX.add(x);
        thisPartitionSet.add(eintragX);
        ArrayList<Long> listToCheck;
        for (int k = 1; k < x; k++) {
            help01 = partitionList.get(k - 1);
            help02 = partitionList.get((int) x - (k + 1));
            for (ArrayList<Long> help01ArrayList : help01) {
                for (ArrayList<Long> help02ArrayList : help02) {
                    if (help01ArrayList.get(help01ArrayList.size() - 1) < help02ArrayList.get(0)) {
                        continue;
                    }
                    listToCheck = new ArrayList<>();
                    for (Long entry : help01ArrayList) {
                        listToCheck.add(entry);
                    }
                    for (Long entry : help02ArrayList) {
                        listToCheck.add(entry);
                    }
                    thisPartitionSet.add(listToCheck);
//                    System.out.println(thisPartitionSet);
//                    System.out.println(partitionList);
//                    PressEnter.toContinue();
                }
            }
        }
        partitionList.add(thisPartitionSet);
    }

    private long showPartitionNumber(long x) {
        showPartitionOfNumber(x, false);
        return partitionList.get((int) x - 1).size();
    }

    private void showPartitionOfNumber(long x) {
        showPartitionOfNumber(x, true);
    }

    private void showPartitionOfNumber(long x, boolean showOutput) {
        if (partitionList == null || partitionList.size() < x) {
            System.out.println("Moment, ich muss alle Partitionen neu "
                    + "berechnen...");
            createPartitionToNumber(x);
        }
        if (showOutput) {
            System.out.println(partitionList.get((int) (x - 1)));
        }
    }

    private void showAllPartitions() {
        for (HashSet<ArrayList<Long>> arrayList : partitionList) {
            System.out.println(arrayList);
            PressEnter.toContinue();
        }
//        System.out.println(partitionList);
    }

//    private boolean monotonFallend(List<Long> testListe) {
//        for (int k = 0; k < testListe.size() - 1; k++) {
//            if (testListe.get(k) < testListe.get(k + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean checkSum(long[] possiblePartition, long x) {
//        long sum = 0;
//        for (long entry : possiblePartition) {
//            sum += entry;
//        }
//        return (sum == x);
//    }
}
