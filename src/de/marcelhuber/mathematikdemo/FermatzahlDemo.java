package de.marcelhuber.mathematikdemo;

import de.marcelhuber.mathematik.*;
import de.marcelhuber.mathematischeHilfsprogramme.*;
import de.marcelhuber.systemtools.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 * Stand 06.04.2017, 20:00 Uhr
 */
public class FermatzahlDemo {

    private long zahl;
    private String rechenwegJaNein;
    private boolean fermatJaNein;
    private boolean goWithMethodeFaster;
    static private long timeFastMethodeFalse,
            timeFastMethodeTrue, timeMethodeWithLog; // Hilfsrechenvariablen
    static private long startIndex 
            = new Fermatzahl().fermatZahl(3);   // starte mit Fermatzahl mit
                                                // hier sichtbarem Index

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
//        System.out.println(startIndex);
        long schleifenEnde = 5_000_000L; //  new Fermatzahl().fermatZahl(5);
//        System.out.println(schleifenEnde); 
//        PressEnter.toContinue();
        new FermatzahlDemo().go(schleifenEnde, false);
        System.out.println("");
        new FermatzahlDemo().go(schleifenEnde, true);
        double zeitVerhaeltnis 
                = (double) timeFastMethodeTrue / timeFastMethodeFalse;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        new FermatzahlDemo().goMethodeWithLog(schleifenEnde);
        System.out.println("Verhältnis \"Schnell zu langsam\": "
                + nf.format(zeitVerhaeltnis));
        System.out.println("Zeit [s] langsamere Methode: "
                + nf.format((double) timeFastMethodeFalse / 1000));
        System.out.println("Zeit [s] schnelle Methode:   "
                + nf.format((double) timeFastMethodeTrue / 1000));
        System.out.println("Zeit [s Methode mit LOG2: "
                + nf.format((double) timeMethodeWithLog / 1000));
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
        for (long zahl = startIndex; zahl < schleifenEnde; zahl++) {
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
        time -= System.currentTimeMillis();
        time *= -1;
        {
            Date day = new Date();
            if (goWithMethodeFaster) {
                timeFastMethodeTrue = time;
                System.out.println(day);
            } else {
                timeFastMethodeFalse = time;
                System.out.println(day);
            }
        }
        anzeigeZeitInSekunden(time);
    }

    private void goMethodeWithLog(long schleifenEnde) {
        System.out.println("\nLOG-METHODE\n");
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
//        System.out.println("Schnellere Methode an? " + isGoWithMethodeFaster());
        for (long zahl = startIndex; zahl < schleifenEnde; zahl++) {
//        System.out.print("Geben Sie eine Zahl ein: ");
//        zahl = ReadInput.readLong();
            ausgabeFermatJaNein.insert(9, "" + zahl + " ");
            fermatJaNein = fermatzahlRechenObjekt.
                    calculateStatusAsFermatNumberWithLog(zahl);
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
        time -= System.currentTimeMillis();
        time *= -1;
        {
            Date day = new Date();
            timeMethodeWithLog = time;
            System.out.println(day);
        }
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
