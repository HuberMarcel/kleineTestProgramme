package de.marcelhuber.pruefungsvorbereitung.oca;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber
 */
public class BesondereHinweise {

    public static void main(String[] args) {
        new BesondereHinweise().wrapperMethode();
    }

    void wrapperMethode() {
        // 4 Wege zur Erzeugung eines Wrapper-Pool-Objekts
        // der primitiven
        // Boxing
//        Byte byteWrapper01 = new Byte(42);               // 42 ist kein byte-Literal
        Byte byteWrapper01 = new Byte((byte) 42);          // 42 ist kein byte-Literal
        Byte byteWrapper02 = 23;                           // technisch wie new Byte((byte) 23)
//        Byte byteWrapper03 = 23L;                          // kein Long-Literal 
        Byte byteWrapper03 = new Byte(byteWrapper01);      // das mag der Compiler auch
//        Byte byteWrapper04 = new Byte("");                 // erzeugt eine NumberFormatException
//        System.out.println(byteWrapper04);                 // s.o.
        Byte byteWrapper05 = new Byte((byte) 128);           // hier kommt -2^7 (=-2^8/2) raus
        System.out.println("Byte byteWrapper01 = new Byte((byte) 42):     "+byteWrapper01);
        System.out.println("               ... = 23:                      "+byteWrapper02);
        System.out.println("               ... = new Byte(byteWrapper01): "+byteWrapper03);
//        Byte byteWrapper04 = new Byte("128");                // erzeugt eine NumberFormatException: Value out of range
//        System.out.println(byteWrapper04); 
        System.out.println("               ... = new Byte((byte) 128):    "+byteWrapper05);
        Byte byteWrapper06 = new Byte("-120");
        System.out.println("               ... = new Byte(\"-120\"):        "+byteWrapper06);
        System.out.println("");
        Marker.marker();
        System.out.println("Hinweis: Byte-Literale sind Int-Literale im Bereich von "
                + Byte.MIN_VALUE+" bis "+Byte.MAX_VALUE);
        System.out.println("Dies sollte man auch bei der Byte-Erzeugung mit einem String "
                + "beachten!");
        Marker.marker();
    }
}
