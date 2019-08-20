package de.marcelhuber.mathematik.zahlentheorie;

import java.util.*;

/**
 *
 * @author Huber, Marcel
 * @date 20.08.2019
 */
public class KettenbruchBerechnungAusEndlicherFolgeTester {

    public static void main(String[] args) {
        KettenbruchBerechnungAusEndlicherFolge test = new KettenbruchBerechnungAusEndlicherFolge();
//        test.berechneWertAusEndlicherFolge((new ArrayList<>(Arrays.asList(2L, 1L, 2L, 1L, 1L, 4L))));
        test.berechneWertAusEndlicherFolge((new ArrayList<>(Arrays.asList(2L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L,
                3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L,
                3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L, 3L))));
        System.out.println("sqrt(13) - 1/2 = " + ((Math.sqrt(13) + 1) / 2.0));
        System.out.println("Die Folge war: " + test.getZahlenfolge());
        System.out.println("Der Wert nochmal: " + test.getWert());
    }
}
