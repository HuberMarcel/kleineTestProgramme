package de.marcelhuber.pruefungsvorbereitung.oca;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber
 */
public class BesondereHinweise {

    public static void main(String[] args) {
//        new BesondereHinweise().wrapperMethode();
        new BesondereHinweise().kurzSchlussOperatoren();
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
        System.out.println("Byte byteWrapper01 = new Byte((byte) 42):     " + byteWrapper01);
        System.out.println("               ... = 23:                      " + byteWrapper02);
        System.out.println("               ... = new Byte(byteWrapper01): " + byteWrapper03);
//        Byte byteWrapper04 = new Byte("128");                // erzeugt eine NumberFormatException: Value out of range
//        System.out.println(byteWrapper04); 
        System.out.println("               ... = new Byte((byte) 128):    " + byteWrapper05);
        Byte byteWrapper06 = new Byte("-120");
        System.out.println("               ... = new Byte(\"-120\"):        " + byteWrapper06);
        System.out.println("");
        Marker.marker();
        System.out.println("Hinweis: Byte-Literale sind Int-Literale im Bereich von "
                + Byte.MIN_VALUE + " bis " + Byte.MAX_VALUE);
        System.out.println("Dies sollte man auch bei der Byte-Erzeugung mit einem String "
                + "beachten!");
        Marker.marker();
    }

    void kurzSchlussOperatoren() {
        int x = 3;
        int y = 7;
        System.out.println("Jetzt ist: x=" + x + " und y=" + y + "!");
        if (x <= 5 & ++y < 9) {
            System.out.println("x war nicht größer als 5 "
                    + "und y war nicht größer als 8.");
        }
        System.out.println("");
        x = 4;
        y = 8;
        System.out.println("Jetzt setzen wir: x=" + x + " und y=" + y + "!");
        if (x <= 5 & ++y < 9) {
            System.out.println("x war nicht größer als 5 "
                    + "und y war nicht größer als 8.");
        }
        System.out.println("Jetzt ist: x=" + x + " und y=" + y + "!");
        System.out.println("");
        System.out.println("");
        x = 4;
        y = 8;
        System.out.println("Jetzt setzen wir: x=" + x + " und y=" + y + "!");
        if (x <= 5 & y++ < 9) {
            System.out.println("x war nicht größer als 5 "
                    + "und y war nicht größer als 9.");
        }
        System.out.println("Jetzt ist: x=" + x + " und y=" + y + "!");
        System.out.println("");
        x = 4;
        y = 8;
        System.out.println("Jetzt setzen wir: x=" + x + " und y=" + y + "!");
        if (x < 4 & ++y < 9) {
            System.out.println("x war nicht größer als 5 "
                    + "und y war nicht größer als 9.");
        }
        System.out.println("Jetzt ist (kein Kurzschluss-UND): x=" + x + " und y=" + y + "!");
        System.out.println("");
        x = 4;
        y = 8;
        System.out.println("Jetzt setzen wir: x=" + x + " und y=" + y + "!");
        if (x < 4 && ++y < 9) {
            System.out.println("x war nicht größer als 5 "
                    + "und y war nicht größer als 9.");
        }
        System.out.println("Jetzt ist (MIT Kurzschluss-UND): x=" + x + " und y=" + y + "!");
        System.out.println("");
        //
        int i = 0;
        System.out.println("Beispiel aus Buch (Seite 312) "
                + "ohne Änderung [i=" + i + "]".toUpperCase());
        y = 5;
        x = 2;
        if ((x > 3) && (y < 2) | doStuff()) {
            System.out.println("true");
        }
        System.out.println("x=" + x + "; y=" + y);         // x=2, y=5
        System.out.println("");
        System.out.println("Beispiel aus Buch (Seite 312), " + ++i + ". Änderung".toUpperCase());
        y = 5;
        x = 2;
        if ((x++ > 3) && (y++ < 2) | doStuff()) {
            System.out.println("true");
        }
        System.out.println("x=" + x + "; y=" + y);             // x=3, y=5  [i=1]
        System.out.println("");
        System.out.println("Beispiel aus Buch (Seite 312), " + ++i + ". Änderung".toUpperCase());
        y = 5;
        x = 2;
        if ((x++ > 3) && (y++ < 2) || doStuff()) {             // (x > 3 && y < 2) || doStuff()
            System.out.println("x=" + x + "; y=" + y);         // x=3, y=5  [i=2]
            System.out.println("true");
        }
        System.out.println("");
        System.out.println("Beispiel aus Buch (Seite 312), " + ++i + ". Änderung".toUpperCase());
        y = 5;
        x = 2;
        if ((++x > 3) & (++y < 2) | doStuff()) {               // (x > 3 & y < 2) | doStuff()
            System.out.println("x=" + x + "; y=" + y);         // x=3, y=6  [i=3]
            System.out.println("true");
        }
        System.out.println("");
        System.out.println("Beispiel aus Buch (Seite 312), " + ++i + ". Änderung".toUpperCase());
        y = 5;
        x = 2;
        if ((++x > 3) & (++y < 2) || doStuff()) {              // (x > 3 & y < 2) | doStuff()
            System.out.println("x=" + x + "; y=" + y);         // x=3, y=6  [i=4]
            System.out.println("true");
        }
        System.out.println("");
        System.out.println("Beispiel aus Buch (Seite 312), " + ++i + ". Änderung".toUpperCase());
        y = 5;
        x = 2;
        if ((++x > 3) && (++y < 2) || doStuff()) {             // (x > 3 && y < 2) || doStuff()
            System.out.println("x=" + x + "; y=" + y);         // x=3, y=5  [i=5]
            System.out.println("true");
        }
        System.out.println("");
        System.out.println("Beispiel aus Buch (Seite 312), " + ++i + ". Änderung".toUpperCase());
        y = 5;
        x = 2;
        if ((++x > 3) && (++y < 2) && doStuff()) {             // (x > 3 && y < 2) && doStuff()
            System.out.println("true");
        }
        System.out.println("x=" + x + "; y=" + y);             // x=3, y=5
        System.out.println("");
        System.out.println("Erwartungen: i=0: x=2, y=5");
        System.out.println("Erwartungen: i=1: x=3, y=5");
        System.out.println("Erwartungen: i=2: x=3, y=5");
        System.out.println("Erwartungen: i=3: x=3, y=6");
        System.out.println("Erwartungen: i=4: x=3, y=6");
        System.out.println("Erwartungen: i=5: x=3, y=5");
        System.out.println("Erwartungen: i=6: x=3, y=5");
        System.out.println("");
        System.out.println("");
        i = 0;
        System.out.println("Anscheinend \"spaltet\" && bei nachfolgendem & oder |");
        boolean b1 = false, b2 = false, b3 = false;
        if ((b1 = true) && (b2 == false) | (b3 = true)) {
            System.out.println("i=" + ++i);
        };                                                     // b1=true, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = false;
        b2 = false;
        b3 = false;
        if ((b1 = true) & (b2 = false) | (b3 = true)) {
            System.out.println("i=" + ++i);
        };                                                     // b1=true, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = false;
        b2 = false;
        b3 = false;
        if ((b1 == true) || (b2 == true) & (b3 = true)) {    // b1==true ODER (b2==true & b3=true)
            System.out.println("i=" + ++i);
        };                                                     // b1=false, b2=false, b3=true + keine Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = false;
        b2 = false;
        b3 = false;
        if ((b1 = true) & (b2 == b1) || (b3 = true)) {
            System.out.println("i=" + ++i);
        };                                                     // b1=true, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = false;
        b2 = false;
        b3 = false;
        if ((b1 = true) & ((b2 == b1) || (b3 = true))) {
            System.out.println("i=" + ++i);
        }                                                      // b1=true, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = true;
        b2 = false;
        b3 = false;
        if ((b1 = false) & (b2 == b1) || (b3 = true)) {
            System.out.println("i=" + ++i);
        }                                                       // b1=false, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = true;
        b2 = false;
        b3 = false;
        if ((b1 = false) & ((b2 == b1) || (b3 = true))) {
            System.out.println("i=" + ++i);
        }                                                      // b1=false, b2=false, b3=false + keine Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = true;
        b2 = false;
        b3 = false;
        if ((b1 = false) & ((b2 == b1) | (b3 = true))) {
            System.out.println("i=" + ++i);
        }                                                      // b1=false, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = true;
        b2 = false;
        b3 = false;
        if ((b1 = false) & (b2 == b1) | (b3 = true)) {
            System.out.println("i=" + ++i);
        }                                                      // b1=false, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = true;
        b2 = false;
        b3 = false;
        if ((b1 = false) & ((b2 == b1) | (b3 = true))) {
            System.out.println("i=" + ++i);
        }                                                      // b1=false, b2=false, b3=true + KEINE Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = true;
        b2 = false;
        b3 = false;
        if (((b1 = false) & (b2 == b1)) | (b3 = true)) {
            System.out.println("i=" + ++i);
        }                                                      // b1=false, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = false;
        b2 = false;
        b3 = false;
        if (b1 = true || b2 & (b3 = true)) {
            System.out.println("i=" + ++i);
        }                                                      // b1=true, b2=false, b3=false + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
        b1 = false;
        b2 = false;
        b3 = false;
        if ((b1 = true || b2) & (b3 = true)) {
            System.out.println("i=" + ++i);
        }                                                      // b1=true, b2=false, b3=true + Ausgabe
        System.out.println("b1=" + b1 + ",  b2=" + b2 + ",  b3=" + b3);
    }

    Boolean doStuff() {
        return true;
    }
}
