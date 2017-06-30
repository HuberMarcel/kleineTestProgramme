package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

/**
 *
 * @author Marcel Huber
 */
public class PrintfAndFormatSeite452 {

    public static void main(String[] args) {
        long i1 = -123;
        long i2 = 12_345;
        // klammere negative digits; 3d: mindestens 3 Stellen bereitstellen
        System.out.printf("\"%1$(3d\"\n", i1);
        System.out.printf("\"%1$(3d\"\n", i2);
        // klammere negative digits; 7d: mindestens 7 Stellen bereitstellen
        System.out.printf("\"%1$(7d\"\n", i1);
        System.out.printf("\"%1$(7d\"\n", i2);
        // schreibe die Zahlen linksbündig und reserviere mindestens 7 Stellen
        System.out.printf("\"%1$-7d\"\n", i1);
        System.out.printf("\"%1$-7d\"\n", i2);
        // schreibe die Zahlen mit mindestens 7 Stellen und fülle ggf. mit 0 vorneweg auf
        System.out.printf("\"%1$07d\"\n", i1);
        System.out.printf("\"%1$07d\"\n", i2);
    }
}
