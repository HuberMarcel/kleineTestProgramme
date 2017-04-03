package de.marcelhuber.assertions;

/**
 *
 * @author Marcel Huber
 */
// hier wird NUR angezeigt, dass bzw. wenn Assertions enabled sind!!
public class AssertionsAbfrageZuBeginnMethode01 {

    public static void main(String[] args) {
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (assertionsEnabled) {
            System.out.println("Assertions Enabled");
        }
    }

    void go() {
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (assertionsEnabled) {
            System.out.println("Assertions Enabled");
        }
    }
}
