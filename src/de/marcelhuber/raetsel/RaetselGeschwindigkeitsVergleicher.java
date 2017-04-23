package de.marcelhuber.raetsel;

import de.marcelhuber.systemtools.PressEnter;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class RaetselGeschwindigkeitsVergleicher {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new RaetselGeschwindigkeitsVergleicher().go();
    }

    private void go() {
        int fallSwitcher = 3;
        int anzahl = 22;
        long time1, time2, time3;
        boolean showCalculation = false;
        RaetselMitZahlen rmZ
                = new RaetselMitZahlen();
        RaetselMitZahlenMitRegulaerenAusdruecken rmZmrA
                = new RaetselMitZahlenMitRegulaerenAusdruecken();
        RaetselMitZahlenMitRegulaerenAusdruecken rmZmrA2
                = new RaetselMitZahlenMitRegulaerenAusdruecken();
        rmZ.setShowCalculationInConsole(showCalculation);
        rmZmrA.setShowCalculationInConsole(showCalculation);
        rmZmrA2.setShowCalculationInConsole(showCalculation);
        time1 = System.nanoTime();
        rmZ.go(anzahl);
        time1 = System.nanoTime() - time1;
        if (fallSwitcher == 1) {
            System.out.printf("time1 [s]: %1$24.2f%n", time1 * 1.0 / Math.pow(10, 9));
            return;
        }
        time2 = System.nanoTime();
//        PressEnter.toContinue();
        rmZmrA.go(anzahl);
        time2 = System.nanoTime() - time2;
//        System.out.println(Arrays.toString(rmZmrA.getIndizesDerSortierung()));
        if (fallSwitcher == 2) {
            System.out.printf("time1 [s]: %1$24.2f%n", time1 * 1.0 / Math.pow(10, 9));
            System.out.printf("time2 [s]: %1$24.2f%n", time2 * 1.0 / Math.pow(10, 9));
            System.out.printf("Faktor time2/time1 ist ca.: %1$7.2f%n", 1.0 * time2 / time1);
            return;
        }
        time3 = System.nanoTime();
        rmZmrA2.goIneffizient(anzahl);
        time3 = System.nanoTime() - time3;
//        System.out.println(Arrays.toString(rmZmrA.getIndizesDerSortierung()));
        System.out.printf("time1 [s]: %1$24.2f%n", time1 * 1.0 / Math.pow(10, 9));
        System.out.printf("time2 [s]: %1$24.2f%n", time2 * 1.0 / Math.pow(10, 9));
        System.out.printf("Faktor time2/time1 ist ca.: %1$7.2f%n", 1.0 * time2 / time1);
        System.out.printf("time3 [s]: %1$24.2f%n", time3 * 1.0 / Math.pow(10, 9));
        System.out.printf("Faktor time3/time1 ist ca.: %1$7.2f%n", 1.0 * time3 / time1);
    }
}
