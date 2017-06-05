// Siehe "Buchmann, Einführung in die Kryptographie; 3.13: "Schnelle 
// Auswertung von Potenzprodukten" 
// TODO: REST - bisher alles bis zur Berechnung des Vektors G realisiert
//       siehe initVectorG()-Methode
package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.DecTogAddisch;
import de.marcelhuber.systemtools.Marker;
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
    private int k;
    private int n;
    private long[][] matrixB;
    private long[] vectorG;

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
        //
        initVectorG();

    }

    private void initBasiselementeAndExponenten() {
        // TODO: Später --> automatisches Einlesen
        basiselemente.add(5L);
        exponenten.add(7L);
        basiselemente.add(11L);
        exponenten.add(13L);
        basiselemente.add(14L);
        exponenten.add(19L);
        k = basiselemente.size();
    }

    private List<List<Long>> initExponentenBinaer() {
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
        return exponentenBinaer;
    }

    private long[][] initMatrixB() {
        matrixB = new long[exponentenBinaer.size()][n];
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
        return matrixB;
    }

    private long[] binaerMitLetztenStellenABgeschnitten(long[] binaerZahl, int j) {
        long[] binaerCutted;
        if (j > binaerZahl.length - 1) {
            binaerCutted = new long[0];
            return binaerCutted;
        }
        binaerCutted = new long[binaerZahl.length - j];
        for (int k = 0; k < binaerCutted.length; k++) {
            binaerCutted[k] = binaerZahl[k];
        }
        return binaerCutted;
    }

    private long[] initVectorG() {
        vectorG = new long[(int) (Math.pow(2, k))];
        vectorG[0] = 1;
        long[] kombinationsFeld = new long[]{0, 0, 0};
        DecTogAddisch dec2gaddDummy = new DecTogAddisch();
        for (long m = 1; m < (long) Math.pow(2, k); m++) {
            for (int r = 0; r < kombinationsFeld.length; r++) {
                kombinationsFeld[r] = 0;
            }
//            System.out.println(Arrays.toString(kombinationsFeld));
//            Marker.marker();
//            System.out.println(Arrays.toString(dec2gaddDummy.calculateDecTogAddischAsArray(m, 2)[0]));
//            System.out.println(Arrays.toString(dec2gaddDummy.calculateDecTogAddischAsArray(m, 2)[1]));
            for (long eintrag : dec2gaddDummy.calculateDecTogAddischAsArray(m, 2)[0]) {
                kombinationsFeld[kombinationsFeld.length - 1 - (int) eintrag] = 1L;
            }
//            System.out.println(Arrays.toString(kombinationsFeld));
            // den Fall m==0 hätten wir separat behandeln müssen, da dieser als 0*2^0 dargestellt wird
            vectorG[(int) m] = 1L;
            for (int r = 0; r < k; r++) {
                if (kombinationsFeld[r] == 1L) {
                    vectorG[(int) m] *= basiselemente.get(k - 1 - r);
                }
            }
        }
        System.out.println(Arrays.toString(vectorG));
        return vectorG;
    }

    private long calcSchnelleExponentiationWithBinaerexponent(long g, long[] binaerexp, long m) {
        long result = 1;
        if (m == 0) {
            for (int k = binaerexp.length - 1; k >= 0; k--) {
                if (binaerexp[k] == 1) {
                    result *= g;
                }
                g *= g;
            }
        } else if (m > 0) {
            result %= m;
            g %= m;
            for (int k = binaerexp.length - 1; k >= 0; k--) {
                if (binaerexp[k] == 1) {
                    result *= g;
                    result %= m;
                }
                g *= g;
                g %= m;
            }
        }
        return result;
    }
}
