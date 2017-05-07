package de.marcelhuber.pruefungsvorbereitung.oca;

import de.marcelhuber.systemtools.Marker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Marcel Huber
 */
public class BesondereHinweise {

    private String intToShadow;

//    static private Integer intToShadow;          // gleicher Variablenname für statische Variable geht nicht
    public static void main(String[] args) {
//        new BesondereHinweise().wrapperInformations();
//        new BesondereHinweise().kurzSchlussOperatoren();
//        new BesondereHinweise().switchStatements();
//        new BesondereHinweise().shadowing();
        new BesondereHinweise().arrays();
    }

    void wrapperInformations() {
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
        System.out.println("");
        System.out.println("");
        String numberAsString = "586";
        System.out.println(new Integer(numberAsString) + 4);
        Integer newInt = new Integer(286);                     // unneccessary Boxing
        System.out.println(newInt.parseInt(numberAsString));   // Compiler macht Integer.parseInt daraus
        System.out.println(newInt.valueOf(2 * 33));              // Compiler macht Integer.parseInt daraus
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

    void switchStatements() {
//        long doubleIntMaxValue = 2 * Integer.MAX_VALUE;
//        long doubleIntMaxValue = (long) (Integer.MAX_VALUE + Integer.MAX_VALUE);
//        long doubleIntMaxValue = (int) (2*(long) (Integer.MAX_VALUE));
        long doubleIntMaxValue = (long) (2 * Integer.MAX_VALUE);
//        //
//        doubleIntMaxValue = 0b111;     // 7
//        doubleIntMaxValue = 0b1;       // 1
//        doubleIntMaxValue = 0x11;      // 17
//        doubleIntMaxValue = 011;       // 9
//        doubleIntMaxValue = -2;        // -2
//        doubleIntMaxValue = 0x1;       // 1
//        doubleIntMaxValue = 01;        // 1
//        doubleIntMaxValue = 0b1;       // 1
//        doubleIntMaxValue = 1;       // 1
//        //
//        System.out.println(doubleIntMaxValue);
//        switch (doubleIntMaxValue) {                           // dort dürfen maximal int in Klammern stehen
//            case 1:;
//            default:;
//        }
        switch ((int) doubleIntMaxValue) {
            case 1:
                System.out.println("Mein Wert ist 1...");
                break;
            case -2:
                System.out.println("Hahaha, jetzt bin ich ein int-Wert: "
                        + (int) doubleIntMaxValue + "...");
                break;
            default:
                System.out.println("Mein Wert ist weder 1 noch -2, sondern "
                        + doubleIntMaxValue + "...");
                break;
        }

//        switch (int j=1) {                                      // verboten
//        case 1:
//                System.out.println("");
//        }
    }

    void shadowing() {
        System.out.println("Der (Initial-)Wert der Variablen intToShadow: "
                + this.intToShadow);
        int intToShadow = 42;
        intToShadow *= 2;
//        for (int intToShadow = 0; intToShadow < 42; ++intToShadow) {  // das geht so nicht - lokale Variablenname schon vergeben
//            System.out.println("Hahahah");
//        }
        {
            // Auch hier ist alles von außen sichtbar, nur neue Variablen sind innerhalb des Scopes durch {} "gefangen"
            int ichBinImBlock = 42;
            System.out.println("intToShadow-Wert nach ++intToShadow: " + ++intToShadow);
            System.out.println("ichBinImBlock hat den Wert: " + ichBinImBlock);
        }
        System.out.println("intToShadow-Wert: " + intToShadow);
//            System.out.println("ichBinImBlock hat den Wert: "+ichBinImBlock);            // hier nicht mehr sichtbar
        for (int i = 0;; i += 1) {
            System.out.println("i=" + ++i);   // für i=100 --> Ausgabe 101
            System.out.println("i=" + i);     // nochmal Ausgabe 101
            System.out.println("");
            if (i > 100) {
                break;                        // für i=100 wurde i auf 101 gesetzt: break
            }
        }
        for (int i = 0;; i += 1) {
            System.out.println("i=" + i++);   // für i=100 --> Ausgabe 100
            System.out.println("i=" + i);     // nun Ausgabe 101
            System.out.println("");
            if (i > 100) {
                break;                        // für i=100 wurde i auf 101 gesetzt: break
            }
        }
//        System.out.println(i);                                 // i ist out of scope
    }

    void arrays() {
        int[] intArray = new int[3];
        // das Objekt rechterhand legt ein Array-Objekt für 3 int-Werte an (Heap)
        // die Variable linkerhand sagt nur, dass auf ein Array of int verwiesen wird
        intArray = new int[12];                 // legal
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (byte) 3 * i;           // erlaubt: widening
        }
        String ausgabe = "Ausgabe";
        System.out.println(ausgabe.toUpperCase() + " (Wortlänge: " + ausgabe.length() + ")");
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(i + ". Feldeintrag: " + intArray[i]);
        }
        System.out.println("Merke: Ein String hat 'ne length()-Methode, während ein "
                + "A(!)rray ein A(!)ttribut für die Länge hat!");
        char[] test = new char[7];
        test = new char[]{'H', 'a', 'l', 'l', 79 + 26 + 6, 90, 90, 90, 90, 90, 91, 92, 93};
//        System.out.println((int) 'a'- (int) 'A');   // 32=26+6

        System.out.println(test);                              // Ausgabe des Arrays of Char
        System.out.println(test.length);
        System.out.println(test.toString());                   // wandelt NICHT automatisch das test-Objekt in einen String
        // man erinnere sich, was die String toString()-Methode macht
        System.out.println(test.toString().length());
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(intArray));
        List <Integer> intArrayAsList = new ArrayList<>();
        for (int i = 0; i < intArray.length; i++) {
            intArrayAsList.add(intArray[i]);
        }
        System.out.println(intArrayAsList);
    }

    Boolean doStuff() { // just a function which returns new Boolean(true);
        return true;
    }

    public String getIntToShadow() {
        return intToShadow;
    }

    public void setIntToShadow(String intToShadow) {
        this.intToShadow = intToShadow;
    }
}
