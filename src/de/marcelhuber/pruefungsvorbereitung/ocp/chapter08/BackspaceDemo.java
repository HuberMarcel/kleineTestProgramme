package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import de.marcelhuber.systemtools.Pause;

/**
 *
 * @author Marcel Huber
 */
public class BackspaceDemo {

    public static void main(String[] args) {
        new BackspaceDemo().go();
    }

    private void go() {
        String satz = "Dieser Satz ist es wirklich Wert, im Detail gelesen "
                + "zu werden!";
        for (String wort : satz.split(" ")) {
            System.out.print(wort);
            Pause.breakInMillis(625);
            useBackspace(wort);
        }
    }

    private void useBackspace(String wort) {
        for (int k = 0; k < wort.length(); k++) {
            System.out.print("\b");
        }
    }
}
