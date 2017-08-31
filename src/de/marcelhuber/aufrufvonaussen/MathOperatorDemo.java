package de.marcelhuber.aufrufvonaussen;

import de.marcelhuber.systemtools.PressEnter;
import de.marcelhuber.systemtools.ReadInput;
import de.marcelhuber.enumBeispiele.MathOperator;
//import de.marcelhuber.kleinetestprogramme.MathOperator;
import java.util.*;
//import jdk.nashorn.internal.objects.*;

/**
 *
 * @author Marcel Stand: 31.03.2017, 08:25 Uhr
 */
public class MathOperatorDemo {

    static private String ausrufeZeichen = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    static private final StringBuilder programmStart = new StringBuilder("PROGRAMM-START");
    static private final StringBuilder programmEnde = new StringBuilder("PROGRAMM-ENDE");

//    static List<Double> rechenZahlen = new ArrayList<>(5);
//    static Double[] rechenZahlenWerte;
    private List<Double> rechenZahlen = new ArrayList<>(5);
    private Double[] rechenZahlenWerte;

    public static void main(String[] args) {
        String[] operation = {"plus", "mINUS", "mAL", "DuRcH", "gGT", "mOd"};
        programmStartUndEndeAnpasser();
        marker();
        System.out.println(programmStart);
        marker();
        System.out.println("");
        new MathOperatorDemo().go(operation);
    }

    private void go(String[] operation) {
        boolean bool = true;

        while (bool) {
            if (rechenZahlen.size() == 0) {
                System.out.println("Geben Sie Ihre " + (rechenZahlen.size() + 1) + "e "
                        + "Zahl (von mindestens zwei) ein:");
            } else {
                System.out.println("Bisher haben Sie folgendes Zahlenfeld eingegeben:");
                System.out.println(Arrays.toString(rechenZahlenWerte));
                System.out.println("\nGeben Sie Ihre " + (rechenZahlen.size() + 1) + "e "
                        + "Zahl ein:");
            }
            rechenZahlen.add(ReadInput.readDouble());
            makeOurDoubleArrayListToOurDoubleArray();
            System.out.print("\nWollen Sie eine weitere Zahl eingeben (J/N): ");
            try {
                bool = !(ReadInput.readString().substring(0, 1).toLowerCase().equals("n"));
            } catch (StringIndexOutOfBoundsException strEx) {
            } finally {
                System.out.println("[HINWEIS: Nur, wenn der erste Buchstabe ein "
                        + "N oder ein n ist, wird abgebrochen!]");
            };
        }

        int counter = 0;
        double z1 = rechenZahlenWerte[0];
        double summe = z1, minus = z1, mal = z1, durch = z1, ggT = z1, mod = z1;
        double summeAlt = z1, minusAlt = z1, malAlt = z1, durchAlt = z1,
                ggTAlt = z1, modAlt = z1;
        double z2;
        double dummy;
        while (counter < rechenZahlenWerte.length - 1) {
            z2 = rechenZahlenWerte[++counter];
//            double rechenErgebnis = Global.Infinity;
            double rechenErgebnis = Double.POSITIVE_INFINITY;
            String information = "";
            for (String operation1 : operation) {
                switch (operation1.toLowerCase()) {
                    case "plus":
                        summeAlt = summe;
                        if (counter == 1) {
                            System.out.println("");
                        }
                        System.out.println("ADDITION");
                        z1 = summe;
                        information = "Addition von " + z1 + " und "
                                + z2 + " [d.h. (" + z1 + ") + (" + z2 + ")] liefert: ";
                        summe = MathOperator.PLUS.rechne(z1, z2);
                        rechenErgebnis = summe;
                        break;
                    case "minus":
                        minusAlt = minus;
                        z1 = minus;
                        System.out.println("SUBTRAKTION");
                        information = "Subtraktion der Zahl " + z2 + " von "
                                + z1 + " [d.h. (" + z1 + ") - (" + z2 + ")] liefert: ";
                        minus = MathOperator.MINUS.rechne(z1, z2);
                        rechenErgebnis = minus;
                        break;
                    case "mal":
                        malAlt = mal;
                        z1 = mal;
                        System.out.println("MULTIPLIKATION");
                        information = "Multiplikation von " + z1 + " mit "
                                + z2 + " [d.h. (" + z1 + ") * (" + z2 + ")] liefert: ";
                        mal = MathOperator.MAL.rechne(z1, z2);
                        rechenErgebnis = mal;
                        break;
                    case "durch":
                        durchAlt = durch;
                        z1 = durch;
                        System.out.println("DIVISION");
                        information = "Dividiert man die Zahl " + z1 + " durch "
                                + z2 + " [d.h. (" + z1 + ") / (" + z2 + ")], so erhält man: ";
                        durch = MathOperator.DURCH.rechne(z1, z2);
                        rechenErgebnis = rechenErgebnis;
                        break;
                    case "ggt":
                        ggTAlt = ggT;
                        z1 = ggT;
                        System.out.println("GGT-BERECHNUNG");
                        information = "Der ggT von " + (int) z1 + " und "
                                + (int) z2 + " ist: ";
                        ggT = MathOperator.GGT.rechne(z1, z2);
                        rechenErgebnis = ggT;
                        break;
                    case "mod":
                        modAlt = mod;
                        z1 = mod;
                        System.out.println("MODULO-BERECHNUNG");
                        information = "Der Rest der Division der Zahl " + z1 + " durch "
                                + z2 + " [d.h. (" + z1 + ") % (" + z2 + ")] liefert : ";
                        mod = MathOperator.MOD.rechne(z1, z2);
                        rechenErgebnis = mod;
                        break;
//                case default: // das wäre Unsinn
                    default:
                        System.out.println("Geben Sie eine bekannte Operation ein!");
                }
                //PressEnter.toContinue();
//            this.ergebnisAnzeige(rechenErgebnis, information);
                ergebnisAnzeige(rechenErgebnis, information);
            }
            z1 = rechenErgebnis;
            System.out.println("Sie haben folgende " + rechenZahlenWerte.length
                    + " Zahlen eingegeben:");
            System.out.println(Arrays.toString(rechenZahlenWerte));
            System.out.println("(HINWEIS: Unsinnige Eingaben wurden zu 0.0 "
                    + "formatiert!)\n");
            if (counter < rechenZahlenWerte.length - 1) {
                System.out.print("Nach dem " + counter + ". Durchlauf erhalten wir "
                        + "folgende E");
            } else {
                System.out.print("Letzter Durchlauf (" + counter + ") liefert die Ende");
            }
            if (counter == 1) {
                rechenZahlen.remove(0);
            }
            dummy = rechenZahlen.remove(0);

            System.out.println("rgebnisse zusammengefasst:"
                    + "\nSumme:             " + summe
                    + outputHelper(summeAlt, dummy)
                    + ";\nSubtraktion:       " + minus
                    + outputHelper(minusAlt, dummy)
                    + ";\nMultiplikation:    " + mal
                    + outputHelper(malAlt, dummy)
                    + ";\nDivision:          " + durch
                    + outputHelper(durchAlt, dummy)
                    + ";\nGgT:               " + ggT
                    + outputHelper((int) ggTAlt, (int) dummy)
                    + ";\nRest der Division: " + mod
                    + outputHelper(modAlt, dummy)
                    + ";");
            if (counter < rechenZahlenWerte.length - 1) {
                PressEnter.toContinue();
            } else {
                System.out.println("");
                marker();
                System.out.println(programmEnde);
                marker();
            }
//            System.out.println("Größe der rechenZahlenArrayList:"+ rechenZahlen.size());
//            PressEnter.toContinue();
        }
    }

    static void programmStartUndEndeAnpasser() {
        ausrufeZeichen += ausrufeZeichen + "!";
        int i = ausrufeZeichen.length() - programmEnde.length();
        for (int j = 0; j < i / 2; j++) {
            programmStart.insert(0, " ");
            programmStart.insert(programmStart.length(), " ");
            programmEnde.insert(0, " ");
            programmEnde.insert(programmEnde.length(), " ");
        }
    }

    void ergebnisAnzeige(double rechenErgebnis, String information) {
        System.out.print(information);
//        if (!(rechenErgebnis == Global.Infinity)) {
        if (!(rechenErgebnis == Double.POSITIVE_INFINITY)) {
            System.out.println("\n" + rechenErgebnis + "\n");
        } else {
            System.out.println("Die Operation ist fehlgeschlagen: Sie haben keine "
                    + "vernünftige Operation ausführen lassen oder keine (sinnvollen) "
                    + "Zahlen eingegeben!");
        }
    }

    static void marker() {
        System.out.println(ausrufeZeichen);
    }

    void makeOurDoubleArrayListToOurDoubleArray() {
        rechenZahlenWerte = new Double[rechenZahlen.size()];
        rechenZahlenWerte = rechenZahlen.toArray(rechenZahlenWerte);
    }

    static String outputHelper(double x, double y) {
        return ",    der Zahlen: " + x + " und " + y;
    }
}
