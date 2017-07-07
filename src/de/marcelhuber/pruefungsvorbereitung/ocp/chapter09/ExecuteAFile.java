package de.marcelhuber.pruefungsvorbereitung.ocp.chapter09;
// Konsolenaufruf unter Windows: java -cp build/classes de.marcelhuber.pruefungsvorbereitung.ocp.chapter09.ExecuteAFile

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class ExecuteAFile {

    Path file;

    {
        file = Paths.get("PrimzahlzwillingeFinder_Start.bat");
    }

    public static void main(String[] args) {
        new ExecuteAFile().go();
    }

    private void go() {
        System.out.println(new File("").getAbsolutePath());
        System.out.println("Ist der File " + file + " ausführbar? "
                + "Analyse-Ergebnis: " + Files.isExecutable(file));
        System.out.println("Was sagt die Objekt-Methode? Analyse-Ergebnis: "
                + "                              " + file.toFile().canExecute());
        if (!Files.isExecutable(file)) {
            file.toFile().setExecutable(true);
        }
        try {
            System.out.println(file.toString());
//            System.out.println(file.toString().substring(0, file.toString().length()-4));
            // es stellt sich noch die Frage, ob bzw. wie man den File
            // mithilfe von Java starten kann
//            Runtime.getRuntime().exec(file.toString().substring(0, file.toString().length() - 4));
            Runtime.getRuntime().exec(file.toString());
        } catch (IOException ioEx) {
            System.out.println(ioEx);
            ioEx.printStackTrace();
        }
    }

}
