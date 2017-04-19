package de.marcelhuber.lottozahlen;

import de.marcelhuber.systemtools.PressEnter;
import java.util.*;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Marcel Huber
 */
public class Lotto6Aus49_Old {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new Lotto6Aus49_Old().go();
    }

    private void go() {
        int anzahlSpiele = 24;
        int[][] lottoZiehungen = new int[anzahlSpiele][6];
        int potentielleZahl;
        boolean isANewNumber = true;
//        for (int i = 0; i < lottoZiehungen.length; i++) {
        for (int i = 0; i < anzahlSpiele; i++) {
            if (i > 0 && (i + 1) % 10 == 0) {
                System.out.println("");
            }
            potentielleZahl = 1 + (int) (49 * Math.random());
            lottoZiehungen[i][0] = potentielleZahl;
            for (int j = 1; j < lottoZiehungen[0].length; j++) {
                do {
                    potentielleZahl = 1 + (int) (49 * Math.random());
                    isANewNumber = true;
                    for (int tmp = 0; tmp < j; tmp++) {
                        if (potentielleZahl == lottoZiehungen[i][tmp]) {
                            isANewNumber = false;
                        }
                    }
                } while (!isANewNumber);
//                System.out.println(potentielleZahl);
                lottoZiehungen[i][j] = potentielleZahl;

            }
//            lottoZiehungen[i][4] = 18; 
//            zum Testen, was passiert, wenn mal nicht alle Zahlen voneinander
//            verschieden sind, obige Zeile einkommentieren
            Arrays.sort(lottoZiehungen[i]);
//            System.out.println("Ziehung " + (i + 1) + ": "
//                    + Arrays.toString(lottoZiehungen[i]));
            System.out.print("Ziehung " + (i + 1) + ": ");
            displayIntArray(lottoZiehungen[i]);
            if (!kontrolle(lottoZiehungen[i]) || !kontrolleSchnell(lottoZiehungen[i])) {
                System.out.print("   --   alle Zahlen verschieden:"
                        + kontrolle(lottoZiehungen[i]));
                System.out.print("   --   alle Zahlen verschieden:"
                        + kontrolleSchnell(lottoZiehungen[i]) + " ");
                PressEnter.toContinue();
            }
            System.out.println("");

        }
//        System.out.println(Arrays.deepToString(lottoZiehungen));
    }

    boolean kontrolleSchnell(int[] intArray) {
        // hier nutzen wir aus, dass das Feld von links nach rechts aufsteigend
        // vorsortiert ist
        boolean alleUngleich = true;
        for (int k = 0; k < intArray.length - 1; k++) {
            if (intArray[k] == intArray[k + 1]) {
                alleUngleich = false;
                break;
            }
        }
        return alleUngleich;
    }

    boolean kontrolle(int[] intArray) {
        int vergleich;
        boolean alleUngleich = true;
        outer:
        for (int k = 0; k < intArray.length; k++) {
            vergleich = intArray[k];
            if (k < intArray.length - 1) {
                for (int m = k + 1; m < intArray.length; m++) {
                    if (vergleich == intArray[m]) {
                        alleUngleich = false;
                        break outer;
                    }
                }
            }
        }
        return alleUngleich;
    }

    void displayIntArray(int[] intArray) {
        String[] strArray = new String[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            strArray[i] = "" + intArray[i];
            if (intArray[i] < 10) {
                strArray[i] = "0" + strArray[i];
            }
        }
        System.out.print(Arrays.toString(strArray));
    }
}
