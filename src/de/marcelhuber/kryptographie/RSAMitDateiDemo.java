package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.GgT;
//import de.marcelhuber.mathematik.Primfaktorzerlegung;
import de.marcelhuber.mathematik.PrimzahlTest;
import static de.marcelhuber.systemtools.Pause.*;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class RSAMitDateiDemo {

    private String message = "Hallo Welt, dies ist eine Nachricht, die ich "
            + "einmal verschlüssele,\num dann hinterher rauszufinden, ob "
            + "bzw. wie gut die Decodierung funktioniert!";

    // public key: n, e
    private long maxValueForPAndQ = 1_250;    // Dauer bei 2_500 an meinem Rechner ca. 60 Sekunden 
    private long p;
    private long q;
    private long n;
    private long phi_n;
    private long d;
    private long e;
    private boolean decodieren;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new RSAMitDateiDemo().go();
    }

    private void go() {
        setDecodieren(true);                  // wir wollen die Nachricht dekodieren
        // siehe die Zeile mit decode(message)
//        System.out.println((long)'ü');     // --> 252
        do {
            initializeTwoPrimesPAndQ();
            n = p * q;
        } while (n < 300);          // wir wollen die ersten 300 Zeichen verwenden dürfen
        phi_n = (p - 1) * (q - 1);
        initializeEAndD();
        showThePublicKeys();
        long[] myMessage = getMessage();
        StringBuilder myCryptedMessage = new StringBuilder();
        for (int i = 0; i < myMessage.length; i++) {
            myCryptedMessage.append((char) myMessage[i]);
        }
        System.out.println("");
        System.out.println("Sie haben folgende verschlüsslte Nachricht erhalten: ");
        System.out.println(myCryptedMessage);
        System.out.println("");
        String nachricht = decode(myMessage);
        System.out.println("");
        System.out.println("Sie haben folgende Nachricht erhalten: ");
        breakInSeconds(1);
        System.err.println(nachricht);
    }

    private void initializeEAndD() {
        long tmp;
        long[] xYggT;
        do {
            tmp = (long) (Math.random() * (phi_n - 2));   // eine Zahl z mit 0 <= z < phi_n - 2
            tmp += 2;                                     // jetzt gilt 1 < tmp < phi_n
            xYggT = new GgT().ggTEuclidExtended(tmp, phi_n);
        } while (Math.abs(xYggT[2]) != 1);
//        long x = xYggT[0];
//        long y = xYggT[1];
//        System.out.println("xxxx");
//        System.out.println(x * tmp + y * phi_n);
//        System.out.println("xxxx");
//        System.out.println(Arrays.toString(xYggT));
        e = tmp;
        d = xYggT[0];     // hierbei kann der Betragswert von d negativ sein und auch > phi_n
        d = d % phi_n > 0 ? d % phi_n : d % phi_n + phi_n;     // d soll immer positiv sein
//        System.out.println("d:" + d);
//        System.out.println("p: " + p + "; q: " + q);
//        System.out.println("phi_n: " + phi_n);
//        // Testausgaben für den ggT
//        System.out.println(e * d + xYggT[1] * phi_n);
//        System.out.println((e * d) % phi_n);
//        System.out.println(((e % phi_n) * (d % phi_n)) % phi_n);
//        System.out.println("");
//        System.out.println("e:" + e);
//        System.out.println(Arrays.toString(new GgT().ggTEuclidExtended(e, phi_n)));
    }

    private void initializeTwoPrimesPAndQ() {
        p = findAPrime();
//        System.out.println("p:" + p);
        do {
            q = findAPrime();
//            System.out.println("q:" + q);
        } while (p == q);
    }

    private long findAPrime() {
        long tmp;
        boolean numberIsOkay = false;
//        Primfaktorzerlegung pFZ = new Primfaktorzerlegung();                                        // A
        PrimzahlTest pzT = new PrimzahlTest();                                                        // B
        do {                                                                                          // B
//        do {                                                                                        // A
            tmp = (long) (Math.random() * maxValueForPAndQ);                                          // A, B
//            pFZ.zerlegeZahl(tmp);                                                                   // A
//            if (pFZ.getPrimfaktorenAlsArray().length == 1 && pFZ.getExponentenAlsArray()[0] == 1) { // A  // beachte: bspw. ist 32=2^5 keine Primzahl
//                numberIsOkay = true;                                                                // A
//            }                                                                                       // A
//        } while (!numberIsOkay);                                                                    // A
        } while (!pzT.primzahlTestMitSiebErastothenes(tmp));                                           // B
        return tmp;
    }

    public void showThePublicKeys() {
        System.out.println("Der öffentliche Schlüssel: "
                + "(n=" + n + ", e=" + e + ")!");
    }

    public long[] getMessage() {
        long[] myCryptedMessage;
        char[] myCharMessage = new char[message.length()];
        message.getChars(0, message.length(), myCharMessage, 0);
//        System.out.println(myCharMessage);
//        System.out.println("xxxxxxxxx");
        myCryptedMessage = new long[message.length()];
        for (int i = 0; i < myCharMessage.length; i++) {
            myCryptedMessage[i] = createMyCryptedKey(myCharMessage[i]);
        }
//        System.out.println("Crypted: " + Arrays.toString(myCryptedMessage));
        return myCryptedMessage;
    }

    private long createMyCryptedKey(long charNumber) {
        long tmp = charNumber % n;
        for (int i = 0; i < e - 1; i++) {
            tmp *= (charNumber % n);
            tmp = tmp % n;
        }
        return tmp;
    }

    private String decode(long[] message) {
        StringBuilder myDecryptedMessage = new StringBuilder();
        if (decodieren) {
//        System.out.println("d=" + d);
            for (int i = 0; i < message.length; i++) {
                myDecryptedMessage.append((char) createMyDecryptedKey(message[i]));
//            System.out.print("Decrypted: ");
//            System.out.print(createMyDecryptedKey(message[i]) + ", ");
            }
        } else {
            myDecryptedMessage.append("Decodierung ausgeschaltet!:\n");
            for (int i = 0; i < message.length; i++) {
                myDecryptedMessage.append((char) message[i]);
            }
        }
        return myDecryptedMessage.toString();
    }

    private long createMyDecryptedKey(long charNumber) {
        long tmp = charNumber % n;
        for (int i = 0; i < d - 1; i++) {
            tmp *= (charNumber % n);
            tmp = tmp % n;
        }
        return tmp;
    }

    public long getN() {
        return n;
    }

    public long getE() {
        return e;
    }

    public boolean isDecodieren() {
        return decodieren;
    }

    public void setDecodieren(boolean decodieren) {
        this.decodieren = decodieren;
    }

}
