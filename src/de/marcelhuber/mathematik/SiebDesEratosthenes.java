package de.marcelhuber.mathematik;

import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class SiebDesEratosthenes {
    private long timeSieb;
    
    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new SiebDesEratosthenes().go();
    }

    public void go() {
        System.out.printf("Geben Sie bitte die Zahl (in sinniger Weise > 1) ein, "
                + "bis zu welcher ".toUpperCase() + "%nSie die Primzahlen [einschließlich] sehen "
                + "möchten (unsinnige Eingaben %nwerden auf 0 gesetzt!): ");
        long readLong = ReadInput.readLong();
        Long[] primzahlenArray;
        timeSieb = System.currentTimeMillis();
        primzahlenArray = primzahlenAlsArray(siebDesEratothenes(readLong));
        timeSieb = System.currentTimeMillis() - timeSieb;
        System.out.println(Arrays.toString(primzahlenArray));
    }

    private List<Long> siebDesEratothenes(long readLong) {
        List<Long> siebAlsListe = new ArrayList<>();
        int faktor;
        if (readLong <= 0) {
            return siebAlsListe;
        }
        boolean[] isNotPrim = new boolean[(int) readLong];
        isNotPrim[0] = true; // 1 ist keine Primzahl
        for (int i = 0; i < isNotPrim.length; i++) {
            if (!isNotPrim[i]) {
                faktor = 2;
                while (faktor * (i + 1) - 1 < readLong) {
                    isNotPrim[faktor * (i + 1) - 1] = true;
                    // es ist dann wahr, dass die
                    // zahl i+1 KEINE Primzahl ist
                    faktor += 1;
                }
            }
        }
        for (long i = 0; i < readLong; i++) {
//            System.out.println("zahl=" + (i + 1) + "      - " + isNotPrim[i]);
            if (!isNotPrim[(int) i]) {
                siebAlsListe.add(i + 1);
            }
        }
        return siebAlsListe;
    }

    private Long[] primzahlenAlsArray(List<Long> siebDesEratothenes) {
        Long[] primzahlenArray = new Long[siebDesEratothenes.size()];
        siebDesEratothenes.toArray(primzahlenArray);
        return primzahlenArray;
    }
    
    public long getTimeSieb(){
        return timeSieb;
    }
    
    public Long[] calculateSiebDesEratosthenes(long z){
        return primzahlenAlsArray(siebDesEratothenes(z));
    }
}
