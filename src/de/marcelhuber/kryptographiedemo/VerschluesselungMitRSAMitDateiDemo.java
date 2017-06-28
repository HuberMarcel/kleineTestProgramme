package de.marcelhuber.kryptographiedemo;

import de.marcelhuber.kryptographie.VerschluesselungMitRSA;
import de.marcelhuber.systemtools.Marker;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class VerschluesselungMitRSAMitDateiDemo {

    public static void main(String[] args) {
        new VerschluesselungMitRSAMitDateiDemo().go();
    }

    private void go() {
        VerschluesselungMitRSA dummy;
//        long zahl = 169;
//        while (!checkPrimzahlstatus(zahl)) {
//            zahl += 2;
//        }
//        System.out.println(zahl);
        dummy = new VerschluesselungMitRSA();
        dummy.goShowKeys();
        String hierMeineGeheimeBotschaft
                = "Mal schauen, wie lange das dauert, bis Du das hier geknackt "
                + "bekommst,\nsofern Du es denn überhaupt knacken kannst!!!";
        long[] geheimeNachricht = new long[hierMeineGeheimeBotschaft.length()];
        int position = 0;
        // Testen wir mal, wie lange die Verschlüsselung auf suboptimalem Wege dauert
        long time = System.currentTimeMillis();
        for (char c : hierMeineGeheimeBotschaft.toCharArray()) {
            geheimeNachricht[position] = dummy.potenzModulo((long) c, 29, 30358439);
            position++;
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Verschlüsselungsdauer [s]: " + time / 1000.0);
        // 
        System.out.println("");
        Marker.marker();
        Marker.marker();
        long timeEntschluesselung = System.currentTimeMillis();
        dummy.testeDeineNachricht(geheimeNachricht);
        timeEntschluesselung -= System.currentTimeMillis();
        timeEntschluesselung *= -1;
        System.out.println("Das Entschlüsseln dauerte [s]: " + timeEntschluesselung / 1000.0);
    }

    private boolean checkPrimzahlstatus(long zahl) {
        boolean primzahlstatus = true;
        long letzteTestzahl;
        if (zahl < 2) {
            primzahlstatus = false;
            return primzahlstatus;
        }
        if (zahl > 3) {
            if (zahl % 2 == 0) {
                primzahlstatus = false;
            }
            letzteTestzahl = 1 + (long) (Math.sqrt(zahl));
            for (int j = 3; j < letzteTestzahl; j = j + 2) {
                if (zahl % j == 0) {
                    primzahlstatus = false;
                    System.out.println(zahl + " wird von " + j + " geteilt, ist also keine Primzahl!");
                    return primzahlstatus;
                }
            }
        }
        return primzahlstatus;
    }
}
