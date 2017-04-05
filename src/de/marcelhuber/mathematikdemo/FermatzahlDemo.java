package de.marcelhuber.mathematikdemo;

import de.marcelhuber.mathematik.*;
import de.marcelhuber.mathematischeHilfsprogramme.*;
import de.marcelhuber.systemtools.*;

/**
 *
 * @author Marcel Huber
 */
public class FermatzahlDemo {

    private long zahl;
    private String rechenwegJaNein;
    boolean fermatJaNein;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new FermatzahlDemo().go();
    }

    private void go() {
        Fermatzahl fermatzahlRechenObjekt = new Fermatzahl();
        fermatzahlRechenObjekt.setShowCalculation(false);
        StringBuilder ausgabeFermatJaNein;
        int indexOfKeine = 0;
        rechenwegJaNein = "Der Rechenweg wird mit angezeigt (ja=true, "
                + "nein=false): " + fermatzahlRechenObjekt.getShowCalculation();
        rechenwegJaNein = "Der Rechenweg wird mit angezeigt (ja=true, "
                + "nein=false): " + fermatzahlRechenObjekt.getShowCalculation();
        System.out.println(rechenwegJaNein);
        ausgabeFermatJaNein = new StringBuilder("Die Zahl ist keine Fermatzahl!");
        for (long zahl = -10; zahl < Math.pow(10, 10); zahl++) {
//        System.out.print("Geben Sie eine Zahl ein: ");
//        zahl = ReadInput.readLong();
            ausgabeFermatJaNein.insert(9, "" + zahl + " ");
            fermatJaNein = fermatzahlRechenObjekt.calculateStatusAsFermatNumber(zahl);
            if (fermatJaNein) {
                indexOfKeine = ausgabeFermatJaNein.indexOf("keine");
                ausgabeFermatJaNein.delete(indexOfKeine, indexOfKeine + 1);
                System.out.print(fermatJaNein + "  |  ");
                System.out.println(ausgabeFermatJaNein);
//                PressEnter.toContinue();
            }

            if (fermatJaNein) {
                ausgabeFermatJaNein.insert(indexOfKeine, "k");
                PressEnter.toContinue();
            } else if (zahl % 100_000_000 == 0) {
                System.out.print(fermatJaNein + "  |  ");
                System.out.println(ausgabeFermatJaNein);
            }
            ausgabeFermatJaNein.delete(9, 9 + ((zahl + "").length()) + 1);
        }
    }
}
