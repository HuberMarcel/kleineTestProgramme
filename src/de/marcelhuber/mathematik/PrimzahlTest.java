package de.marcelhuber.mathematik;

import de.marcelhuber.mathematischeHilfsprogramme.*;
import de.marcelhuber.systemtools.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class PrimzahlTest {

    static private boolean hilfsAnzeige = false;// = true;
// einschalten (auf true setzen), um 
// Zwischenergebnisse anzuzeigen
    private long pruefZahl;
    private boolean isPossiblePrim;
    private boolean isPrim;
    private List<Long> primzahlListe = new ArrayList<>();
    private long teiler = 0; // potentieller Teiler

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        PrimzahlTest dummyObjekt = new PrimzahlTest();
//        dummyObjekt.goTestePrimAusscheidungsverfahren();
//        PressEnter.toContinue();
        dummyObjekt.goPrimzahlTestMitSiebErastothenes();
        dummyObjekt.go();
    }

    private void go() {
        System.out.print("Geben Sie die Zahl ein, von der Sie wissen wollen, "
                + "ob es eine Primzahl ist: ");
        pruefZahl = ReadInput.readLong();
//        hilfsAnzeige=true;
//        primAusscheidungsverfahren(pruefZahl);
        String ausgabeDesErgebnisses;
        ausgabeDesErgebnisses = naiverPrimzahlTest(pruefZahl);
        System.out.println(ausgabeDesErgebnisses);
        long endZahl;
//        System.out.println("Bis zu welcher Zahl wollen Sie Primzahlen sehen? "
//                + "Ihre Eingabe: " + (endZahl = ReadInput.readLong()));
        System.out.print("Bis zu welcher Zahl wollen Sie Primzahlen sehen? "
                + "Ihre Eingabe: ");
        endZahl = ReadInput.readLong();
        boolean ergebnisPrimAusscheidung;
        long timeHier = System.currentTimeMillis();
        for (long k = 0 * (-endZahl); k < endZahl + 1; k++) {
            ergebnisPrimAusscheidung = primAusscheidungsverfahren(k);
            if (!ergebnisPrimAusscheidung) {
                isPrim = ergebnisPrimAusscheidung;
            } else {
                if (hilfsAnzeige) {
                    System.out.println(naiverPrimzahlTest(k));
                } else {
                    naiverPrimzahlTest(k);
                }
            }
            if (isPrim) {
                primzahlListe.add(k);
            }
//            if (k % 25 == 0) {
//                PressEnter.toContinue();
//            }
        }
        timeHier = System.currentTimeMillis() - timeHier;
        System.out.println("Rechendauer [s]: " + timeHier / 1000.0);
        System.out.println("Hier - wie gewünscht - die Primzahlen bis "
                + "ggf. einschließlich " + endZahl + ":");
        Long[] primzahlArray = new Long[primzahlListe.size()];
        primzahlListe.toArray(primzahlArray);
        System.out.println(Arrays.toString(primzahlArray));
        System.out.printf("%nVergleich mit der Methode des Sieb des Eratosthenes:%n");
        SiebDesEratosthenes siebEratosthenesDummy = new SiebDesEratosthenes();
        siebEratosthenesDummy.go();
        System.out.println("Beide Rechenzeiten im Vergleich:");
        System.out.println("Rechendauer [s]: " + timeHier / 1000.0);
        System.out.println("Rechenzeit [s] Sieb des Eratosthenes: "
                + siebEratosthenesDummy.getTimeSieb() / 1000.0);
        if (siebEratosthenesDummy.getTimeSieb() != 0) {
            System.out.printf("Die Methode hier hat also bzgl. der Sieb-Methode"
                    + "den Geschwindigkeitsfaktor: %.2f%n",
                    1.0 * timeHier / siebEratosthenesDummy.getTimeSieb());
        }
    }

    private void goPrimzahlTestMitSiebErastothenes() {
        System.out.print("Geben Sie die Zahl ein, von der Sie wissen wollen, "
                + "ob Sie prim ist: ");
        long readLong = -99;
        readLong = ReadInput.readLong();
//        do {
            primzahlTestMitSiebErastothenes(readLong);
            System.out.print("Die Zahl " + readLong + " ist ");
            if (getIsPrim()) {
                System.out.print("prim!");
//                if (Math.abs(readLong) > 2) {
//                    System.out.println("    Teiler-Status: " + getTeiler());
//                } else {
//                    System.out.println("");
//                }
                System.out.println("");
            } else {
                System.out.print("nicht prim");
                if (Math.abs(readLong) == 1) {
                    System.out.println("!");
                } else {
                    System.out.println(", sie hat den Teiler "
                            + getTeiler() + "!");
                }
            }
//        } while (readLong++ < 120);
    }

    private void goTestePrimAusscheidungsverfahren() {
        boolean primPossible;
        for (long j = 1; j < 1000_001; j += 2) {
            System.out.println("\nZahl " + j + ":");
            primPossible = primAusscheidungsverfahren(j);
            System.out.println("Status als mögliche Primzahl: " + primPossible
                    + " für " + getPruefZahl() + "!");
            if (!primPossible) {
                PressEnter.toContinue();
            }
        }
        System.out.println("");
    }

    public boolean primAusscheidungsverfahren(long checkNumber) {
        pruefZahl = checkNumber;
        isPossiblePrim = true;
        if (checkNumber < 3) {
            switch ((int) checkNumber) {
                case 0:
                case 1:
                    isPossiblePrim = false;
                case 2:
                default:
                    if (hilfsAnzeige) {
                        System.out.println("Wir untersuchen hier nur "
                                + "positive Zahlen > 2, Sie haben " + checkNumber + " "
                                + "eingegeben!");
                    }
                    return isPossiblePrim;
            }
        }
        long gegenKontrolle = checkNumber - 1;
        long z = gegenKontrolle;
        double bHalbe;
        long m = 0;
        long p, q;
        isPossiblePrim = true;
        if (checkNumber % 2 == 0) {
            if (hilfsAnzeige) {
                System.out.println("Die Zahl " + checkNumber + " ist als "
                        + "gerade Zahl > 2 sicher nicht prim!");
            }
            teiler = 2;
            isPossiblePrim = false;
        } else {
            while (z % 2 == 0) {
                m++;
                z /= 2;
            }
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + "m: " + m);
            // Nun Test, ob pruefzahl-1 die Form b^m hatte
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + "Prüfzahl: " + pruefzahl);
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + m + "-e Wurzel aus z=" + z);
            bHalbe = Math.pow(z, (double) 1 / m);
//            System.out.println("bHalbe=" + bHalbe);
//            System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
//                    + Math.abs(Math.pow((long) bHalbe, m) - gegenKontrolle / Math.pow(2, m)));
            if (Math.abs(Math.pow((long) bHalbe, m) - gegenKontrolle / Math.pow(2, m)) > 0.1) {
                if (hilfsAnzeige) {
                    System.out.println("(PrimzahlTest|primAusscheidungsverfahren): Die "
                            + m + "-e Wurzel aus " + z + " ist " + bHalbe + " und damit "
                            + "sicher keine positive ganze Zahl\n(PrimzahlTest|primAusscheidungsverfahren): "
                            + "Voraussetzungen zur Verneinung des Primzahlstatus sind nicht erfüllt!");
                }
                isPossiblePrim = true;
            } else {
                if (hilfsAnzeige) {
                    System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                            + "Gewünschte Form ist vorhanden:");
                    System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                            + gegenKontrolle + "=(2*" + (long) bHalbe + ")^{" + m + "}");
                }
                if (!hilfsmethoden.getResultCheckIs2erPotenz(m)) {
                    if (hilfsAnzeige) {
                        System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                                + "Das kann keine Primzahl sein, da die Frage, ob "
                                + "\n(PrimzahlTest|primAusscheidungsverfahren): "
                                + m + " eine 2er-Potenz ist, beantwortet werden muss "
                                + "mit " + hilfsmethoden.getResultCheckIs2erPotenz(m));
                    }
                    p = m;
                    q = 1;
                    while (p % 2 == 0) {
                        p /= 2;
                        q *= 2;
                    }
                    if (hilfsAnzeige) {
                        System.out.println("(PrimzahlTest|primAusscheidungsverfahren): "
                                + m + "=(p*q) mit p=" + p + ", q=" + q + " liefert, dass "
                                + (long) (1 + Math.pow(2 * bHalbe, q)) + "=(" + (long) (2 * bHalbe)
                                + "^{" + q + "}+1) ein Teiler von " + checkNumber + " ist!");
                        System.out.println("(PrimzahlTest|primAusscheidungsverfahren): Kontrolle: "
                                + checkNumber + "/" + (long) (1 + Math.pow(2 * bHalbe, q)) + "="
                                + (double) checkNumber / (long) (1 + Math.pow(2 * bHalbe, q)));
                    }
                    teiler = (long) (1 + Math.pow(2 * bHalbe, q));
                    isPossiblePrim = false;
                }
            }
        }
        return isPossiblePrim;
    }

    public long naivElementareWurzel(long z) {
        // berechnet die größte ganze Zahl x mit x <= |z| und x^2 < |z|
        int x;
        for (x = 1; x * x <= Math.abs(z); x++) {
        }
        return x - 1;
    }

    public boolean primzahlTestMitSiebErastothenes(long zahl) {
        teiler = 0; // potentieller Teiler
        if (Math.abs(zahl) == 1) {
            isPrim = false;
            return isPrim;
        } else if (Math.abs(zahl) == 2) {
            isPrim = true;
            return isPrim;
        }
        if (!primAusscheidungsverfahren(zahl)) {
            isPrim = false;
        } else {
            long wurzel = naivElementareWurzel(zahl);
            Long[] primzahlenBisWurzel
                    = new SiebDesEratosthenes().
                            calculateSiebDesEratosthenes(wurzel);
            isPrim = true;
//            System.out.println(Arrays.toString(primzahlenBisWurzel));
            for (Long primzahl : primzahlenBisWurzel) {
//                System.out.println(zahl+"%"+primzahl+"="+(zahl%primzahl));
                if (zahl % primzahl == 0) {
                    isPrim = false;
                    teiler = primzahl;
                    break;
                }
            }
        }
        return isPrim;
    }

    public String naiverPrimzahlTest(long z) {
        pruefZahl = z;
        long letzteTestzahl = naivElementareWurzel(z);
//        System.out.println("Letzte Testzahl " + letzteTestzahl + " für " + z);
        isPrim = true;
        long t = 0;
        for (t = 2; t <= letzteTestzahl; t++) {
            if (z % t == 0) {
                isPrim = false;
                break;
            }
        }
        if (z == 0) {
            isPrim = false;
            t = 2;
        }
        if (z != 0) {
            assert (t <= letzteTestzahl + 1) : "\nSchleifendurchlauf funktioniert nicht "
                    + "korrekt oder t wurde manipuliert: t = " + t;
        }
        String ergebnis = "Die Zahl " + z + " ist ";
        ergebnis += (isPrim) ? "prim!" : "nicht prim, sie hat den Teiler " + t + "!";
        if (Math.abs(z) == 1) {
            isPrim = false;
            t = 1;
            ergebnis = ergebnis.substring(0, ergebnis.length() - 5) + "nicht prim!";
        }
        return ergebnis;
    }

    public long getPruefZahl() {
        return pruefZahl;
    }

    public boolean getIsPossiblePrim() {
        return isPossiblePrim;
    }

    public boolean getIsPrim() {
        return isPrim;
    }

    public long getTeiler() {
        return teiler;
    }

    public boolean isHilfsAnzeige() {
        return hilfsAnzeige;
    }

    public void setHilfsAnzeige(boolean bool) {
        hilfsAnzeige = bool;
    }
}
