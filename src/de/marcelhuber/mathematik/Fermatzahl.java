// Fermatzahlen f aus IN sind Zahlen der Bauart
// f = {2^(2^k)}+1 mit einem k aus IN u {0} (0 inklusive)
package de.marcelhuber.mathematik;

import de.marcelhuber.mathematischeHilfsprogramme.*;

/**
 *
 * @author Marcel Huber
 */
public class Fermatzahl {

    private boolean statusAsFermatNumber;
    private boolean showCalculation;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new Fermatzahl().go();
    }

    private void go() {

    }

    public boolean calculateStatusAsFermatNumber(long zahl) {
        if (zahl <= 2) {
            if (zahl <= 0) {
                if (showCalculation) {
                    System.out.println("!!!!!!!"
                            + "Fermatzahlen sind positiv!!!!!!!");
                }
            }
            return false;
        }
        zahl -= 1;
        if (showCalculation) {
            System.out.println("\nRECHENWEG für die Zahl " + (zahl+1) + ":");
            System.out.println("Zuerst wird von " + (zahl + 1)
                    + " die Zahl 1 abgezogen: " + zahl);
        }
        if (!hilfsmethoden.getResultCheckIs2erPotenz(zahl)) {
            if (showCalculation) {
                System.out.println("Wir haben nun keine 2er-Potenz vorliegen!");
            }
            return false;
        }
        // wegen des returns ist alles folgende quasi der else-Zweig
        long counter = 0;
        while (zahl % 2 == 0) {
            zahl /= 2;
            counter++;
            if (showCalculation) {
                System.out.println("Die " + counter + ". Division [counter="
                        + counter + "] durch 2 " + "liefert: " + zahl);
            }
        }
        if (showCalculation) {
            System.out.println("Nach der letzten Division durch 2: " + zahl);
            System.out.println("Der Test, ob counter [=" + counter + "] eine 2er-Potenz ist"
                    + " (true=ja, false=nein), ergibt: " + hilfsmethoden.getResultCheckIs2erPotenz(counter));
        }
//        System.out.println("(Fermatzahl) counter"+counter+"himo: "+ hilfsmethoden.getResultCheckIs2erPotenz(counter));
        statusAsFermatNumber = hilfsmethoden.getResultCheckIs2erPotenz(counter);
        return statusAsFermatNumber;
    }

    public boolean getShowCalculation() {
        return showCalculation;
    }

    public void setShowCalculation(boolean showCalculation) {
        this.showCalculation = showCalculation;
    }
}
