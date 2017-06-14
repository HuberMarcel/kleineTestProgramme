package de.marcelhuber.spielereien;
// Aus dem entsprechenden classes-Ordner in der Windows-Konsole
// java de.marcelhuber.spielereien.MitWindowsKonsolenaufrufInDateiSchreiben > Test.txt
// aufrufen

/**
 *
 * @author Marcel Huber
 */
public class MitWindowsKonsolenaufrufInDateiSchreiben {

    public static void main(String[] args) {
        System.out.println("Aus dem entsprechenden classes-Ordner in der Windows-Konsole \n"
                + "    java de.marcelhuber.spielereien.MitWindowsKonsolenaufrufInDateiSchreiben > Test.txt\n"
                + "aufrufen (die Test.txt-Datei findet sich dann in eben diesem Ordner)!");
        System.out.println("Hinweis: Mit >> anstatt > wird Text in der Datei \"drangehängt\"!");
        System.out.println("Das ist ein Test!");
    }
}
