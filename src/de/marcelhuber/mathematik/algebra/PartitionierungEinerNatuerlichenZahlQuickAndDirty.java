// Definition: Siehe Algebra von Meyberg/Karpfinger, Seite 118
//             Diese Implementierung hier ist sehr unschön, effizient ist was
//             anderes
package de.marcelhuber.mathematik.algebra;

import java.util.Arrays;
//import de.marcelhuber.systemtools.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber; 16.09.2017
 */
public class PartitionierungEinerNatuerlichenZahlQuickAndDirty {

    {
        partitionsListe = new ArrayList<>();
    }

    private List<Long[]> partitionsListe;

    public static void main(String[] args) {
        PartitionierungEinerNatuerlichenZahlQuickAndDirty dummyObject = new PartitionierungEinerNatuerlichenZahlQuickAndDirty();
        long x = 6;
        dummyObject.createPartitionSet(x);
    }

    private void createPartitionSet(long x) {
        for (long k = 1; k <= x; ++k) {
            createAllVectors(x, k);
        }
//        System.out.println("Size: " + partitionsListe.size());
//        Marker.marker('_');
        List<Integer> deleteIndices = new ArrayList<>();
        for (int i = 0; i < partitionsListe.size(); i++) {
            Long[] possiblePartition = partitionsListe.get(i);
            if ((summiere(possiblePartition) != x)
                    || !monotonFallendeNatuerlicheZahlen(possiblePartition)) {
                deleteIndices.add(i);
            }
        }
        for (int s = 0; s < deleteIndices.size(); s++) {
            partitionsListe.remove(deleteIndices.get(s)-s);
        }
        for (Long[] possiblePartition : partitionsListe) {
            System.out.println(Arrays.toString(possiblePartition));
        }
        System.out.println("Anzahl der Partitionen von " + x + ": "
                + partitionsListe.size());
    }

    private void createAllVectors(long x, long k) {
        if (k == 1) {
            for (long r = 0; r < x; r++) {
                Long[] newPartition = new Long[]{r + 1};
                partitionsListe.add(newPartition);
            }
        }
        Long[] newPartition;
        for (int i = 0; i < partitionsListe.size(); i++) {
            Long[] possiblePartition = partitionsListe.get(i);
            if (possiblePartition.length == k - 1) {
                for (long r = 1; r <= x; r++) {
                    newPartition = Arrays.copyOf(possiblePartition,
                            possiblePartition.length + 1);
                    newPartition[(int) k - 1] = r;
//                    System.out.println("k: " + k);
//                    System.out.println(Arrays.toString(newPartition));
//                    PressEnter.toContinue();
                    partitionsListe.add(newPartition);
                }
            }
        }

    }

    private long summiere(Long[] y) {
        long summe = 0;
        for (long zahl : y) {
            summe += zahl;
        }
        return summe;
    }

    private boolean monotonFallendeNatuerlicheZahlen(Long[] x) {
        for (int k = 0; k < x.length - 1; k++) {
            if (x[k] < x[k + 1] || x[k] <= 0 || x[k + 1] <= 0) {
                return false;
            }
        }
        return true;
    }
}
