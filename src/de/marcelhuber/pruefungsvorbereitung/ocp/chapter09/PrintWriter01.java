package de.marcelhuber.pruefungsvorbereitung.ocp.chapter09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class PrintWriter01 {

    private File aFileForPrintWriter;
    private PrintWriter pw;
    static private final double PI_GERUNDET_AUF_DREI_STELLEN = 3.1415;

    public static void main(String[] args) {
        new PrintWriter01().goPrintWriter();
    }

    private void goPrintWriter() {
        aFileForPrintWriter = new File("aFileForPrintWriter.txt");
        try {
            pw = new PrintWriter(aFileForPrintWriter);
            // pw.write("...") BRAUCHT pw.flush()
            pw.printf("Ich bin ein  String für den PrintWriter, der nun einfach "
                    + "mal testweise in die Datei " + aFileForPrintWriter + "%n"
                    + "geschrieben wird. Klingt komisch, ist aber so! Ich will "
                    + "auch mal einen Double-Wert"
                    + " anlegen: %1$2.2f%nWeiter in "
                    + "einer neuen Zeile...", PI_GERUNDET_AUF_DREI_STELLEN);
            pw.flush();
            pw.close();
            FileWriter fw = new FileWriter(aFileForPrintWriter, true);
            // \n\n sorgt anscheinend nicht für Zeilenumbrüche
            fw.write(String.format("\n\nIch bin ein Text, der am Ende der Datei angehangen wurde!")
                    .toUpperCase());
            fw.flush();
            fw.close();
//            // Das folgende bringt so nichts ... pw.append() dient anscheinend nur dazu,
//            // während des Schreibvorgangs in einer Datei dann am Ende noch einen
//            // abschließenden Text "zu setzen". Wenn die Datei neu angelegt wird,
//            // wird sie automaischt geleert und die append()-Methode sorgt für den
//            // einziegen Texteintrag in dieser Textdatei!
//            pw = new PrintWriter(aFileForPrintWriter);
//            pw.append("Ich hänge mich mit dem PrintWriter mal testweise ans Ende dran!".toUpperCase());
//            pw.flush();
//            pw.close();
            // Eigentlich soll die Textdatei, wie sie jetzt vorhanden ist, nochmal
            // geöffnet werden und der Text 
            // "Ich hänge mich mit dem PrintWriter mal testweise ans Ende dran!".toUpperCase())
            // ans Ende der Datei geschrieben werden!
            fw = new FileWriter(aFileForPrintWriter, true);
            fw.write(String.format("%nHängen wir nochmal PI auf zwei Nachkommastellen "
                    + "gerundet an: %1$3.2f: ", PI_GERUNDET_AUF_DREI_STELLEN).toUpperCase());
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(PrintWriter01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
