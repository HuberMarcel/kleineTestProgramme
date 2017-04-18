package de.marcelhuber.pruefungsvorbereitung.oca.interfacetest;

import de.marcelhuber.pruefungsvorbereitung.oca.*;

/**
 *
 * @author Marcel Huber
 */
public class InterfaceTester implements IBeispielInterface {
//    long variable; // auch das wäre eine shadowing-Variable
//    static long variable; // auch das wäre shadowing

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new InterfaceTester().go();
    }

    private void go() {
        ichBinAutomatischEineAbstrakteMethode();
        int testVariable = variable; // die Variable "variable" ist die aus dem
        // Interface
        System.out.println("Wert der (Interface)-Variablen: " + variable);
        System.out.println("Wert der test-Variablen: " + testVariable);
//        variable = 5; // Interface-Variablen sind final
        int variable = 7; // shadowing
        System.out.println("Wert der (shadowing)-Variablen: " + variable);
    }

    @Override
    public void ichBinAutomatischEineAbstrakteMethode() {
        System.out.println("Ich überschreibe die Methode namens: "
                + "ichBinAutomatischEineAbstrakteMethode()");
    }

}