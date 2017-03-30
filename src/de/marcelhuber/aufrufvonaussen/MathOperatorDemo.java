package de.marcelhuber.aufrufvonaussen;

import de.marcelhuber.enumBeispiele.MathOperator;
import de.marcelhuber.kleinetestprogramme.*;
//import de.marcelhuber.kleinetestprogramme.MathOperator;
import de.marcelhuber.SystemTools.*;
import java.util.*;
import jdk.nashorn.internal.objects.*;

/**
 *
 * @author viona25
 */
public class MathOperatorDemo {

    public static void main(String[] args) {
        String[] operation = {"plus", "mINUS", "mAL", "DuRcH", "gGT", "mOd"};
        new MathOperatorDemo().go(operation);
    }

    void go(String[] operation) {

        List<Double> rechenZahlen = new ArrayList<>(2);
        rechenZahlen.add(-210.22);
        rechenZahlen.add(-60.99);

        double z1 = rechenZahlen.remove(0);
        double z2 = rechenZahlen.remove(0);
        double rechenErgebnis = Global.Infinity;
        String information = "";
        for (String operation1 : operation) {
            switch (operation1.toLowerCase()) {
                case "plus":
                    System.out.println("ADDITION");
                    information = "Addition von " + z1 + " und "
                            + z2 + " [d.h. (" + z1 + ") + (" + z2 + ")] liefert: ";
                    rechenErgebnis = MathOperator.PLUS.rechne(z1, z2);
                    break;
                case "minus":
                    System.out.println("SUBTRAKTION");
                    information = "Subtraktion der Zahl " + z2 + " von "
                            + z1 + " [d.h. (" + z1 + ") - (" + z2 + ")] liefert: ";
                    rechenErgebnis = MathOperator.MINUS.rechne(z1, z2);
                    break;
                case "mal":
                    System.out.println("MULTIPLIKATION");
                    information = "Multiplikation von " + z1 + " mit "
                            + z2 + " [d.h. (" + z1 + ") * (" + z2 + ")] liefert: ";
                    rechenErgebnis = MathOperator.MAL.rechne(z1, z2);
                    break;
                case "durch":
                    System.out.println("DIVISION");
                    information = "Dividiert man die Zahl " + z1 + " durch "
                            + z2 + " [d.h. (" + z1 + ") / (" + z2 + ")], so erhält man: ";
                    rechenErgebnis = MathOperator.DURCH.rechne(z1, z2);
                    break;
                case "ggt":
                    System.out.println("GGT-BERECHNUNG");
                    information = "Der ggT von " + (int) z1 + " und "
                            + (int) z2 + " ist: ";
                    rechenErgebnis = MathOperator.GGT.rechne(z1, z2);
                    break;
                case "mod":
                    System.out.println("MODULO-BERECHNUNG");
                    information = "Der Rest der Division der Zahl " + z1 + " durch "
                            + z2 + " [d.h. (" + z1 + ") % (" + z2 + ")] liefert : ";
                    rechenErgebnis = MathOperator.MOD.rechne(z1, z2);
                    break;
//                case default: // das wäre Unsinn
                default:
                    System.out.println("Geben Sie eine bekannte Operation ein!");
            }
            PressEnter.ToContinue();
//            this.ergebnisAnzeige(rechenErgebnis, information);
            ergebnisAnzeige(rechenErgebnis, information);
        }
    }

    void ergebnisAnzeige(double rechenErgebnis, String information) {
        System.out.print(information);
        if (!(rechenErgebnis == Global.Infinity)) {
            System.out.println("\n" + rechenErgebnis + "\n");
        } else {
            System.out.println("Die Operation ist fehlgeschlagen: Sie haben keine "
                    + "vernünftige Operation ausführen lassen oder keine (sinnvollen) "
                    + "Zahlen eingegeben!");
        }
    }
}
