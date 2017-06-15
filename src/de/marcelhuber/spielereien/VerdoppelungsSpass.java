package de.marcelhuber.spielereien;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.ReadInput;

/**
 *
 * @author Marcel Huber
 */
public class VerdoppelungsSpass {

    static private long ergebnisGoMitVerschiebungsOperator;
    static private long ergebnisGoMultipliziereMitZwei;
    static private long timeGoMitVerschiebungsOperator;
    static private long timeGoMultipliziereMitZwei;
    static private int testPositiv = Integer.MAX_VALUE;
    static private int testNegativ = Integer.MIN_VALUE;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        Marker.marker();
        System.out.println("Vorweg: Spaß mit Binary Strings!".toUpperCase());
        Marker.marker();
        System.out.println("testNegativ:                               " 
                + testNegativ);
        System.out.println("0 als Binary String:                       "
                + Integer.toBinaryString(0));
        System.out.println("test als Binary String:                    "
                + Integer.toBinaryString(testNegativ));
        System.out.println("testNegativ + 1 als Binary String:         "
                + Integer.toBinaryString(testNegativ + 1));
        System.out.println("testNegativ << 1:                          " 
                + (testNegativ << 1));
        System.out.println("testNegativ << 1 als Binary String:        "
                + Integer.toBinaryString(testNegativ << 1));
        System.out.println("testNegativ >> 1:                          " 
                + (testNegativ >> 1));
        System.out.println("testNegativ >> 1 als Binary String:        "
                + Integer.toBinaryString(testNegativ >> 1));
        Marker.marker();
        System.out.println("(testNegativ + 1) >>> 1:                   "
                + ((testNegativ + 1) >>> 1));
        System.out.println("(testNegativ + 1) >>> 1 als Binary String: "
                + Integer.toBinaryString(testNegativ >>> 1));
        Marker.marker();
        System.out.println("\n");
        Marker.marker();
        System.out.println("testPositiv:                               " 
                + testPositiv);
        System.out.println("0 als Binary String:                       "
                + Integer.toBinaryString(0));
        System.out.println("testPositiv als Binary String:             "
                + Integer.toBinaryString(testPositiv));
        System.out.println("testPositiv + 1 als Binary String:         "
                + Integer.toBinaryString(testPositiv + 1));
        System.out.println("testPositiv << 1:                          " 
                + (testPositiv << 1));
        System.out.println("testPositiv << 1 als Binary String:        "
                + Integer.toBinaryString(testPositiv << 1));
        System.out.println("testPositiv >> 1:                          " 
                + (testPositiv >> 1));
        System.out.println("testPositiv >> 1 als Binary String:        "
                + Integer.toBinaryString(testPositiv >> 1));
        Marker.marker();
        System.out.println("(testPositiv + 1) >>> 1:                   "
                + ((testPositiv + 1) >>> 1));
        System.out.println("(testPositiv + 1) >>> 1 als Binary String: "
                + Integer.toBinaryString(testPositiv >>> 1));
        System.out.println("");
        System.out.println("\n\n");
        System.out.print("Geben Sie die Zahl ein:                               "
                + "        ");
        long startzahl = ReadInput.readLong();
        System.out.print("Geben Sie ein, wie oft diese Zahl verdoppelt werden "
                + "soll:     ");
        long verdoppelungsanzahl = ReadInput.readLong();
        //
        timeGoMitVerschiebungsOperator = System.nanoTime();
        ergebnisGoMitVerschiebungsOperator
                = new VerdoppelungsSpass().goMitVerschiebungsOperator(startzahl, verdoppelungsanzahl);
        timeGoMitVerschiebungsOperator = System.nanoTime() - timeGoMitVerschiebungsOperator;
        //
        System.out.println("\n\n");
        //
        timeGoMultipliziereMitZwei = System.nanoTime();
        ergebnisGoMultipliziereMitZwei
                = new VerdoppelungsSpass().goMultipliziereMitZwei(startzahl, verdoppelungsanzahl);
        timeGoMultipliziereMitZwei = System.nanoTime() - timeGoMultipliziereMitZwei;
        //
        if (ergebnisGoMitVerschiebungsOperator != ergebnisGoMultipliziereMitZwei) {
            System.err.println("Warnung!".toUpperCase());
            System.err.println("Verschiedene Ergebnisse... da ist was schiefgelaufen!");
        } else {
            System.out.println("\nWunderbar: Zweimal das gleiche Ergebnis!\n".toUpperCase());
            System.out.println("Zeitvergleiche [s]: \ngoMitVerschiebungsOperator(): "
                    + "             "
                    + timeGoMitVerschiebungsOperator / Math.pow(10, 9));
            System.out.println("goMultipliziereMitZwei:                    "
                    + timeGoMultipliziereMitZwei / Math.pow(10, 9));
            System.out.println("Verhältnis der oberen zur unteren Methode: "
                    + ((double) timeGoMitVerschiebungsOperator / timeGoMultipliziereMitZwei));
        }
    }

    private long goMitVerschiebungsOperator(long startzahl, long verdoppelungsanzahl) {
        long ergebnis;
        ergebnis = startzahl << verdoppelungsanzahl;
        Marker.marker();
        System.out.println("Das Ergebnis der goMitVerschiebungsOperator()-Methode "
                + "lautet: " + ergebnis);
        Marker.marker();
        return ergebnis;
    }

    private long goMultipliziereMitZwei(long startzahl, long verdoppelungsanzahl) {
        long ergebnis = verdoppelungsanzahl;
        for (long k = 0; k < verdoppelungsanzahl; k++) {
            ergebnis *= 2;
        }
        ergebnis = startzahl << verdoppelungsanzahl;
        Marker.marker();
        System.out.println("Das Ergebnis der goMultipliziereMitZwei()-Methode "
                + "lautet: " + ergebnis);
        Marker.marker();
        return ergebnis;
    }
}
