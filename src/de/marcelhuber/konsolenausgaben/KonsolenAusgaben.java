package de.marcelhuber.konsolenausgaben;
// dieses Programm auch mal auf der Windows-Konsole ausführen!!
//
// java de.marcelhuber.konsolenausgaben.KonsolenAusgaben vom classes-Ordner
// ausgehend aufrufen 

import java.io.Console;

/**
 *
 * @author Marcel Huber
 */
public class KonsolenAusgaben {

    public static void main(String[] args) {
        System.out.println("Wir testen hier Umlaute etc: ÄÖÜäöüß...");
        Console cons = System.console();
        if (!(cons == null)) {
            cons.printf("Wir testen hier Umlaute etc: ÄÖÜäöüß...%n");
        }
    }
}
