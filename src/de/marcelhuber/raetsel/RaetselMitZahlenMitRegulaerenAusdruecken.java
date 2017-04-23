package de.marcelhuber.raetsel;

// Programm läuft nun fehlerfrei (23.04.2017)
import de.marcelhuber.mathematik.SortierungsErsteller;
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
    Integer[] indizesFuerSortierung;
    int anzahl;

    boolean showCalculationInConsole;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
//        new RaetselMitZahlenMitRegulaerenAusdruecken().goTesteMeineSortierung();
//        new RaetselMitZahlenMitRegulaerenAusdruecken().goIneffizient();
        new RaetselMitZahlenMitRegulaerenAusdruecken().go();
    }

    private void goTesteMeineSortierung() {
        Integer[] test = new Integer[]{3, 4, 2, 5, 1};
//        erstelleSortierIndizes(test); // old
        new SortierungsErsteller().indizesFuerIntegerfeldSortierungEffizienter(test); // new
        sortiereMeinArray(test);
        System.out.println(Arrays.toString(indizesDerSortierung));
    }

    public void go(int anzahl) {
        this.anzahl = anzahl;
        go();
    }

    public void goIneffizient(int anzahl) {
        this.anzahl = anzahl;
        goIneffizient();
    }

    private void go() {
        if (anzahl == 0) {
            anzahl = 20;
        }
        String letzteZeile = "1";
        String naechsteZeile = "";
        int counter = -1;
        boolean endless = false;
        while (++counter < anzahl || endless) {
            if (showCalculationInConsole) {
                System.out.println(letzteZeile);
            }
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
//                    System.out.println(matcher.group());
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
//            erstelleSortierIndizes(stellenStartArray);   // old
            indizesFuerSortierung // new
                    = new SortierungsErsteller().indizesFuerIntegerfeldSortierungEffizienter(stellenStartArray); // new
            indizesDerSortierung = new int[indizesFuerSortierung.length];                                        // new
            for (int i = 0; i < indizesDerSortierung.length; i++) {                                              // new
                indizesDerSortierung[i] = indizesFuerSortierung[i];                                              // new
            }                                                                                                    // new
            stellenStartArray = sortiereMeinArray(stellenStartArray);
            stellenEndArray = sortiereMeinArray(stellenEndArray);
            ziffernArray = sortiereMeinArray(ziffernArray);
//            System.out.println("\n\nSortierung vorgenommen: ");
//            System.out.println(Arrays.toString(ziffernArray));
//            System.out.println(Arrays.toString(stellenStartArray));
//            System.out.println(Arrays.toString(stellenEndArray));
//            System.out.println("Sortierte Indizes: ");
//            System.out.println(Arrays.toString(indizesDerSortierung));
            for (int i = 0; i < stellenStartArray.length; i++) {
                naechsteZeile += "" + (stellenEndArray[i] - stellenStartArray[i])
                        + ziffernArray[i];
            }
            letzteZeile = naechsteZeile;
//            System.out.println(naechsteZeile);
            if (counter > 0 && counter % 10 == 0) {
//                PressEnter.toContinue();
            }
        }
    }

    private void goIneffizient() {
        if (anzahl == 0) {
            anzahl = 20;
        }
        String letzteZeile = "1";
        String naechsteZeile = "";
        int counter = -1;
        boolean endless = false;
        while (++counter < anzahl || endless) {
            if (showCalculationInConsole) {
                System.out.println(letzteZeile);
            }
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
//                    System.out.println(matcher.group());
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

            erstelleSortierIndizes(stellenStartArray);                                       // old
//        System.out.println(Arrays.toString(indizesDerSortierung));
            stellenStartArray = sortiereMeinArray(stellenStartArray);
            stellenEndArray = sortiereMeinArray(stellenEndArray);
            ziffernArray = sortiereMeinArray(ziffernArray);
//            System.out.println("\n\nSortierung vorgenommen: ");
//            System.out.println(Arrays.toString(ziffernArray));
//            System.out.println(Arrays.toString(stellenStartArray));
//            System.out.println(Arrays.toString(stellenEndArray));
//            System.out.println("Sortierte Indizes: ");
//            System.out.println(Arrays.toString(indizesDerSortierung));
            for (int i = 0; i < stellenStartArray.length; i++) {
                naechsteZeile += "" + (stellenEndArray[i] - stellenStartArray[i])
                        + ziffernArray[i];
            }
            letzteZeile = naechsteZeile;
//            System.out.println(naechsteZeile);
            if (counter > 0 && counter % 10 == 0) {
//                PressEnter.toContinue();
            }
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
            minIndex = j;
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
                indizesDerSortierung[j] = minIndex;
            }
        }
//        System.out.println(Arrays.toString(indizesDerSortierung));
    }

    private Integer[] makeIntegerArrayListToIntegerArray(List<Integer> liste) {
        Integer[] arrayInteger = new Integer[liste.size()];
        liste.toArray(arrayInteger);
        return arrayInteger;
    }

    public int[] getIndizesDerSortierung() {
        return indizesDerSortierung;
    }

    public void setShowCalculationInConsole(boolean showCalculationInConsole) {
        this.showCalculationInConsole = showCalculationInConsole;
    }

    public boolean getShowCalculationInConsole() {
        return showCalculationInConsole;
    }
}
