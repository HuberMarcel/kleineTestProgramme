package de.marcelhuber.pruefungsvorbereitung.ocp.chapter09;
// WICHTIG: Man beachte, dass die Methoden zum Schreiben in eine Datei
//          eine CHECKED-Exception, nämlich eine IOException, werfen 
//          können --> handle oder declare 
//
// Beim Reader ist eine FileNotFoundException beachtenswert

import de.marcelhuber.systemtools.Marker;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class Writer01 {

    File neuerFileZumTesten;

    public static void main(String[] args) {
        Writer01 dummy = new Writer01();
        Marker.marker('_');
        dummy.goWrite();
        System.out.println("");
        Marker.marker('_');
        dummy.goRead();
        System.out.println("");
        Marker.marker('_');
        dummy.goReadWithBuffer();
    }

    private void goWrite() {
        System.out.println(("Wir legen eine neue Datei an und schreiben etwas "
                + "in diese hinein!").toUpperCase());
        neuerFileZumTesten = new File("neuerFileZumTesten.txt");
        try {
            neuerFileZumTesten.createNewFile();
            FileWriter fw = new FileWriter(neuerFileZumTesten);
            fw.write("Ich bin ein Test-String, und ich schreibe mich in die Datei " + neuerFileZumTesten);
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Writer01.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Die neu erzeugte Datei "
                + "\t" + neuerFileZumTesten.toString() // das toString() braucht man nicht
                + "\nbefindet sich an folgender Stelle:");
        System.out.println(neuerFileZumTesten.getAbsolutePath());
//        System.out.println(neuerFileZumTesten);                           // s.o.: das toString() braucht man nicht
    }

    private void goRead() {
        System.out.println(("Wir lesen die Datei nun Zeichen für Zeichen aus "
                + "und geben die gelesenen Zeichen aus!").toUpperCase());
        long c;
        try {
            FileReader fr = new FileReader(neuerFileZumTesten);
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println("");
        } catch (IOException ioEx) {
            System.err.println("Exception: " + ioEx);
            ioEx.printStackTrace();
        }
    }

    private void goReadWithBuffer() {
        System.out.println(("Wir bufferen immer 10 Zeichen und geben diese dann, "
                + "damit das erkennbar ist, zeilenweise aus!").toUpperCase());
        char[] geleseneZeichen = new char[10];
        try {
            FileReader fr = new FileReader(neuerFileZumTesten);
            while (fr.read(geleseneZeichen) != -1) {
                System.out.println(geleseneZeichen);
            }
        } catch (IOException ioEx) {
            System.err.println("Exception: " + ioEx);
            ioEx.printStackTrace();
        }
    }
}
