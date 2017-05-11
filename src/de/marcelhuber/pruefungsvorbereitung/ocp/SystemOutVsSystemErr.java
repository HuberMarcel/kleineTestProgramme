package de.marcelhuber.pruefungsvorbereitung.ocp;

/**
 *
 * @author Marcel Huber
 */
public class SystemOutVsSystemErr {

    public static void main(String[] args) {
        new SystemOutVsSystemErr().go();
    }

    void go() {
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Die aktuelle Zahl ist " + i);
            }
            pause(0);
            System.err.println("Der " + k + ". Schleifendurchlauf ist fertig!");
        }
    }

    void pause(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException ex) {
        }
    }
}
