package de.marcelhuber.raetsel;

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
        int faelle = 3;
        int anzahl = 15;
        long time1, time2, time3;
        RaetselMitZahlen rmZ
                = new RaetselMitZahlen();
        RaetselMitZahlenMitRegulaerenAusdruecken rmZmrA
                = new RaetselMitZahlenMitRegulaerenAusdruecken();
        time1 = System.nanoTime();
        rmZ.go(anzahl);
        time1 = System.nanoTime() - time1;
        if (faelle == 1) {
            System.out.printf("time1 [s]: %1$24.2f%n", time1 * 1.0 / Math.pow(10, 9));
            return;
        }
        time2 = System.nanoTime();
        rmZmrA.go(anzahl);
        time2 = System.nanoTime() - time2;
        if (faelle == 2) {
            System.out.printf("time1 [s]: %1$24.2f%n", time1 * 1.0 / Math.pow(10, 9));
            System.out.printf("time2 [s]: %1$24.2f%n", time2 * 1.0 / Math.pow(10, 9));
            System.out.printf("Faktor time2/time1 ist ca.: %1$7.2f%n", 1.0 * time2 / time1);
            return;
        }
        time3 = System.nanoTime();
        rmZmrA.goIneffizient(anzahl);
        time3 = System.nanoTime() - time3;
        System.out.printf("time1 [s]: %1$24.2f%n", time1 * 1.0 / Math.pow(10, 9));
        System.out.printf("time2 [s]: %1$24.2f%n", time2 * 1.0 / Math.pow(10, 9));
        System.out.printf("Faktor time2/time1 ist ca.: %1$7.2f%n", 1.0 * time2 / time1);
        System.out.printf("time3 [s]: %1$24.2f%n", time3 * 1.0 / Math.pow(10, 9));
        System.out.printf("Faktor time3/time1 ist ca.: %1$7.2f%n", 1.0 * time3 / time1);
    }
}
