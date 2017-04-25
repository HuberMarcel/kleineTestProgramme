package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.PressEnter;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class SortierungsErsteller {

    private Integer[] indizesDerSortierung;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
//        new SortierungsErsteller().goNichtEffizient();
        new SortierungsErsteller().go();
    }

    private void go() {
        Long[] longFeld = new Long[]{2L, 8L, 34L, 5L, 21L, 3L, 13L,};
        Long[] longFeldSortiert = new Long[longFeld.length];
        Integer[] indizesSortiertesFeld
                = indizesFuerLongfeldSortierungEffizienter(longFeld);
        for (int i = 0; i < longFeld.length; i++) {
            longFeldSortiert[i] = longFeld[indizesSortiertesFeld[i]];
        }
        System.out.println("Eingabefeld:           "
                + Arrays.toString(longFeld));
        System.out.println("Indizes zum Sortieren: "
                + Arrays.toString(indizesSortiertesFeld));
        System.out.println("Sortiertes Feld:       "
                + Arrays.toString(longFeldSortiert));
    }

    private void goNichtEffizient() {
        Long[] longFeld = new Long[]{2L, 8L, 34L, 5L, 21L, 3L, 13L,};
        Long[] longFeldSortiert = new Long[longFeld.length];
        Integer[] indizesSortiertesFeld
                = indizesFuerLongfeldSortierung(longFeld);
        for (int i = 0; i < longFeld.length; i++) {
            longFeldSortiert[i] = longFeld[indizesSortiertesFeld[i]];
        }
        System.out.println("Eingabefeld:           "
                + Arrays.toString(longFeld));
        System.out.println("Indizes zum Sortieren: "
                + Arrays.toString(indizesSortiertesFeld));
        System.out.println("Sortiertes Feld:       "
                + Arrays.toString(longFeldSortiert));
    }

    public Integer[] indizesFuerIntegerfeldSortierungEffizienter(Integer[] integerFeld) {
        // longFeld ist eine Referenz auf das übergebene Feld, wenn wir hier
        // longFeld verändern, dann verändert sich das global; daher arbeiten 
        // wir, um das Ursprungsobjekt zu behalten, hier mit einer Kopie des
        // gesamten Feldes
        int length = integerFeld.length;
        Integer[] integerFeldCopy = new Integer[length];
        for (int i = 0; i < length; i++) {
            integerFeldCopy[i] = integerFeld[i];
        }
        Integer tauschHelfer;
        int indexTauschHelfer;
        indizesDerSortierung = new Integer[length];
        for (int i = 0; i < length; i++) {
            indizesDerSortierung[i] = i;
        }
        int indexActualMin;
        for (int i = 0; i < length; i++) {
            indexActualMin = i;
            for (int j = i + 1; j < length; j++) {
                if (integerFeldCopy[j] < integerFeldCopy[indexActualMin]) {
                    indexActualMin = j;
                }
            }
            if (i != indexActualMin) {
                tauschHelfer = integerFeldCopy[i];
                indexTauschHelfer = indizesDerSortierung[i];
                integerFeldCopy[i] = integerFeldCopy[indexActualMin];
                indizesDerSortierung[i] = indizesDerSortierung[indexActualMin];
                integerFeldCopy[indexActualMin] = tauschHelfer;
                indizesDerSortierung[indexActualMin] = indexTauschHelfer;
            }
        }
        return indizesDerSortierung;
    }

    public Integer[] indizesFuerLongfeldSortierungEffizienter(Long[] longFeld) {
        // longFeld ist eine Referenz auf das übergebene Feld, wenn wir hier
        // longFeld verändern, dann verändert sich das global; daher arbeiten 
        // wir, um das Ursprungsobjekt zu behalten, hier mit einer Kopie des
        // gesamten Feldes
        int length = longFeld.length;
        Long[] longFeldCopy = new Long[length];
        for (int i = 0; i < length; i++) {
            longFeldCopy[i] = longFeld[i];
        }
        Long tauschHelfer;
        int indexTauschHelfer;
        indizesDerSortierung = new Integer[length];
        for (int i = 0; i < length; i++) {
            indizesDerSortierung[i] = i;
        }
        int indexActualMin;
        for (int i = 0; i < length; i++) {
            indexActualMin = i;
            for (int j = i + 1; j < length; j++) {
                if (longFeldCopy[j] < longFeldCopy[indexActualMin]) {
                    indexActualMin = j;
                }
            }
            System.out.println("indexActualMin:" + indexActualMin);
            if (i != indexActualMin) {
                tauschHelfer = longFeldCopy[i];
                indexTauschHelfer = indizesDerSortierung[i];
                longFeldCopy[i] = longFeldCopy[indexActualMin];
                indizesDerSortierung[i] = indizesDerSortierung[indexActualMin];
                longFeldCopy[indexActualMin] = tauschHelfer;
                indizesDerSortierung[indexActualMin] = indexTauschHelfer;
            }
//            System.out.println("Feld: " + Arrays.toString(longFeldCopy));
//            System.out.println(Arrays.toString(indizesDerSortierung));
//            PressEnter.toContinue();
        }
        return indizesDerSortierung;
    }

    private Integer[] indizesFuerLongfeldSortierung(Long[] longFeld) {
        int length = longFeld.length;
        boolean[] isUsed = new boolean[length];
        indizesDerSortierung = new Integer[length];
        indizesDerSortierung[0] = 0;
        isUsed = initializeIsUsed(isUsed);
        Long actualMin;
        Long help;
        int counter = 0;
        int indexLastMin;
        while (counter < length) {
            for (int i = 0; i < length; i++) {
                if (!isUsed[i]) {
                    actualMin = longFeld[i];
                    isUsed[i] = true;
                    indexLastMin = i;
                    indizesDerSortierung[counter] = i;
                    for (int j = 0; j < length; j++) {
                        if (!isUsed[j] && longFeld[j] < actualMin) {
                            actualMin = longFeld[j];
                            isUsed[j] = true;
                            indizesDerSortierung[counter] = j;
                            isUsed[indexLastMin] = false; // beachte, dass hier i != j ist
                            indexLastMin = j;
                        }
//                        System.out.println(Arrays.toString(indizesDerSortierung));
//                        System.out.println(Arrays.toString(isUsed));
                    }
                    counter++;
                }
//                PressEnter.toContinue();
            }
        }
        return indizesDerSortierung;
    }

    private boolean[] initializeIsUsed(boolean[] isUsed) {
        for (int k = 0; k < isUsed.length; k++) {
            isUsed[k] = false;
        }
        return isUsed;
    }
}
