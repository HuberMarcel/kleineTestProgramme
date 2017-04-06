// Fermatzahlen f aus IN sind Zahlen der Bauart
// f = {2^(2^k)}+1 mit einem k aus IN u {0} (0 inklusive)
package de.marcelhuber.mathematik;

import de.marcelhuber.mathematischeHilfsprogramme.*;
import de.marcelhuber.systemtools.PressEnter;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class Fermatzahl {

    private boolean statusAsFermatNumber;
    private boolean showInternCalculation;
    private List<Long> fermatZahlen = new ArrayList<>();
//    private long m = 0;                    // alter Code 05.04.17
    private int m = 0;                         // neuer Code 06.04.17
    private final double LOG2 = Math.log(2);

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new Fermatzahl().go();
        PressEnter.toContinue();
        new Fermatzahl().goFermatZahlenTester(-2);
        new Fermatzahl().goFermatZahlenTester(-1);
        new Fermatzahl().goFermatZahlenTester(0);
        new Fermatzahl().goFermatZahlenTester(1);
        new Fermatzahl().goFermatZahlenTester(2);
    }

    private void go() {
//        setShowInternCalculation(true);
//        for (int j = -3; j < 10; j++) {
//            System.out.println(j + ": Status - "
//                    + calculateStatusAsFermatNumberWithLog(j));
//        }
//        PressEnter.toContinue();
        System.out.println("0. Fermat-Zahl: " + fermatZahl(0));
        System.out.println("1. Fermat-Zahl: " + fermatZahl(1));
        System.out.println("2. Fermat-Zahl: " + fermatZahl(2));
        System.out.println("3. Fermat-Zahl: " + fermatZahl(3));
        System.out.println("4. Fermat-Zahl: " + fermatZahl(4));
        System.out.println("5. Fermat-Zahl: " + fermatZahl(5));
//        System.out.println("6. Fermat-Zahl: " + fermatZahl(6));

//        PressEnter.toContinue();
        for (int i = 0; i < 1_000_000; i++) {
            if (calculateStatusAsFermatNumberFaster(i)) {
                System.out.println(i + " ist Fermatzahl! \t");
//                PressEnter.toContinue();
            }
        }

    }

    private void goFermatZahlenTester(long m) {
//        PressEnter.toContinue();
        fuelleFermatZahlen(m);
//        fuelleFermatZahlen(m+2);
        anzeigeFermatzahlenListe();
    }

    public long fermatZahl(long m) {
        if (m < 0) {
            return 0;
        }
        return 1 + (long) Math.pow(2, Math.pow(2, m));
    }

    public boolean calculateStatusAsFermatNumberWithLog(long zahl) {
        statusAsFermatNumber = false;
        double firstExponent, secondExponent;
        if (zahl < 3) {
            return statusAsFermatNumber;
        }
        zahl -= 1;
        firstExponent = Math.log(zahl) / LOG2;
        if (showInternCalculation) {
            System.out.println("Erster Exponent (zahl=" + (zahl + 1) + "):"
                    + firstExponent);
        }
        if (Math.abs(firstExponent - (long) firstExponent)
                >= 1d / (LOG2 * (1 + (long) (Math.pow(2, (long) firstExponent))))) {
            return statusAsFermatNumber = false;
        }
        /*
        Bemerkung zum letzten if-Block: Ich gehe davon aus, dass log(x)/log(2)
        tatsächlich nur einen minimal zu großen Wert liefert. Nehmen wir an, 
        dass x=2^m+1 ist. Dann gilt wegen 1-1/y <= log(y) also
        (log(x)-log(2^m))/log(2) = log(x/2^m)/log(2) >= (1  - 2^m/x)/log(2)
                                 = ((x-2^m)/x)/log(2) = 1/(log(2) *[2^m +1])
        Wenn also ein Wert < der rechten Seite rauskommt, ist alles gut
         */
        if ((long) firstExponent == 1) {
            return statusAsFermatNumber = true;
        }
        secondExponent = Math.log(firstExponent) / LOG2;
        if (showInternCalculation) {
            System.out.println("Zweiter Exponent (zahl=" + (zahl + 1) + "):"
                    + secondExponent);
        }
        if (Math.abs(secondExponent - (long) secondExponent)
                < 1d / (LOG2 * (1 + (long) (Math.pow(2, (long) secondExponent))))) {
            statusAsFermatNumber = true;
        }
        /*
         Wenn der Logarithmus nicht exakt rechnet, so muss die Differeny 
         >= der rechten Seite sein, wenn wir nicht von einer Zweierpotenz, 
        sondern von einer Zahl, die etwas größer als eine Zweier-Potenz ist,
        ausgegangen sind. 
         */
        return statusAsFermatNumber;
    }

    public boolean calculateStatusAsFermatNumberFaster(long z) {
        if (!fermatZahlen.contains(fermatZahl(0))) {     // neuer Code 06.04.17
            fermatZahlen.add(fermatZahl(0));             // neuer Code 06.04.17
        }                                                // neuer Code 06.04.17
        statusAsFermatNumber = false;
        if (z < fermatZahlen.get(0)) {
//        if (z < fermatZahl(0)) {            // alter Code 05.04.17
            statusAsFermatNumber = false;
            m = 1;
        } else {
            if (z < fermatZahl(m)) {
                makeItPossibleToGetFermatNumberFromFermatzahlen(m);       // neuer Code 06.04.17
//                while (z < fermatZahl(m)) {         // alter Code 05.04.17
                while (z < fermatZahlen.get(m)) {
                    m--;
                }
            }
//            while (z > fermatZahl(m)) {         // alter Code 05.04.17
            makeItPossibleToGetFermatNumberFromFermatzahlen(m);       // neuer Code 06.04.17
//            System.out.println("Zahl z=" + z + ",  m=" + m + "     FSIZE " + fermatZahlen.size());
//            Long[] testAusgabe = new Long[fermatZahlen.size()];
//            fermatZahlen.toArray(testAusgabe);
//            System.out.println(Arrays.toString(testAusgabe));
//            PressEnter.toContinue();
            while (z > fermatZahlen.get(m)) {       // neuer Code 06.04.17
                m += 1;
                makeItPossibleToGetFermatNumberFromFermatzahlen(m);       // neuer Code 06.04.17                                           
            }
        }
//        if (z == fermatZahl(m)) {                       // alter Code 05.04.17
        makeItPossibleToGetFermatNumberFromFermatzahlen(m);       // neuer Code 06.04.17                                 
        if (z == fermatZahlen.get(m)) {         // neuer Code 06.04.17        
            statusAsFermatNumber = true;
        }
        if (showInternCalculation) {
            System.out.println("(FermatZahl|calculateStatusAsFermatNumberFaster): "
                    // + m + "-e Fermatzahl: " + fermatZahl(m)      // alter Code 05.04.17
                    + m + "-e Fermatzahl: " + fermatZahlen.get(m) // neuer Code 06.04.17
                    + " und Ihre Zahl war: " + z);
            System.out.println("Also Status: " + statusAsFermatNumber);
        }
        return statusAsFermatNumber;
    }

    private void makeItPossibleToGetFermatNumberFromFermatzahlen(int m) {
        // erweiter die fermatZahlen-Liste so, dass sie fermatZahl(m),
        // also die m-te Fermatzahl (die 0-te ist die 3) enthält
        if (fermatZahlen.size() < m + 1) {      // neuer Code 06.04.17
            fuelleFermatZahlen(m);          // neuer Code 06.04.17
        }                                       // neuer Code 06.04.17
    }

    private void fuelleFermatZahlen(long m) {
        for (int k = 0; k < m + 1; k++) {
            if (!fermatZahlen.contains(fermatZahl(k))) {
                fermatZahlen.add(k, fermatZahl(k));
            }
        }
    }

    public boolean calculateStatusAsFermatNumber(long zahl) {
        if (zahl <= 2) {
            if (zahl <= 0) {
                if (showInternCalculation) {
                    System.out.println("!!!!!!!"
                            + "Fermatzahlen sind positiv!!!!!!!");
                }
            }
            return false;
        }
        zahl -= 1;
        if (showInternCalculation) {
            System.out.println("\nRECHENWEG für die Zahl " + (zahl + 1) + ":");
            System.out.println("Zuerst wird von " + (zahl + 1)
                    + " die Zahl 1 abgezogen: " + zahl);
        }
        if (!hilfsmethoden.getResultCheckIs2erPotenz(zahl)) {
            if (showInternCalculation) {
                System.out.println("Wir haben nun keine 2er-Potenz vorliegen!");
            }
            return false;
        }
        // wegen des returns ist alles folgende quasi der else-Zweig
        long counter = 0;
        while (zahl % 2 == 0) {
            zahl /= 2;
            counter++;
            if (showInternCalculation) {
                System.out.println("Die " + counter + ". Division [counter="
                        + counter + "] durch 2 " + "liefert: " + zahl);
            }
        }
        if (showInternCalculation) {
            System.out.println("Nach der letzten Division durch 2: " + zahl);
            System.out.println("Der Test, ob counter [=" + counter + "] eine 2er-Potenz ist"
                    + " (true=ja, false=nein), ergibt: " + hilfsmethoden.getResultCheckIs2erPotenz(counter));
        }
//        System.out.println("(Fermatzahl) counter"+counter+"himo: "+ hilfsmethoden.getResultCheckIs2erPotenz(counter));
        statusAsFermatNumber = hilfsmethoden.getResultCheckIs2erPotenz(counter);
        return statusAsFermatNumber;
    }

    public boolean getShowInternCalculation() {
        return showInternCalculation;
    }

    public void setShowInternCalculation(boolean showInternCalculation) {
        this.showInternCalculation = showInternCalculation;
    }

    public void anzeigeFermatzahlenListe() {
        // dient zur Ausgabe der aktuellen Liste der Fermatzahlen
        Long[] fermatZahlenAlsArray = new Long[fermatZahlen.size()];
        fermatZahlen.toArray(fermatZahlenAlsArray);
        System.out.println("Die Liste der aktuell vorhandenen "
                + "Fermatzahlen: ");
        System.out.println(Arrays.toString(fermatZahlenAlsArray));
    }
}
