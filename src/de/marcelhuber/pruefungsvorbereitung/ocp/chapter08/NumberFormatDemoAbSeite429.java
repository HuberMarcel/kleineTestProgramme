package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author Marcel Huber
 */
public class NumberFormatDemoAbSeite429 {

    private float f1 = 53453.445f;

    public static void main(String[] args) {
        NumberFormatDemoAbSeite429 dummy = new NumberFormatDemoAbSeite429();
        dummy.goElementary();
        dummy.goWithFractionDigits();
    }

    private void goElementary() {
        NumberFormat nfarray[] = new NumberFormat[6];
        Locale locDe = new Locale("de", "DE");
        Locale locFr = new Locale("fr", "CH");
        nfarray[0] = NumberFormat.getInstance();
        nfarray[1] = NumberFormat.getInstance(locDe);
        nfarray[2] = NumberFormat.getInstance(locFr);
        nfarray[3] = NumberFormat.getCurrencyInstance();
        nfarray[4] = NumberFormat.getCurrencyInstance(locDe);
        nfarray[5] = NumberFormat.getCurrencyInstance(locFr);
        for (NumberFormat nf : nfarray) {
            System.out.println(nf.format(f1));
        }
        // Hinweis: bei den Währungen wird (in sinnvoller Weise)
        //          auf die 2. Nachkommastelle gerundet
    }

    private void goWithFractionDigits() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(3);
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(f1));
        nf.setMinimumIntegerDigits(4);
        nf.setMaximumIntegerDigits(3);
        // das zuletzt gesetzte ist relevant
        System.out.println(nf.format(f1));
        System.out.println("Ausgabe von f1 wie eingegeben: " + f1);
        //
        System.out.println("Wir geben die Zahl als String ein und parsen nur "
                + "den Integeranteil!");
        String f1AsString = "" + f1;
        System.out.println("Zahl als String: " + f1AsString);
//         nf.setMaximumFractionDigits(12);
        try {
            nf.setParseIntegerOnly(true);
            System.out.println("Ausgabe von f1 mit ... .setParseIntegerOnly(true):");
            System.out.println(nf.parse(f1AsString));
            System.out.println("???????????????????");
            System.out.println("\n");
            System.out.println("Erklärung: Die Zahl ist nach der Lokalität anzugeben,"
                    + "also mit Komma anstatt Punkt!");
            System.out.println("Parsen wir mal 53453,445fgdfg (das Parsing hört bei der "
                    + "ersten unsinnigen Stelle auf):");
            System.out.println(nf.parse("53453,445fgdfg"));
            System.out.println("Jetzt haben wir die erwartete Ausgabe "
                    + ((int) f1) / 1 + "!");
            // ??? 
            // erwartet wäre die Ausgabe 53453
            // Konsole liefert 53453445
        } catch (ParseException ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}
