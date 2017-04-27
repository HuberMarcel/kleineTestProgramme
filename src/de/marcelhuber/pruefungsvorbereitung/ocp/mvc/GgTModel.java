package de.marcelhuber.pruefungsvorbereitung.ocp.mvc;

import java.util.Observable;

/**
 *
 * @author Marcel Huber
 */
public class GgTModel extends Observable {

    private GgTModelCalculator calc;
    private long resultGgT;    // Ergebnis der ggT-Berechnung
    private long x, y;          // x*a+y*b=resultGgT soll später gelten, x,y ganzzahlig

//    public static void main(String[] args) {
//        new GgTModel().go();
//    }
//
//    void go() {
//        ggTEuclidExtended(15, 33);
//        System.out.println("x: " + x);
//        System.out.println("y: " + y);
//        System.out.println("ggT: " + resultGgT);
//    }
    public void ggTEuclidExtended(long a, long b) {
        long[] ergebnisFeld = new long[3];
        if (calc == null) {
            calc = new GgTModelCalculator();
        }
        ergebnisFeld = calc.ggTEuclidExtended(a, b);
        x = ergebnisFeld[0];
        y = ergebnisFeld[1];
        resultGgT = ergebnisFeld[2];
        benachrichtige();
    }

    public long getResultGgT() {
        return resultGgT;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    private void benachrichtige() {
        setChanged();
        notifyObservers(x);
        notifyObservers(y);
        notifyObservers(resultGgT);
    }
}
