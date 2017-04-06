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
    private boolean fermatJaNein;
    private boolean goWithMethodeFaster;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        long schleifenEnde = 500_000_000;
        new FermatzahlDemo().go(schleifenEnde, false);
        System.out.println("");
        new FermatzahlDemo().go(schleifenEnde, true);

    }

    private void go(long schleifenEnde, boolean goWithMethodeFaster) {
        this.goWithMethodeFaster = goWithMethodeFaster;
        long time = System.currentTimeMillis();
        Fermatzahl fermatzahlRechenObjekt = new Fermatzahl();
        fermatzahlRechenObjekt.setShowInternCalculation(false);
        StringBuilder ausgabeFermatJaNein;
        int indexOfKeine = 0;
        rechenwegJaNein = "Der Rechenweg wird mit angezeigt (ja=true, "
                + "nein=false): " + fermatzahlRechenObjekt.getShowInternCalculation();
        rechenwegJaNein = "Der Rechenweg wird mit angezeigt (ja=true, "
                + "nein=false): " + fermatzahlRechenObjekt.getShowInternCalculation();
        System.out.println(rechenwegJaNein);
        ausgabeFermatJaNein = new StringBuilder("Die Zahl ist keine Fermatzahl!");
        System.out.println("Schnellere Methode an? " + isGoWithMethodeFaster());
        for (long zahl = fermatzahlRechenObjekt.fermatZahl(4); zahl < schleifenEnde; zahl++) {
//        System.out.print("Geben Sie eine Zahl ein: ");
//        zahl = ReadInput.readLong();
            ausgabeFermatJaNein.insert(9, "" + zahl + " ");
            if (goWithMethodeFaster) {
                fermatJaNein = fermatzahlRechenObjekt.calculateStatusAsFermatNumberFaster(zahl);
            } else {
                fermatJaNein = fermatzahlRechenObjekt.calculateStatusAsFermatNumber(zahl);
            }
            if (fermatJaNein) {
                indexOfKeine = ausgabeFermatJaNein.indexOf("keine");
                ausgabeFermatJaNein.delete(indexOfKeine, indexOfKeine + 1);
                System.out.print(fermatJaNein + "  |  ");
                System.out.println(ausgabeFermatJaNein);
//                PressEnter.toContinue();
                time = System.currentTimeMillis() - time;
                anzeigeZeitInSekunden(time);
                PressEnter.toContinue();
                time = System.currentTimeMillis();
                ausgabeFermatJaNein.insert(indexOfKeine, "k");
            } else if (zahl % 1000_000_000 == 0) {
                System.out.println("Kontrollausgabe: ");
                System.out.print(fermatJaNein + "  |  ");
                System.out.println(ausgabeFermatJaNein + "\n");
            }
//            System.out.println(ausgabeFermatJaNein);
            ausgabeFermatJaNein.delete(9, 9 + ((zahl + "").length()) + 1);
        }
        time = System.currentTimeMillis() - time;
        anzeigeZeitInSekunden(time);
    }

    private void anzeigeZeitInSekunden(long time) {
        System.out.println("Zeit [s] seit letztem Enter: "
                + (long) ((double) time / 1000));
    }

    public boolean isGoWithMethodeFaster() {
        return goWithMethodeFaster;
    }

    public void setGoWithMethodeFaster(boolean goWithMethodeFaster) {
        this.goWithMethodeFaster = goWithMethodeFaster;
    }
}
