package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class BoxingPrimitiveDatentypen {

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new BoxingPrimitiveDatentypen().go();
    }

    private void go() {
        double d = 10.33D;
        Long lo = (long) d;    // funktioniert
//        lo = (Long) d;    // funktioniert nicht 
        byte b = -121;
//        lo = b;             // funktioniert nicht
        lo = (long) b;        // funktioniert
        System.out.printf("%6.2f%n", d);
//        System.out.printf("%6.2d", b);   // IllegalFormatPrecisionException
        System.out.printf("%6d%n", b);
//        System.out.printf("%6.2d", lo);
        System.out.printf("%6d", lo);
        System.out.println("");
        System.out.println('\u0000');
        System.out.printf("Ausgabe des Literals 0263  als Zahlenwert"
                + "im Dezimalsystem (2*8^2+6*8+3=128+48+3=179):       %5d%n", 0263);     // 2*8^2+6*8+3=128+48+3=179 
        System.out.printf("Ausgabe des Literals 0xA95 als Zahlenwert"
                + "im Dezimalsystem (10*16^2+9*16+5=2560+144+5=2709): %5d%n", 0xA95);    // 10*16^2+9*16+5=2560+144+5=2709 
        System.out.println((byte) 130);
        byte by = 127;
        short sh = Short.MAX_VALUE;
//        sh = sh + by;     // geht nicht, da sh+by vom Typ int ist
        int a = (int) 32.55;   
        sh += by;
        System.out.println(sh);
    }
}
