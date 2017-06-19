package de.marcelhuber.kryptographie;

import de.marcelhuber.mathematik.GgT;
import de.marcelhuber.systemtools.Pause;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class ChinesischerRestsatzBuchmann5eAuflageSeite43 {

    // Hinweis: Alle ...Array-Variablen sind vom Typ []Wrapperklasse
    private Long[] mArray;           // enthält die Module m_{i+1} des Satzes 
    private long m;                  // das Produkt der Module, wie im Satz
    private Long[] bigMArray;        // die "großen" Produkte M_{i+1}
    private long bigM;               // das Array der M_{i+1}
    private Long[] yArray;                // das Array der y_{i+1} des Satzes
    private Long[] aArray;           // die a_{i+1} des Satzes 
    private boolean checkIfOurModulsArePairwiseRelativelyPrime;
    private long x;                  // Lösung des KongruenzSystems
    private long newModul;           // das neue Modul = bigM;
    private String hinweis;
    //
    // diese boolsche Variable testet, ob die Module paarweise teilerfremd
    // sind - das ist eine Voraussetzung zur Anwendung des Satzes
    // falls diese erfüllt ist, ist sie true, sonst false

    public static void main(String[] args) {
        ChinesischerRestsatzBuchmann5eAuflageSeite43 dummy
                = new ChinesischerRestsatzBuchmann5eAuflageSeite43();
        Long[] aArray = new Long[]{-2L, 1L, 0L};
        Long[] module = new Long[]{-4L, 3L, -5L};   // die Modulo sollten > 0 sein!
        dummy.loeseDasKongruenzSystem(aArray, module);
        if (dummy.isCheckIfOurModulsArePairwiseRelativelyPrime()) {
            System.out.println("Lösung:\n");
            System.out.println("    "
                    + "x kongruent " + dummy.getX() + " (mod " + dummy.getNewModul() + ").");
            System.out.println("(Mit dem kleinsten ganzzahligen positiven Repräsentanten "
                    + "lautet diese:"
                    + "\n    x kongruent "
                    + ((dummy.getX() % dummy.getNewModul() >= 0)
                    ? (dummy.getX() % dummy.getNewModul())
                    : ((dummy.getX() % dummy.getNewModul()) + dummy.getNewModul()))
                    + " (mod " + dummy.getNewModul() + ").)");
        } else {
            System.out.println("");
            if (dummy.getHinweis() != null) {
                System.out.println("[Hinweis:\n".toUpperCase()
                        + dummy.getHinweis() + "]");
                System.err.println("");
                System.err.println("[Hinweis:\n".toUpperCase()
                        + dummy.getHinweis() + "]");
            }
        }
    }

    public boolean loeseDasKongruenzSystem(Long[] aArrayUebergabe, Long[] mArrayUebergabe) {
        aArray = aArrayUebergabe;
        mArray = mArrayUebergabe;
        // zur Sicherheit: Es ist sinnvoll, alle Module als positiv zu betrachten
        for (int k = 0; k < mArray.length; k++) {
            mArray[k] = Math.abs(mArray[k]);
        }
        boolean loesbar;
        if ((aArray != null) && mArray != null) {
            if (aArray.length != mArray.length) {
                loesbar = false;
                hinweis = "aArray.length = " + aArray.length + " "
                        + "stimmt nicht mit mArray.length = " + mArray.length + " "
                        + "überein!";
                return loesbar;
            }
        }
        int[] zweiIndizes = checkIfTheModulsArePairwiseRelativelyPrime(mArrayUebergabe);
        loesbar = checkIfOurModulsArePairwiseRelativelyPrime;
        if (!loesbar) {
            if (zweiIndizes[0] == -2 && zweiIndizes[1] == -2) {
                hinweis = "Sie haben keine Module übergeben; "
                        + "mArrayUebergabe.length = " + mArrayUebergabe.length;
            } else {
                hinweis = "Die Module an den Stellen "
                        + zweiIndizes[0] + " und "
                        + zweiIndizes[1] + " sind nicht paarweise teilerfremd,\n"
                        + "es handelt sich um das Zahlenpaar: ("
                        + mArrayUebergabe[zweiIndizes[0]] + "," + mArrayUebergabe[zweiIndizes[1]] + ").";
            }
            return loesbar;
        }
        // im weiteren Verlauf wird das System der Kongruenzen loesbar sein
        GgT dummyGgT;
        bigM = 1;
        for (int k = 0; k < mArray.length; k++) {
            bigM *= mArray[k];
        }
        newModul = bigM;
        bigMArray = new Long[mArray.length];
        for (int k = 0; k < mArray.length; k++) {
            bigMArray[k] = bigM / mArray[k];
        }
        // wir brauchen die y_{i+1} mit y_{i+1} * bigMArray_{i+1} kongr. 1 mod mArray_{i+1} für i=0 , ..., mArray.length-1
        // bigMArray_{k+1} = bigMArray[k];
        dummyGgT = new GgT();
        x = 0;
        yArray = new Long[mArray.length];
        for (int k = 0; k < mArray.length; k++) {
            dummyGgT.ggTEuclidExtended(bigMArray[k], mArray[k]);
            yArray[k] = dummyGgT.getX();      // das x bei getX ist das aus ggT-Klasse, also der Vorfaktor von bigMArray[k]
            x += aArray[k] * yArray[k] * bigMArray[k];
            x %= newModul;
        }
//        if (x < 0) {
//            x += newModul;
//        }
        return loesbar;
    }

    private int[] checkIfTheModulsArePairwiseRelativelyPrime(Long[] mArrayUebergabe) {
        // falls es zwei nicht tf Zahlen gibt, erhalten wir ein Zahlenpaar,
        // welches sagt, an welchen Stellen die "schlechten" Zahlen stehen;
        // (keine sinnvollen Indizes, wenn das Array null oder leer ist --> Paar (-2,-2))
        //
        // zudem wird checkIfOurModulsArePairwiseRelativelyPrime dann auf false gesetzt
        // falls alles gut geht, wird checkIfOurModulsArePairwiseRelativelyPrime auf true gesetzt
        // die Indize-Rückgabe liefert dann (-1,-1)
        mArray = mArrayUebergabe;
        if (mArray == null || mArray.length == 0) {      // der Kurzschlussoperator ist hier wichtig - mit | Nullpointerexc.
            checkIfOurModulsArePairwiseRelativelyPrime = false;
            return new int[]{-2, -2};
        }
        checkIfOurModulsArePairwiseRelativelyPrime = true;
        long newGgT;
        int index01 = -1;    // falls einer und damit beide Indizes auf -1 bleiben ==> alles gut
        int index02 = -1;    // ansonsten geben sie die Indizes des ersten Paares aus, deren ggT != 1 ist
        GgT dummy = new GgT();
        for (int j = 0; j < mArray.length - 1; j++) {
            for (int k = j + 1; k < mArray.length; k++) {
                if (Math.abs(dummy.ggTEuclid(mArray[j], mArray[k])) != 1) {     // der Betrag, weil der ggT nur eindeutig bis auf Assoziiertheit ist
                    checkIfOurModulsArePairwiseRelativelyPrime = false;
                    return new int[]{index01 = j, index02 = k};
                }
            }
        }
        checkIfOurModulsArePairwiseRelativelyPrime = true;
        return new int[]{index01, index02};
    }

    public List<Long> getMArray() {
        return Collections.unmodifiableList(Arrays.asList(mArray));
    }

    public long getM() {
        return m;
    }

    public List<Long> getBigMArray() {
        return Collections.unmodifiableList(Arrays.asList(bigMArray));
    }

    public List<Long> getYArray() {
        return Collections.unmodifiableList(Arrays.asList(yArray));
    }

    public List<Long> getAArray() {
        return Collections.unmodifiableList(Arrays.asList(aArray));
    }

    public boolean isCheckIfOurModulsArePairwiseRelativelyPrime() {
        return checkIfOurModulsArePairwiseRelativelyPrime;
    }

    public long getX() {
        return x;
    }

    public long getNewModul() {
        return newModul;
    }

    public String getHinweis() {
        return hinweis;
    }
}
