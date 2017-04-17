package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.PressEnter;

/**
 *
 * @author Marcel Huber
 */
public strictfp class Reihenwert {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new Reihenwert().go();
    }

    private void go() {
        long k, end = 600;
        double sum = 0;
        double sumTheorie = 163.0/60;
        System.out.println("Theoretischer Wert: " + sumTheorie);
        for (k = 2; k < end; k++) {
            sum += (StrictMath.pow(2, k - 4) + StrictMath.pow(3, k + 1))
                    * StrictMath.pow(5, -k);
            System.out.printf("Differenz theoretischer Wert - aktuelle "
                    + "Berechnung (k=" + k + "): " + "%1$3.20f%n", (sumTheorie - sum));
            if (k % 50 == 0) {
                PressEnter.toContinue();
            }
        }
    }
}
