package de.marcelhuber.pruefungsvorbereitung.oca.selftestseite216;

/**
 *
 * @author Marcel Huber
 */
public class Ouch {

    static int ouch = 7;

    public static void main(String[] args) {
        new Ouch().go(ouch);
        System.out.print(" " + ouch);
        System.out.println("");
    }

    void go(int ouch) {
        ouch++;
//        for (int ouch = 3; ouch < 6; ouch++);     // so steht es eigentlich im Buch
        for (ouch = 3; ouch < 6; ouch++);
        System.out.print(" " + ouch);
    }
}
