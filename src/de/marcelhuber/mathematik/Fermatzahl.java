// Fermatzahlen f aus IN sind Zahlen der Bauart
// f = {2^(2^k)}+1 mit einem k aus IN u {0} (0 inklusive)
package de.marcelhuber.mathematik;

import de.marcelhuber.mathematischeHilfsprogramme.*;
import de.marcelhuber.systemtools.PressEnter;

/**
 *
 * @author Marcel Huber
 */
public class Fermatzahl {

    private boolean statusAsFermatNumber;
    private boolean showInternCalculation;
    private long m = 0;

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
        System.out.println("0. Fermat-Zahl: " + fermatZahl(0));
        System.out.println("1. Fermat-Zahl: " + fermatZahl(1));
        System.out.println("2. Fermat-Zahl: " + fermatZahl(2));
        System.out.println("3. Fermat-Zahl: " + fermatZahl(3));
        System.out.println("4. Fermat-Zahl: " + fermatZahl(4));
        System.out.println("5. Fermat-Zahl: " + fermatZahl(5));
//        System.out.println("6. Fermat-Zahl: " + fermatZahl(6));

        for (int i = 0; i < 100_000; i++) {
            if (calculateStatusAsFermatNumberFaster(i)) {
                PressEnter.toContinue();
            }
        }
    }

    public long fermatZahl(long m) {
        if (m < 0) {
            return 0;
        }
        return 1 + (long) Math.pow(2, Math.pow(2, m));
    }

    public boolean calculateStatusAsFermatNumberFaster(long z) {
        statusAsFermatNumber = false;
        if (z < fermatZahl(0)) {
            statusAsFermatNumber = false;
            m = 1;
        } else {
            if (z < fermatZahl(m)) {
                while (z < fermatZahl(m)) {
                    m--;
                }
            }
            while (z > fermatZahl(m)) {
                m += 1;
            }
        }
        if (z == fermatZahl(m)) {
            statusAsFermatNumber = true;
        }
        if (showInternCalculation) {
            System.out.println("(FermatZahl|calculateStatusAsFermatNumberFaster): "
                    + m + "-e Fermatzahl: " + fermatZahl(m)
                    + " und Ihre Zahl war: " + z);
            System.out.println("Also Status: " + statusAsFermatNumber);
        }
        return statusAsFermatNumber;
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
}
