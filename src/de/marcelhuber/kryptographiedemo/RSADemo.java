package de.marcelhuber.kryptographiedemo;

import de.marcelhuber.kryptographie.RSA;
import de.marcelhuber.mathematik.SchnelleExponentiation;
import de.marcelhuber.systemtools.ReadInput;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class RSADemo {
    
    public static void main(String[] args) {
        new RSADemo().go();
    }
    
    private void go() {
        RSA rsaDummy = new RSA();
        rsaDummy.generatePublicKeys();
        long n = rsaDummy.getN();
        long e = rsaDummy.getE();
        System.out.println("");
        System.out.println("Zum Vergleich: Ich habe hier folgende Keys abgegriffen: ");
        System.out.println("e: " + e);
        System.out.println("n: " + n);
        System.out.println("");
        String geheimeBotschaft;
//        geheimeBotschaft = "Das ist nun wirklich eine "
//                + "absolut geheime".toUpperCase() + " Botschaft!";
        System.out.println("Teilen Sie mir bitte Ihre geheime Botschaft mit!");
        geheimeBotschaft = ReadInput.readString();
        // die Kodierung erfolgt nun natürlich in DIESER Klasse hier
        long[] kodierteGeheimeBotschaft = kodiere(geheimeBotschaft, e, n);
        System.out.println("Ihre kodierte Botschaft wäre folgender String:");
        for (long k : kodierteGeheimeBotschaft) {
            System.out.print((char) k);
        }
        System.out.println("\nBzw. als long[]:");
        System.out.println(Arrays.toString(kodierteGeheimeBotschaft));
        System.out.println("");
        rsaDummy.testeDeineKodierteBotschaft(kodierteGeheimeBotschaft);
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
        System.out.println(Arrays.toString(kodierungsIntArray));
        return kodierungsIntArray;
    }
}
