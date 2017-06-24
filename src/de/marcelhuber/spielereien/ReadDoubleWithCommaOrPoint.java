package de.marcelhuber.spielereien;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.ReadInput;

/**
 *
 * @author Marcel Huber
 */
public class ReadDoubleWithCommaOrPoint {

    static long readDoubleCounter = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ReadDoubleWithCommaOrPoint().go();
    }

    private void go() {
        double readDouble = readDouble();
        writeDouble(readDouble);
    }

    public double readDouble() {
        System.out.println(++readDoubleCounter + ". Eingabeaufforderung: ");
        System.out.print("Geben Sie eine Fließkommazahl ein: ");
        String s = ReadInput.readString();
        return parseDouble(s);
    }

    public double parseDouble(String s) {
        double x = 0;
        boolean sCannotBeParsed = false;
        NumberFormatException nFex = new NumberFormatException();
        s = s.trim();
        String[] separatedS = s.split(",");
        try {
            if (separatedS.length == 1) {
                if (s.contains(".") == false) {
                    s = separatedS[0] + ".";
                    try {
                        Long.parseLong(s);
                    } catch (NumberFormatException ex) {
                        nFex = ex;
                        sCannotBeParsed = true;
                    }
                    if (!sCannotBeParsed) {
                        zeigeHinweis();
                    }
                }
            }
            if (separatedS.length > 1) {
                try {
                    Long.parseLong(separatedS[0]);
                } catch (NumberFormatException ex) {
                    nFex = ex;
                    sCannotBeParsed = true;
                }
                if (!sCannotBeParsed) {
                    try {
                        Long.parseLong(separatedS[1]);
                    } catch (NumberFormatException ex) {
                        nFex = ex;
                        sCannotBeParsed = true;
                    }
                }
                if (!sCannotBeParsed && separatedS.length == 2) {
                    s = separatedS[0] + "." + separatedS[1];
                } else if (!sCannotBeParsed && separatedS.length > 2) {
                    sCannotBeParsed = true;
                }
                if (sCannotBeParsed) {
                    throw nFex;
                }
            }
            if ((!sCannotBeParsed && separatedS.length == 2)) {//|| (!sCannotBeParsed && separatedS.length == 1)) {
                zeigeHinweis();
            }
//            System.out.println("s vor dem Parsen: " + s);
            x = Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            System.out.println("Fehleingabe, neuer Versuch!\n");
            x = readDouble();
        }
        return x;
    }

    public void writeDouble(double d) {
        System.out.println("Ihre Eingabe war: " + d);
    }

    private void zeigeHinweis() {
        System.err.println("Das Komma (,) wurde durch einen Punkt (.) ersetzt!");
    }

}
