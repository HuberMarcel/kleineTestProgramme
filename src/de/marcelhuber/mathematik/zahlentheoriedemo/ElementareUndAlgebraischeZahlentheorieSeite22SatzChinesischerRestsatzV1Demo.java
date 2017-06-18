package de.marcelhuber.mathematik.zahlentheoriedemo;

import de.marcelhuber.mathematik.zahlentheorie.ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.ReadInput;

/**
 *
 * @author Marcel Huber
 */
public class ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1Demo {

    private long a;
    private long n;
    private long b;
    private long m;
    private long x;
    private boolean loesbar;
    private long newModul;
    private String hinweis;

    public static void main(String[] args) {
        new ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1Demo().go();
    }

    private void go() {
//        a = 2;
//        n = 7;
//        b = 12;
//        m = 29;
        boolean erneuterDurchlauf = false;
        int eingabeErneuterDurchlauf;
        do {
            System.out.println("Aufgabe: Gesucht ist im Falle der Lösbarkeit "
                    + "die Lösung der simultanen Kongruenzen\n");
            System.out.println("\n    x kongruent a (mod n)     und     "
                    + "x kongruent b (mod m).");
            System.out.println("");
            System.out.print("Geben Sie a ein:     ");
            a = ReadInput.readLong();
            do {
                System.out.print("Geben Sie n > 0 ein: ");
                n = ReadInput.readLong();
                if (!(n > 0)) {
                    System.out.println("n muss > 0 sein!");
                }
            } while (!(n > 0));
            System.out.print("Geben Sie b ein:     ");
            b = ReadInput.readLong();
            do {
                System.out.print("Geben Sie m > 0 ein: ");
                m = ReadInput.readLong();
                if (!(m > 0)) {
                    System.out.println("m muss > 0 sein!");
                }
            } while (!(m > 0));
            goCalculate(a, n, b, m);
            System.out.println("Ende der Berechnung !!".toUpperCase());
            System.out.println("");
            System.out.println("");
            Marker.marker();
            System.out.println("");
            System.out.print("Wollen Sie eine weitere Rechnung durchführen "
                    + "(geben Sie die Zahl 1 für JA\nein oder eine andere für Abbruch!)?: ");
            eingabeErneuterDurchlauf = ReadInput.readIntWithExceptionHandling();
            if (eingabeErneuterDurchlauf == 1) {
                erneuterDurchlauf = true;
                System.out.println("");
                Marker.marker();
                System.out.println("");
                System.out.println("");
            } else {
                erneuterDurchlauf = false;
            }
        } while (erneuterDurchlauf);
    }

    private void goCalculate(long a, long n, long b, long m) {
        this.a = a;
        this.n = n;
        this.b = b;
        this.m = m;
        System.out.println("Wir wollen das System der folgenden beiden "
                + "simultanen Kongruenzen lösen:\n");
        System.out.println("    x kongruent " + a + " (mod " + n + ")     und     "
                + "x kongruent " + b + " (mod " + m + ").\n\n");
        ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1 dummy
                = new ElementareUndAlgebraischeZahlentheorieSeite22SatzChinesischerRestsatzV1();
//        dummy.loeseKongruenzsystemChinesischerRestzsatzV1(a, n, b, m);
        if (!dummy.loeseKongruenzsystemChinesischerRestzsatzV1(a, n, b, m)) {
            loesbar = dummy.isLoesbar();
//        if (!dummy.isLoesbar()) {
            System.out.println("Das System der Kongruenzen ist nicht lösbar. Grund:");
            System.out.println(dummy.getGrundFuerNichtloesbar());
        } else {
            loesbar = dummy.isLoesbar();
            x = dummy.getX();
            newModul = dummy.getNewModul();
            System.out.println("Die Lösung lautet:\n\n"
                    + "    x kongruent " + x + " (mod "
                    + newModul + ").");
            if (x != dummy.findPositiveXMinimal(x, newModul)) {
                System.out.println("(Formuliert mit der kleinsten positive Lösung bedeutet das "
                        + "x kongruent "
                        + dummy.findPositiveXMinimal(x, newModul)
                        + " (mod " + newModul + ").)\n\n");
            } else {
                System.out.println("\n");
            }
        }
        hinweis = dummy.getHinweis();
        if ((hinweis != null) && hinweis.length() > 0) {
            System.out.println("[Hinweis:".toUpperCase() + hinweis + "]");
        }
    }
}
