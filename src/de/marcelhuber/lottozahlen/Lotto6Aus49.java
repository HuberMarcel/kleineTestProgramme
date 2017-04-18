package de.marcelhuber.lottozahlen;

import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class Lotto6Aus49 {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new Lotto6Aus49().go();
    }

    private void go() {
        int anzahlSpiele = 12;
        int[][] lottoZiehungen = new int[anzahlSpiele][6];
        int potentielleZahl;
        boolean realNewNumber = true;
//        for (int i = 0; i < lottoZiehungen.length; i++) {
        for (int i = 0; i < anzahlSpiele; i++) {
            for (int j = 0; j < lottoZiehungen[0].length; j++) {
                potentielleZahl = 1 + (int) (49 * Math.random());
                lottoZiehungen[i][0] = potentielleZahl;
                do {
                    potentielleZahl = 1 + (int) (49 * Math.random());
                    realNewNumber = true;
                    for (int tmp = 0; tmp < j; tmp++) {
                        if (potentielleZahl == lottoZiehungen[i][tmp]) {
                            realNewNumber = false;
                        }
                    }
                } while (!realNewNumber);
//                System.out.println(potentielleZahl);
                lottoZiehungen[i][j] = potentielleZahl;
            }
            System.out.println("Ziehung " + (i + 1) + ": "
                    + Arrays.toString(lottoZiehungen[i]));
        }
        System.out.println(Arrays.deepToString(lottoZiehungen));
    }
}
