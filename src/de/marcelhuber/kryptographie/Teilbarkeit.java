package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematischeHilfsprogramme.hilfsmethoden;
import de.marcelhuber.systemtools.PressEnter;

/**
 *
 * @author Marcel Huber
 */
public class Teilbarkeit {

    boolean showCalculation;// = true; // Zwischenschritte bei Rechnungen anzeigen
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
//        new Teilbarkeit().goTestSchriftlicheDivision();
//        new Teilbarkeit().go();
        new Teilbarkeit().goTestSchriftlicheDivisionReinAlgebraisch();
    }

    private void goTestSchriftlicheDivisionReinAlgebraisch() {
        long a = (long) (Math.random() * Math.pow(10, 6));
        long b = (long) (Math.random() * Math.pow(10, 5));
        long q, q1, q2;
        long r, r1, r2;
        long time1, time2Algebraisch;
        // es ist mir bewußt, dass die Methode in unnötiger Weise je 2-Mal läuft
        time1 = System.nanoTime();
        q1 = simuliereSchriftlicheDivision(a, b)[0];
        r1 = simuliereSchriftlicheDivision(a, b)[1];
        time1 = System.nanoTime() - time1;
        time2Algebraisch = System.nanoTime();
        q2 = simuliereSchriftlicheDivisionReinAlgebraisch(a, b)[0];
        r2 = simuliereSchriftlicheDivisionReinAlgebraisch(a, b)[1];
        time2Algebraisch = System.nanoTime() - time2Algebraisch;
        System.out.printf("Zeit [s] der Berechnungen für die 1. Methode                   "
                + ": %1$5.2f%n", (time1 / Math.pow(10, 9)));
        System.out.printf("Zeit [s] der Berechnungen für die 2. Methode (rein algebraisch)"
                + ": %1$5.2f%n", (time2Algebraisch / Math.pow(10, 9)));
        System.out.println("\nDie 1. Methode sagt:");
        System.out.println(a + " = " + q1 + "*" + b + "+" + r1);
        System.out.println("Gegentest: " + q1 + "*" + b + "+" + r1 + " = " + (q1 * b + r1));
        System.out.println("\nDie 2. Methode (rein algebraisch) sagt:");
        System.out.println(a + " = " + q2 + "*" + b + "+" + r2);
        System.out.println("Gegentest: " + q2 + "*" + b + "+" + r2 + " = " + (q2 * b + r2));
        System.out.println("");
        if (q1 == q2 && r1 == r2) {
            System.out.println("ALLES GUT, GLEICHES ERGEBNIS!");
        } else {
            displayWarnung();
        }
        System.out.println("");
        System.out.println("ZEITVERGLEICHE:");
        long timeDirekt = System.nanoTime();
        a = Math.abs(a); // in den anderen Methoden bilden wir ja auch immer die Beträge
        b = Math.abs(b);
        q = a / b;
        r = a % b;
        timeDirekt = System.nanoTime() - timeDirekt;
        System.out.printf("Zeit [s] der Berechnungen hier                                 "
                + ": %1$5.2f%n", (timeDirekt / Math.pow(10, 9)));
        System.out.printf("Verhältnis 1. Methode zu hier:                    %1$10.2f%n",
                1.0 * time1 / timeDirekt);
        System.out.printf("Verhältnis 2. Methode (rein algebraisch) zu hier: %1$10.2f%n",
                1.0 * time2Algebraisch / timeDirekt);
        System.out.println("\nDiese Methode hier sagt:");
        System.out.println(a + " = " + q + "*" + b + "+" + r);
        System.out.println("");
        if (q1 == q2 && q == q1 && r == r1 && r1 == r2) {
            System.out.println("ALLES PERFEKT: ÜBERALL DAS GLEICHE ERGEBNIS!");
        } else {
            displayWarnung();
        }
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

    private long[] simuliereSchriftlicheDivisionReinAlgebraisch(long a, long b) {
        long q = 0;
        long r = 0;
        long aRechendummy = 0;
        long counter = 0;
        long verbrauchteZiffern = 0;
        long ergebnisZahl = 0;
        long[] rueckgabeQuotientRest = new long[2];
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            q = 0;
            r = a;
            rueckgabeQuotientRest[0] = q;
            rueckgabeQuotientRest[1] = r;
            if (showCalculation) {
                System.out.println("Ergebnis: " + q);
                System.out.println("Rest:     " + r);
            }
            return rueckgabeQuotientRest;
        }
        if (b == 0) {
            System.out.println("Division durch 0!");
            r = a;
        } else {
            verbrauchteZiffern = zaehleZiffern(b);
            aRechendummy = a;
            long anzahlZifferna = zaehleZiffern(a);
            while (verbrauchteZiffern <= anzahlZifferna) {
                verbrauchteZiffern++;
                aRechendummy /= Math.pow(10, anzahlZifferna - verbrauchteZiffern);
                if (aRechendummy / 10 >= b) {
                    verbrauchteZiffern--;
                    aRechendummy /= 10;
                }
                ergebnisZahl += aRechendummy / b * (long) Math.pow(10, anzahlZifferna - verbrauchteZiffern);
                if (showCalculation) {
                    System.out.println(++counter + ". Rechenschritt:");
                    System.out.println("Diese Zahl wird durch " + b + " geteilt:   " + aRechendummy);
                    System.out.println("Ergebnis (bis zur " + counter + ". Ziffer von):   " + ergebnisZahl + ";");
                    System.out.println("die letzte Ziffer (ganz rechts) wurde aktualisiert!");
                    System.out.println("");
                }
                aRechendummy = a - ergebnisZahl * b;
                verbrauchteZiffern++;
            }
            if (showCalculation) {
                System.out.println("Ergebnis: " + ergebnisZahl);
                System.out.println("Rest:     " + aRechendummy);
            }
            q = ergebnisZahl;
        }
        r = aRechendummy;
        rueckgabeQuotientRest[0] = q;
        rueckgabeQuotientRest[1] = r;
        return rueckgabeQuotientRest;
    }

    private long zaehleZiffern(long z) {
        z = Math.abs(z);
        long counter = 0;
        long dez = 1;
        while (dez <= z) {
            counter++;
            dez *= 10;
        }
        return counter;
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
        q = Long.parseLong(ergebnisZahl.toString());
        long[] rueckgabeQuotientRest = {q, r};
        return rueckgabeQuotientRest;
    }

    private void anzeigeNaiverTeilbarkeitsTest(Object auswertung) {
        System.out.println("Teilbar? " + (boolean) ((Object[]) auswertung)[0]);
        System.out.println("Ganzzahl-Division-Ergebnis: " + (long) ((Object[]) auswertung)[1]);
        System.out.println("Rest: " + (long) ((Object[]) auswertung)[2]);

    }

    private void displayWarnung() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!WARNUNG: EINE DER BEIDEN METHODEN IST WOHL DEFEKT!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
