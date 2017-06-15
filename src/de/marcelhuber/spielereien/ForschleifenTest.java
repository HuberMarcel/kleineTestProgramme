package de.marcelhuber.spielereien;

/**
 *
 * @author Marcel Huber
 */
public class ForschleifenTest {

    public static void main(String[] args) {
        long n;
        long zugabe = 1;   // auch -2, 0, 1, 2 testen
        for (n = 0, System.out.println("(I) Aktueller Wert von n  : " + n);
                n < 10; 
                n += zugabe, System.out.println("(II) Aktueller Wert von n:  " + n)) {
            // die erste System-Ausgabe mit (I) wird einmalig bei der Initialisierung ausgeführt
            // alle anderen bei jedem Durchlauf, wobei immer zuerst die Ausgabe 
            // aus dem Block und danach die mit (II) ausgeführt wird
            System.out.println("Aktueller Wert von n:       " + n);
//            ++n;
        }
    }
}
