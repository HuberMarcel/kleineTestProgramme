package de.marcelhuber.assertions;

/**
 *
 * @author Marcel Huber
 */
// hier wird IMMER angezeigt, ob Assertions enabled oder disabled sind!!
public class AssertionsAbfrageZuBeginnMethode02 {

    public static void main(String[] args) {
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (assertionsEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
    }

    void go() {
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        if (assertionsEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
    }
}
