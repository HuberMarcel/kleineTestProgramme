package de.marcelhuber.aufrufvonaussen;

import de.marcelhuber.kleinetestprogramme.*;

/**
 *
 * @author Marcel
 */
public class GgTRekursivaufruf {

    public static void main(String[] args) {
        new GgTRekursivaufruf().go();
    }

    void go() {
        GgTRekursiv hilfsRechenObjekt = new GgTRekursiv();
        int[] y = {12, 4, 8, 18};
        hilfsRechenObjekt.ggT(y);
    }
}
