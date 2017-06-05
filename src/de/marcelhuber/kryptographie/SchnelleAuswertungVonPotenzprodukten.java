// Siehe "Buchmann, Einführung in die Kryptographie; 3.13: "Schnelle 
// Auswertung von Potenzprodukten" 
package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.DecTogAddisch;
import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.Pause;
import de.marcelhuber.systemtools.PressEnter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private long produktA;
    private boolean calcWithModul;
    private long modul;

    private class InappropriateArrayLengthsException extends Exception {

        public String toString() {
            return "Die Arrays haben verschiedene Längen!";
        }
    }

    public SchnelleAuswertungVonPotenzprodukten() {
    }

    public SchnelleAuswertungVonPotenzprodukten(List<Long> basiselemente, List<Long> exponenten) {
        this.basiselemente = basiselemente;
        this.exponenten = exponenten;
    }

    public SchnelleAuswertungVonPotenzprodukten(List<Long> basiselemente, List<Long> exponenten, long modul) {
        this(basiselemente, exponenten);
        if (modul > 0) {
            calcWithModul = true;
            this.modul = modul;
        } else {
            calcWithModul = false;
        }
    }

    public static void main(String[] args) {
        SchnelleAuswertungVonPotenzprodukten dummy = new SchnelleAuswertungVonPotenzprodukten();
        dummy.go();
        dummy.go02();
    }

    private void go02() {
        List<Long> basen = new ArrayList<>();
        List<Long> expo = new ArrayList<>();
        basen.add(2L);
        expo.add(3L);
        basen.add(5L);
        expo.add(4L);
        basen.add(11L);
        expo.add(3L);
        System.out.println(basen);
        System.out.println(expo);
        long result = calcSchnelleAuswertungDerPotenzprodukte(basen, expo);
        System.out.println("Das Ergebnis lautet: "
                + result);
    }

    public long calcSchnelleAuswertungDerPotenzProdukte() {
        List<Long> basiselementeCopy = new ArrayList<>();
        List<Long> exponentenCopy = new ArrayList<>();
        for (int s = 0; s < basiselemente.size(); s++) {
            basiselementeCopy.add(basiselemente.get(s));
            exponentenCopy.add(exponenten.get(s));
        }
        return calcSchnelleAuswertungDerPotenzprodukte(basiselementeCopy, exponentenCopy);
    }

    public long calcSchnelleAuswertungDerPotenzprodukte(
            List<Long> basiselemente, List<Long> exponenten) {
        this.basiselemente.clear();
        this.exponenten.clear();
        this.basiselemente = basiselemente;
        this.exponenten = exponenten;
        if (basiselemente.size() != exponenten.size()) {
            try {
                throw new InappropriateArrayLengthsException();
            } catch (InappropriateArrayLengthsException ex) {
                Pause.breakInSeconds(1);
                System.err.println("Fehler: " + ex);
            }
            return 0;
        } else {
            k = basiselemente.size();
            produktA = 1L;
            if (calcWithModul) {
                if (modul > 0) {
                    produktA = 1L % modul;
                }
            }
            initExponentenBinaer();
            initMatrixB();
            initVectorG();
            int indexOfVectorG;
            for (int j = 0; j < n; j++) {
                indexOfVectorG = 0;
                for (int z = 0; z < k; z++) {
                    indexOfVectorG += matrixB[z][j] * (int) Math.pow(2, z);
                }
                if (calcWithModul) {
                    if (modul > 0) {
                        produktA = ((((produktA % modul) * (produktA % modul)) % modul)
                                * vectorG[indexOfVectorG]) % modul;
                    } else {
                        produktA = (produktA * produktA) * vectorG[indexOfVectorG];
                    }
                } else {
                    produktA = (produktA * produktA) * vectorG[indexOfVectorG];
                }
            }
        }
        return produktA;
    }

    private void go() {
        initBasiselementeAndExponenten();
        //
        System.out.print("Die Basiselemente:                           ");
        System.out.println(basiselemente);
        System.out.print("Die Exponenten:                              ");
        System.out.println(exponenten);
        //
        produktA = 1L;
        if (calcWithModul) {
            if (modul > 0) {
                produktA = 1L % modul;
            }
        }
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
        int indexOfVectorG;
        for (int j = 0; j < n; j++) {
            indexOfVectorG = 0;
            for (int z = 0; z < k; z++) {
                indexOfVectorG += matrixB[z][j] * (int) Math.pow(2, z);
            }
            if (calcWithModul) {
                if (modul > 0) {
                    produktA = ((((produktA % modul) * (produktA % modul)) % modul)
                            * vectorG[indexOfVectorG]) % modul;
                } else {
                    produktA = (produktA * produktA) * vectorG[indexOfVectorG];
                }
            } else {
                produktA = (produktA * produktA) * vectorG[indexOfVectorG];
            }
        }
        System.out.println("Das Ergebnis ist: " + produktA);
//        exponenten.remove(0); // zum Test der Fehlermeldung
    }

    private void initBasiselementeAndExponenten() {
        // TODO: Später --> automatisches Einlesen
        basiselemente.add(5L);
        exponenten.add(2L);
        basiselemente.add(7L);
        exponenten.add(3L);
        basiselemente.add(11L);
        exponenten.add(5L);
        k = basiselemente.size();
//        basiselemente.add(2L);
//        exponenten.add(3L);
//        basiselemente.add(5L);
//        exponenten.add(7L);
//        basiselemente.add(11L);
//        exponenten.add(3L);
//        r = basiselemente.size();
    }

    private List<List<Long>> initExponentenBinaer() {
        // hier wird auch n mit initialisiert
        exponentenBinaer.clear();
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
//                    System.out.println("r=" + r + " gehört dazu");
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
//            for (int r = 0; r < n; r++) {
//                if (r < n - expBin.size()) {
//                    matrixB[zeile][r] = 0L;
//                } else {
//                    matrixB[zeile][r] = expBin.get(r - n + expBin.size());
//                }
//            }
            for (int r = 0; r < n - expBin.size(); r++) {
                matrixB[zeile][r] = 0L;
            }
            for (int r = n - expBin.size(); r < n; r++) {
                matrixB[zeile][r] = expBin.get(r - n + expBin.size());
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
        for (int r = 0; r < binaerCutted.length; r++) {
            binaerCutted[r] = binaerZahl[r];
        }
        return binaerCutted;
    }

    private long[] initVectorG() {
        vectorG = new long[(int) (Math.pow(2, k))];
        vectorG[0] = 1L;
        if (calcWithModul) {
            if (modul > 0) {
                vectorG[0] = 1L % modul;
            }
        }
        long[] kombinationsFeld = new long[k];
        for (int s = 0; s < k; s++) {
            kombinationsFeld[s] = 0L;
        }
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
            if (calcWithModul) {
                if (modul > 0) {
                    vectorG[(int) m] = 1L % modul;
                }
            }
            for (int r = 0; r < k; r++) {
                if (kombinationsFeld[r] == 1L) {
                    if (calcWithModul) {
                        if (modul > 0) {
                            vectorG[(int) m] *= (basiselemente.get(k - 1 - r)) % modul;
                            vectorG[(int) m] %= modul;
                        } else {
                            vectorG[(int) m] *= basiselemente.get(k - 1 - r);
                        }
                    } else {
                        vectorG[(int) m] *= basiselemente.get(k - 1 - r);
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(vectorG));
        return vectorG;
    }

    private long calcSchnelleExponentiationWithBinaerexponent(long g, long[] binaerexp, long m) {
        long result = 1;
        if (m == 0) {
            for (int r = binaerexp.length - 1; r >= 0; r--) {
                if (binaerexp[r] == 1) {
                    result *= g;
                }
                g *= g;
            }
        } else if (m > 0) {
            result %= m;
            g %= m;
            for (int s = binaerexp.length - 1; s >= 0; s--) {
                if (binaerexp[s] == 1) {
                    result *= g;
                    result %= m;
                }
                g *= g;
                g %= m;
            }
        }
        return result;
    }

    public boolean isCalcWithModul() {
        return calcWithModul;
    }

    public void setCalcWithModul(boolean calcWithModul) {
        this.calcWithModul = calcWithModul;
    }

    public long getModul() {
        return modul;
    }

    public void setModul(long modul) {
        this.modul = modul;
    }
}
