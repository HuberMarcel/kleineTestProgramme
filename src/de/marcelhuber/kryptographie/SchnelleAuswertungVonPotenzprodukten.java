// Siehe "Buchmann, Einführung in die Kryptographie; 3.13: "Schnelle 
// Auswertung von Potenzprodukten" 
// TODO: REST - bisher nur alle Vorbereitungen bis zur Berechnung der
//       Matrix B realisiert... 
//       Die Zeilen der Matrix B sind die Exponenten in Binärdarstellung, 
//       wobei ich diese von links nach rechts ausgebe. D.h. bspw., 
//       matrixB[0][0] ist die Ziffer, die vor 2^{matrixB[0].length-1} steht

package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.DecTogAddisch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class SchnelleAuswertungVonPotenzprodukten {

    private List<Long> basiselemente = new ArrayList<>();
    private List<Long> exponenten = new ArrayList<>();
    private List<List<Long>> exponentenBinaer = new ArrayList<>();
    private int n;
    private Long[][] matrixB;

    public static void main(String[] args) {
        new SchnelleAuswertungVonPotenzprodukten().go();
    }

    private void go() {
        initBasiselementeAndExponenten();
        //
        System.out.print("Die Basiselemente:                           ");
        System.out.println(basiselemente);
        System.out.print("Die Exponenten:                              ");
        System.out.println(exponenten);
        //
        initExponentenBinaer();
        //
        System.out.print("Die Exponenten in Binärdarstellung:          ");
        System.out.println(exponentenBinaer);
        //
        initMatrixB();
        //
        System.out.print("Die (auf Spaltenlänge " + n + " normierte) "
                + "Matrix B: ");
        System.out.println(Arrays.deepToString(matrixB));

    }

    private void initBasiselementeAndExponenten() {
        // TODO: Später --> automatisches Einlesen
        basiselemente.add(5L);
        exponenten.add(7L);
        basiselemente.add(11L);
        exponenten.add(13L);
        basiselemente.add(14L);
        exponenten.add(19L);
    }

    private void initExponentenBinaer() {
        // hier wird n auch mit initialisiert
        DecTogAddisch dec2gaddDummy = new DecTogAddisch();
        List<Long> dummy = new ArrayList<>();
        List<Long> dummyTwo;
        for (Long exp : exponenten) {
            dummy = dec2gaddDummy.calculateDecTogAddisch(exp, 2).get(0);
            dummyTwo = new ArrayList<>();
            if ((int) (dummy.get(dummy.size() - 1) + 1) > n) {
                n = (int) (dummy.get(dummy.size() - 1) + 1);
            }
            for (long k = dummy.get(dummy.size() - 1); k >= 0; k--) {
                if (dummy.contains(k)) {
//                    System.out.println("k=" + k + " gehört dazu");
                    dummyTwo.add(1L);
                } else {
                    dummyTwo.add(0L);
                }
            }
            exponentenBinaer.add(dummyTwo);
//            System.out.println("exp: " + exp + " --- in binärer Darstellung: "
//                    + exponentenBinaer.get(counter++));
        }
    }

    private void initMatrixB() {
        matrixB = new Long[exponentenBinaer.size()][n];
//        System.out.println(Arrays.deepToString(matrixB));
        int zeile = 0;
        for (List<Long> expBin : exponentenBinaer) {
//            for (int k = 0; k < n; k++) {
//                if (k < n - expBin.size()) {
//                    matrixB[zeile][k] = 0L;
//                } else {
//                    matrixB[zeile][k] = expBin.get(k - n + expBin.size());
//                }
//            }
            for (int k = 0; k < n - expBin.size(); k++) {
                matrixB[zeile][k] = 0L;
            }
            for (int k = n - expBin.size(); k < n; k++) {
                matrixB[zeile][k] = expBin.get(k - n + expBin.size());
            }
            ++zeile;
        }
//        System.out.println(Arrays.deepToString(matrixB));
    }
}
