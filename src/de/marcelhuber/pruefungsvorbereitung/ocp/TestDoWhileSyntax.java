package de.marcelhuber.pruefungsvorbereitung.ocp;

/**
 *
 * @author Marcel Huber, 14.09.2017
 */
public class TestDoWhileSyntax {

    public static void main(String[] args) {
        int I = 1;

        do {
            while (I < 1) {
                System.out.print("I is " + I);
            }
        } while (I > 1);
    }
}
