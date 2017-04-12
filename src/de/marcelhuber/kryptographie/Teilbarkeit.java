package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematischeHilfsprogramme.hilfsmethoden;
import de.marcelhuber.systemtools.PressEnter;

/**
 *
 * @author Marcel Huber
 */
public class Teilbarkeit {

    boolean showCalculation = true;
    String divisionszeichen = ":";

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
//        new Teilbarkeit().goTestFallNaiverTeilbarkeitsTest();
        new Teilbarkeit().goTestSchriftlicheDivision();
//        new Teilbarkeit().go();
    }

    private void go() {
        System.out.println("Rechenzeitvergleich:");
        boolean teilbar;
        long a = 576531 - 27, b = 459;
        long q, r;
        long timeDirekt = System.nanoTime();
        long timeIndirekt;
        long timeSchriftlicheDivision;
        if (a % b == 0) {
            teilbar = true;
        } else {
            teilbar = false;
        }
        q = a / b;
        r = a - q * b;
        timeDirekt = System.nanoTime() - timeDirekt;
        System.out.println("Ergebnis der direkten Methode:          " + teilbar);
        System.out.println("Das dauerte "
                + (timeDirekt / Math.pow(10, 9)) + " Sekunden!");
        timeIndirekt = System.nanoTime();
        teilbar = (boolean) ((Object[]) naiverTeilbarkeitsTest(a, b))[0];
        timeIndirekt = System.nanoTime() - timeIndirekt;
        System.out.println("Ergebnis der naiv indirekten Methode:   " + teilbar);
        System.out.println("Das dauerte " + (timeIndirekt / Math.pow(10, 9))
                + " Sekunden!");
        System.out.printf("Faktor indirekt zu direkt:                    "
                + "%1$11.2f%n", 1.0 * timeIndirekt / timeDirekt);
        timeSchriftlicheDivision = System.nanoTime();
        long[] schriftlichDividieren = simuliereSchriftlicheDivision(a, b);
        timeSchriftlicheDivision = System.nanoTime() - timeSchriftlicheDivision;
        System.out.println("Ergebnis der schriftlichen Division:    "
                + (schriftlichDividieren[1] == 0));
        System.out.println("Das dauerte "
                + (timeSchriftlicheDivision / Math.pow(10, 9)) + " Sekunden!");
        System.out.printf("Faktor schriftliches Dividieren zu direkt:    "
                + "%1$11.2f%n", 1.0 * timeSchriftlicheDivision / timeDirekt);
// reserviere 11 Stellen, 1 davon ist für das Komma, 8 Vorkomma-Plätze, 
// 2 Nachkomma-Plätze; mit %1$ wird die erste Variable angesprochen (ist 
// unnötig, das zusätzlich zu schreiben)
        System.out.println("Test: a hatte den Wert " + a);
        System.out.println("Es gilt\n" + schriftlichDividieren[0] + "*" + b + "+"
                + schriftlichDividieren[1] + " = " + (schriftlichDividieren[0] * b
                + schriftlichDividieren[1]));
    }

    private void goTestFallNaiverTeilbarkeitsTest() {
        long a = 3;
        long b = 8;
        System.out.println("\n" + a + " durch " + b + ":");
        Object auswertung = naiverTeilbarkeitsTest(a, b);
        anzeigeNaiverTeilbarkeitsTest(auswertung);
        System.out.println("\n" + (-a) + " durch " + b + ":");
        auswertung = naiverTeilbarkeitsTest(-a, b);
        anzeigeNaiverTeilbarkeitsTest(auswertung);
        System.out.println("\n" + a + " durch (" + -b + "):");
        auswertung = naiverTeilbarkeitsTest(a, -b);
        anzeigeNaiverTeilbarkeitsTest(auswertung);
        System.out.println("\n" + -a + " durch (" + (-b) + "):");
        auswertung = naiverTeilbarkeitsTest(-a, -b);
        anzeigeNaiverTeilbarkeitsTest(auswertung);
    }

    private Object[] naiverTeilbarkeitsTest(long a, long b) {
        Object[] rueckgabe = new Object[3];
        boolean teilbar = false;
        long teiler = 0, q = 0, hilfsvar = 0;
        long rest = 0;
        if (b == 0) {
            if (a == 0) {
                teilbar = true;
            }
        } else {
            if (b < 0) {
                if (a < 0) {
                    while (hilfsvar > a) {
                        q++;
                        hilfsvar += b;
                    }
                } else {
                    while ((hilfsvar -= b) <= a) {
                        q--;
                    }
                    hilfsvar += b;
                }
            } else {
                if (a < 0) {
                    while (hilfsvar > a) {
                        q--;
                        hilfsvar -= b;
                    }
                } else {
                    while ((hilfsvar += b) <= a) {
                        q++;
                    }
                    hilfsvar -= b;
                }
            }
        }
        rest = a - hilfsvar;
        if (rest == 0) {
            teilbar = true;
        } else {
            teilbar = false;
        }
        rueckgabe[0] = teilbar;
        rueckgabe[1] = q;
        rueckgabe[2] = rest;
        return rueckgabe;
    }

    private void goTestSchriftlicheDivision() {
        long a = 4675;
        long b = 22;
        long[] quotientRest;
        quotientRest = simuliereSchriftlicheDivision(a, b);
        boolean ergebnisKontrolleLocal = false;
        if (ergebnisKontrolleLocal) {

            System.out.println("\nDer Quotient von " + a + " durch "
                    + b + ": " + quotientRest[0]);
            System.out.println("Der Rest der Division von " + a + " durch "
                    + b + " ist " + quotientRest[1]);
            System.out.println("Es gilt also " + a + " = " + quotientRest[0] + "*" + b + "+"
                    + quotientRest[1]);
            System.out.println("Kontrolle: " + quotientRest[0] + "*" + b + "+"
                    + quotientRest[1] + " = " + (quotientRest[0] * b + quotientRest[1]));
        }
    }

    private long[] simuliereSchriftlicheDivision(long a, long b) {
        long q = 0;
        long r = 0;
        long aAnteil = 0;
        long counter = 0;
        int verbrauchteZiffern = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        StringBuilder ergebnisZahl = new StringBuilder("");
        if (b == 0) {
            System.out.println("Division durch 0!");
            ergebnisZahl.append("0");
            r = a;
        } else {
            if (a < b) {
                q = 0;
                r = a;
            } else {
                verbrauchteZiffern = ("" + b).length();
                aAnteil = Long.parseLong(("" + a).substring(0, verbrauchteZiffern));
                if (aAnteil < b) {
                    verbrauchteZiffern++;
                    aAnteil = Long.parseLong(("" + a).substring(0, verbrauchteZiffern));
                }
            }
//            System.out.println(("" + a).length());
//            System.out.println(verbrauchteZiffern);
            while (verbrauchteZiffern <= ("" + a).length()) {
                if (showCalculation) {
                    if (counter == 0) {
                        System.out.println("Aufgabe: " + a + divisionszeichen + b
                                + " = Ganz-Zahl" + "+" + "Rest");
                    }
//                    System.out.println("\nSchritt " + ++counter + "(Teil-Division): "
//                            + "     " + aAnteil+ divisionszeichen + b + "=" + (aAnteil / b));
                    System.out.printf("%nSchritt " + ++counter + " (Teil-Division): %1$20d"
                            + divisionszeichen + "%2$d = %3$d%n", aAnteil, b, (aAnteil / b));
                }
                ergebnisZahl.append("" + aAnteil / b);
                if (showCalculation) {
//                            + aAnteil + "-" + (aAnteil / b) + "*" + b + "=" + (aAnteil % b));
//                    System.out.println("Schritt " + counter++ + "(Zurückrechnen):    "
                    System.out.printf("Schritt " + counter++ + " (Zurückrechnen): "
                            + "%1$18d-%2$d*%3$d = %4$d%n", aAnteil,
                            (aAnteil / b), b, (aAnteil % b));
                }
                aAnteil = aAnteil % b;
//                System.out.println(verbrauchteZiffern);
                if (verbrauchteZiffern < ("" + a).length()) {
                    aAnteil = Long.parseLong(
                            "" + aAnteil + ("" + a).substring(verbrauchteZiffern,
                                    ++verbrauchteZiffern));
                } else {
                    verbrauchteZiffern++;
                }
//                System.out.println("ergebnisZahl:" + ergebnisZahl);
                r = aAnteil;
                if (showCalculation) {
                    System.out.print("Nächste Zahl nach dem Zurückrechnen = "
                            + r);
                    if (verbrauchteZiffern <= ("" + a).length()) {
                        System.out.println(" (Ziffer " + ("" + a).substring(verbrauchteZiffern - 1,
                                verbrauchteZiffern) + " der Zahl " + a
                                + " an die zuletzte zurückgerechnete Zahl angehängt)");
                    } else {
                        System.out.println("");
                    }
                    System.out.println("Aktuelle Darstellung der Ganz-Zahl  = "
                            + ergebnisZahl);
                }
            }
            if (showCalculation) {
                System.out.println("\nEs gilt also:");
                System.out.println(a + divisionszeichen + b + " = "
                        + ergebnisZahl + " REST " + r);
            }
        }
        long[] rueckgabeQuotientRest = {Long.parseLong(ergebnisZahl.toString()), r};
        return rueckgabeQuotientRest;
    }

    private void anzeigeNaiverTeilbarkeitsTest(Object auswertung) {
        System.out.println("Teilbar? " + (boolean) ((Object[]) auswertung)[0]);
        System.out.println("Ganzzahl-Division-Ergebnis: " + (long) ((Object[]) auswertung)[1]);
        System.out.println("Rest: " + (long) ((Object[]) auswertung)[2]);

    }
}
