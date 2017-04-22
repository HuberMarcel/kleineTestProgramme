package de.marcelhuber.raetsel;

// Programm ist aktuell fehlerbehaftet, tut noch nicht das gleiche 
// wie Raetsel mit Zahlen....

import de.marcelhuber.systemtools.PressEnter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Marcel Huber
 */
public class RaetselMitZahlenMitRegulaerenAusdruecken {

    int[] indizesDerSortierung;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new RaetselMitZahlenMitRegulaerenAusdruecken().go();
    }

    private void go() {
        String letzteZeile = "3111";
        String naechsteZeile = "";
        int anzahl = 14;
        int counter = -1;
        while (++counter < anzahl) {
            naechsteZeile = "";
            List<List<Integer>> stellenStartEndZiffern = new ArrayList<>();
            List<Integer> ziffern = new ArrayList<>();
            List<Integer> stellenStart = new ArrayList<>();
            List<Integer> stellenEnd = new ArrayList<>();
            Matcher matcher;

            for (int k = 0; k < 10; ++k) { // vermutlich wird hier eh nur k < 4 möglich sein 
                matcher = Pattern.compile(k + "+").matcher(letzteZeile);
                while (matcher.find()) {
                    ziffern.add(k);
                    stellenStart.add(matcher.start());
                    stellenEnd.add(matcher.end());
                    System.out.println(matcher.group());
                }
            }
            stellenStartEndZiffern.add(ziffern);
            stellenStartEndZiffern.add(stellenStart);
            stellenStartEndZiffern.add(stellenEnd);
            Integer[] ziffernArray
                    = makeIntegerArrayListToIntegerArray(stellenStartEndZiffern.get(0));
//        System.out.println(Arrays.toString(ziffernArray));
            Integer[] stellenStartArray
                    = makeIntegerArrayListToIntegerArray(stellenStartEndZiffern.get(1));
//        System.out.println(Arrays.toString(stellenStartArray));
            Integer[] stellenEndArray
                    = makeIntegerArrayListToIntegerArray(stellenStartEndZiffern.get(2));
//        System.out.println(Arrays.toString(stellenEndArray));
//        System.out.println(letzteZeile);
            erstelleSortierIndizes(stellenStartArray);
//        System.out.println(Arrays.toString(indizesDerSortierung));
            stellenStartArray = sortiereMeinArray(stellenStartArray);
            stellenEndArray = sortiereMeinArray(stellenEndArray);
            ziffernArray = sortiereMeinArray(ziffernArray);
            System.out.println("\n\nSortierung vorgenommen: ");
            System.out.println(Arrays.toString(ziffernArray));
            System.out.println(Arrays.toString(stellenStartArray));
            System.out.println(Arrays.toString(stellenEndArray));
            System.out.println("Sortierte Indizes: ");
            System.out.println(Arrays.toString(indizesDerSortierung));
            for (int i = 0; i < stellenStartArray.length; i++) {
                naechsteZeile += "" + (stellenEndArray[i] - stellenStartArray[i])
                        + ziffernArray[i];
            }
            letzteZeile = naechsteZeile;
            System.out.println(naechsteZeile);
            PressEnter.toContinue();
        }
    }

    private Integer[] sortiereMeinArray(Integer[] intFeld) {
        Integer[] returnFeld = new Integer[intFeld.length];
        for (int k = 0; k < returnFeld.length; k++) {
            returnFeld[k] = intFeld[indizesDerSortierung[k]];
        }
        return returnFeld;
    }

    private void erstelleSortierIndizes(Integer[] intFeld) {
        indizesDerSortierung = new int[intFeld.length];

        int minIndex;

        for (int j = 0; j < indizesDerSortierung.length; j++) {
            minIndex = 0;
            labelOne:
            for (int k = 0; k < intFeld.length; k++) {
                minIndex = k;
                for (int m = 0; m < j; m++) {
                    if (k == indizesDerSortierung[m]) {
                        continue labelOne;
                    }
                }
                labelTwo:
                for (int p = 0; p < intFeld.length; p++) {
                    for (int m = 0; m < j; m++) {
                        if (p == indizesDerSortierung[m]) {
                            continue labelTwo;
                        }
                    }
                    if (intFeld[p] < intFeld[minIndex]) {
                        minIndex = p;
                    }
                }
            }
            indizesDerSortierung[j] = minIndex;
        }
//        System.out.println(Arrays.toString(indizesDerSortierung));
    }

    private Integer[] makeIntegerArrayListToIntegerArray(List<Integer> liste) {
        Integer[] arrayInteger = new Integer[liste.size()];
        liste.toArray(arrayInteger);
        return arrayInteger;
    }
}
