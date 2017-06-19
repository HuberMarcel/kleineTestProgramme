package de.marcelhuber.kryptographiedemo;
// Einfach mal zur Demonstration, wie man die ChinesischerRestsatzBuchmann5eAuflageSeite43Demo-Klasse
// auch verwenden kann

import de.marcelhuber.systemtools.Pause;

// Beispiel: x = 4 mod 32;
//           x = 3 mod 7;
//           x = 79 mod 423
//           liefert: x mod 55492 mod 94752
/**
 *
 * @author Marcel Huber
 */
public class ChinesischerRestsatzBuchmann5eAuflageSeite43DemoDemo {

    public static void main(String[] args) {
        System.out.println("1. Rechnung:".toUpperCase());
        ChinesischerRestsatzBuchmann5eAuflageSeite43Demo demoDummy
                = new ChinesischerRestsatzBuchmann5eAuflageSeite43Demo();
        Long[] a = {4L, 3L, 79L};
        Long[] m = {32L, 7L, 423L};
        demoDummy.goCalculate(a, m);
        System.out.println("x           = " + demoDummy.getX());
        System.out.println("Neues Modul = " + demoDummy.getNewModul());
        // neue Rechnung geht schief, daher alte Werte für x und newModul!
        System.out.println("");
        Pause.breakInSeconds(2);
        System.out.println("2. Rechnung:".toUpperCase());
        a = new Long[]{};
        m = new Long[]{};
        demoDummy.goCalculate(a, m);
        System.out.println("x           = " + demoDummy.getX());
        System.out.println("Neues Modul = " + demoDummy.getNewModul());
        System.out.println("");
        Pause.breakInSeconds(2);
        System.out.println("3. Rechnung:".toUpperCase());
        a = new Long[]{};
        m = new Long[]{3L};
        demoDummy.goCalculate(a, m);
        System.out.println("x           = " + demoDummy.getX());
        System.out.println("Neues Modul = " + demoDummy.getNewModul());
        System.out.println("");
        Pause.breakInSeconds(2);
        System.out.println("4. Rechnung:".toUpperCase());
        a = new Long[]{2L};
        m = new Long[]{3L, 7L};
        demoDummy.goCalculate(a, m);
        System.out.println("x           = " + demoDummy.getX());
        System.out.println("Neues Modul = " + demoDummy.getNewModul());
        System.out.println("");
        Pause.breakInSeconds(2);
        System.out.println("5. Rechnung:".toUpperCase());
        a = new Long[]{2L, 5L, 33L, 4L, -21L};
        m = new Long[]{6L, 7L, 11L, 9L, 10L};
        demoDummy.goCalculate(a, m);
        System.out.println("x           = " + demoDummy.getX());
        System.out.println("Neues Modul = " + demoDummy.getNewModul());
        System.out.println("");
        Pause.breakInSeconds(2);
        System.out.println("6. Rechnung:".toUpperCase());
        a = new Long[]{2L, 5L, 33L, 4L, -21L};
        m = new Long[]{5L, 7L, 11L, 9L, 13L};
        demoDummy.goCalculate(a, m);
        System.out.println("x           = " + demoDummy.getX());
        System.out.println("Neues Modul = " + demoDummy.getNewModul());
        System.out.println("");
        Pause.breakInSeconds(2);
    }

}
