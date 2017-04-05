package de.marcelhuber.mathematikdemo;

import de.marcelhuber.mathematik.PrimzahlTest;
import de.marcelhuber.systemtools.*;
/*
 *
 * @author Marcel Huber
 */

public class PrimzahlTestDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new PrimzahlTestDemo().go();
    }

    private void go() {
        long pruefZahl;
        PrimzahlTest primRechenObjekt = new PrimzahlTest();
        String ausgabePrimOderNicht;
        System.out.print("Geben Sie die zu prüfende Zahl ein: ");
        pruefZahl = ReadInput.readLong();
        ausgabePrimOderNicht = primRechenObjekt.naiverPrimzahlTest(pruefZahl);
        System.out.println(ausgabePrimOderNicht);
        System.out.println("\nKontrolle: ");
        System.out.println("Die zu untersuchende Zahl war: " + primRechenObjekt.getPruefZahl());
        System.out.println("Der zugehörige Primzahlstatus (ist prim=true/ ist nicht prim=false): "
                + primRechenObjekt.getIsPrim());
        System.out.println("Die letzte Zahl, die als Teiler zu prüfen gewesen wäre, war: "
                + primRechenObjekt.naivElementareWurzel(pruefZahl));
//        for (int i = 0; i < Math.pow(10, 1); i++) {
//            ausgabePrimOderNicht = primRechenObjekt.naiverPrimzahlTest(i);
//            if (primRechenObjekt.getIsPrim()) {
//                ausgabePrimOderNicht = ";   " + ausgabePrimOderNicht;
//            }
//            System.out.println(i + ": Primzahlstatus = " + primRechenObjekt.getIsPrim()
//                    + " " + ausgabePrimOderNicht);
//        }
    }
}
