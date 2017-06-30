package de.marcelhuber.kryptographie;
// Hinweis: In goRSA() kann man die letzte Zeile einkommentieren, und sich damit
//          alle für die Rechnung relevanten Informationen anzeigen lassen

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.SchnelleExponentiation;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Marcel Huber
 */
public class RSA {

    private long[] primzahlen = new long[2];
    private long n;                               // public key
    private long phi_n;
    private long[] eUndD = new long[2];
    private long e;                               // public key
    private long d;
    private boolean zweiUngleichePrimzahlen;
    private boolean primzahlStatus;
    // Als Beispiel kann man p1 = 37, p2 = 137, e = 1049 und d = 2441 nehmen

    public static void main(String[] args) {
        RSA dummy = new RSA();
//        long x = 313;
//        long y = 7999;
//        long m = 11;
//        System.out.println(dummy.produktModulo(x, y, m));
//        System.out.println((x * y) % m);
        dummy.goRSAWithPrimzahlChoices();
        System.out.println("");
        System.out.println("");
        Marker.marker();
        dummy.goRSAWithPrimzahlInputs();
    }

    private void goRSAWithPrimzahlInputs() {
        getZahlen();
        if (!zweiUngleichePrimzahlen) {
            System.err.println("Problem: Sie haben keine zwei verschiedene "
                    + "Primzahlen eingegeben!");
            System.err.println("Abbruch...");
            return;
        }
        goRSA();
    }

    private void goRSAWithPrimzahlChoices() {
//        SiebDesEratosthenes siebErasDummy = new SiebDesEratosthenes();
//        siebErasDummy.goShowPrimes();
        int index01 = -1;
        int index02 = -1;
        while (index01 <= 0) {
            System.out.print("Die wievielte Primzahl soll Ihre erste sein? "
                    + "Eingabe einer Zahl > 0 bitte:  ");
            index01 = ReadInput.readIntWithExceptionHandling();
        }
        while (index02 <= 0) {
            do {
                System.out.print("Die wievielte Primzahl soll Ihre zweite sein? "
                        + "Eingabe einer Zahl > 0 bitte: ");
                index02 = ReadInput.readIntWithExceptionHandling();
                if (index01 == index02) {
                    System.err.println("Sie müssen ungleiche "
                            + "Primzahlen wählen!! Neue Eingabe...");
                }
            } while (index01 == index02);
        }
        if (index01 > index02) {
            System.out.println("Ich sortiere Ihre Eingaben der Größe nach...");
            int helper = index02;
            index02 = index01;
            index01 = helper;
        }
        long zahl = 1;
        for (int k = 0; k < index01;) {
            ++zahl;
            if (checkPrimzahlStatus(zahl)) {
                ++k;
            }
        }
        primzahlen[0] = zahl;

        for (int k = index01; k < index02;) {
            ++zahl;
            if (checkPrimzahlStatus(zahl)) {
                ++k;
            }
        }
        primzahlen[1] = zahl;
        System.out.println(Arrays.toString(primzahlen));
        goRSA();
    }

    public void generatePublicKeys() {
        System.out.println("Erstmal ein Testlauf:".toUpperCase());
        Marker.marker();
        Marker.marker();
        goRSAWithPrimzahlChoices();
        Marker.marker();
        Marker.marker();
        System.out.println("Ende des Testlaufs...".toUpperCase());
        showPublicKeys(e, n);
    }

    private void goRSA() {
        n = primzahlen[0] * primzahlen[1];
        phi_n = (primzahlen[0] - 1) * (primzahlen[1] - 1);
        // wähle nun e mit 1 < e < phi_n und ggT(e,phi_n) = 1
        eUndD = calculateEUndDRandomized(phi_n);
        System.out.println("eUndD == null? " + (eUndD == null));
        if (eUndD == null) {
            goRSAWithPrimzahlChoices();
        } else {
            e = eUndD[0];
            d = eUndD[1];
            System.out.println("");
            showPublicKeys(e, n);
            String geheimeBotschaft = "Dies ist eine " + "geheime(!!) ".toUpperCase()
                    + "Botschaft, die wir zum " + "Testen ".toUpperCase()
                    + "entschlüsseln lassen wollen!!!";
            long[] geheimeBotschaftKodiertArray = kodiere(geheimeBotschaft, e, n);
            System.out.println("Die zu entschlüsselnde Botschaft lautet:");
            for (long k : geheimeBotschaftKodiertArray) {
                System.out.print((char) k);
            }
            System.out.println("");
            System.out.println("");
            Marker.marker();
            System.out.println("Im Klartext sollte das gewesen sein:");
            System.out.println(dekodiere(geheimeBotschaftKodiertArray, d, n));
            PressEnter.toContinue();
//            showAllInformationsInclSecrets(d, e, n, phi_n);
        }
    }

    private boolean getZahlen() {
        boolean primzahlenZuGross = true;
        while (primzahlenZuGross) {
            zweiUngleichePrimzahlen = false;
            for (int k = 0; k < primzahlen.length; k++) {
                primzahlStatus = false;
                while (!primzahlStatus) {
                    System.out.print("Geben Sie die " + (k + 1) + ". Primzahl ein: ");
                    primzahlen[k] = ReadInput.readLongWithExceptionHandling();
                    primzahlStatus = checkPrimzahlStatus(primzahlen[k], true);
//                System.out.println("primzahlStatus: "+primzahlStatus);
                }
            }
            if (primzahlen[0] != primzahlen[1]) {
                zweiUngleichePrimzahlen = true;
            }
            if ((primzahlen[0] * primzahlen[1]) != (int) (primzahlen[0] * primzahlen[1])) {
                primzahlenZuGross = true;
            } else {
                primzahlenZuGross = false;
            }
            if (primzahlenZuGross) {
                System.err.println("Geben Sie bitte erneut zwei ungleiche "
                        + "Primzahlen ein - Ihre waren vermutlich zu groß...");
            }
        }
        return zweiUngleichePrimzahlen;
    }

    public boolean checkPrimzahlStatus(long z) {
        return checkPrimzahlStatus(z, false);
    }

    private boolean checkPrimzahlStatus(long z, boolean showErrMessages) {
        boolean isPrim = false;
        if (z < 2) {
            isPrim = false;
            if (showErrMessages) {
                System.err.println("Primzahlen sind >= 2...");
            }
            return isPrim;
        }
        if (z == 2) {
            isPrim = true;
            return isPrim;
        }
        if (z > 2) {
            if (z % 2 == 0) {
                isPrim = false;
                if (showErrMessages) {
                    System.err.println("Primzahlen > 2 sind nicht gerade...");
                }
                return isPrim;
            }
            long letztePruefzahl = 1 + (long) Math.sqrt(z);
            for (int k = 3; k < letztePruefzahl; k += 2) {
                if (z % k == 0) {
                    isPrim = false;
                    if (showErrMessages) {
                        System.err.println(z + " ist keine Primzahl, sie hat den "
                                + "Teiler: " + k + "...");
                    }
                    return isPrim;
                }
            }
            isPrim = true;
        }
        return isPrim;
    }

    private long[] calculateEUndDRandomized(long phi_n) {
        // wähle nun e mit 1 < e < phi_n und ggT(e,phi_n) = 1
        // e wird "per Zufallswahl" generiert
        // berechne dann d aus IN mit d*e kongruent 1 mod phi_n
        if (phi_n != (int) phi_n) {
            System.err.println("phi_n = " + phi_n + " muss im Integerbereich "
                    + "[" + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE + "] liegen!");
            return null;
        }
        long[] zahlen = new long[]{-1, -1};
        Random zufallsGenerator = new Random();
        GgT ggTDummy = new GgT();
        do {
            zahlen[0] = 1 + zufallsGenerator.nextInt(-1 + (int) phi_n);
//            System.out.println("zahl: " + zahlen[0]);
            ggTDummy.ggTEuclidExtended(zahlen[0], phi_n);
        } while (Math.abs(ggTDummy.getGgT()) != 1);
        zahlen[1] = ggTDummy.getX();
        // wichtig: d soll ja aus IN sein!!
        zahlen[1] = (zahlen[1] % phi_n >= 0) ? (zahlen[1] % phi_n)
                : (zahlen[1] % phi_n) + phi_n;
        e = zahlen[0];
        d = zahlen[1];
        if ((d * e) <= Math.max(d, e)) {
            System.err.println("Ihre Primzahlen sind vermutlich zu groß - oder e und d "
                    + "wurden ungünstig generiert...");
            System.err.println("Hier das Produkt d * e = " + (d * e));
            System.err.println("Abbruch...");
            System.exit(0);
        }
        return zahlen;
    }

    private long[] kodiere(String geheimeBotschaft, long e, long n) {
        long[] kodierungsIntArray = new long[geheimeBotschaft.length()];
        int counter = 0;
        for (char c : geheimeBotschaft.toCharArray()) {
            kodierungsIntArray[counter] = potenzModulo((int) c, e, n);
            ++counter;
        }
        System.out.println(Arrays.toString(kodierungsIntArray));
        PressEnter.toContinue();
        return kodierungsIntArray;
    }

    private String dekodiere(long[] geheimeBotschaftAlsLongArray, long d, long n) {
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

    public long getN() {
        return n;
    }

    public long getE() {
        return e;
    }

    private void showPublicKeys(long e, long n) {
        System.out.println("Die public keys: ");
        System.out.println("Exponent e: " + e);
        System.out.println("Modul n   : " + n);
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

    private void showAllInformationsInclSecrets(long d, long e, long n, long phi_n) {
        System.out.println("");
        System.out.println("");
        System.out.println("d                         : " + d);
        System.out.println("e                         : " + e);
        System.out.println("n                         : " + n);
        System.out.println("phi_n                     : " + phi_n);
        System.out.println("(e * d)                   : " + (e * d));
        System.out.println("(e * d) % phi_n           : " + (e * d) % phi_n);
        System.out.println("produktModulo(e, d, phi_n): " + produktModulo(e, d, phi_n));
        System.out.println("(e * d) / (1.0 * phi_n)   : " + (e * d) % (1.0 * phi_n));
    }

    public void testeDeineKodierteBotschaft(long[] geheimeBotschaftAlsLongArray) {
        System.out.println("Du wolltest mir also folgendes mitteilen:");
        System.out.println(dekodiere(geheimeBotschaftAlsLongArray, d, n));
    }
}
