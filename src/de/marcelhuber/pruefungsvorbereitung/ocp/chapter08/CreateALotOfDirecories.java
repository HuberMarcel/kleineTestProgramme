package de.marcelhuber.pruefungsvorbereitung.ocp.chapter08;

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
public class CreateALotOfDirecories {

    private Path path;
    private Path file;
    private boolean deleteAllYouHaveCreatedHere;

    {
        deleteAllYouHaveCreatedHere = true;
    }

    public static void main(String[] args) {
        CreateALotOfDirecories dummy = new CreateALotOfDirecories();
        dummy.go();
    }

    private void go() {
        path = Paths.get("TestOrdner01/TestOrdner02/");
        file = Paths.get(path.toString(), "TestTextFile.txt");
        try {
            Files.createDirectories(path);
            if (!file.toFile().exists()) {
                Files.createFile(file);
            }
            // nur leere Ordner können gelöscht werden, bspw. übernächste Zeile alleine einkommentieren
//            Files.delete(file);
//            Files.delete(path);
//            Files.delete(path.getParent());
        } catch (IOException ioEx) {
            System.err.println(ioEx);
            ioEx.printStackTrace();
        } finally {
            deleteEverythingYouHaveCreatedHere();
        }
    }

    private void deleteEverythingYouHaveCreatedHere() {
        // nur leere Ordner können gelöscht werden, bspw. übernächste Zeile alleine einkommentieren
        if (deleteAllYouHaveCreatedHere) {
            try {
                Files.deleteIfExists(file);
                Files.deleteIfExists(path);
                Files.deleteIfExists(path.getParent());
            } catch (IOException ioEx) {
                System.err.println(ioEx);
                ioEx.printStackTrace();
            }
        }
    }
}
