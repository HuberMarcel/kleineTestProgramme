package de.marcelhuber.pruefungsvorbereitung.oca.interfacetest;

import de.marcelhuber.pruefungsvorbereitung.oca.*;

/**
 *
 * @author Marcel Huber
 */
public class InterfaceTester implements IBeispielInterfacePublic {
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

//    @Override
//    public void michGibtEsSeiJava8() {
//        IBeispielInterfacePublic.super.michGibtEsSeiJava8();
//    }
    private void go() {
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(true);
        System.out.println("Ergebnis des Vergleichs nach Casten: " + ((boolean) b1 == (boolean) b2));
        System.out.println("Referenzvergleich:                   " + (b1 == b2));
        System.out.println("Equals-Methode:                      " + b1.equals(b2));
        InterfaceTester.super.equals(this);                    // was macht das??
        // da InterfaceTester von Object erbt: 
        new Object().equals(this);
        System.out.println(InterfaceTester.super.equals(this) == new Object().equals(this));                          // false: auf dem jetzigen Objekt wird die equals aus Object verwendet
        System.out.println((boolean) InterfaceTester.super.equals(this));                                             // true  
        System.out.println((boolean) new Object().equals(this));                                                      // false
        System.out.println((boolean) InterfaceTester.super.equals(this) == (boolean) new Object().equals(this));      // false, da geprüft wird, ob true == false
        System.out.println((boolean) super.equals(this));                                                             // true
        System.out.println((boolean) new Object().equals(this));                                                      // false
        System.out.println((boolean) super.equals(this) == (boolean) new Object().equals(this));                      // false, da geprüft wird, ob true == false
//        michGibtEsSeiJava8();
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
//        IBeispielInterfacePublic.super.ichBinAutomatischEineAbstrakteMethode();
        System.out.println("Ich überschreibe die Methode namens: "
                + "ichBinAutomatischEineAbstrakteMethode()");
    }

}
