package de.marcelhuber.konsoleneingaben;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class KonsolenEingaben {

    public static void main(String[] args) {
        new KonsolenEingaben().goConsoleReadline();
        new KonsolenEingaben().goLongWithBufferedReader();
        new KonsolenEingaben().goScanner();
    }

    private void goConsoleReadline() {
        long eingelesenerLongWert = Long.MAX_VALUE;
        String tastaturEingabe = null;
        System.out.println("HINWEIS: In der IDE Netbeans haben wir kein Konsolenobjekt!");
        System.out.print("Geben Sie einen Long-Wert ein: ");
//        Console cons = System.console();
//        tastaturEingabe = cons.readLine();
        if (System.console() != null) {
            tastaturEingabe = System.console().readLine();
            tryToParseTastatureingabeInLong(eingelesenerLongWert, tastaturEingabe);
        } else {
            System.out.println("ABBRUCH, da keine Konsole existent!");
        }
        System.out.println("Ende der Methode: goConsoleReadline()!");
    }

    private void goLongWithBufferedReader() {
        long eingelesenerLongWert = Long.MAX_VALUE;
        String tastaturEingabe = null;
        System.out.print("Geben Sie einen Long-Wert ein: ");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            tastaturEingabe = bufferedReader.readLine();
            tryToParseTastatureingabeInLong(eingelesenerLongWert, tastaturEingabe);
        } catch (IOException ex) {
            System.out.println("Problem bei der Tastatur-Eingabe!");
        }
        System.out.println("Ende der Methode: goLongWithBufferedReader()!");
    }

    private void goScanner() {
        long eingelesenerLongWert = Long.MAX_VALUE;
        String tastaturEingabe = null;
        System.out.println("HINWEIS: In der IDE Netbeans haben wir kein Konsolenobjekt!");
        System.out.print("Geben Sie einen Long-Wert ein: ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            tastaturEingabe = sc.next();
            tryToParseTastatureingabeInLong(eingelesenerLongWert, tastaturEingabe);
        }
        System.out.println("Ende der Methode: goScanner()!");
    }

    private void tryToParseTastatureingabeInLong(long eingelesenerLongWert, String tastaturEingabe) {
        try {
            eingelesenerLongWert = Long.parseLong(tastaturEingabe);
        } catch (NumberFormatException nFex) {
            System.out.println("Eingelesene Zeile nicht in long parsebar!");
        } finally {
            System.out.println("Ihre Eingabe war:              "
                    + tastaturEingabe);
            if (eingelesenerLongWert != Long.MAX_VALUE) {
                System.out.println("Ihr long-Wert:                 "
                        + eingelesenerLongWert);
            } else {
                System.out.println("Falls Sie nicht " + Long.MAX_VALUE + " eingegeben "
                        + "haben, ist etwas schiefgelaufen!");
            }
        }
    }
}
