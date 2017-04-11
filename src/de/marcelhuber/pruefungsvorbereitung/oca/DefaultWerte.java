package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class DefaultWerte {
//    final byte b; 
    // geht nicht, wenn nicht an anderer Stelle ein
    // Wert initialisiert wird 
//    { b = 3;} so würde es gehen

    private byte b;
    private short s;
    private int i;
    private long ell;
    private float f;
    private double d;
    private char c;
    private boolean bool;

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        DefaultWerte dummy = new DefaultWerte();
        dummy.go();
        System.out.printf("%n" + dummy.getClass());
    }

    private void go() {
        ausgabe("byte:     " + b);
        ausgabe("short:    " + s);
        ausgabe("int:      " + i);
        ausgabe("long      " + ell);
        ausgabe("float:    " + f);
        ausgabe("double:   " + d);
        ausgabe("char:     " + c + "(\\u0000 - Null-Character)");
        ausgabe("boolean:  " + bool);
//        Integer test = new Integer("3");
//        System.out.println("" + test);
    }

    private void ausgabe(String s) {
        System.out.println("Initialwert einer Variablen vom Typ " + s);
    }
}
