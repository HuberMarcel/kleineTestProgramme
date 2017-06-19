package de.marcelhuber.kryptographiedemo;
// Beispiel: x = 4 mod 32;
//           x = 3 mod 7;
//           x = 79 mod 423
//           liefert: x mod 55492 mod 94752

import de.marcelhuber.kryptographie.ChinesischerRestsatzBuchmann5eAuflageSeite43;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.ReadInput;

/**
 *
 * @author Marcel Huber
 */
public class ChinesischerRestsatzBuchmann5eAuflageSeite43Demo {

    private int n;
    private boolean erneuterDurchlauf;
    private int eingabeErneuterDurchlauf;
    private Long[] aArray;
    private Long[] module;
    private long x;
    private long newModul;

    public static void main(String[] args) {
        new ChinesischerRestsatzBuchmann5eAuflageSeite43Demo().goInputsAndCalculation();
    }

    private void goInputsAndCalculation() {
        int intForForward;
        do {
            do {
                System.out.print("Wieviele simultane Kongruenzen mit paarweise "
                        + "teilerfremden Modulen möchten Sie lösen?\nIhre Eingabe: ");
                n = ReadInput.readInt();
                System.out.print("Sie wollen also " + n + " Kongruenzen lösen? Geben Sie "
                        + "bitte 1 ein, falls das korrekt ist oder Sonstiges,"
                        + "\num die Eingabe zu korrigieren: ");
                intForForward = ReadInput.readInt();
                if (intForForward != 1) {
                    System.out.println("");
                    Marker.marker();
                    Marker.marker();
                    System.out.println("Sie wollen die Anzahl also korrigieren... Neue Eingabe!");
                    Marker.marker();
                    System.out.println("");
                }
            } while (intForForward != 1);
            System.out.println("");
            if (n > 0) {
                aArray = new Long[n];
                module = new Long[n];
                System.out.println("Wir wollen also das System der " + n + " simultanen Kongruenzen");
                System.out.print("     x kongruent a[i] (mod m[i])     "
                        + "für i = 0");
                if (n >= 2) {
                    System.out.print(", ");
                }
                if (n > 2) {
                    System.out.print("..., ");
                }
                if (n >= 2) {
                    System.out.print(n - 1);
                }
                System.out.println("\n\nfür paarweise teilferfremde Module (die "
                        + "m[i]) lösen.\n");
                System.out.println("");
                for (int k = 0; k < n; k++) {
                    System.out.println("");
                    System.out.print("Geben Sie a[" + k + "] ein:     ");
                    aArray[k] = ReadInput.readLong();
                    do {
                        System.out.print("Geben Sie m[" + k + "] > 0 ein: ");
                        module[k] = ReadInput.readLong();
                        if (!(module[k] > 0)) {
                            System.err.println("m[" + k + "] muss > 0 sein!");
                        }
                    } while (!(module[k] > 0));
                    if (Math.abs(aArray[k]) > module[k] || aArray[k] < 0) {
                        aArray[k] = (aArray[k] % module[k] >= 0)
                                ? aArray[k] % module[k]
                                : ((aArray[k] % module[k]) + module[k]);
                        System.err.println("(Bemerkung: a[" + k + "] wurde "
                                + "in \"sinnvoller Weise \" in den "
                                + "Wert " + aArray[k] + " geändert - die\n"
                                + "neue Kongruenz ist äquivalent zur alten!!)");
                    }
                }
                System.out.println("");
                System.out.println("Zur Übersicht nochmal das vollständige "
                        + "System der Kongruenzen:");
                for (int k = 0; k < n; k++) {
                    System.out.println("     "
                            + (k + 1) + ". Kongruenz:"
                            + "     x kongruent " + aArray[k]
                            + " (mod " + module[k] + ");");
                }
                System.out.println("");
                goCalculate(aArray, module);
                System.out.println("");
                Marker.marker();
                System.out.println("Ende der Berechnung !!".toUpperCase());
                Marker.marker();
                Marker.marker();
                System.out.println("\n");
            }
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

    public void goCalculate(Long[] a, Long[] m) {  // die Methode soll auch für andere Klassen
        // verfügbar sein
        aArray = a;
        module = m;
        ChinesischerRestsatzBuchmann5eAuflageSeite43 dummy
                = new ChinesischerRestsatzBuchmann5eAuflageSeite43();
        dummy.loeseDasKongruenzSystem(aArray, module);
        if (dummy.isCheckIfOurModulsArePairwiseRelativelyPrime()) {
            x = dummy.getX();
            newModul = dummy.getNewModul();
            System.out.println("Lösung:\n");
            System.out.println("    "
                    + "x kongruent " + x + " (mod " + newModul + ").");
            System.out.println("(Mit dem kleinsten ganzzahligen positiven Repräsentanten "
                    + "lautet diese:"
                    + "\n    x kongruent "
                    + ((x % newModul >= 0) ? (x % newModul)
                            : ((x % newModul) + newModul)) + " (mod " + newModul + ").)");
        } else {
            System.out.println("");
            if (dummy.getHinweis() != null) {
                System.out.println("[Hinweis:\n".toUpperCase()
                        + dummy.getHinweis() + "]");
                System.err.println("");
                System.err.println("[Hinweis:\n".toUpperCase()
                        + dummy.getHinweis() + "]");
            }
        }
    }

    public long getX() {
        return x;
    }

    public long getNewModul() {
        return newModul;
    }
}
