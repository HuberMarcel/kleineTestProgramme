package de.marcelhuber.pruefungsvorbereitung.oca;
// klar: Labels gehen bei jedweger Art von for-Schleifen
// wie sieht es bei while-Schleifen aus?
// --> funktioniert

/**
 *
 * @author Marcel Huber
 */
public class LabelsBeiSchleifen {

    public static void main(String[] args) {
        new LabelsBeiSchleifen().go();
    }

    private void go() {
        int i = 0;
        int j = 0;
        outerWhile:
        while (i < 10) {
            while (j < 10) {
                ++j;
                if (j == 5) {
                    break outerWhile;
                }
            }
        }
        System.out.println("i=" + i + ",  j=" + j); // Ausgabe i=0 (unverändert) und j=5
    }
}
