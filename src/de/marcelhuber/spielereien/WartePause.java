package de.marcelhuber.spielereien;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class WartePause {

    private long zahl;

    public static void main(String[] args) {
        new WartePause().go();
    }

    private void go() {
        long dieseZahl = 3;
        zahl = 1;
        System.out.println("Wir geben - im 1/2-Sekunden-Takt - die ersten "
                + "10 Potenzen (Exponenten von 0 bis 9) von " + dieseZahl + " aus "
                + "\nund warten danach 5 Sekunden, bevor das Programm gänzlich "
                + "beendet wird:");
        for (int k = 0; k < 10; k++) {
            System.out.println(dieseZahl + "^" + k + " = " + zahl);
            zahl *= dieseZahl;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(WartePause.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        long time = System.nanoTime();
//        System.out.print("Programm wird beendet: ");
//        while (true) {
//            System.out.print(" .");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(WartePause.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (System.nanoTime() - time >= 5 * Math.pow(10, 9)) {
//                break;
//            }
//        }
        // effizientere Implementierung (permanente Differenzrechnung bleibt erspart)
        long endTime = System.nanoTime() + (long) (5 * Math.pow(10, 9));
        System.out.print("Dieses Programm wird in 5 Sekunden beendet: ");
        long timeBeendigung = System.currentTimeMillis();
        while (true) {
            System.out.print(" .");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WartePause.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (System.nanoTime() > endTime) {
                break;
            }
        }
        timeBeendigung -= System.currentTimeMillis();
        timeBeendigung *= -1;
        System.out.println("\n[Das Beenden dauerte tatsächlich "
                + (timeBeendigung / Math.pow(10, 3)) + " Sekunden!]");
        System.out.println("\nProgramm-Ende".toUpperCase());
        System.out.println("");
    }
}
