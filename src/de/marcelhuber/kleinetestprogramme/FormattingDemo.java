package de.marcelhuber.kleinetestprogramme;

import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class FormattingDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new FormattingDemo().go();
    }

    private void go() {
        Date date = new Date();
        double durchschnittTageProMonat = (7 * 31 + 4 * 30 + 28.25) / 12;
        long time = date.getTime();
        long tagAnzahl = (time) / 1000 / 60 / 60 / 24;
        long monatAnzahl = (long) (tagAnzahl / durchschnittTageProMonat);
        double monatsAnzahlAsDouble = (tagAnzahl / durchschnittTageProMonat);
        long jahrAnzahl = (long) (tagAnzahl / 365.25);
        double jahrAnzahlAsDouble = (tagAnzahl / 365.25);
        System.out.println("Seit dem 1.1.1970 sind " + tagAnzahl
                + " Tage vergangen!");
        System.out.println("Das sind etwa " + monatAnzahl + " Monate, genauer "
                + monatsAnzahlAsDouble + "!");
        System.out.println("Das sind etwa " + (double) monatAnzahl / 12 + " Jahre (Rechnung "
                + "mit Monaten)!");
        System.out.println("Das sind etwa " + jahrAnzahl + " Jahre, genauer "
                + jahrAnzahlAsDouble + "!");
    }
}
