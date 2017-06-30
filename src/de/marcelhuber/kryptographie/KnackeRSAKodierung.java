package de.marcelhuber.kryptographie;
// Der Algorithmus ist noch sehr ineffizient... auch die Primzahlen als
// ArrayList zu speichern, ist nicht die beste Wahl. Zudem könnte man auch
// die Liste sukzessive Verkleinern während der Untersuchung

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.SchnelleExponentiation;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class KnackeRSAKodierung {

    private String checkString; // wir nehmen an, dass dieser String im kodierten Wort enthalten ist
    private long time;
    private long timeCounter = 1;
    private List<Long> primzahlen = new ArrayList<>();
    private RSA rsaDummy = new RSA();
    private long d;
    private long e;
    private long n;
    private long phi_n;
    private long p1;
    private long p2;
    private String geheimeBotschaft;
    private long[] geheimeBotschaftAlsLongArray;
    private long dTest;
    private boolean showPrimesWhileCalculation;// = true;
//    private long counter;

    public static void main(String[] args) {
        new KnackeRSAKodierung().goKnackeDieBotschaft();
    }

    private void goKnackeDieBotschaft() {
        checkString = "wollen";
        geheimeBotschaft = "Diese " + "ganz geheime Botschaft ".toUpperCase()
                + "wollen wir testweise entschlüsseln!!";
        p1 = 43;
        p2 = 619;
        n = p1 * p2;
        phi_n = (p1 - 1) * (p2 - 2);
        d = 25001;
        e = 1703;
//        GgT ggtDummy = new GgT();
//        ggtDummy.ggTEuclidExtended(d, phi_n);
//        System.out.println("ggT:" + ggtDummy.getGgT());
        e = 10_000;
        geheimeBotschaftAlsLongArray = kodiere(geheimeBotschaft, e, n);
        System.out.println(Arrays.toString(geheimeBotschaftAlsLongArray));
        System.out.println("(d * e) % phi_n = (103 * 87) % 160 = " + (103 * 87) % 160);
//        Marker.marker();
//        System.out.println(dekodiere(geheimeBotschaftAlsLongArray, d, n));
//        System.out.println(dekodiere(geheimeBotschaftAlsLongArray, d, n).contains(checkString));
//        Marker.marker();
//        geheimeBotschaftAlsLongArray = new long[]{51, 96, 84, 157, 76, 96, 157,
//            74, 76, 84, 96, 66, 84, 76, 113, 86, 30, 86, 61, 121, 86, 116, 33,
//            33, 46, 76, 110, 155, 74, 157, 176, 179, 92, 119, 74, 22, 76, 144,
//            96, 84, 76, 136, 96, 126, 76, 45, 127, 131, 76, 50, 86, 8, 50, 86,
//            56, 76, 84, 66, 74, 157, 176, 179, 48, 142, 157, 157, 84, 48, 66,
//            76, 48, 92, 157, 157, 84, 66, 76, 136, 155, 48, 48, 84, 66, 33, 33, 33};
        boolean zahlIsPositiv = false;
        long lastPrimeNumber = -1;
        while (!zahlIsPositiv) {
            System.out.print("Geben Sie an, bis zur wievielten Primzahl sie "
                    + "testen wollen - also eine Zahl > 0 bitte: ");
            // hier ist 3000 ein guter Wert für das konkrete Fallbeispiel
            lastPrimeNumber = ReadInput.readIntWithExceptionHandling();
            if (lastPrimeNumber > 0) {
                zahlIsPositiv = true;
            }
        }
        primzahlen.clear();
        long counter = 0;
        long zahl = 1;
        while (counter < lastPrimeNumber) {
            if (rsaDummy.checkPrimzahlStatus(zahl)) {
                ++counter;
                primzahlen.add(zahl);
            }
            ++zahl;
        }
        System.out.println("Hier die ersten " + lastPrimeNumber + " Primzahlen:");
        System.out.println(primzahlen);
        int counter01 = 0;
        int counter02;
        time = System.currentTimeMillis();
        while (counter01 < lastPrimeNumber - 1) {
            counter02 = counter01 + 1;
            p1 = primzahlen.get(counter01);
            if (n % p1 != 0) {
                ++counter01;
                continue;
            } else {
                System.out.println("");
                System.out.println(p1 + " teilt " + n);
                System.out.println("");
            }
            for (int k = counter02; k < lastPrimeNumber; ++k) {
                p2 = primzahlen.get(k);
                n = p1 * p2;
                phi_n = (p1 - 1) * (p2 - 1);
                if (showPrimesWhileCalculation) {
                    System.out.println(p1 + " | " + p2);
                    System.out.println("n:     " + n);
                    System.out.println("phi_n: " + phi_n);
                    System.out.println("");
                }
                testAllCombinationsWithEAndD();
            }
            ++counter01;
        }
    }

    private long[] kodiere(String geheimeBotschaft, long e, long n) {
        long[] kodierungsIntArray = new long[geheimeBotschaft.length()];
        int counter = 0;
        SchnelleExponentiation schnelleExpDummy = new SchnelleExponentiation();
        for (char c : geheimeBotschaft.toCharArray()) {
            kodierungsIntArray[counter]
                    = schnelleExpDummy.calcSchnelleExponentiationNachPseudocode(c, e, n);
            ++counter;
        }
        return kodierungsIntArray;
    }

    private String dekodiere(long[] geheimeBotschaftAlsLongArray, long d, long n) {
//        System.out.println("Dekodierung läuft...");
        StringBuffer botschaftDekodiert = new StringBuffer("");
        for (long k : geheimeBotschaftAlsLongArray) {
            botschaftDekodiert.append((char) (potenzModulo(k, d, n)));
        }
        return botschaftDekodiert.toString();
    }

    private long potenzModulo(long basis, long exponent, long modul) {
        SchnelleExponentiation schnelleExpDummy = new SchnelleExponentiation();
        long returnLong = schnelleExpDummy.calcSchnelleExponentiationNachPseudocode(basis, exponent, modul);
        return returnLong;
    }

    private void testAllCombinationsWithEAndD() {
//        System.out.println("counter: "+ ++counter);
        GgT ggTDummy = new GgT();
        String dekodierTestString;
        for (int k = 2; k < phi_n; k++) {
            if (System.currentTimeMillis() > (time + (timeCounter * 10_000))) {
                System.err.print("Still at work (since "
                        + (System.currentTimeMillis() - time) / 1_000.0 + "s) ...");
                System.err.println("... last check: k = " + k + "; d = " + dTest);
                ++timeCounter;
            }
            ggTDummy.ggTEuclidExtended(k, phi_n);
            if (Math.abs(ggTDummy.getGgT()) == 1) {
                if (produktModulo(k, e, phi_n) == 1) {
                    dTest = k;
                    System.out.println("Könnte das die Botschaft sein?");
                    dekodierTestString = dekodiere(geheimeBotschaftAlsLongArray, dTest, n);
                    System.out.println(dekodierTestString);
//                    System.out.println("Dann wäre d = " + dTest);
//                    System.out.println("          n = " + n);
//                    System.out.println("      phi_n = " + phi_n);
                    if (dekodierTestString.toLowerCase().contains(checkString)) {
                        System.out.println("Dann wäre d = " + dTest);
                        System.out.println("          n = " + n);
                        System.out.println("      phi_n = " + phi_n);
                        PressEnter.toContinue();
                    }
                }
            }
        }
    }

    private long produktModulo(long a, long b, long modul) {
        long produkt = 0;
        String aAsString = "" + a;
        String bAsString = "" + b;
        if (aAsString.length() >= bAsString.length()) {
            for (int k = 0; k < aAsString.length(); k++) {
                produkt += ((Long.parseLong("" + aAsString.toCharArray()[k])
                        * (Math.pow(10, aAsString.length() - k - 1)
                        % modul)
                        % modul) * b)
                        % modul;
                produkt %= modul;
            }
        } else {
            produkt = produktModulo(b, a, modul);
        }
        return produkt;
    }

    public long getE() {
        return e;
    }

    public long getN() {
        return n;
    }
}
