// dieses Programm muss über die Konsole gestartet werden
// etwa unter J:\JAVA(DAA)__OCPJP\JAVA_OCPJP\JavaTESTs\kleineTestProgramme\build\classes>
//       dann java de.marcelhuber.pruefungsvorbereitung.ocp.formatter.StringFormatTest
//      aufrufen
package de.marcelhuber.pruefungsvorbereitung.ocp.formatter;

import de.marcelhuber.systemtools.*;
import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author Marcel Huber
 */
public class StringFormatTest {

    static private String[] formatSetzer;

    public static void main(String[] args) {
        formatSetzer = new String[]{"%1$3.2f", "%1$10.1f", "%1$10.2f",
            "%1$10.3f", "%1$10.4f", "%1$10.5f",};
        for (String format : formatSetzer) {
            System.out.format("Testen wir %" + format + " bei 123.4567: "
                    + "..." + format + "...%n", 123.4567, 456.1234);
//            PressEnter.toContinue();
        }
        // ersetzt man 1$ durch 2$, so wird die zweite Zahl benutzt

        // jetzt noch ein anderer Test
        System.out.println("\n\n");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("\n\n");
        String name = null;
        int alter;
        Console console = System.console();
        Scanner scanner = new Scanner(console.reader());
//        console.printf(" Geben Sie Ihren Namen ein: ");
        System.out.print(" Geben Sie Ihren Namen (ohne Leerzeichen!) ein: ");
        name = scanner.next();
        scanner = new Scanner(console.reader());
        System.out.print("\n Geben Sie Ihr Alter ein: ");
        while (!scanner.hasNextInt()) {
            console.printf("\n Ungültige Eingabe. Bitte erneut versuchen!");
            System.out.print("\n Geben Sie Ihr Alter ein: ");
            scanner.next();
        }
//        alter = Integer.parseInt(scanner.next());
        alter = scanner.nextInt();
        System.out.println("\n\nIhre Eingaben lieferten:");
        System.out.println(
                "    Name:  " + name);
        System.out.println(
                "    Alter: " + alter);
    }

}
