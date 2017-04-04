package de.marcelhuber.mathematikdemo;

import de.marcelhuber.mathematik.*;
import de.marcelhuber.systemtools.*;

/**
 *
 * @author Marcel Huber
 */
public class GgTDemo {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new GgTDemo().go();
    }

    void go() {
        long a, b, x, y;
        GgT ggTRechenObjekt = new GgT();
        System.out.print("Eingabe a: ");
        a = ReadInput.readLong();
        System.out.print("Eingabe b: ");
        b = ReadInput.readLong();
        ggTRechenObjekt.ggTEuclidExtended(a, b);
        x = ggTRechenObjekt.getX();
        y = ggTRechenObjekt.getY();
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("ggT = " + ggTRechenObjekt.getGgT());
        System.out.println(x + " * (" + a + ") + (" + y + ") * (" + b + ") = "
                + (x * a + y * b));
    }
}
