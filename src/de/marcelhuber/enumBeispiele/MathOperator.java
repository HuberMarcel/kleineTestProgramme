package de.marcelhuber.enumBeispiele;

import de.marcelhuber.kleinetestprogramme.GGTZahlenpaar;
import de.marcelhuber.kleinetestprogramme.GGTZahlenpaar;

/**
 *
 * @author viona25
 */
public enum MathOperator {

    PLUS {
                @Override
                public double rechne(double x, double y) {
                    return x + y;
                }
            },
    MINUS {
                @Override
                public double rechne(double x, double y) {
                    return PLUS.rechne(x, -y);
                }
            },
    MAL {
                @Override
                public double rechne(double x, double y) {
                    return x * y;
                }
            },
    DURCH {
                @Override
                public double rechne(double x, double y) {
                    return MAL.rechne(x, 1 / y);
                }
            },
    GGT {
                @Override
                public double rechne(double x, double y) {
                    int[] ggTMitVorfaktoren
                    = new GGTZahlenpaar((int) x,
                            (int) y).calculatorErweiterterEuklidischerAlgorithmus();
                    // hier gleich weitermachen
                    return ggTMitVorfaktoren[2];
                }
            },
    MOD {
                @Override
                public double rechne(double x, double y) {
                    return  x % y;
                }
            };

//    public abstract double calc(double zahl1, double zahl2); // so wäre das besser
    public double rechne(double zahl1, double zahl2) {
        return 1;
    }
;

}
