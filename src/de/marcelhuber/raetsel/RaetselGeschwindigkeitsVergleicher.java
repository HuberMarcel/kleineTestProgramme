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
        long time1, time2;
        RaetselMitZahlen rmZ
                = new RaetselMitZahlen();
        RaetselMitZahlenMitRegulaerenAusdruecken rmZmrA
                = new RaetselMitZahlenMitRegulaerenAusdruecken();
        int anzahl = 23;
        time1 = System.nanoTime();
        rmZ.go(anzahl);
        time1 = System.nanoTime() - time1;
        time2 = System.nanoTime();
        rmZmrA.go(anzahl);
        time2 = System.nanoTime() - time2;
        System.out.printf("time1 [s]: %1$24.2f%n", time1 * 1.0 / Math.pow(10, 9));
        System.out.printf("time2 [s]: %1$24.2f%n", time2 * 1.0 / Math.pow(10, 9));
        System.out.printf("Faktor time2/time1 ist ca.: %1$7.2f%n", 1.0 * time2 / time1);
    }
}
