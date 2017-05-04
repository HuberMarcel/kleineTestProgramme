package de.marcelhuber.pruefungsvorbereitung.ocp.generics;

/**
 *
 * @author Marcel
 */
public class GenericsDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new GenericsDemo().go();
    }

    private void go() {
        Pocket<String> stringPocketObjekt01 = new Pocket<String>(new Pocket<String>());     // nur bei no-arg-Konstruktor erhöht sich Zählung von objectPocketValueGetterCounter

        stringPocketObjekt01.setValue("Hallo Marcel");
        System.out.println(stringPocketObjekt01.getValue());

        Pocket stringPocketObjekt02 = new Pocket<String>();
        stringPocketObjekt02.setValue(42);
        System.out.println(stringPocketObjekt02.getValue());

        System.out.println("Anzahl der Aufrufe von getValue für Objekt 1: "
                + stringPocketObjekt01.getObjectPocketValueGetterCounter());
        System.out.println("Anzahl der Aufrufe von getValue für Objekt 2: "
                + stringPocketObjekt02.getObjectPocketValueGetterCounter());
        System.out.println("");

        // zählt, wie oft die getValue-Methode pro Objekt benutzt wird
        System.out.println("Anzahl der Aufrufe von getValue insgesamt   : "
                + stringPocketObjekt01.getPocketValueGetterCounter());
        System.out.println("Anzahl der Aufrufe von getValue insgesamt   : "
                + stringPocketObjekt02.getPocketValueGetterCounter());
        System.out.println("Anzahl der Aufrufe von getValue insgesamt   : "
                + Pocket.getPocketValueGetterCounter());

        System.out.println("");
        Pocket<Integer> pInt = new Pocket<Integer>(stringPocketObjekt01);
        System.out.println("Anzahl der Aufrufe von getValue für Objekt 1: "
                + stringPocketObjekt01.getObjectPocketValueGetterCounter());
        System.out.println("Anzahl der Aufrufe von getValue für Objekt 2: "
                + stringPocketObjekt02.getObjectPocketValueGetterCounter());
        System.out.println("");

        // zählt, wie oft die getValue-Methode pro Objekt benutzt wird
        System.out.println("Anzahl der Aufrufe von getValue insgesamt   : "
                + stringPocketObjekt01.getPocketValueGetterCounter());
        System.out.println("Anzahl der Aufrufe von getValue insgesamt   : "
                + stringPocketObjekt02.getPocketValueGetterCounter());
        System.out.println("Anzahl der Aufrufe von getValue insgesamt   : "
                + Pocket.getPocketValueGetterCounter());
    }
}
