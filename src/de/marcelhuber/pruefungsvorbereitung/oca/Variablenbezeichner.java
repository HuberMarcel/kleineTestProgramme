package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class Variablenbezeichner {
    public int haha;
    protected String michKannManErben;
    int ichBinDefault;
    private long ichGehoereDieserKlasseAlleine;
//    int super; // super ist reserviert
//    byte this; // auch this ist reserviert
    
    public static void main(String[] args) {
        // kein Access-Level innerhalb einer Methode
//        public int ichBinEinInteger = 9;
        int ichBinEinInteger = 9; // lowerCamelCase
        String $dasGehtAuch;      // Währungszeichen sind erlaubt
        int _a_istErlaubt;
//        long :b; // das geht mal gar nicht
//        int e#; // das darf auch nicht sein
//        int double; auch das ist Nonsens
//        byte .f; // auch da meckert der Compiler
//        char 2016Variabe; // natürlich darf ich nicht mit einer Ziffer beginnen
    }
}
