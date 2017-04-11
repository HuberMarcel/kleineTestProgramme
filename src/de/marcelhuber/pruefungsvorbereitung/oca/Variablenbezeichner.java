package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class Variablenbezeichner {
//   const und goto sind Schlüsselwörter ohne Fkt. in Java!!
    public int haha;
    protected String michKannManErben;
    int ichBinDefault;
    private long ichGehoereDieserKlasseAlleine;
    transient byte test;
// Midifier transient besagt: Variable gehört
// nicht zum Objekt
//    int super; // super ist reserviert
//    byte this; // auch this ist reserviert

    public static void main(String[] args) {
        // kein Access-Level innerhalb einer Methode
//        public int ichBinEinInteger = 9;
        int ichBinEinInteger = 9; // lowerCamelCase
        String $dasGehtAuch;      // Währungszeichen sind erlaubt
        int _a_istErlaubt;
//        char default; // reserviertes Schlüsselwort
//        const TEST;  Konstanten mit final (static)
//        long :b; // das geht mal gar nicht
//        int e#; // das darf auch nicht sein
//        int double; auch das ist Nonsens
//        byte .f; // auch da meckert der Compiler
//        char 2016Variabe; // natürlich darf ich nicht mit einer Ziffer beginnen
//        int strictfp;  // das ist auch nicht erlaubt, da eine Klasse damit
        // strikt nach der IEEE-Norm rechnen soll
//        long goto; // das ist ein rein reserviertes Keyword und darf damit nicht
//                   // verwendet werden
//        transient String test; // der Modifier transient ergibt hier keinen Sinn
//        Integer volatile; // volatile ist ein Modifier, der signalisieren soll,
//                          // dass fremde Prozesse den Variablenwert ändern können
        new Variablenbezeichner().go();
    }

    private void go() {
        this.test = 3;
    }
}
