package de.marcelhuber.kryptographie;
// Die ineffiziente Variante bei der ersten Methode ist auskommentiert, jetzt 
// wurde eine neue implementiert
// Die Primzahlen als ArrayList zu speichern - auch generell ist das sicher nicht 
// die beste Wahl. Zudem könnte man auch die Liste sukzessive Verkleinern während 
// der Untersuchung

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.SchnelleExponentiation;
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
    private boolean showPrimesWhileCalculation = true;
    private long lastPrimeNumber;
//    private long counter;

    public static void main(String[] args) {
        KnackeRSAKodierung dummy = new KnackeRSAKodierung();
        dummy.goKnackeDieBotschaftMitPublicKeys();
        System.out.println("\n");
        System.out.println("Jetzt die Methode ohne Kenntnisse der "
                + "public keys...");
        dummy.goKnackeDieBotschaftOhnePublicKeys();
    }

    private void goKnackeDieBotschaftMitPublicKeys() {
        checkString = "wollen";
        geheimeBotschaft = "Diese " + "ganz geheime Botschaft ".toUpperCase()
                + "wollen wir testweise entschlüsseln!!";
        p1 = 43;
        p2 = 619;
        n = p1 * p2;
        System.out.println("(public key) n: " + n);
        phi_n = (p1 - 1) * (p2 - 2);
        d = 13199;
        e = 1703;
        System.out.println("(public key) e: " + e);
        geheimeBotschaftAlsLongArray = kodiere(geheimeBotschaft, e, n);
//        // alte Variante
//        fillTheFirstPrimeNumbersInList();
//        // Wir gehen davon aus, dass n bekannt ist... 
//        long primTeiler = -1;
//        for (int k = 0; k < primzahlen.size(); k++) {
//            if (n % primzahlen.get(k) == 0) {
//                primTeiler = primzahlen.get(k);
//                break;
//            }
//        }
        // Start: neue Variante
        long primTeiler = -1;
        boolean lastPrimeNumberIsPositiv = false;
        lastPrimeNumber = -1;
        while (!lastPrimeNumberIsPositiv) {
            System.out.print("Geben Sie an, bis zur wievielten Primzahl sie "
                    + "testen wollen - also eine Zahl > 0 bitte: ");
            // hier ist 500 ein guter Wert für das konkrete Fallbeispiel
            lastPrimeNumber = ReadInput.readIntWithExceptionHandling();
            if (lastPrimeNumber > 0) {
                lastPrimeNumberIsPositiv = true;
            }
        }
        long counter = 0;
        long potentiellerPrimteiler = 1;
        RSA rsaDummy = new RSA();
        while (counter < lastPrimeNumber) {
            if (rsaDummy.checkPrimzahlStatus(potentiellerPrimteiler)) {
                if (n % potentiellerPrimteiler == 0) {
                    primTeiler = potentiellerPrimteiler;
                    break;
                }
                ++counter;
            }
            ++potentiellerPrimteiler;
        }
        // Ende: neue Variante
        // besser: für jede natürliche Zahl erst prüfen, ob sie prim ist, und 
        // dann falls ja: ob sie n teilt... sonst kommt man vermutlich schnell
        // in ein Speicherplatzproblem bei der ArrayList
        if (primTeiler == -1) {
            System.out.println("Kein Primteiler von " + n + " gefunden...");
            return;
        }
        System.out.println("Primteiler von " + n + " gefunden: " + primTeiler);
        p1 = primTeiler;
        p2 = n / p1;
        System.out.println("p1:    " + p1);
        System.out.println("p2:    " + p2);
        phi_n = (p1 - 1) * (p2 - 1);
        System.out.println("phi_n: " + phi_n);
        GgT ggTDummy = new GgT();
        // auch e sollte hier ja bekannt gewesen sein...
        ggTDummy.ggTEuclidExtended(e, phi_n);
//        // Test, ob ggT auch 1 ist
//        System.out.println("GgT: " + ggTDummy.getGgT());
        d = ggTDummy.getX();
        d = (d % phi_n < 0) ? (d % phi_n) + phi_n : d % phi_n;
        System.out.println("d:     " + d);
        System.out.println("");
        System.out.println("Die Botschaft lautete also:");
        System.out.println(dekodiere(geheimeBotschaftAlsLongArray, d, n));
    }

    private void goKnackeDieBotschaftOhnePublicKeys() {
        checkString = "wollen";
        geheimeBotschaft = "Diese " + "ganz geheime Botschaft ".toUpperCase()
                + "wollen wir testweise entschlüsseln!!";
        p1 = 43;
        p2 = 619;
        n = p1 * p2;
        phi_n = (p1 - 1) * (p2 - 2);
        d = 13199;
        e = 1703;
//        GgT ggtDummy = new GgT();
//        ggtDummy.ggTEuclidExtended(d, phi_n);
//        System.out.println("ggT:" + ggtDummy.getGgT());
        geheimeBotschaftAlsLongArray = kodiere(geheimeBotschaft, e, n);
        // Im folgenden gehen wir davon aus, dass weder e noch n bekannt ist
        // einzige Annahmen: Der RSA wurde zum Verschlüsseln eingesetzt und 
        // wir kennen ein Wort, das in der verschlüsselten Botschaft enthalten ist
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
        fillTheFirstPrimeNumbersInList();
        int counter = 1;
        time = System.currentTimeMillis();
        while (counter < lastPrimeNumber - 1) {
            for (int k = 0; k < counter; ++k) {
                p1 = primzahlen.get(k);
                p2 = primzahlen.get(counter);
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
            ++counter;
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
                        System.out.println("          p = " + p1);
                        System.out.println("          q = " + p2);
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

    private void fillTheFirstPrimeNumbersInList() {
        boolean zahlIsPositiv = false;
        lastPrimeNumber = -1;
        while (!zahlIsPositiv) {
            System.out.print("Geben Sie an, bis zur wievielten Primzahl sie "
                    + "testen wollen - also eine Zahl > 0 bitte: ");
            // hier ist 500 ein guter Wert für das konkrete Fallbeispiel
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
    }
}
