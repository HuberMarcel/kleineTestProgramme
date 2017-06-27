package de.marcelhuber.kryptographie;
// HINWEIS: Die Zeilen (130, 131; Stand 27.06.2017)
//            // WICHTIG: d soll aus IN sein!!!!
//            d = ((d % phi_n) >= 0) ? (d % phi_n) : (d % phi_n) + phi_n;
// sind ungeheuer wichtig!!
//
//
// Zudem weiterer Hinweis: Die potenzModulo()-Methode ist suboptimal implementiert
//                         Besser demnächst noch schnelle Exponentiation einbauen

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.mathematik.SchnelleExponentiation;
import de.marcelhuber.systemtools.PressEnter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class VerschluesselungMitRSA {

    private String ordner;
    private String dateiname;
    private String[] primzahlenString;
    private long[] primzahlen;
    private long n;
    private long pz01;
    private long pz02;
    private long phi_n;
    private boolean primzahlstatus;
    private long d;
    private long e;
    private GgT ggTDummy;

    // Initialisierung
    {
        ordner = "RSA";
        dateiname = "/zweiUngleichePrimzahlen.txt";
        try {
            lesePrimzahlenAusTextdatei();
        } catch (IOException ex) {
            System.out.println("Datei nicht da oder nicht lesbar!");
            System.out.println(ex);
            ex.printStackTrace();
        }
//        System.err.println(Arrays.toString(primzahlenString));
        checkPrimzahlstatus();
        pz01 = primzahlen[0];
        pz02 = primzahlen[1];
        n = pz01 * pz02;
        phi_n = (pz01 - 1) * (pz02 - 1);
        ggTDummy = new GgT();
        checkIfEIsOkay();
    }

    private void lesePrimzahlenAusTextdatei() throws IOException, FileNotFoundException {
        File file = new File(ordner + dateiname);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String zeile = br.readLine();
        // datei soll nur drei Zeilen haben, 
        // die erste kann übersprungen werden, header mit Informationen
        // in der zweiten die Primzahlen mit $ getrennt
        // in der dritten dann e
        // Jetzt also 2. Zeile einlesen:
        zeile = br.readLine();
        primzahlenString = zeile.split("\\$");
        if (primzahlenString.length != 2 || primzahlenString[0].equals(primzahlenString[1])) {
            System.err.println("Überprüfen Sie den Inhalt der Datei!");
            System.err.println("Abbruch...");
            System.exit(0);
        } else {
            primzahlen = new long[2];
            for (int k = 0; k < 2; k++) {
                primzahlen[k] = Long.parseLong(primzahlenString[k]);
            }
//            System.out.println(Arrays.toString(primzahlen));
        }
        e = Long.parseLong(br.readLine().split("\\$")[0]);
    }

    private void checkPrimzahlstatus() {
        primzahlstatus = true;
        long letzteTestzahl;
        for (long pz : primzahlen) {
            if (pz < 2) {
                primzahlstatus = false;
                return;
            }
            if (pz > 3) {
                if (pz % 2 == 0) {
                    primzahlstatus = false;
                    System.err.println(pz + " ist gerade!");
                    System.err.println("Abbruch...");
                    System.exit(0);
                }
                letzteTestzahl = 1 + (long) (Math.sqrt(pz));
                for (int j = 3; j < letzteTestzahl; j = j + 2) {
                    if (pz % j == 0) {
                        primzahlstatus = false;
                        System.err.println(pz + " wird von " + j + " geteilt, ist also keine Primzahl!");
                        System.err.println("Abbruch...");
                        System.exit(0);
                    }
                }
            }
        }
    }

    private void checkIfEIsOkay() {
        boolean eIsOkay = true;
        if (e <= 1 || e >= phi_n) {
            eIsOkay = false;
            System.err.println("e soll 1 < e < phi_n erfüllen, das ist hier "
                    + "verletzt!");
            System.err.println("Abbruch...");
            System.exit(0);
        }
        if (ggTDummy == null) {
            ggTDummy = new GgT();
        }
        ggTDummy.ggTEuclidExtended(e, phi_n);
        if (Math.abs(ggTDummy.getGgT()) == 1) {
            eIsOkay = true;
            d = ggTDummy.getX();
            // WICHTIG: d soll aus IN sein!!!!
            d = ((d % phi_n) >= 0) ? (d % phi_n) : (d % phi_n) + phi_n;
        } else {
            eIsOkay = false;
            System.err.println("Prüfen Sie e=" + e + " in Ihrer Textdatei!");
            System.err.println("ggT(" + e + ",phi_n) soll ja =1 sein, ist "
                    + "aber = " + ggTDummy.getGgT());
            System.err.println("phi_n: " + phi_n);
            System.err.println("Abbruch...");
            System.exit(0);
        }
    }

    // Ende der Initialisierung
    public static void main(String[] args) {
        VerschluesselungMitRSA dummy
                = new VerschluesselungMitRSA();
        dummy.goShowKeys();
        dummy.goTest();
    }

    public void goShowKeys() {
////        System.out.println(potenzModulo(2, 6, 7));
//        GgT testGgT = new GgT();
//        testGgT.ggTEuclidExtended(d, e);
//        System.out.println(testGgT.getGgT());
//        testGgT.ggTEuclidExtended(e, phi_n);
//        System.out.println(testGgT.getGgT());
        System.out.println("Hier sind die Keys:");
        System.out.println("n = " + n + "; e = " + e);
    }

    public void goTest() {
        String geheimeMitteilung = "Das ist alles streng geheim, 007!";
//        geheimeMitteilung = "TEST";
//        String verschluesseltesWort
//                = verschluesseleEinWort(geheimeMitteilung);
        long[] verschluesseltesWort
                = verschluesseleEinWort(geheimeMitteilung);
        System.out.println("Hier die verschlüsselte Mitteilung:");
//        System.out.println(verschluesseltesWort);
        System.out.println(Arrays.toString(verschluesseltesWort));
        for (long z : verschluesseltesWort) {
            System.out.print((char) z);
        }
        System.out.println("");
//        String entschluesselteMitteilung
//                = entschluesseleDasVerschluesselteWort(verschluesseltesWort);
        long[] entschluesselteMitteilung
                = entschluesseleDasVerschluesselteWort(verschluesseltesWort);
        System.out.println("Das heißt wohl im " + "Klartext:".toUpperCase());
//        System.out.println(entschluesselteMitteilung);
        for (long z : entschluesselteMitteilung) {
            System.out.print((char) z);
        }
        System.out.println("");
    }

    public long getN() {
        return n;
    }

    public long getE() {
        return e;
    }

//    private String kodierungsUndEntkodierungsmethode(String wort, long key) {
    private long[] kodierungsUndEntkodierungsmethode(String wort, long key) {
//        String ergebnisString = "";
        long[] ergebnisLongArray = new long[wort.length()];
        char[] geheimesWortArrayVonChar = wort.toCharArray();
        int counter = 0;
        for (char c : geheimesWortArrayVonChar) {
//            System.out.println("c:   " + (long) c);
//            System.out.println("key: " + key);
//            System.out.println("n:   " + n);
//            System.out.println("     " + potenzModulo(c, key, n));
//            ergebnisString += (char) potenzModulo(c, key, n);
            ergebnisLongArray[counter] = potenzModulo((long) c, key, n);
            counter++;
        }
//        return ergebnisString;
        return ergebnisLongArray;
    }

    private long[] kodierungsUndEntkodierungsmethode(long[] wort, long key) {
        long[] ergebnisLongArray = new long[wort.length];
        int counter = 0;
        for (long c : wort) {
//            ergebnisLongArray[counter] = potenzModulo(c, key, n);
            ergebnisLongArray[counter] = schnellPotenzModulo(c, key, n);
            counter++;
        }
        return ergebnisLongArray;
    }

//    private String verschluesseleEinWort(String geheimesWort) {
//        String verschluesseltesWort
//                = kodierungsUndEntkodierungsmethode(geheimesWort, e);
//        return verschluesseltesWort;
//    }
    private long[] verschluesseleEinWort(String geheimesWort) {
        long[] verschluesseltesWort
                = kodierungsUndEntkodierungsmethode(geheimesWort, e);
        return verschluesseltesWort;
    }

    public long potenzModulo(long basis, long exponent, long modul) {
        long returnLong = 1;
//        System.out.println("Basis:      " + basis);
        for (int k = 0; k < exponent; k++) {
            returnLong *= basis;
            returnLong %= modul;
        }
//        System.out.println("returnLong: " + returnLong);
//        PressEnter.toContinue();
        return returnLong;
    }
    
    public long schnellPotenzModulo(long basis, long exponent, long modul){
        SchnelleExponentiation dummySchnellExp = new SchnelleExponentiation();
//        return dummySchnellExp.calcSchnelleExponentiation(basis, exponent, modul);
        return dummySchnellExp.calcSchnelleExponentiationNachPseudocode(basis, exponent, modul);
    }

//    private String entschluesseleDasVerschluesselteWort(String verschluesseltesWort) {
//        String entschluesseltesWort
//                = kodierungsUndEntkodierungsmethode(verschluesseltesWort, d);
//        return entschluesseltesWort;
//    }
    private long[] entschluesseleDasVerschluesselteWort(String verschluesseltesWort) {
        long[] entschluesseltesWort
                = kodierungsUndEntkodierungsmethode(verschluesseltesWort, d);
        return entschluesseltesWort;
    }

    private long[] entschluesseleDasVerschluesselteWort(long[] verschluesseltesWortAlsCharArray) {
        long[] entschluesseltesWort
                = kodierungsUndEntkodierungsmethode(verschluesseltesWortAlsCharArray, d);
        return entschluesseltesWort;
    }

    public void testeDeineNachricht(long[] verschluesselteNachricht) {
        long[] meinErgebnis 
                = kodierungsUndEntkodierungsmethode(verschluesselteNachricht, d);
        System.out.println("Das wolltest Du mir also das folgende mitteilen:");
        for (long charZahl : meinErgebnis) {
            System.out.print((char) charZahl);
        }
        System.out.println("");
        System.out.println("Richtig? Okay, ich bin mir eh sicher, Du brauchst "
                + "nicht mehr zu antworten... ;)");
    }
}
